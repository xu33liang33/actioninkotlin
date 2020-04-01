package chapter04

class Button1 : Clickble1, Focusable {
    override fun click() {
    }
    /**
     * 这个不是接口里的showOff他们都有自己的默认实现，但是有重名必须实现自己的，
     * 强制实现自己的方法，
     */
    override fun showOff() {
        // 基类写在尖括号里
        super<Clickble1>.showOff()
        super<Focusable>.showOff()
    }
    // 也可以写成函数表达式
//    override fun showOff() = super<Clickble1>.showOff()
}