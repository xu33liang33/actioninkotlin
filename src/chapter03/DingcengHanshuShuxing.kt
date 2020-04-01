package chapter03

import chapter03.joinToString1

/**
 * 顶层函数和属性
 */
fun main(args: Array<String>) {
    val list = arrayListOf(1, 7, 23, 18, 5, 17)
//    joinToString1(list)// 顶层函数
    list.sort()
    println(joinToString1(list))

    // 顶层属性
    println(UNIX_LINE_SEPARATOR)

    // public static final = const

    println(UNIX_LINE_SEPARATOR01)

    //拓展函数 和 属性
    // 拓展函数不能访问私有的或者受保护的成员
    println("Kotlin".lastChar())
    println("Kotlin".lastChar)


}

//拓展函数  String 接收者类型， this 接收者对象
// String类添加了自己的方法
/**
 * 不会自动在全项目生效，必须import才能用
 */
fun String.lastChar(): Char = this[this.length - 1]

/**
 * 拓展属性  必须定义 getter方法
 */
val String.lastChar: Char
    get() = get(length - 1)

/**
 * 可变的拓展属性 get set
 */
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }















