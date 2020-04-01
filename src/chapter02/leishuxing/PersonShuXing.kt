package chapter02.leishuxing

import chapter03.lastChar as last
import java.util.Random

class PersonShuXing(
        val name: String,
        var isMarried: Boolean)

// val  只有getter
// var  生成getter setter
// 属性名称 is 开头getter不增加任何前缀

//自定义访问器
data class Rectangle(private val height: Int, private val width: Int) {
    val isSquare: Boolean
        //声明属性
        get() { // 声明属性的get
            return height == width
        }

    var extraValue: Int = 0
        get() = 232
        set(value: Int) {
//            println(value)
//            extraValue = value
            field = value
            value
        }
}

fun main(args: Array<String>) {
    //自定义访问器
    val rec = Rectangle(41, 43)
    println(rec.isSquare)

    println(rec.extraValue)
    rec.extraValue = 123
    println(rec.extraValue)

    /**
     *  第三章测试方法 导入 拓展函数
     *  可以用 as 修改名字
     *  （解决命名冲突）
     */
    val a = "Java".last()

    val aa = PersonShuXing("a", false)
    println(aa.isMarried)
}

// import语句
fun createRandomRectangle(): Rectangle {
    val random = Random()//不用写 new
    return Rectangle(random.nextInt(), random.nextInt())
}
