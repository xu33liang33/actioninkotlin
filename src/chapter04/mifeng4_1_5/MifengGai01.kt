package chapter04.mifeng4_1_5

/**
 * 添加新的子类 会连锁报错提醒哪里应该修改
 * seal密封
 */
sealed class Expr01 {// 默认open类
    // 将所有可能的类作为嵌套类列出
    class Num01(val value: Int) : Expr01()
    class Sum01(val left: Expr01, val right: Expr01) : Expr01()
}
/**
 * when表达式涵盖了所有的可能所以不再需要else分支
 */
fun eval01(e: Expr01): Int = when (e) {
    is Expr01.Num01 -> e.value
    is Expr01.Sum01 -> eval01(e.left) + eval01(e.right)
// 潜在bug
// 解决方法 sealed 修饰符，对可能创建的子类做严格的限制，所有的直接子类必须嵌套在父类中
//涵盖所有情况就不用再写else
}











