package chapter06

/**
 * Kotlin对"可空类型"的显式的支持
 * 度过了用kotlin编写java等价代码的阶段
 */
fun main(args: Array<String>) {
//    strLen(null) //编译错误-null can not be a value of a non-null type String

    println(strLen("test"))
//    println(strLen(null))

    /**
     * 可空性
     * Type? = Type or Null
     * java NullPointerException
     * 可空类型-指出哪些变量和属性允许为null的方式
     */
    val a: String? = null
    val b: String? = a
//    var a = ""

    if (a.isNullOrBlank()) {

    }

    val x = 0xF
    val x1 = 0xFF
    val list = listOf(1L, 2L, 3L)
    val bbbb = x.toLong() in list
    println("$bbbb||$x||$x1")


    val strings = listOf("A", "B", "C")
    println("%s/%s/%s".format(*strings.toTypedArray()))
}

/**
 * 没有问号的类型表示这种类型的变量不能存储null引用
 */
fun strLen(s: String) = s.length

/**
 *Only safe(?.) or non-null asserted(!!.)calls are allowed on a nullable receiver of type String?
 * 可空类型不能调用他的方法
 */
//fun strLenA(s: String?) = s.length

fun strLenB(s: String?): Int {
    if (s != null) {
        return s.length
    } else {
        return 0
    }
}