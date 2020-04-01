package chapter04.对象表达式

import java.awt.Button
import java.awt.event.*

fun main(args: Array<String>) {

    val button = Button()
    // 匿名内部类 不是单例的哦
    button.addActionListener(object :ActionListener{
        override fun actionPerformed(e: ActionEvent?) {

        }
    })
}