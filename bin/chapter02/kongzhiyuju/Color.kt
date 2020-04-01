package chapter02.kongzhiyuju

import chapter02.kongzhiyuju.Color.*

// enum 软关键字 01
enum class Color {
	RED, ORANGE, YELLOW, GREEN, BLUE, INDOGO
}

// when 03 基本用法
fun getMnemonic(color: Color) =
		when (color) {
			Color.RED -> "红"
			Color.ORANGE -> "橘"
			Color.YELLOW -> "黄"
			Color.GREEN -> "绿"
			Color.BLUE -> "蓝"
			else -> "sss"
		}

fun getWarmth(color: Color) = when (color) {// when写不全的话会提示你错误（全或者else处理）
	Color.RED, Color.ORANGE -> "Worm"
	Color.BLUE -> "cold"
	else -> "soso"
}


// when  允许任何对象 04
//  导入了kongzhiyuju.Color.* 可以直接用枚举了
fun mix(c1: Color, c2: Color) =
		when (setOf(c1, c2)) {
			setOf(RED, YELLOW) -> ORANGE
			setOf(GREEN, BLUE) -> INDOGO
			else -> throw Exception("bad girl")
		}

//   不带参数的when 04
fun mix1(c1: Color, c2: Color) =
		when {
			(c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
			else -> throw Exception("bad girl")
		}
	
	
	






