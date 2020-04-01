package chapter09


/**
 *  并不能声明、泛型 普通非扩展属性
 *  原则-保证运行时 类型都是已知的
 */
//val <T> error:T  = TODO()

/**
 * kotlin泛型的细节
 *
 * 实化类型参数   --  允许你在   运行时的  内联函数  中引用作为类型实参的具体类型
 * (普通类和函数会被擦除)
 * 普通 函数 不可以，因为运行时 类型会被擦除
 *
 * 声明点变型       --   声明一个带类型参数的泛型类型，是否是另一个
 * 泛型类型的子类型或者超类型
 */
fun main(args: Array<String>) {

    val list = listOf(1, 2, 3, 4, 5)
    /**
     * 泛型函数
     * <T>      类型行参声明
     * 将类型 形参   ----- 到 类型实参
     */
    val result = list.slice(1..4)
    val result1 = list.subList(1, 4)
    println(result)
    list.filter {
        it % 2 == 0
    }

    val letters = ('a'..'z').toList()
    println(letters.size)
    println(letters.slice<Char>(0..2))// <Char>可以省略
    println(letters.slice(10..15))// <Char>可以省略

    // 扩展属性
    /**
     * 并不能声明、泛型 普通非扩展属性
     */
    println(listOf(1, 2, 333333333, 4).penultimate)
    println(listOf(1, 2, 3, 4).sum())
    println()
    val helloWorld = StringBuffer("Hello world")
    ensureTrail(helloWorld)
    println(helloWorld)

    println()
    println()

    // 不能检查 类型被擦除了
//    if(list  is List<String>){
//
//    }


    /**
     * 检测变量是一个list而不是set
     * 星号投影
     */
    if (list is List<*>) {
        list.sum()
    }

    if (list is Set<*>) {

    }
}
//
//fun <T>  List<T>.filter(predicate:(T) -> Boolean):List<T>{
//
//}

fun <T> jfjfj(a: T) {

}


/**
 * 泛型的扩展属性-能在任何种类元素的列表上调用
 */
val <T> List<T>.penultimate: T
    get() = this[size - 2]

/**
 * 类型参数约束
 */
//fun <T : Number> List<T>.sum():T{
//
//}


fun <T> ensureTrail(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith(".")) {
        seq.append(".")
    }
}

/**
 * 让类型形参非空
 */
fun process(T: Any) {

}




