package chapter04.xiushifu4_1_2

import chapter04.Clickble1

// open 类可以被继承
open class RichButton : Clickble1 {
    final override fun click() { // override 本身就是open的
    }// 想不让继承在前面加final

    open fun disable() {} // final 方法不能在子类中重写
    open fun animate() {} // open方法可以被重写
}