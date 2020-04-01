package chapter03

import java.lang.StringBuilder


@JvmOverloads// 指示编译器生成重载函数，从最后一个开始省略每个参数
fun <T> joinToString4(
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

fun <T> Collection<T>.joinToString44(
        collection: Collection<T>,
        separator: String = ", ",// 分离器
        prefix: String = "",//前缀
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}


