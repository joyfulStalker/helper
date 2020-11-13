package common.utils;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * 自动填充创建数据createTime、createBy、createByName
 * 自动填充修改数据updateTime、updateBy、updateByName
 * @author liuSonglin
 */
public class AutoFillBaseDataUtil {

    /**
     * 新增时使用，自动填充创建数据createTime、createBy、createByName
     *
     * @param obj
     * @throws IllegalAccessException
     */
    public static void fillCreatedData(Object obj) {

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        int time = 0;
        try {
            for (int i = 0; i < declaredFields.length; i++) {
                if (time >= 3) {
                    break;
                }
                Field declaredField = declaredFields[i];
                declaredField.setAccessible(true);
                if ("createTime".equals(declaredField.getName())) {
                    declaredField.set(obj, new Date());
                    time++;
                    continue;
                }
                if ("createBy".equals(declaredField.getName())) {
                    declaredField.set(obj, -1);
                    time++;
                    continue;
                }
                if ("createByName".equals(declaredField.getName())) {
                    declaredField.set(obj, "系统管理");
                    time++;
                    continue;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改时使用，自动填充修改数据updateTime、updateBy、updateByName
     *
     * @param obj
     * @throws IllegalAccessException
     */
    public static void fillUpdatedData(Object obj) {

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        int time = 0;
        try {
            for (int i = 0; i < declaredFields.length; i++) {
                if (time >= 3) {
                    break;
                }
                Field declaredField = declaredFields[i];
                declaredField.setAccessible(true);
                if ("updateTime".equals(declaredField.getName())) {
                    declaredField.set(obj, new Date());
                    time++;
                    continue;
                }
                if ("updateBy".equals(declaredField.getName())) {
                    declaredField.set(obj, -1);
                    time++;
                    continue;
                }
                if ("updateByName".equals(declaredField.getName())) {
                    declaredField.set(obj, "系统管理");
                    time++;
                    continue;
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
