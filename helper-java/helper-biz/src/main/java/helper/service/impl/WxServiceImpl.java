package helper.service.impl;

import cn.hutool.http.HttpUtil;
import helper.service.IWxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class WxServiceImpl implements IWxService {

    @Override
    public String getOpenId(String jsCode) {
        String openId = HttpUtil.get("https://api.weixin.qq.com/sns/jscode2session?appid=wx5bf7d38a156959e7&secret=ec98bc9dc225bbb7a38fe10aa02b52f6&js_code=" + jsCode + "&grant_type=authorization_code");
        log.info("openId是：" + openId);
        return openId;
    }
}
