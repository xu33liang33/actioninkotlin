package chapter02.leishuxing

//类型推断

val a = "StringValue"

val anser = 42
val anser01: Int = 42

val yearsOfCompute = 7.5e6

//可变和不可变
val value = "Value"            //一次赋值
var variable = "variable"

fun main(args: Array<String>) {
    //引用本身不可变，指向的对象可变-类型声明后不再改变
    val languege = arrayListOf("Java", "aaa")
    languege.add("Kotlin")
//	languege = 42

    val answer: Int
    answer = 1

    // 字符串模版
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello $name")

}

















