package chapter04.伴生对象

/**
 * Kt中不能拥有静态成员，Java的"static"关键字不是Kt语言的一部分
 */
class BanSheng {
    //companion关键字，获得了直接通过容器类名称来访问这个对象的方
    // 法属性的能力，不再需要显示地指明对象的名称，
    //最终看起来像Java中的静态方法调用
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

fun main(args: Array<String>) {
    BanSheng.bar()
}






