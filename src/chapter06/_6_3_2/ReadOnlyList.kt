package chapter06._6_3_2

/**
 *
 * Kotlin的集合设计有很大的不同
 * kotlin将访问集合数据的集合和修改集合数据的接口分开了
 *
 * Collection接口没有任何添加和移除元素的方法
 *
 * MutableCollection全
 *
 *          Collection                      MutableCollection
 *    -----------------------           -------------------------
 *    |   size              |           |   add()               |
 *    |   iterator()        | <---------|   remove()            |
 *    |   contains()        |           |   clear()             |
 */
fun main(args: Array<String>) {



}