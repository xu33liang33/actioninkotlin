package chapter07

data class Point002(val x: Int, val y: Int) {

    operator fun plus(other: Point002): Point002 {
        return Point002(x + other.x, y + other.y)
    }
}


fun main() {
    val x1 = Point002(1, 3)
    val x2 = Point002(10, 30)

    println((x1 + x2).plus(x1))


    val a1 = 100
    val b1 = 120
    println(Integer.toBinaryString(a1))
    println(Integer.toBinaryString(b1))
    /**
     * shl  |
     * shr  |
     * ushr |
     * and  |
     * or   |
     * xor  |
     * inv  |
     */
    println(a1 shr 3)
    println(a1 ushr 3)

}