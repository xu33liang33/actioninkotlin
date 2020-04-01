package chapter09

/**
 * 变型：-------- 描述了拥有 相同 基础类型和 不同类型实参的（泛型）类型间如何关联
 *
 *  如：List<String> he List<Any> 如何关联
 */

interface Transformer<T> {
    /**
     * () 里是 in 位置
     * : 后是 out 位置
     *
     * out关键字标记后只能出现在out位置
     * 构造方法的参数 既不是 in 也不是 out
     *
     * 然而如果 构造参数前 加上 val 或者 var
     * 只覆盖 public/protected/internal
     * private不限制不是in和out
     */
    fun transform(t: T): T
}

fun main(args: Array<String>) {

    /**
     * 安全的  String 给 Any
     */
    printContents(listOf("abc", "def"))

    val strings = mutableListOf("abc", "edf")
    val a: String = "a"
    // ****黑人问号脸****
    /**
     * 区别就是 只读  和 可变的区别
     */
//    addAnswer(strings)

    /**
     * 类/类型/子类型
     *
     * 612-类型---- 规定了该类型的可能值
     *
     * List 不是一个类型 是 类
     * 非空类型  是  可空类型   的子类型
     *
     *  A?   <-------  A
     *
     * 如果A是B的子类型---List<A>  List<B>是协变的（子类型被保留了）
     *
     */
    val s: String = "asa"
    val t: String? = s


    /**
     * 协变泛型类 ---- 如果A 是B的子类型，那么 Producer<A> 就是 Producer<B>
     *     子类型化 被 保留了 Cat 是  Animal 的子类型，那么 Producer<Cat> 就是 Producer<Animal>
     *
     * 要声明类在某个 类型参数上是可以协变的，在类型参数名称前加上 out 关键字
     *  out 不能随便用 不安全
     *  只能生产 不能 消费
     */

    val animal = Animal()
    animal.feed()

    feedAll(Herd1())

    feedAll(Herd())

}

/**
 * 协变的
 */
interface Producer<out T> {
    fun produce(): T
}

fun printContents(list: List<Any>) {
    println(list.joinToString())
}

fun addAnswer(list: MutableList<Any>) {
    list.add(42)
}


/**
 * 只有 值 的类型是变量的子类型时，才允许 变量 存储该值
 */
fun test(i: Int) {
    val n: Number = i // int 是 number的子类型

    fun f(s: String) {

    }
    /**
     * 报错---
     */
//    f(i)
}

///////////////////////////////////////

//out 例子   协变
/**
 * kotlin 源码
 *
 * public interface List<out E> : Collection<E> {
 * public interface MutableList<E> : List<E>, MutableCollection<E> {
 */
open class Animal {
    open fun feed() {
        println("feed")
    }
}

open class Cat : Animal()

/**
 *
 */
open class Herd<out T : Animal> {

    val list: List<T> = mutableListOf()
    val size: Int get() = 3
    //    val ele:T = T
    operator fun get(i: Int): T {
        return list[i]
    }

//    fun put(t: T) {
//
//    }

}

class Herd1 : Herd<Cat>()

fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals[i].feed()
    }
}

open class A<in T : Animal> {
    fun put(e: T) {

    }

    fun out() {

    }
}

fun test2() {
    val a = A<Cat>()
    val b = A<Animal>()
    test(a)
    test(b)
}

fun test(param: A<Cat>) {
    param.put(Cat())
}




