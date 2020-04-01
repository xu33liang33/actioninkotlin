package chapter08._8_2

import chapter05.Person5Lambda
import chapter06._6_1_4_Elvis.Person615


/**
 * 操作集合的标准库函数
 * inline只能提高带有lambda参数的函数的性能
 */
fun main(args: Array<String>) {

    val list = listOf<Person5Lambda>(Person5Lambda("志玲", 45, "C")
            , Person5Lambda("空空", 36, "G"))

    // 系统提供的 API 是内联 inline的大家可以放心使用😄
    println(list.filter {
        it.age < 40
    })

    println(list.filter {
        it.age < 40
    }.map {
        it.name
    })

//    大量数据用 asSequence 序列
    val result = mutableListOf<Person5Lambda>()
    list.forEach {
        if (it.age < 40){
            result.add(it)
        }
    }
    println(result)
}