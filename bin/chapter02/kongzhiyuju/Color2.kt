package chapter02.kongzhiyuju

// 带属性的枚举类 02
enum class Color2(val r: Int, val g: Int, val b: Int) {
	RED(255, 0, 0),
	GREEN(0, 255, 0),
	BlUE(0, 0, 255);

	fun rgb() = (r * 256 + g) * 256 + b
}


fun main(args: Array<String>) {
	println("Hello World!")
}