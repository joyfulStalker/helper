package common.utils;

import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @description: map与obj相互转换
 * @author: lsl
 * @create: 2020-09-21 09:47
 **/
public class ChangeUtils {

    public static final String PREFIX_SET = "set";
    public static final String PREFIX_GET = "get";

//    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
//        Student student = new Student();
//        student.setAge(1);
//        student.setName("asfd");
//        student.setSex(2);
//        student.setClassName("两年级");
//
//        Map map = objToMap(student);
//        System.out.println(map);
//    }

//    public static Object<T> mapToObj(Map map,Class clazz){
//
//        return null;
//    }

    /**
     * 对象转map
     *
     * @param obj
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Map objToMap(Object obj) throws InvocationTargetException, IllegalAccessException {
        if (obj == null) {
            return Maps.newHashMap();
        }
        Map map = Maps.newHashMap();
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith(PREFIX_GET)) {
                String filedName = methodName.substring(PREFIX_GET.length());
                filedName = filedName.substring(0, 1).toLowerCase() + filedName.substring(1);
                Field field = null;
                try {
                    field = searchDeclaredField(clazz, filedName);
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                } catch (NoSuchFieldException e) {
                    continue;
                }
                map.put(filedName, method.invoke(obj));
            }
        }
        return map;
    }

    /**
     * 搜索字段，如果当前类没有，则搜索父类，重复此步骤直到搜索到或者没有父类为空
     *
     * @param clazz
     * @param fieldName
     * @return
     * @throws NoSuchFieldException
     */
    public static Field searchDeclaredField(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        Field declaredField = null;
        Class<?> currentClazz = clazz;
        while (currentClazz != null) {
            try {
                declaredField = currentClazz.getDeclaredField(fieldName);
                return declaredField;
            } catch (NoSuchFieldException e) {
                currentClazz = currentClazz.getSuperclass();
                continue;
            }
        }
        throw new NoSuchFieldException(fieldName);
    }

}
//
//@Data
//class Student extends People {
//    private String className;
//
//    public void setSadf() {
//
//    }
//}
//
//@Data
//class People {
//    private Integer sex;
//    private Integer age;
//    private String name;
//}