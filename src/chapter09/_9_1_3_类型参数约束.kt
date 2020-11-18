package chapter09

/**
 * 类型参数约束----限制 泛型 类型实参的 类型
 * java
 * <T extends Number>   sum(List<T> list)
 *
 * 把"冒号"放在类型参数名称之后，作为类型形参的 上界 类型
 * 必须是这个具体类型的类型或者子类
 *
 */
fun main(args: Array<String>) {

    /**
     * 类型参数 限制 栗子
     */
    val list913 = listOf(1, 2, 3, 4, 5)
    println(list913.sum())
    list913.sum913()

    val list913String = listOf("a", "b")
//    println(list913String.sum())
//    list913String.sum913()

    println(oneHalf(7))

    val a = max("a", "b")
    val b = "a".compareTo("b")
    println('a'.toFloat())
    println('z'.toFloat())
    println('A'.toFloat())
    println('Z'.toFloat())
    println("$a | $b")


    println()
    val sb = StringBuilder("Hello World")
    ensureTrailingPeriod(sb)

//    ensureTrailingPeriod("aaa")
    println(sb)
}

/**
 * 限制T的范围
 */
fun <T : Number> List<T>.sum913(): String {
    return ""
}

/**
 * 一旦定义了 上界 就可以把类型T的值作为上界类型 使用
 */
fun <T : Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}


/**
 * 比较两个值的大小
 */
fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
//    return if (first.compareTo(second) >  0) first else second
}

/**
 * 多条件约束
 */
fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith(".")) {
        seq.append(".")
    }
}

/**
 * 让类型形参非空
 *
 * 默认上界-Any?   也就是 可空的～
 * 非空可以设置 Any 为上界
 * 也可以指定任何不为空的类型为上界来实现非空操作
 */
fun <T : Any> notNull(str: T) {
    println(str.toString())
}

class Pro913<T> {
    fun pro(value: T) {
//        value.hashCode()
        value?.hashCode()
    }
}



