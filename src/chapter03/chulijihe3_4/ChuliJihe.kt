package chapter03.chulijihe3_4

/**
 *可变参数/中缀屌用/库的支持
 * 解构声明-用来把一个单独的组合值展开到多个变量中
 **/
fun main(args: Array<String>) {
    val strings: List<String> = listOf("1", "2", "3")
    println(strings.last())     // 看源码 -已经声明了拓展函数

    val numbers: Collection<Int> = setOf(1, 14, 3)
    println(numbers.max())      // 看源码

    // 3。4。2  可变参数 看源码  vararg 关键字 java  ... 可变参数
    val list = listOf(2, 3, 5, 9, 11)

    val list1 = listOf("args:", *args)// * 展开运算符 展开数组内容
    println(list1)

    // 中缀调用 to 特殊函数
    val map = mapOf(1 to "aaa", 7 to "bbb", 53 to "ccc")
    val map2 = mapOf(1.toooq("aaa"))

    // to 源码 infix
//    public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)

    testVararg(1, 5, 6, 79, 0)
}

fun testVararg(vararg a: Int) {
    for (element in a) {
        println(element)
    }
}

// infix 表示允许使用中缀符号调用
infix fun Any.toooq(other: Any) = Pair(this, other)
















