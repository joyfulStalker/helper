package co.imdo.perfect.getui.api;

import co.imdo.perfect.getui.po.PushMessageVo;

/**
 * 个推api
 */
public interface GeTuiService {
    /**
     * 推送
     *
     * @param pushMessage
     */
    void push(PushMessageVo pushMessage);
}
