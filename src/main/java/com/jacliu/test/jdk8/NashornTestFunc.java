package com.jacliu.test.jdk8;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class NashornTestFunc {

    public static void javaFun1(String name) {
        System.out.println("javaFun1 中打印出来的：： " + name);
    }

    public static void javaFun2(Object object) {
        System.out.println(object.getClass());
    }

    public static void javaFun3(ScriptObjectMirror mirror) {
        System.out.println(mirror.getClassName() + ": " +
                Arrays.toString(mirror.getOwnKeys(true)));
    }

    public static void javaFun4(ScriptObjectMirror person) {
        System.out.println("Full Name is: " + person.callMember("getFullName"));
    }
}
