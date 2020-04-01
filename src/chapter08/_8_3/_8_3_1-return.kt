package chapter08._8_3

import chapter01.Person
import chapter06._6_1_4_Elvis.Person615

fun main(args: Array<String>) {
    val people = listOf<Person>(Person("Alice", 20), Person("Zhiling", 45), Person("Tom", 24))
    lookForAlice(people)

    /**
     * forEach 检验
     *
     */
    println()
    println("v2v2v2v2v2v2v2v2v2")
    lookForAliceV2(people)

    println()
    println("v3v3v3v3v3v3v3v3")
//    lookForAliceV3(people)
////    lookForAliceV4(people)
    lookForAliceV5(people)

    println()
    val aaa = people.filter {
        it.age!! < 40
    }.map { it.name }.joinToString(separator = ",") {
        it
    }

    println(aaa)
}

fun lookForAlice(people: List<Person>) {
    for (person in people) {
        if (person.name == "Alice") {
            println("Found")
            return
        }
    }
    println("not found")
}

/**
 * lambda中调用"return"会从调用lambda的函数中返回
 * 非局部返回-   从一个比包含return的代码块更大 的代码块中返回了
 * 只有在以lambda作为参数的函数是内联函数的时候才能从更外层的函数返回
 */
fun lookForAliceV2(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found")
            return
        }
    }
    println("not found")
}

/**
 * 标签 返回
 */
fun lookForAliceV3(people: List<Person>) {
    people.forEach label@{
        if (it.name == "Alice") {
            println("Found")
            return@label
        }
    }
    println("not found")
}

/**
 * 使用lambda作为参数的函数的函数名可以作为标签
 */
fun lookForAliceV4(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found")
            return@forEach
//            return@lookForAliceV4
        }
    }
    println("not found")
}

/**
 * 匿名函数的返回
 * return 指向最近的函数
 * 从最近的fun关键字声明的函数返回
 */
fun lookForAliceV5(people: List<Person>) {
    people.forEach(fun(person) {
        if (person.name == "Alice") {
            println("Found")
            return
        }
        println("${person.name} is not Alice")
    })
}




