package chapter10._10_1_4_声明注解

import chapter10.json.kotlin.*
import chapter10.json.kotlin.createInstance
import chapter10.json.kotlin.findAnnotation
import java.util.*
import kotlin.reflect.KProperty


/**
 * 看源码---
 */
fun main(args: Array<String>) {
    val person1016 = Person1023("lily", Date())


}

data class Person1023(
        val name: String,
        @CustomSerializer(DataSerializer::class) val birthDate: Date
)

/**
 * 源码
 */
fun KProperty<*>.getSerializer1023(): ValueSerializer<Any?>? {
    val customSerializerAnn = findAnnotation<CustomSerializer>() ?: return null
    val serializerClass = customSerializerAnn.serializerClass

    val valueSerializer = serializerClass.objectInstance
            ?: serializerClass.createInstance()
    @Suppress("UNCHECKED_CAST")
    return valueSerializer as ValueSerializer<Any?>
}











