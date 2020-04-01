package chapter10._10_1_4_声明注解

import chapter10.json.kotlin.DeserializeInterface
import kotlin.reflect.KClass

/**
 *
 *
 *
 */
fun main(args: Array<String>) {


}

interface Company {
    val name: String
}
data class CompanyImpl(override val name:String):Company

/**
 * DeserializeInterface
 * 控制接口类型的属性反序列化，指定反序列化时哪个类作为实现被创建
 */
data class Person1016(
        val name:String,
        @DeserializeInterface(CompanyImpl::class) val company: Company
)

/**
 * KClass 是 java的 java.lang.Class在kotlin中的对应类型
 * out 变型
 */
@Target(AnnotationTarget.PROPERTY)
annotation class DeserializeInterface1016(val targetClass: KClass<out Any>)

