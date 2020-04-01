package chapter03

import java.lang.StringBuilder

//  扩展函数 扩展属性
//	顶层函数 局部函数

val UNIX_LINE_SEPARATOR = "\n"
//const = public static final
const val UNIX_LINE_SEPARATOR01 = "\n"

//创建集合
val set = hashSetOf(1, 7, 23)

val list = arrayListOf(1, 7, 23, 18, 5, 17)
const count = 3.14159

// to 普通函数
val map = hashMapOf(1 to "one", 7 to "seven", 23 to "twenty-three")

fun main(args: Array<String>) {
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
    // 集合类一致

    // 更方便灵活的API
    println(list.last())//拓展函数
    println(list.max())
    println(list.first())

    println(list)

    println(joinToString(list, "; ", "(", ")"))

    // 命名参数 必须与方法参数 一致
    // 观看更直观
    // （PS：修改名用 rename可以一起修改，手动修改🙅）
    println(joinToString(list,
            separator = "; ",
            prefix = "(",
            postfix = ")"))

    // 默认参数值
    println(joinToString1(list))
    println(joinToString1(list,"; "))
    println(joinToString1(list,prefix = "{",postfix = "}"))

    // 作为拓展函数的工具函数
    println("-------------------------")
    println(list.joinToString())

//    println(list.joinToString44(list,","))



}

/**
 * 自定义 遍历元素方法 自定义toString输出格式
 */
fun <T> joinToString(
        collection: Collection<T>,
        separator: String,// 分离器
        prefix: String,//前缀
        postfix: String
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}


fun <T> joinToString1(
        collection: Collection<T>,
        separator: String = ", ",// 分离器
        prefix: String = "(",//前缀
        postfix: String = ")"
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}


















