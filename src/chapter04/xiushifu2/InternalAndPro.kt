package chapter04.xiushifu2

import chapter04.Focusable

/**
 * 修饰符                     类成员                 顶层声明
 * public（默认）           所有地方可见              所有地方可见
 * internal                 模块可见                模块可见
 * protected               子类中可见               ---------
 * private                  类中可见                文件中可见
 */
internal open class TalkativeButton : Focusable {

    fun yell() = println("Hey!")

    protected fun whisper() = println("Let`s talk!")

}

internal fun TalkativeButton.giveSpeech() {// 默认是public的不行
    yell() // private的不能被访问

//    whisper()//子类才能访问
}

fun main(args: Array<String>) {
    val a = TalkativeButton()
    a.giveSpeech()
}










