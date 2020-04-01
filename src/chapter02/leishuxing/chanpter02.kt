package chapter02.leishuxing


/**
声明函数	·变量·类	枚举·属性
控制语句
智能转换
异常处理
 **/
class chanpter02 {

    //标准main函数 NB
    fun main(args: Array<String>) {
        println("Hello World!11111")
    }
}

//标准main函数
fun main(args: Array<String>) {
    println("Hello World!222")//简洁包装
    println(max(1, 2))


}

/**
带返回值的函数
 **/
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

//表达式函数体
fun max1(a: Int, b: Int): Int = if (a > b) a else b

//表达式函数体 进一步省略
fun max2(a: Int, b: Int) = if (a > b) a else b


fun test() {}