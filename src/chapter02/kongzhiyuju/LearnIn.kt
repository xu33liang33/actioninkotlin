package chapter02.kongzhiyuju

import java.io.BufferedReader

// in  反义词 !in

fun recognize(c: Char) = when (c) {
	in '0'..'9' -> "It is a digit!"
	in 'a'..'z' -> "It is a letter!"
	else -> "other!"
}

// in 这么厉害能不能String也在 范围呢？
fun main(args: Array<String>) {
	println("Kotlin" in "Java".."Scala")
	println("Kotlin" in setOf("Java", "Scala"))

	val number = 20
	val percentage =
			if (number in 0..100) {
				println(number)
				number
			} else {
				throw IllegalArgumentException("$number not in 0--100")
			}
}

// kotlin中的异常处理
fun readNumber(reader: BufferedReader): Int? {//  方法不用显示 扔出 异常
	try {
		val line = reader.readLine()
		return Integer.parseInt(line)
	} catch (e: NumberFormatException) {// exception不用引入我的天
		return null
	} finally {
		reader.close()
	}
}

//try 表达式
fun readNumber01(reader: BufferedReader){//  方法不用显示 扔出 异常
	val number01 = try {
		Integer.parseInt(reader.readLine())
	} catch (e: NumberFormatException) {
		return 
	}
	println(number01)
}























