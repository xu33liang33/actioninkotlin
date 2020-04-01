package chapter06._6_1_4_Elvis

/**
 *
 * " ?: "
 * Elvis Presley 猫王名字
 * Elvis运算符
 * null合并运算符
 *
 */

/**
 * null合并运算符 "?:"
 *
 *                  ----------(foo!=null)--->foo
 *                 |
 * foo?:bar   -----
 *                 |
 *                  ----------(foo == null)->bar
 *  只会调用非空值的方法
 *  和安全调用 一起使用效果更佳
 *
 *  return 和 throw 语境用更佳
 *
 */

fun main(args: Array<String>) {
    println(strLenSafe("abc"))
    println(strLenSafe(null))

    println("-----------------------")

    println(strLenSafeV2("abc"))
    println(strLenSafeV2(null))
}

fun strLenSafe(s: String?) = s?.length
fun strLenSafeV2(s: String?) = s?.length ?: 0