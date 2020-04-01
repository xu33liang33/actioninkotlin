package chapter04.xiushifu4_1_2

import chapter04.Clickble1

// open 类可以被继承
open class RichButton1 : Clickble1 {
    final override fun click() { // override 本身就是open的
    }// 想不让继承在前面加final
}