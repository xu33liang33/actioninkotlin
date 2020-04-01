package chapter08

/**
 *
 *  lambda帮助我们构建抽象概念
 *  内联函数---消除lambda带来的性能开销，使lambda內的控制流更加灵活
 *
 *  声明一个高阶函数-使用lambda作为参数或返回值的函数
 *
 */
fun main(args: Array<String>) {

    // 声明高阶函数----以另一个函数作为参数或者返回值的函数
    // 栗子： filter库函数
    val listFilter = listOf(1, 2, 3, 4, 5, 6)
    val re = listFilter.filter {
        it % 2 == 0
    }

    println(listFilter)
    println(re)
    println("----------")

    /**
     * 函数类型
     */
    val sum = { x: Int, y: Int -> x + y }
    val action = { println(333) }// () -> kotlin.Unit  断点看类型

    /**
     *  格式：
     *  需要将函数参数类型放在括号中，紧跟一个 箭头 和函数返回类型
     *  (Int,String) ->  Unit
     *  函数声明中Unit不能 省略（void 不返回有用的值）
     */
    //函数类型的返回值也可以 显式 标记为可空类型
    val sum1: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    val sum2: (Int, Int) -> Int = { x, y -> x + y }
    val action1: () -> Any = { println(333) }
    val action2: () -> Unit = { println(333) }   // Unit不能省略

    // 返回 类型也可以标记为可空 的
    var canReturnNull: (Int, Int) -> Int? = { a, b -> a * b }
    val canReturnNull02: (Int, Int) -> Int? = { a, b -> a + b }
    var funOrNull: ((Int, Int) -> Int)? = null//函数为空
    /**
     * 函数类型可空变量
     */
    var funOrNull2: ((first: Int, second: Int) -> Int)? = null//函数参数可以指定参数名

    run {
        println(canReturnNull02(1, 2))
    }
    run {
        println("222")
    }
    run {
        action()
    }
    run {
        action1()
    }
    run {
        action2
    }

    performRequest("http://kotlin.in") { code, content ->
        println(code)
        println(content)
    }

    /**
     *支持改名字
     */
    performRequest("http://kotlin.in") { aaa, bbb ->
        println(aaa)
        println(bbb)
    }

    val list = mutableListOf(1, 2, 3, 6, 9, 3, 1, 46, 8, 44, 7)

    list.sortBy {
        -it
    }

    println(list)
}


/**
 * 可以为函数类型声明中的参数指定名字
 */
fun performRequest(
        url: String,
        callback: (code: Int, content: String) -> Unit // 有名字了
) {


}