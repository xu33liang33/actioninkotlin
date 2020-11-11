package chapter04.testby

/**
 * 装饰器模式
 * 新建个类实现之前类的接口 并将之前类作为成员变量保存
 */

class DelegatingCollection<T>(

        innerList: Collection<T> = ArrayList<T>()
) : Collection<T> by innerList {}


class CountingSet<T>(
        val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {

    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }

}

fun main(args: Array<String>) {

    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 3))

    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
}