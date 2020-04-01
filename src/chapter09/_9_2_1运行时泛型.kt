package chapter09

import java.lang.IllegalArgumentException

/**
 * 运行时泛型---擦除和实化类型参数
 * 声明 inline 函数，使类型实参 不被擦除
 *
 * 擦除：---你创建了List<String> 运行时只能看到它是List，不能识别里面的元素类型
 */
fun main(args: Array<String>) {

    /**
     * list1 list2 的String 和 Int 会被擦除，
     */
    val list1 :List<String> = listOf("a","b")
    val list2 :List<Int> = listOf(1,2,3)

    /**
     * 星号投影 * -----来检查是不是一个列表～～
     *
     * 拥有未知类型实参的泛型类型---java：List<?>
     */
    if(list1 is List<String>){
        println("checked")
    }

    /**
     * 星号投影～
     *
     * 不关注list内部东西，判断是否是 list
     *
     */
    if(list1 is List<*>){
        println("checked")
    }

    printSum(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

    //有意思 因吹斯汀
    /**
     * Exception in thread "main" java.lang.ClassCastException:
     * java.lang.String cannot be cast to java.lang.Number
     * 说明什么？：因为没有办法判断实参是不是一个List<Int>
     *
     */
    printSum(list1)

}

/**
 *
 *
 */
fun printSum(c: Collection<*>) {
    val intList = c as? List<Int> ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

/**
 * Cannot check for instance of erased type : T
 */
//fun <T> isA921(value : Any) =  value is T

