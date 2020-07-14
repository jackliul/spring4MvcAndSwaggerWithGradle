package com.jacliu.test.hutools;

import cn.hutool.core.bean.BeanDesc;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONUtil;
import com.jacliu.test.domain.Order;
import com.jacliu.test.domain.User;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollecTest {
    public static void main(String[] args) {
        // 测试迭代相关
        testIte();

        // 交并差集
        collecsaa();
    }

    private static void collecsaa() {
        // 交集
        //CollUtil.intersection();
        // 并集
        //CollUtil.union();
        // 差集
        //CollUtil.disjunction();
        // 截取部分集合。
        //CollUtil.sub();
        // 切割成子集合 【与第三方对接时批量推送 比如200时有用】
        //CollUtil.split();
        // 映射建值
        /**
         * keys = a,b,c,d<br>
         * values = 1,2,3,4<br>
         * delimiter = , 则得到的Map是 {a=1, b=2, c=3, d=4}<br>
         * */
        //CollUtil.zip();
        // 根据汉字拼音排序
        //CollUtil.sortByPinyin();
        // 反序
        // reverse();reverseNew();
    }

    private static void testIte() {
        HashMap<Object, Object> of = MapUtil.of(new String[][]{{"aa", "fddddf"}, {"bb", "bb"}, {"aa", "aaa"}});
        Map<Map.Entry<Object, Object>, Integer> entryIntegerMap = IterUtil.countMap(of.entrySet().iterator());
        System.out.println(JSONUtil.toJsonStr(entryIntegerMap));

    }
}
