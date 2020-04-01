package chapter04.数据类类委托4_3

import java.io.*

/**
 * 实现接口的object
 */
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

fun main(args: Array<String>) {
    println(CaseInsensitiveFileComparator
            .compare(File("/User"), File("/user")))

    val list = listOf(File("/Z"),
            File("/a"), File("/g"))
    println(list.sortedWith(CaseInsensitiveFileComparator))
}