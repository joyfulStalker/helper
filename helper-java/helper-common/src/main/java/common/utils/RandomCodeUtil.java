package common.utils;

import java.util.Random;

/**
 * @author liuSonglin
 */
public class RandomCodeUtil {

    /**
     * 获取6位随机数
     *
     * @return
     */
    public static String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
