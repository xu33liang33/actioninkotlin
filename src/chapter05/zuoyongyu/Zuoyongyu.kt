package chapter05.zuoyongyu

import java.awt.Button

/**
 * 函数内声明匿名内部类在其内可以引用这个函数的参数和局部变量，
 * lambda也可以
 */
fun main(args: Array<String>) {
    val errors = listOf("403 Forbidden", "404 Not Found")
    errors.forEach { println(it) }

    printMSGWithPrefix(errors, "Http Errors:")

    val response = listOf("200 OK", "418 I`m a teapot", "500 Internal Server Error")
    printProblemCounts(response)
}

fun printMSGWithPrefix(message: Collection<String>, prefix: String) {
    message.forEach {
        println("$prefix $it")
    }
}

/**
 * kotlin中不会仅限于访问final变量，在lambda内部也可以修改
 * kotlin允许内部访问非final变量甚至修改他们《"lambda捕捉"》
 */
fun printProblemCounts(response: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    response.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors,$serverErrors server errors")
}


/**
 *  这么写是不对的，对局部变量的修改只会在lambda执行的时候发生
 *  写成类的属性
 */
fun tryToCountButtonClicks(button: Button): Int {
    var clicks = 0
    button.addActionListener {
        clicks++
    }
    return clicks
}









