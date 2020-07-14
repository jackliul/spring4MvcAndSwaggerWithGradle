var fun1 = function(name) {
    print('Hi there from Javascript, ' + name);
    return "greetings from javascript";
};

var fun2 = function (object) {
    print("JS Class Definition: " + Object.prototype.toString.call(object));
};

var fun3 = function (name) {
    var ArrayList = Java.type('java.util.ArrayList');
    var list = new ArrayList();
    list.add('a');
    list.add('b');
    list.add('c');

    for each (var el in list)
    {
        print(el);  // a, b, c
    }
    return ArrayList;
};

var fun4 = function () {
    var map = new java.util.HashMap();
    map.put('foo', 'val1');
    map.put('bar', 'val2');

    for each (var e in map.keySet()) print(e);  // foo, bar

    for each (var e in map.values()) print(e);  // val1, val2
    return map;
};

var fun5 = function () {
    var list2 = new java.util.ArrayList();
    list2.add("ddd2");
    list2.add("aaa2");
    list2.add("bbb1");
    list2.add("aaa1");
    list2.add("bbb3");
    list2.add("ccc");
    list2.add("bbb2");
    list2.add("ddd1");

    list2
        .stream()
        .filter(function(el) {
            return el.startsWith("aaa");
        })
        .sorted()
        .forEach(function(el) {
            print(el);
        });
    // aaa1, aaa2
};


var fun6 = function (code) {
    var javaOrder = Java.type('com.jacliu.test.domain.Order');
    javaOrder.orderCode = code;
    print(javaOrder)
    return javaOrder;
};

var fun7 = function () {
    var nashornTestFunc = Java.type('com.jacliu.test.jdk8.NashornTestFunc');
    var result = nashornTestFunc.javaFun1('John Doe');
};

var fun8 = function () {
    var nashornTestFunc = Java.type('com.jacliu.test.jdk8.NashornTestFunc');
    nashornTestFunc.javaFun2(123);
    nashornTestFunc.javaFun2(49.99);
    nashornTestFunc.javaFun2(new Date());
    nashornTestFunc.javaFun2({foo: 'bar'});
    nashornTestFunc.javaFun2(true);
    nashornTestFunc.javaFun2(new RegExp());
};

var fun9 = function () {
    var nashornTestFunc = Java.type('com.jacliu.test.jdk8.NashornTestFunc');
   nashornTestFunc.javaFun3({
        foo: 'bar',
        bar: 'foo'
    });
    //nashornTestFunc.javaFun3(111);
};

function Person(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.getFullName = function() {
        return this.firstName + " " + this.lastName;
    }
}
var fun10 = function () {
    var nashornTestFunc = Java.type('com.jacliu.test.jdk8.NashornTestFunc');
    var person = new Person("Peter", "Parker");
    nashornTestFunc.javaFun4(person);
    //nashornTestFunc.javaFun3(111);
};
