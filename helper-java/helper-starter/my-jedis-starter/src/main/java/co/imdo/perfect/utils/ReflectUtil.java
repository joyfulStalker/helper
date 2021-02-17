package co.imdo.perfect.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
        String firstWord = key.substring(0, 1);
        Method declaredMethod = null;
        try {
            declaredMethod = obj.getClass().getDeclaredMethod("set" + key.replaceFirst(firstWord, firstWord.toUpperCase()), String.class);
            declaredMethod.invoke(obj, value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}