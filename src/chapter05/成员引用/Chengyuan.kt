package chapter05.成员引用

import chapter05.Person5Lambda

fun salute() = println("Salute!")

fun main(args: Array<String>) {
    //成员引用
    /**
     * 类名称：：引用的成员
     */
    val age = Person5Lambda::age

    // 引用顶层函数
    run(::salute)

    ///////////////////
    val action = { person: Person5Lambda, message: String ->
        sendMail(person, message)
    }

    val nextAction = ::sendMail

    //构造方法引用
    val createPerson = ::Person5Lambda
    val p = createPerson("Alice", 22, "C")

    println(p)

    val predicate = Person5Lambda::isAdult

    val result = predicate(p)
    println(result)

}

fun sendMail(person: Person5Lambda, message: String) {

}

fun Person5Lambda.isAdult() = age >= 21

