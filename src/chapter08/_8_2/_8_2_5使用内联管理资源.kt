package chapter08._8_2

import chapter05.Person5Lambda
import chapter06._6_1_4_Elvis.Person615
import com.sun.deploy.util.SyncAccess

/**
 *
 * Lambda去除重复代码模式-资源管理：先获取一个资源，完成一个操作，然后释放
 *
 *
 * try/finally 语句
 */
fun main(args: Array<String>) {

    val l: Lock = Lock()
    /**
     * 用来操作可关闭的资源
     * 无论如何会把资源关闭-内联函数
     */
    l.use {

    }


    // 没试出来
//    l.withLock{
//
//    }


    val people = listOf(
            Person5Lambda("Alice", 29, "B"),
            Person5Lambda("Tom", 9, "B"),
            Person5Lambda("Lily", 31, "B"),
            Person5Lambda("John", 44, "B"))

    lookForAlice(people)
    lookForAlice222(people)
    lookForAlice333(people)
    lookForAlice555(people)

    val list = people.filter(
            fun(person): Boolean {
                return person.age < 30
            }
    )
    println(list)
}


/**
 * Kotlin 标准库函数 withLock
 *
 */
fun lookForAlice(people: List<Person5Lambda>) {
    for (p in people) {
        if (p.name == "Alice") {
            println("Found")
            return
        }
    }
    println("lookForAlice111----Alice is not Found")
}

/**
 * 非内联lambda函数中使用return是不允许的
 */
fun lookForAlice222(people: List<Person5Lambda>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found")
            return
        }
    }
    println("lookForAlice222 --Alice is not Found")
}


fun lookForAlice333(people: List<Person5Lambda>) {
    people.forEach label@{
        if (it.name == "Alice") {
            println("Found")
            return@label
        }
    }
    println("Alice is not Found")
}

fun lookForAlice444(people: List<Person5Lambda>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found")
            return@forEach
        }
    }
    println("Alice is not Found")
}

/**
 * 匿名函数：默认使用局部返回 --- lambda语法的另一种语法形式
 * 函数 名字 和 参数类型省略
 *
 */
fun lookForAlice555(people: List<Person5Lambda>) {
    people.forEach(
            fun(person) {
                if (person.name == "Alice") return
                println("${person.name} is not Alice")
            })
}

/**
 * return
 * 从最近的使用  fun关键字声明  的函数返回
 */





