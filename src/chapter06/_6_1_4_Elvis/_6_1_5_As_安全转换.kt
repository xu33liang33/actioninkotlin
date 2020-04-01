package chapter06._6_1_4_Elvis

/**
 * 安全转换 "as?"
 * 安全转换尝试把值转换成给定的类型，否则返回null
 *
 *                  ----------(foo is Type)--->foo as Type
 *                 |
 * foo as? Type ----
 *                 |
 *                  ----------(foo !is Type)->null
 *
 */
class Person615(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Person615 ?: return false
        return other.firstName == firstName && other.lastName == lastName
    }
}

private var intNum: Int? = null
private lateinit var intNum11: Person615

/**
 * 不初始化就用也会报错
 */
lateinit var a: String

fun main(args: Array<String>) {
    val p1 = Person615("A", "B")
    val p2 = Person615("A", "B")

    println(p1 == p2)

    println(p1.equals(p2))
    println(p1.equals(false))

    val sss = null
    sss?.let {
        println("----------")
    }

    var aaaa: Int = 20
    var bbbb: Long? = 3
    bbbb = aaaa as?  Long

    println(bbbb)

}


/**
 *  "
 *  非空断言"
 *
 *
 *                  ----------(foo !=snull)--->foo
 *                 |
 * foo!! ----------
 *                 |
 *                  ----------(foo == null)->NullPointerException
 *
 *
 */


/**
 *
 * let 函数                       foo != null
 *                           ----------------lambda 內it是非空的
 *       foo?.let{           |
 *          ...it...   -----
 *       }                   |
 *                           ----------------什么都不会发生
 *                               foo == null
 */







