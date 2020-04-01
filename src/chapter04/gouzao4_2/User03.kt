package chapter04.gouzao4_2

/**
 *被括号围起来的语句块 就叫-主构造方法-
 *
 *  val
 *
 */
class User03(val nickName: String = "a",
             val isSub: Boolean = true)

fun main(args: Array<String>) {
    val a = User03("bbbb", false)
    val a2 = User03()
//    a.isSub = true
    val a1 = User03(nickName = "bqweqw", isSub = false)
    println("${a.nickName}---${a.isSub}")
    println("${a2.nickName}---${a2.isSub}")


    val userMain = UserMain("lkgfghjk")
    println(userMain.nickName)

    mainding(null)
}