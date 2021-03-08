package co.imdo.perfect.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射工具
 */
public class ReflectUtil {

    /**
     * 属性列表
     *
     * @param clazz
     * @return
     */
    public static List<String> getObjectNames(Class clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        List objectNames = new ArrayList();
        for (Field field : declaredFields) {
            objectNames.add(field.getName());
        }
        return objectNames;
    }

    /**
     * 方法调用
     *
     * @param obj
     * @param key
     * @param value
     */
    public static void invoke(Object obj, String key, String value) {
        try {
            Field field = obj.getClass().getDeclaredField(key);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}