package chapter10._10_1_4_声明注解

import chapter10.json.kotlin.JsonName
import chapter10.json.kotlin.findAnnotation
import chapter10.json.kotlin.joinToStringBuilder
import chapter10.json.kotlin.serialization.*
import java.lang.StringBuilder
import kotlin.reflect.full.memberProperties
import kotlin.reflect.*


/**
 *  反射---在运行时动态访问对象属性和方法
 *
 * 用反射来访问注解和注解中的数据
 *
 */

fun main(args: Array<String>) {

//    StringBuilder.serializeObject
//    反射入口 KClass
    val person = chapter01.Person("asd", 45)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    println(kClass.qualifiedName)
    // 打印属性名称
    kClass.memberProperties.forEach {
        println(it.name)
    }


    val kFunction = ::foo1022
//    vararg args: Any?
    /**
     * KFunction1<Int,Unit>
     */
    kFunction.call(45)

    /**
     * java.lang.IllegalArgumentException: Callable expects 1 arguments, but 2 were provided.
     */
//    kFunction.call(45, 23)

    val kFunction2: KFunction2<Int, Int, Int> = ::sum1022
    println(kFunction2.invoke(1, 1) + kFunction2(1, 1))

    /**
     * 会报错的
     * 如果具体类型函数，类型确定的话，优先使用invoke方法（更安全）
     * call方法不提供类型安全校验
     */
//    kFunction2(1)
//    kFunction2.call(1)

    /**
     * KProperty  实例调用call 会 调用该属性的getter
     * 最好用get()方法
     * 只能访问 最外层或者 类中的属性，不能访问函数的局部变量
     */
    val kProperty = ::counter1022
    kProperty.setter.call(21)

    println(kProperty.get())

    val kProperty2 = person::age
    println(kProperty2.get())

    /**
     *
     *
     */




}

var counter1022 = 0

fun foo1022(x: Int) = println(x)

fun sum1022(x: Int, y: Int) = x + y


////////////////////////////////////////////////

interface KCallable1022<out R> {
    fun call(vararg args: Any?): R
}


fun serialize1022(obj: Any): String {

    return ""
}

/**
 * 第一版
 */
private fun StringBuilder.serializeObject(obj: Any) {
    val kClass = obj.javaClass.kotlin
    val properties = kClass.memberProperties

    properties.joinToStringBuilder(
            this, prefix = "{", postfix = "}") { prop ->
        serializeString(prop.name)
        append(": ")
        serializePropertyValue(prop.get(obj))
    }
}


private fun StringBuilder.serializePropertyValue(value: Any?) {
    when (value) {
        null -> append("null")
        is String -> serializeString(value)
        is Number, is Boolean -> append(value.toString())
        is List<*> -> serializeList(value)
        else -> serializeObject(value)
    }
}

private fun StringBuilder.serializeString(s: String) {
    append('\"')
    s.forEach { append(it.escape()) }
    append('\"')
}

private fun Char.escape(): Any =
        when (this) {
            '\\' -> "\\\\"
            '\"' -> "\\\""
            '\b' -> "\\b"
            '\u000C' -> "\\f"
            '\n' -> "\\n"
            '\r' -> "\\r"
            '\t' -> "\\t"
            else -> this
        }

private fun StringBuilder.serializeList(data: List<Any?>) {
    data.joinToStringBuilder(this, prefix = "[", postfix = "]") {
        serializePropertyValue(it)
    }
}

/**
 * V2
 */
private fun StringBuilder.serializeObjectV2(obj: Any) {
    val kClass = obj.javaClass.kotlin
    val properties = kClass.memberProperties

    properties

            .filter {
                it.findAnnotation<JsonExclude>() == null
            }
            .joinToStringBuilder(
                    this, prefix = "{", postfix = "}") {
                serializeProperty(it, obj)
            }
}

inline fun <reified T> KAnnotatedElement.findAnnotation(): T? = annotations.filterIsInstance<T>().firstOrNull()

private fun StringBuilder.serializeProperty(
        prop: KProperty1<Any, *>, obj: Any
) {
    val jsonNameAnn = prop.findAnnotation<JsonName>()
    val propName = jsonNameAnn?.name ?: prop.name
    serializeString(propName)
    append(": ")

    val value = prop.get(obj)
    val jsonValue = prop.getSerializer()?.toJsonValue(value) ?: value
    serializePropertyValue(jsonValue)
}


