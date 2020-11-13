package helper.service;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liuSongLin
 * @since 2020-03-08
 */
public interface IWxService {
    /**
     * 获取微信的openId
     *
     * @param jsCode
     * @return
     */
    String getOpenId(String jsCode);
}
