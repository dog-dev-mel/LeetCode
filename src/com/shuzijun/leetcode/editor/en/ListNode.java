package com.shuzijun.leetcode.editor.en;

/*
 * @Author: ITAIHAO
 *
 * @Date: 2022-07-19 21:09
 *
 */


public class ListNode {
    int val;
    /*
     * using class name as a variable type? What does it mean?
     *
     * Here, ListNode is a class. Each ListNode instance has a "val" to hold an integer value
     *          and a file "next" to hold a reference to another ListNode instance.
     * Additionally, every class is a type. So "ListNode next" is declaring a field whose name is "next" and whose type is "ListNode"
     *
     * 1.域||字段 |实例变量 |成员变量 (field | instance variable | member variable)   Non-static field
     * 定义：Field is a data member of class which it is not static. All fields are variables.
     *     比如：ListNode next,如果调用，需要 ListNode obj = new ListNode(), obj.next ;
     * 声明：field 声明在class中，但不在method或constructor中。如果有多个对象的实例，则每一个实例都会持有一份成员变量，实例之间不共享成员变量的数据。
     * 作用范围：作用域比静态变量小，可以在类中或者非静态方法中使用以及通过生成实例对象使用。（访问限制则不可用）
     * 初始化：JVM 在初始化类的时候会给成员变量赋初始值。
     *
     *        1) 虽然有如上定义，但是一般在使用时，成员变量 field 包括 instance variable 和 class variable。
     *           为了区分，个人认为，用实例变量/非静态变量（instance variable / non-static field）
     *                           用类变量/静态变量（class variable / static field）
     *                   描述上面的定义更佳。
     *        2) field与特定的object相关联，只能通过对象（new 出）访问
     *
     * 2. 类字段|静态字段|静态变量 (class variable | static field | static variable) Static field
     * 定义：Class variables also known as static variables are declared with the static keyword in a class, but outside a method, constructor or a block.
     *      使用 static 修饰的字段，一般叫做静态变量。比如class ListNode里面static int val, 可以直接调用ListNode.val;
     * 声明：class variable声明在class中，但不在method或constructor中。如果有多个对象的实例，他们共享一份静态变量。
     * 作用范围：作用域最大，类中都可以访问，或通过 类名.变量名 的方式调用（访问限制则不可用）。
     * 初始化：JVM 在初始化类的时候会给静态变量赋初始值。
     *
     * 1和2，共性都只能定义在class中，class variable带static字段，多个对象实例共享一份
     *                           instance variable不带static字段，多个对象实例各自一份，不共享。
     *
     * 3.局部变量 local variable
     * Method内部的局部变量local variable，参数变量parameter variable，都不能称为Field.
     * 定义在一个区块内，通常用{}，没有访问修饰符，block外部无法使用变量
     * JVM初始化不会给local variable 赋default value，需要自己定义
     * 生命周期为Method的周期
     *
     * 4. 参数 input parameter | parameter variable | argument
     * 一般在constructor()构造参数，method()方法参数，异常参数
     *
     * Strictly speaking, a parameter is a variable within the definition of a method.
     *                    int numberAdder(first, second)
     * An argument would be the data or actual value which is passed to the method.
     *                    int numberAdder(4,2)
     *
     * 5. 不可变量|常量 (final variable|constant)
     * 使用 final 关键词修饰的变量。不可变量属于field。
     *
     * 6. 成员 member
     * A field or method of a class. Unless specified otherwise, a member is not static.
     * 指的是类中非静态的成员变量或方法。（用法同field）
     *
     * 7.  属性（property）
     * Characteristics of an object that users can set, such as the color of a window.
     * 可被用户设置或获取的对象特征即为属性。
     * POJO 或 JavaBean 中的成员变量也称作属性（具有set、getter方法）。
     */
    ListNode next;

    /*
     * There can be multiple constructors in a class.
     * However, the parameter list of the constructors should not be same.
     * This is known as constructor overloading
     */

    //constructor
    ListNode() {
    }

    //constructor
    ListNode(int val) {
        this.val = val;
    }

    //constructor
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static String printLinkedList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(", ");
            head = head.next;
        }
        return sb.substring(0, sb.length() - 2);
    }

    public static ListNode convertArrayToLinkedList(int[] input) {
        ListNode head = new ListNode();
        ListNode dummy = head;
           for (int num : input) {
            head.next = new ListNode(num);
            head = head.next;
        }
        return dummy.next;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
