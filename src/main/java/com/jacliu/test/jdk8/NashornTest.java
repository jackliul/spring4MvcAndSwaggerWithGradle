package com.jacliu.test.jdk8;

import com.jacliu.test.domain.Order;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

public class NashornTest {

    public static void main(String[] args) {
        //test1();

        String fileName = NashornTest.class.getClassLoader().getResource("").toString()
                .replaceAll("classes", "resources") +"testNashorn.js";
        fileName = fileName.replaceAll("file:/","");
        //test2(fileName);

        //
        //test3(fileName);
        test4();
    }

    private static void test4() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
       // engine.eval();
    }

    private static void test3(String fileName) {
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            engine.eval(new FileReader(fileName));
            Invocable invocable = (Invocable) engine;

           // Object result = invocable.invokeFunction("fun6", "test001");
           /* System.out.println(((Order) result).getOrderCode());
            if(result instanceof Order){
                System.out.println(((Order) result).getOrderCode());
            }*/

            //Object result1 = invocable.invokeFunction("fun7");
            //Object result2 = invocable.invokeFunction("fun8");
            //Object result3 = invocable.invokeFunction("fun9");
            Object result4 = invocable.invokeFunction("fun10");
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void test2(String fileName) {
        try {

            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            engine.eval(new FileReader(fileName));
            Invocable invocable = (Invocable) engine;

            Object result = invocable.invokeFunction("fun1", "Peter Parker");
            System.out.println(result);

            invocable.invokeFunction("fun2", engine);
            invocable.invokeFunction("fun2", new ArrayList<>());

            Object o = invocable.invokeFunction("fun3", "testUser");
            System.out.println(o);

            invocable.invokeFunction("fun4");
            invocable.invokeFunction("fun5");
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void test1() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            engine.eval("print('Hello World!');");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

}
