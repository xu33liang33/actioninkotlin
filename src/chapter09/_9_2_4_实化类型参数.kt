package chapter09

import chapter01.Person
import java.util.*
import javax.xml.ws.Service

/**
 * 泛型在运行时擦除，你无法弄清楚这个 实例创建时用的究竟是哪些类型实参
 */
//fun <T> isAAA(value: Any) = value is T

fun main(args: Array<String>) {

    /**
     * inline 函数 加 reified 例外 可以判断类型，因为编译器每次函数调用转换成实际的代码
     */
    println(isA2<String>("aaa"))
    println(isA2<String>(32))

    // reified 关键字用法  看源码
    /**
     * 过滤列表中类型的工具类
     */
    val lista = listOf("one", 2, "three", Person("a", 34))
    println(lista.filterIsInstance<String>())

    /**
     * 9.2.3
     * 使用实例化类型代替类引用
     * loadService语法更好用
     */
    ServiceLoader.load(Service::class.java)
    val serviceImpl = loadService<Service>()
    // 优化 安卓的  startActivity(intent)

    //startActivity<DetailActivity>()

    // 实化类型参数 的限制🚫
}

/**
 * 运行时检测
 */
//fun < T> isA(value: Any) = value is T

/**
 * inline大显身手-他们的类型参数 可以被实化
 * reified   关键字 具体化 只能用在inline中
 */
inline fun <reified T> isA2(value: Any) = value is T

inline fun <reified T> Iterable<*>.filterIsInstance924(): List<T> {
    val destination = mutableListOf<T>()
    for (element in this) {
        if (element is T) {
            destination.add(element)
        }
    }
    return destination
}

//加载服务类
inline fun <reified T> loadService() {
    ServiceLoader.load(T::class.java)
}


/**
 * 优化
 */
//inline fun <reified T:Activity> Context.startActivity(){
//    val intent  = Intent(this,T::class.java)
//    startActivity(intent)
//}


//startActivity<DetailActivity>()














