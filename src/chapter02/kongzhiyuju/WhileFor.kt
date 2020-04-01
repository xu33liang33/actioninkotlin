package chapter02.kongzhiyuju

import java.util.*
import kotlin.reflect.jvm.internal.impl.protobuf.Internal

// while和java一样

// 区间
val oneToTen = 1..10

fun main(args: Array<String>) {

	println(oneToTen)

	println()
	println("***************************")

	for (i in 100 downTo 1 step 2) {
		print(fizzBuzz(i))
	}

	//------------------------------------------

	val charNumber = 'A'

	println(charNumber.toInt())

	for (c in 'A'..'Z') {
		val binary = Integer.toBinaryString(c.toInt())//二进制字符串
		binaryReps[c] = binary// 不用get  put
	}

	//迭代map
	for ((letter01, binary01) in binaryReps) {
		println("$letter01 = $binary01")
	}

	println()

	//下标写法
	val list = arrayListOf("a", "b", "c")

	for (a in list) {
		println(" $a")
	}
	for ((index, element) in list.withIndex()) {
		println("$index : $element")
	}

	println()
	println("***************************")

	for (a in list.withIndex()) {
		val element:IndexedValue<String> = a
		println(" $a")
	}
}

fun fizzBuzz(i: Int) = when {
	i % 15 == 0 -> "FizzBuzz "
	i % 3 == 0 -> "Fizz "
	i % 5 == 0 -> "Buzz "
	else -> "$i "
}

//迭代map
val binaryReps = TreeMap<Char, String>()







