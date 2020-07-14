package com.jacliu.test.jdk8;

import java.net.URL;

public class ClassPathTest {
    public static void main(String[] args) {
        URL resource = NashornTest.class.getResource("/");
        System.out.println(resource);

        URL resource1 = NashornTest.class.getResource("");
        System.out.println(resource1);

        URL resource3 = NashornTest.class.getClassLoader().getResource("");
        System.out.println(resource3);

        URL resource4 = NashornTest.class.getClassLoader().getResource("/");
        System.out.println(resource4);
    }
}
