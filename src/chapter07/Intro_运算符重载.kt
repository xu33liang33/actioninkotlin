package chapter07

import java.lang.IndexOutOfBoundsException
import java.math.BigDecimal
import java.time.LocalDate
import kotlin.ranges.ClosedRange as ClosedRange1

/**
 *
 *运算符重载
 * BigDecimal运算
 *  约定 operator
 *
 *  a * b   |   times
 *  a / b   |   div
 *  a % b   |   mod
 *  a + b   |   plus
 *  a - b   |   minus
 *
 */
fun main(args: Array<String>) {
    BigDecimal.ZERO

    var p1 = Point(10, 20)
    val p2 = Point(30, 40)

    println(p1 + p2)
    println(p1.plus(p2))
    p1 += p2
    println(p1)
    println(p2 * 5.toDouble())

    var bd = BigDecimal.ZERO
    println(++bd)

    val a = Point(10, 20) == Point(10, 20)
    println("equal: $a")


    val p111 = Person722("Alice", "Smith")
    val p222 = Person722("Bob", "Johnson")
    println(p111 < p222)

    println(p2[1])

    println('a' in "abc")

}

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    fun and(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    /**
     * Point(10,20) == Point(10,20)
     */
    override fun equals(obj: Any?): Boolean {
        if (obj === this) return true
        if (obj !is Point) return false
        return obj.x == x && obj.y == y
    }

}

operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

/**
 *
 * 重载一元运算符
 *
 * +a           |   unaryPlus
 * -a           |   unaryMinus
 * !a           |   not
 * ++a,a++      |   inc
 * --a,a--      |   dec
 *
 */
operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE

/**
 * 比较运算符
 *
 * equals
 * == 运算符
 *
 */

/**
 *
 * 排序运算符
 * compareTo 接口
 *
 */
class Person722(val firstName: String, val lastName: String) : Comparable<Person722> {
    override fun compareTo(other: Person722): Int {
        return compareValuesBy(this, other, Person722::lastName, Person722::firstName)
    }
}


/**
 * 集合与区别的约定
 *  a[b]    下标运算符 "get"和"set"
 *
 *
 */
operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

/**
 * "in"的约定
 * contains
 *
 *
 */

data class Rectangle732(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle732.contains(p: Point): Boolean {
    return p.x in upperLeft.x until lowerRight.x &&
            p.y in upperLeft.y until lowerRight.y
}

/**
 * rangeTo 约定
 * ".."符号 1..10
 *实现了Comparable 接口就不需要实现rangeTo了～因为标准库已经实现
 */
//operator fun<T:Comparable<T>> T.rangeTo(that:T) : kotlin.ranges.ClosedRange<T> {
//    1..10
//}

/**
 * for循环中使用iterator的约定
 *
 *
 *
 */












