package chapter05

import java.awt.Button

data class Person5Lambda(val name: String, val age: Int, val zhaobei: String)

/**
 * lambda
 *
 */
fun main(args: Array<String>) {
    // lambda实现
    val a = Button()
    a.addActionListener {
        //点击按钮后执行的动作
    }

    val people = listOf(
            Person5Lambda("Alice", 25, "B"),
            Person5Lambda("linzhiling", 44, "C"),
            Person5Lambda("canglaoshi", 35, "G")
    )
    findTheOldest(people)

    //lambda 简明语法
    println(people.maxBy { it.age })
    /**
     * 如果lambda刚好是函数或者属性的委托，可以用成员引用替换
     */
    // 成员引用
    println(people.maxBy(Person5Lambda::age))

    // 看看lambda格式 可以独立声明存储到一个变量中
    /**
     * 始终用花括号包围，箭头->吧实参列表和函数体隔开
     */
    val sum = { x: Int, y: Int -> x + y }
    println(sum(5, 2));//当作普通函数对待

    //直接调用lambda表达式 可读性不佳 "()"问题
    { println(123) }()

    // 库函数 run函数
    run { println(42) }

    // 如果lambda表达式是函数调用的最后一个实参，它可以放到括号的外边
    println(people.maxBy({ p: Person5Lambda -> p.age }))//标准写法
    // 当lambda是函数唯一的实参时，还可以去掉调用代码中的空括号
    println(people.maxBy() { p: Person5Lambda -> p.age })
    //当lambda是唯一实参时可以省略括号
    println(people.maxBy { p: Person5Lambda -> p.age })

    val name1 = people.joinToString(separator = " *&* ")
    val name2 = people.joinToString(separator = " *&* ", transform = { p: Person5Lambda -> p.name })
    println("name1:" + name1)
    println("name2:" + name2)
    // 放在括号外
    val name3 = people.joinToString(" *&* ") { p: Person5Lambda -> p.name }
    println(name3)

    println(people.maxBy { p: Person5Lambda -> p.age })
    println(people.maxBy { p -> p.age })//智能推断～优先不写类型～报错再说～
    println(people.maxBy { it.age })//最终简化结果"it"自动生成的参数名称

    /**
     * 如果用变量存储lambda，就没有可推断出参数类型的上下文，所以必须制定参数类型
     */
    val sum1 = { x: Int, y: Int ->
        // 可以包含更多语句
        println("Computing the sum of $x and $y ..111")
        println("Computing the sum of $x and $y ..222")
        x + y//最后一个表达式就是结果
    }
    println(sum1(51, 23))
}

fun findTheOldest(people: List<Person5Lambda>) {
    var maxage = 0
    var theOldest: Person5Lambda? = null
    for (person in people) {
        if (person.age > maxage) {
            maxage = person.age
            theOldest = person
        }
    }
    println(theOldest)
}




