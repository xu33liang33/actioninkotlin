package chapter04.gouzao4_2

import javax.naming.Context
import javax.swing.text.AttributeSet

/**
 * 重载 构造方法 （多用 默认参数）
 */
open class ViewTest {
    // 无主构造方法
    constructor(ctx: Context) {
        // balabala
    }

    constructor(ctx: Context, attr: AttributeSet? = null) {
        // balabala
    }
}

// ViewTest没有括号，这里继承不用括号
// 有括号会报错
class MyButton : ViewTest {
    constructor(ctx: Context)
            : super(ctx) {
    }

    constructor(ctx: Context, attr: AttributeSet)
            : super(ctx, attr)
}

class MyButton1 : ViewTest {
    constructor(ctx: Context)
            : this(ctx, null) {
    }

    constructor(ctx: Context, attr: AttributeSet? = null)
            : super(ctx, attr)
}

fun main(args: Array<String>) {
    val a = UserMain("aaa")

    a.nickName
    println("asdasd")
}

fun mainding(args: Array<String>?) {
    val a = UserMain("aaa")

    a.nickName

    println("asdasd")
}








