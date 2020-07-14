package com.jacliu.test.jdk8;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ColTest {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("aa", "aab", "bbc", "aad", "123", "3");
        Map<Integer, String> collect = strings.stream()
                .filter(o->o.startsWith("aa")).collect(Collectors.toMap(k -> strings.indexOf(k), k -> k));
        //System.out.println(JSONUtil.toJsonStr(collect));
    }
}
