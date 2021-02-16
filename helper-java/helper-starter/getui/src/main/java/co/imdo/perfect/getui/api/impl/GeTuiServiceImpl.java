package co.imdo.perfect.getui.api.impl;

import co.imdo.perfect.getui.api.GeTuiService;
import co.imdo.perfect.getui.po.PushMessageVo;
import com.alibaba.fastjson.JSON;
import com.getui.push.v2.sdk.api.PushApi;
import com.getui.push.v2.sdk.common.ApiResult;
import com.getui.push.v2.sdk.dto.req.Audience;
import com.getui.push.v2.sdk.dto.req.AudienceDTO;
import com.getui.push.v2.sdk.dto.req.message.PushDTO;
import com.getui.push.v2.sdk.dto.req.message.PushMessage;
import com.getui.push.v2.sdk.dto.req.message.android.GTNotification;
import com.getui.push.v2.sdk.dto.res.TaskIdDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Map;

@Slf4j
public class GeTuiServiceImpl implements GeTuiService {

    @Autowired
    private PushApi pushApi;

    @Override
    public void push(PushMessageVo pushMessage) {
        if (pushMessage.getCid().contains(",")) {
            toList(pushMessage);
            return;
        }
        toSingle(pushMessage);
    }

    private void toSingle(PushMessageVo pushMessage) {
        PushDTO<Audience> pushDTO = getAudiencePushDTO(pushMessage.getTitle(), pushMessage.getMessage());
        // 设置接收人信息
        Audience audience = new Audience();
        audience.addCid(pushMessage.getCid());
        pushDTO.setAudience(audience);
        ApiResult<Map<String, Map<String, String>>> apiResult = pushApi.pushToSingleByCid(pushDTO);
        getResult(apiResult);
    }

    private void toList(PushMessageVo pushMessage) {
        String taskId = createMessage(pushMessage.getTitle(), pushMessage.getMessage());
        if (StringUtils.isBlank(taskId)) {
            return;
        }
        AudienceDTO audienceDTO = new AudienceDTO();
        Audience audience = new Audience();
        Arrays.stream(pushMessage.getCid().split(",")).forEach(audience::addCid);
        audienceDTO.setAudience(audience);
        audienceDTO.setTaskid(taskId);
        audienceDTO.setAsync(false);
        ApiResult<Map<String, Map<String, String>>> apiResult = pushApi.pushListByCid(audienceDTO);
        getResult(apiResult);
    }


    private String createMessage(String title, String message) {
        PushDTO<Audience> pushDTO = getAudiencePushDTO(title, message);
        ApiResult<TaskIdDTO> apiResult = pushApi.createMsg(pushDTO);
        if (apiResult.isSuccess()) {
            TaskIdDTO data = apiResult.getData();
            if (data == null) {
                return null;
            }
            return data.getTaskId();
        }
        log.error("apiResult ===> {}", JSON.toJSONString(apiResult));
        return null;
    }


    private PushDTO<Audience> getAudiencePushDTO(String title, String message) {
        //根据cid进行单推
        PushDTO<Audience> pushDTO = new PushDTO<>();
        pushDTO.setGroupName(System.currentTimeMillis() + "");
        // 设置推送参数
        pushDTO.setRequestId(System.currentTimeMillis() + "");
        GTNotification notification = new GTNotification();
        notification.setTitle(title);
        notification.setBody(message);
        notification.setClickType("startapp");
//        notification.setIntent("co.imdo.perfect/pages/notice/list");
//        notification.setPayload("{\"path\":\"information\"}");
        PushMessage pushMessage = new PushMessage();
        pushMessage.setNotification(notification);
        pushDTO.setPushMessage(pushMessage);
        // notification.setUrl("https://www.getui.com");
        return pushDTO;
    }


    private void getResult(ApiResult<Map<String, Map<String, String>>> apiResult) {
        if (apiResult.isSuccess()) {
            log.info("推送返回：{}", apiResult.getData());
        } else {
            log.error("推送失败返回 ===> {}", JSON.toJSONString(apiResult));
        }
    }
}
