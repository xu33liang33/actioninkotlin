package chapter04

class ButtonPure : Clickble {
    override fun click() {
        println("I am clicked~~~~!!Pure")
    }
}

fun main(args: Array<String>) {
    ButtonPure().click()
}