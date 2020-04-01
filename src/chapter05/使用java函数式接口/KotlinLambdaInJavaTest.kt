package chapter05.使用java函数式接口

import java.awt.Button

fun main(args: Array<String>) {
    val a = Button()
    /**
     * ActionEvent接口只有一个抽象方法
     * SAM接口（单抽象方法）
     */
    a.addActionListener {
        //点击按钮后执行的动作
    }

    /**
     * 带接收者的lambda- "with" & "apply"
     * -在lambda函数体内可以调用一个不同对象的方法，而且无须借助任何额外限定符-java-n
     */
    println(alphabbet())
    println(alphabbetWith())
    println(alphabbet3())
    println(alphabetApply01())

    // apply 始终会返回作为实参传递给它的对象
}

/**
 * 长
 */
fun alphabbet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun alphabbetWith(): String {
    val sb = StringBuilder()
    //with 函数 两个参数，
    return with(sb) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        append("\nNow I know the alphabet!")//省掉this也可以调用
        this.toString()
    }
}

fun alphabbet3() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
    toString()
}


//-------------------------------------------
fun alphabetApply01() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}.toString()










