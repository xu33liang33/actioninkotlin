package chapter09


/**
 *Comparable 源码 in
 */
fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4, 2, 3, 5, 8, 0)
    println(list.sorted())

    val anyComparator = Comparator<Any> { e1, e2 ->
        e1.hashCode() - e2.hashCode()
    }

    /**
     * Comparator<Any> 是 Comparator<String> 的子类型
     * Any 是 Sting 的超类
     * sortedWith函数期望一个
     */
    val listS = listOf<String>("qw", "ru", "zxz", "fbf", "sda", "asd")
    println(listS.sortedWith(anyComparator))


    /**
     *        Animal           <----------           Cat
     *
     *
     *        Producer<Animal> <---------- (协变)     Producer<Cat>   out
     *
     *
     *        Consumer<Animal> ----------> （逆变）   Consumer<Cat>     in
     *
     */



}

interface Comparator934<in T> {
    fun compare(e1: T, e2: T): Int
}

interface Function1<in P, out R> {
    operator fun invoke(p: P): R
}

