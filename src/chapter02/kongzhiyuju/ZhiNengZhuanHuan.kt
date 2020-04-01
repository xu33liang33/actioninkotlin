package chapter02.kongzhiyuju

// 智能转换 标记接口
interface Expr

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr


fun evalOrigin(e: Expr): Int = //表达式函数
        if (e is Num) {
            e.value
        } else if (e is Sum) {
            eval(e.right) + eval(e.left)
        } else {
            throw IllegalArgumentException("Unkonw type")
        }

fun eval1(e: Expr): Int = //表达式函数
        when (e) {
            is Num -> e.value
            is Sum -> eval(e.right) + eval(e.left)
            else -> throw IllegalArgumentException("Unkonw type")
        }

fun eval(e: Expr): Int {
    if (e is Num) {//is 判断类型类似“instanceOf”
        val n = e as Num // 多余代码不用显示转换不用强转-智能转换
        return n.value
    } else if (e is Sum) {
        return eval(e.left) + eval(e.right)
    }
    throw IllegalArgumentException("Unkonw type")
}


fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))

    println(evalWithLoging(Sum(Sum(Num(1), Num(2)), Num(4))))
}


// 代码块中最后的表达式就是结果
fun evalWithLoging(e: Expr): Int =
        when (e) {
            is Num -> {
                println("num:${e.value}")
                e.value
            }
            is Sum -> {
                val left = evalWithLoging(e.left)
                val right = evalWithLoging(e.right)
                println("sum:$left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("Unkonw type")
        }
























