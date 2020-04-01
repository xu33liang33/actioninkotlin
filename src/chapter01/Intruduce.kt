package chapter01

import java.net.InetAddress
import java.util.*
import kotlin.collections.LinkedHashMap


/**
 * JetBrains公司产品
 * 第一部分：高效编写实用现有API和Kotlin代码
 *  （语句·函数·类·_6_1_2_类型）
 */

//初体验
data class Person(
		val name: String,
		val age: Int? = null
)

fun main(args: Array<String>) {
	val persons = listOf(Person("Alice"), Person("Bob", age = 20))
	val oldest = persons.maxBy {
		it.age ?: 0
	}
	println("oldest is $oldest")


//	val map = HashMap<String, Int>()
//	val map = HashMap<String, Int>()
	val map = LinkedHashMap<String, Int>()
	map["语文"] = 1
	map["数学"] = 2
	map["英语"] = 3
	map["历史"] = 4
	map["政治"] = 5
	map["地理"] = 6
	map["生物"] = 7
	map["化学"] = 8
	for ((key, value) in map) {
		println("$key: $value")
	}

	println("-----------------------")

	//获取本机InetAddress的实例：
	//获取本机InetAddress的实例：
	val address = InetAddress.getLocalHost()
	println("本机名：" + address.hostName)
	println("IP地址：" + address.hostAddress)
	val bytes = address.address
	println("字节数组形式的IP地址：" + Arrays.toString(bytes))
	println("直接输出InetAddress对象：$address")


}


/**
 * KT 会自动类型推断
 *   对空值处理
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