package javabasics.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Kevin
 * @date 2022-02-08
 **/
public class Apple {

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main1(String[] args) throws Exception {
        //正常的调用
        Apple apple = new Apple();
        apple.setPrice(5);
        System.out.println("Apple Price:" + apple.getPrice());
        //使用反射调用
        Class clz = Class.forName("javabasics.reflect.Apple");
        //得到setPrice函数
        Method setPriceMethod = clz.getMethod("setPrice", int.class);
        //获取构造器
        Constructor appleConstructor = clz.getConstructor();
        //从构造器中得到一个实例
        Object appleObj = appleConstructor.newInstance();
        setPriceMethod.invoke(appleObj, 14);
        Method getPriceMethod = clz.getMethod("getPrice");
        System.out.println("Apple Price:" + getPriceMethod.invoke(appleObj));
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 第一种，使用 Class.forName 静态方法。当你知道该类的全路径名时，你可以使用该方法获取 Class 类对象。
        Class clz = Class.forName("java.lang.String");
        // 这种方法只适合在编译前就知道操作的 Class
        Class clzz = String.class;

        //第三种，使用类对象的 getClass() 方法。
        String str = new String("Hello");
        Class clzzz = str.getClass();

        System.out.println(clz);
        System.out.println(clzz);
        System.out.println(clzzz);

        String o = (String)clz.getConstructor().newInstance();
        System.out.println(o.isEmpty());

        Field[] fields = clz.getFields();
        System.out.println(Arrays.toString(fields));

        Field[] declaredFields = clz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }
}
