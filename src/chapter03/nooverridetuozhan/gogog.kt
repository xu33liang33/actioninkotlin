package chapter03.nooverridetuozhan

fun main(args: Array<String>) {

    //  正常的重写
    val view: View = Button()
    view.click()

    // 不可重写拓展函数
    view.showOff()

}

fun View.showOff() = println("I am a view ")

fun Button.showOff() = println("I am a Button ")