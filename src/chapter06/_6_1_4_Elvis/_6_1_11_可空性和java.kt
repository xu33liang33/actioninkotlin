package chapter06._6_1_4_Elvis

import java.lang.IllegalStateException

/**
java将基本数据类型和引用类型做了区分
kotlin不会自动地把数字从一种类型转换成另外一种（即使转换成范围更大的）
kotlin 要求转换必须是显示的

 */
fun main(args: Array<String>) {
    println()

    val list = listOf("a", "b", "c")
    val list22 = mutableListOf("a", "b", "c")
//    list.add()
    list22.add("D")

}

/**
 * Any 类型和 Any？
 *  Object类java中是所有引用数据类型的根
 *  Any是除了null外的类的根
 *  Any？可以为空
 *
 *
 */

/**
 * Unit类型
 * kotlin的"void"
 *  void不是类型Unit是
 *
 */
fun testUnit(): Unit {
    println()
}

/**
 * Nothing类型"这个函数永远不返回"
 *
 *
 */
fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}









