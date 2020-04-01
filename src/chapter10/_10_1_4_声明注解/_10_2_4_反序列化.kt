package chapter10._10_1_4_声明注解

import chapter10.json.kotlin.deserialization.deserialize
import chapter10.json.kotlin.serialization.serialize

/**
 *反序列化 更复杂
 * 阶段组成：1。词法分析器   2。语法分析器（解析器）     3。反序列化组件
 *
 *1。词法分析器-----把由字符组成的输入字符串切分成一个由 标记 组成的列表
 *                  字符标记（逗号/冒号/方括号）
 *                  值标记
 *
 */
fun main(args: Array<String>) {
    val author1024 =  Author1024("Jack")
    val book = Book1024("How to make lunch?",author1024)

    println(serialize(book))

    val bookJson = """
        {"author": {"name": "Rose"}, "title": "How to make dinner?"}
        """.trimIndent()
    println(bookJson)
    val book222 = deserialize<Book1024>(bookJson)
    println(book222)




}

data class Author1024(val name:String)

data class Book1024(val title:String,val author:Author1024)


/**
 * 源码
 */
interface JsonObject {
    fun setSimpleProperty(propertyName: String, value: Any?)

    fun createObject(propertyName: String): JsonObject

    fun createArray(propertyName: String): JsonObject
}

