package chapter05.集合函数式API

import chapter02.kongzhiyuju.fizzBuzz
import java.io.File

fun main(args: Array<String>) {

    /**
     * 为啥说序列是惰性的呢？
     */
    //中间操作
    listOf(1, 2, 3, 4, 5).asSequence()
            .map { println("map($it)"); it * it }
            .filter { println("filter($it)  ");it % 2 == 0 }

    // 末端操作  toList()
    val result01 = listOf(1, 2, 3, 4, 5).asSequence()
            .map { println("map($it)"); it * it }
            .filter { println("filter($it)  ");it % 2 == 0 }
            .toList()
//    println("---------------------")
//    println(result01)

    //注意效率问题 filter/map

    /**
     * 创建序列
     * generateSequence函数
     * seed 种子 第一个
     * 有延期操作的序列
     * 最后sum才执行
     */
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numberTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numberTo100.sum())

//    val result = 1..100
//    println(result)
//    for (i in 100 downTo 1 step 2) {
//        print(fizzBuzz(i))
//    }

    val file = File("/Users/svtk/.Hiddendir/a.txt")
    println(file.isInsideHiddenDirectory())

}

fun File.isInsideHiddenDirectory() = generateSequence(this)
{ it.parentFile }.any { it.isHidden }

