package chapter09

import java.lang.IllegalArgumentException
import java.util.*
import kotlin.reflect.KClass

/**
 *
 * 星号投影---表明你不知道关于泛型实参的任何信息
 *
 * 当：不需要使用任何在签名中引用类型参数的方法
 * 只是读取数据而不关心它的具体类型时
 *
 */
fun main(args: Array<String>) {

    val list: MutableList<Any?> = mutableListOf('a', 1, "qwe")
    val chars = mutableListOf('r', 'a', 'b', 'c')
    val unknownElment: MutableList<*> = if (Random().nextBoolean()) list else chars

    //编译器禁止调用  此 方法
//    unknownElment.add(42)

    println(unknownElment.first())

    printFirst(unknownElment)
    printFirst2(unknownElment)


    //////////////////////////////////

    val validators = mutableMapOf<KClass<*>,FiledValidator<*>>()
    validators[String::class] = DefaultStringValidator
    validators[Int::class] = DefaultIntValidator

    //出错了---编译器并不知道它是那种验证器
    //把具体类传递给未知类 是不安全的
//    validators[String::class]!!.validate("")

    //
    val validator = validators[String::class] as DefaultStringValidator
    println(validator.validate(""))


    val validator1 = validators[Int::class] as DefaultStringValidator
    println(validator1.validate(""))



}

fun printFirst(list: List<*>) {
    if (list.isNotEmpty()) {
        println(list.first())
    }
}

/**
 * 替代方案
 */
fun <T> printFirst2(list: List<T>) {
    if (list.isNotEmpty()) {
        println(list.first())
    }
}

/**
 * 验证器
 */
interface FiledValidator<in T> {
    fun validate(input: T): Boolean
}

object DefaultStringValidator : FiledValidator<String> {
    override fun validate(input: String): Boolean = input.isNotEmpty()
}

object DefaultIntValidator : FiledValidator<Int> {
    override fun validate(input: Int): Boolean = input >= 0
}

///////final
object Validators{
    private val validators = mutableMapOf<KClass<*>,FiledValidator<*>>()


    fun<T:Any> registerValidator(kClass:KClass<T>  ,filedValidator: FiledValidator<T>){
        validators[kClass]  = filedValidator
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <T:Any> get(kClass:KClass<T>):FiledValidator<T> =
            validators[kClass]  as?  FiledValidator<T>
                    ?: throw  IllegalArgumentException("No validator for ${kClass.simpleName}")

}








