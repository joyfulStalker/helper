package common.utils;

/**
 * @author liuSonglin
 */
public class PasswordUtil {

    /**
     * @param userName
     * @param password
     * @return
     */
    public static String encrypt(String userName, String password) {
        return SignUtil.bytesToMd5((userName + password).getBytes());
    }
}
