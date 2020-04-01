package chapter04.xiushifu4_1_2

/**
 * final        不能被重写               类成员默认使用
 * open         可以被重写               需明确表明
 * abstract     必须被重写               只能在抽象类中：抽象成员不能有实现
 * override     重写父类或接口中的成员     没有final则表明是open的
 */
//   抽象类 抽象成员始终是open的
abstract class Animated { //  抽象类不能创建实例
    abstract fun animate() // abstract 没有实现，必须由子类重写
    open fun stopAnimating() {// 可以标注为open的
    }
     fun animateTwice() {// 非抽象函数不是默认open的
        println("abstract - method")
    }
}