package chapter08._8_2

import java.io.Closeable

/**
 * lambda被编译成匿名类/
 * lambda捕捉变量的化每次调用都会新建一个类
 *
 * 内联函数-消除lambda带来的运行时开销
 *
 * inline 修饰符 只能提高带有lambda参数的函数的性能
 *
 * 函数体会被直接替换到函数被调用的地方
 *
 * 一般lambda包裹在实现了函数接口的 匿名内部类 中
 */
class Lock : Closeable {
    override fun close() {}
    fun lock() {}
    fun unlock() {}
}

fun main(args: Array<String>) {
    val l = Lock()
    synchronized(l) {

    }
}

inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    } finally {
        lock.unlock()
    }
}
fun foo(l: Lock) {
    println("Before  sync")

    synchronized(l) {
        println("Action")
    }
    println("After sync")
}
/**
 * 编译后的foo函数
 */
fun _foo_(l: Lock) {
    println("Before  sync")///////

    l.lock()
    try {
        println("Action")/////////////
    } finally {
        l.unlock()
    }

    println("After sync")///////
}

/**
 * 传递函数类型的变量作为参数
 * 这种情况body没有被内联，因为在调用的地方没有lambda
 */
class LockOwner(val lock:Lock){
    fun  runUnderLock(body:() -> Unit){
        synchronized(lock,body)
    }
}



/**
 * 内联函数限制
 * 不是 所有lambda都能被内联
 *
 */

/**
 * 内联集合操作
 * 内联函数总是很小的
 * filter源码
 * 不期望传递 进来是 内连的 noinline
 */
public inline fun <T> Iterable<T>.filter(noinline predicate: (T) -> Boolean): List<T> {
    return filterTo(ArrayList<T>(), predicate)
}



