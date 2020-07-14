package com.jacliu.test.hutools;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Editor;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.BeanUtils;

import java.net.URL;
import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        //testIeterRemove();

        //testArrayToMap();

        /**
         * <pre>
         * [
         *  {a: 1, b: 1, c: 1}
         *  {a: 2, b: 2}
         *  {a: 3, b: 3}
         *  {a: 4}
         * ]
         * </pre>
         * <p>
         * 结果是：
         *
         * <pre>
         * {
         *   a: [1,2,3,4]
         *   b: [1,2,3,]
         *   c: [1]
         * }
         * </pre>
         * */
        // 把一个List Map对象里面的 相同键值的map去除 并组成新的 Map<Key,List<Val>> 对象
        // 行转列
        //testListMapToListMap();

        /**
         * <pre>
         * {
         *   a: [1,2,3,4]
         *   b: [1,2,3,]
         *   c: [1]
         * }
         * </pre>
         * <p>
         * 结果是：
         *
         * <pre>
         * [
         *  {a: 1, b: 1, c: 1}
         *  {a: 2, b: 2}
         *  {a: 3, b: 3}
         *  {a: 4}
         * ]
         * */
        // 把一个map对象【map的有些value是list】转成 list<Map> 把其中的 key拿出来
        // 列转行
        //testMapListToMapList();

        // 将map转为二维数组
        // toArrays();

        // 转成字符串
        //testMapToStr();

        // 过滤map 【编辑的有使用场景 过滤的并不太实用 不如直接用jdk8流式操作】
        // editMap();
    }

    private static void editMap() {
        HashMap<Object, Object> map = MapUtil.of(new String[][]{{"test1", "1"}, {"test5", "5"}, {"test3", "3"}, {"test7", "7"}});
        System.out.println(JSONUtil.toJsonStr(map));

        Map<Object, Object> filterMap = MapUtil.filter(map, new Filter<Map.Entry<Object, Object>>() {
            @Override
            public boolean accept(Map.Entry<Object, Object> objectObjectEntry) {
                if (Objects.equals(objectObjectEntry.getKey(), "test3")) {
                    return false;
                }
                return true;
            }
        });
        System.out.println(JSONUtil.toJsonStr(filterMap));

        Map<Object, Object> editorMap =  MapUtil.filter(map, new Editor<Map.Entry<Object, Object>>() {

            @Override
            public Map.Entry<Object, Object> edit(Map.Entry<Object, Object> objectObjectEntry) {
                if(Objects.equals(objectObjectEntry.getKey(),"test1")){
                    objectObjectEntry.setValue("nihao");
                }
                return objectObjectEntry;
            }
        });
        System.out.println(JSONUtil.toJsonStr(editorMap));
    }

    private static void testMapToStr() {
        HashMap<Object, Object> map = MapUtil.of(new String[][]{{"test1", "1"}, {"test5", "5"}, {"test3", "3"}, {"test7", "7"}});
        String nihao = MapUtil.sortJoin(map, ",", "-", true, "nihao");
        System.out.println(nihao);
    }

    private static void toArrays() {
        HashMap map = new HashMap();
        map.put("aa",11);
        map.put(22,"vv");
        map.put("cc",55);
        Object[][] objects = MapUtil.toObjectArray(map);
        System.out.println(JSONUtil.toJsonStr(objects));
    }

    private static void testMapListToMapList() {
        HashMap<String, List<Integer>> map1 = MapUtil.of("a", Arrays.asList(1, 2, 3, 4));
        HashMap<String, List<Integer>> map2 = MapUtil.of("b", Arrays.asList(1, 2, 3,10));
        HashMap<String, List<Integer>> map3 = MapUtil.of("c", Arrays.asList(1, 2, 5,18,19));
        map1.putAll(map2);
        map1.putAll(map3);

        List<Map<String, Integer>> maps = MapUtil.toMapList(map1);
        System.out.println(JSONUtil.toJsonStr(maps));
        maps.stream().forEach(map->{
            System.out.println(JSONUtil.toJsonPrettyStr(map));
        });
    }

    private static void testListMapToListMap() {
        // of 方法会去重【后面的会覆盖掉前面的方法 比如 第一行中的 29或覆盖掉18】
        HashMap<Object, Object> map1 = MapUtil.of(new Object[][]{{"aa",18},{"bb",22},{"aa",29},{"cc",44},{"cc",55}});
        HashMap<Object, Object> map2 = MapUtil.of(new Object[][]{{"aa",12},{"bb",32},{"aa",123},{"ff",44},{"cc",77}});
        HashMap<Object, Object> map3 = MapUtil.of(new Object[][]{{"aa",15},{"bb",23},{"gg",55},{"cc",44},{"hh",55}});
        List<HashMap<Object, Object>> hashMaps = Arrays.asList(map1, map2, map3);
        Map<Object, List<Object>> objectListMap = MapUtil.toListMap(hashMaps);

        objectListMap.keySet().stream().forEach(key->{
            System.out.println("key :: " + key + " ;; values  " + JSONUtil.toJsonPrettyStr(objectListMap.get(key)));
        });
    }

    private static void testArrayToMap() {
        HashMap<Object, Object> map = MapUtil.of(new String[][]{{"aa", "11"}, {"bb", "22"}, {"cc", "33"}});
        map.keySet().stream().forEach(key->{
            System.out.println("key:: " + key + " ;; " + map.get(key));
        });
        Iterator<Map.Entry<Object, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Object, Object> next = iterator.next();
            if(Objects.equals(next.getKey(),"aa")){
                iterator.remove();
            }
            System.out.println("next.getKey():: " + next.getKey() + " ;; " + map.get(next.getKey()));
        }
    }

    private static void testIeterRemove() {
        HashMap<String, Integer> aa = MapUtil.of("aa", 123);
        System.out.println(aa.size());
        Iterator<Map.Entry<String, Integer>> iterator = aa.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + " ::: " + next.getValue());
            if(Objects.equals(next.getKey(),"aa")){
                iterator.remove(); // 迭代时删除 用该方法
            }
        }
        System.out.println(aa.size());
    }
}
