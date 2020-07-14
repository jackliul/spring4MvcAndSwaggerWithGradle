package com.jacliu.test.hutools;

import cn.hutool.core.bean.BeanDesc;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Editor;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONUtil;
import com.jacliu.test.domain.Order;
import com.jacliu.test.domain.User;

import java.beans.PropertyDescriptor;
import java.util.*;

public class BeanTest {
    public static void main(String[] args) {
        // java bean 与 map相互交互相关
        //beanToMap();
        //mapToBean();

        // java class 属性相关
        //classTest();

        // bean内容判断
        beanUsful();
    }

    private static void beanUsful() {
        Order order = BeanUtil.mapToBean(MapUtil.of(new Object[][]{{"orderUser", "wwqqq"}}),Order.class, true);
        System.out.println(BeanUtil.isEmpty(order));
        System.out.println(BeanUtil.hasNullField(order,""));
    }

    private static void mapToBean() {
        HashMap<Object, Object> map = MapUtil.of(new Object[][]{{"orderCode", 210L}, {"orderUser", "testJack"}});
        // 注意 调用默认构造器，所以类中必须有默认构造器才行。
        Order order = BeanUtil.mapToBean(map, Order.class, false);
        System.out.println(JSONUtil.toJsonStr(order));

        Order order1 = BeanUtil.fillBeanWithMap(MapUtil.of(new Object[][]{{"orderUser", "wwqqq"}}), order, true);
        System.out.println(JSONUtil.toJsonStr(order1));
    }

    private static void classTest() {
        BeanDesc beanDesc = BeanUtil.getBeanDesc(Order.class);

        PropertyDescriptor[] propertyDescriptors = BeanUtil.getPropertyDescriptors(Order.class);

        Order jacliu = new Order(100L, "jacliu");
        Object fieldValue = BeanUtil.getFieldValue(jacliu, "orderCode");
        System.out.println("aaaa " + fieldValue);
        BeanUtil.setFieldValue(jacliu, "orderCode",300L);
        fieldValue = BeanUtil.getFieldValue(jacliu, "orderCode");
        System.out.println("aaaa " + fieldValue);

        // 【此方法确有用 但不知性能如何】
        User user = new User(100L, "www", "aaa", "12e", "erer", "ererer");
        jacliu.setUser(user);
        ArrayList<User> users = new ArrayList<>();
        user.setTelephone("232323232");
        users.add(user);
        jacliu.setUsers(users);


        jacliu.setUser(user);
        jacliu.setUsers(users);
        Object property = BeanUtil.getProperty(jacliu, "user.telephone");
        System.out.println(property);
        Object property1 = BeanUtil.getProperty(jacliu, "users[0].address");
        System.out.println(property1);
    }

    private static void beanToMap() {
        Map<String, Object> jacliu = BeanUtil.beanToMap(new Order(100L, "jacliu"));
        jacliu.keySet().forEach(key->{
            System.out.println("key :: " + key + " ;; value :: " + jacliu.get(key));
        });
    }


}
