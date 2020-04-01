package chapter08._8_1_2

import java.lang.StringBuilder

/**
 *  高阶函数实现
 *  调用作为参数的函数
 */
fun main(args: Array<String>) {
    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a * b }
    twoAndThree { a, b -> a * b + 100 }

    println("a1b～！#@c！dz".filter {
//        println("01filter:      $it")
        it in 'a'..'z'
    })
}

/**
 * 实现两个数字2/3的任意操作
 * 调用函数类型参数语法---和普通函数一样
 */
fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

/**
 * 实现系统函数filter
 * String       -接收者类型(第一个String)
 * predicate    -参数类型
 * (Char)       -作为参数传递的函数的参数类型-括号不能省略/括号不能省略/括号不能省略
 * Boolean      -作为参数传递的函数的返回类型
 * (Char) -> Boolean    -函数类型参数
 */
fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
//        println("02for:         $index - $element")
        if (predicate(element)) {// 条件为true返回到 结果中{
//            println("03append:      $index - $element")
            sb.append(element)
        }
    }
    return sb.toString()
}

/**
 * 函数类型在java中被声明成普通的接口
 */
//813   FunctionN invoke() 方法
fun processTheAnswer(f: (Int) -> Int) {
    println(f(43))
}









