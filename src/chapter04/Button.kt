package chapter04

class Button : Clickble1 {

    /**
     * 未实现的必须实现
     */
    override fun click() {
        println("I am clicked~~~~!!")
    }

    /**
     * 有默认实现的可以省略
     */
    override fun showOff() {
        super.showOff()
    }
}

fun main(args: Array<String>) {
    Button().click()
}










