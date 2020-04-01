package chapter06._6_1_4_Elvis

/**
 *
 * 可空类型的扩展
 *
 * 扩展函数可以为可空类型定义扩展处理null
 * 例如标准库中的isEmpty或者isBlank
 *
 */
fun main(args: Array<String>) {
    "a".isEmpty()
//    null.isEmpty()
    "".isBlank()

    verifyInput(null)

    printHashCode(null)
//    printHashCode1(null)
}

/**
 * 不需要安全调用就能访问可空类型扩展
 *
 * java中this不能是null类型
 * kotlin 不一样
 *
 */
fun verifyInput(input: String?) {
    if (input.isNullOrBlank()) {
        println("aaa")
    }
}


/**
 * kotlin中泛型和泛型函数参数默认可空
 *
 */
fun <T> printHashCode(a: T) {
    println(a?.hashCode())
}

/**
 * 要使类型非空必须指定  非空上界
 *
 */
fun <T : Any> printHashCode1(a: T) {
    println(a.hashCode())
}



















