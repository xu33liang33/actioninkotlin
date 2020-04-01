package chapter01


/**
 * JetBrains公司产品
 * 第一部分：高效编写实用现有API和Kotlin代码
 *  （语句·函数·类·_6_1_2_类型）
 */

//初体验
data class Person(val name: String, val age: Int? = null)

fun main(args: Array<String>) {
	val persons = listOf(Person("Alice"), Person("Bob", age = 20))
	val oldest = persons.maxBy { it.age ?: 0 }
	println("oldest is $oldest")
}


/**
 * KT 会自动类型推断
对空值处理
 *	不用“；”
 */
fun typeTuiDuan() {
	val a = 1
	var b = "1234"
}


//函数类型
//lambda表达式
//数据类
//标准库API
//fun findAlice() = findPerson { it.name == "Alice" }

//eclipse安装插件 help-eclipsemarketplace



// 借助Java2Kotlin转换器 学习