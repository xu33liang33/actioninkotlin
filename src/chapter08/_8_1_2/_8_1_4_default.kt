package chapter08._8_1_2

import java.lang.StringBuilder


/**
 * 函数类型的  "参数默认值"  和null值
 * "著名"的joinToString函数-深挖
 */
fun main(args: Array<String>) {
    val letters = listOf("Alpha", "Beta", "King")
    println(letters.joinToString())
    println(letters.joinToString812()) //不能控制 集合中元素 转换为字符串 的规则


    println("--------joinToString812v2---------")
    println(letters.joinToString812v2())
    //放在方法外
    println(letters.joinToString812v2 {
        it.toLowerCase() + "😄"
    })
    // 命名参数
    println(letters.joinToString812v2(separator = "! ", postfix = "! ", transform = {
        it.toUpperCase()
    }))

    println("--------joinToStringV3---------")
    println(letters.joinToStringV3 {
        it.toUpperCase() + "test"
    })
    println(letters.joinToStringV3())

}

/**
 * 标准方法
 */
fun <T> Collection<T>.joinToString812(
        separator: String = ", ",// 分离器
        prefix: String = "",//前缀
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}


/**
 * 默认参数-函数类型参数lambda
 * transform - 泛型函数
 * 声明函数类型默认值语法------把lambda放在后面
 *
 */
fun <T> Collection<T>.joinToString812v2(
        separator: String = ", ",// 分离器
        prefix: String = "",//前缀
        postfix: String = "",
        transform: (T) -> String = {
            it.toString()
        }
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(transform(element))
    }
    result.append(postfix)
    return result.toString()
}


fun too(callback: (() -> Unit)?) {
    callback?.invoke()// 安全调用
    if (callback != null) {
        callback()
    }
}

/**
 * 可空函数类型
 * 函数类型是一个包含 invoke 方法的接口的具体实现
 */
fun <T> Collection<T>.joinToStringV3(
        separator: String = ", ",// 分离器
        prefix: String = "",//前缀
        postfix: String = "",
        transform: ((T) -> String)? = null
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)

        val str = transform?.invoke(element) ?: element.toString()

        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}







