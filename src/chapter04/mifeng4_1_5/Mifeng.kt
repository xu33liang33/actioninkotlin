package chapter04.mifeng4_1_5

interface Expr

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr


fun eval(e: Expr): Int = when (e) {
    is Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
// 潜在bug
// 解决方法 sealed 修饰符，
    else -> throw IllegalArgumentException("Unknown expression ")
}











