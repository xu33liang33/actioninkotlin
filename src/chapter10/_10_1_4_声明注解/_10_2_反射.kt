package chapter10._10_1_4_声明注解

import chapter10.PersonIntro10
import kotlin.reflect.full.memberProperties

var counter =  0

fun main(args: Array<String>) {

    /**
     * 序列化---反序列化
     */
    val person = PersonIntro10("A", 40)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)

    kClass.memberProperties.forEach {
        println(it.name)
    }

    val kFunction = ::foo
    kFunction.call(43)
    //Callable expects 1 arguments, but 2 were provided.
//    kFunction.call(43,"asa")

    println("------------------")
    val kFunction1 = ::sum
    println(kFunction1.invoke(1, 2) + kFunction1(3, 4) + kFunction1.call(1, 1))


    val kProperty = ::counter
    kProperty.setter.call(21)
    println(counter)
    println(kProperty.get())

    println()
    // 最外层或者类中的属性
    val memberProperty = PersonIntro10::age
    println(memberProperty.get(person))

}

fun foo(x: Int) = println(x)

fun sum(x: Int, y: Int) = x + y