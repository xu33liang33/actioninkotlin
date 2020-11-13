package chapter05.集合函数式API

import chapter05.Person5Lambda
import java.util.*
import java.util.Collections.shuffle

fun main(args: Array<String>) {
    /**
     * filter
     * 函数可以从集合中移除你不想要的元素，但是它并不会改变这些元素。
     *
     * map
     * 函数对集合中每一个元素应用给定的函数并把结果收集到一个新集合，元素个数不改变
     */
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    for (i in 0..20) {
        shuffle(list)
        println("Collections.shuffle:$list")
    }


    println(list.filter {
        it % 3 == 0
    })
    //    println(list)

    val people = listOf<Person5Lambda>(Person5Lambda("Alice", 25, "B"),
            Person5Lambda("ZHiling", 44, "C"), Person5Lambda("Bob", 29, "D"))

    val aaa = people.map {
        it.zhaobei
    }
    println()
    println()
    println()
    println(aaa)
    println()
    println()
    println()

    println(people.filter {
        it.age > 30
    })
    //    println(people)

    val listMap = listOf(1, 2, 3, 4)
    println(listMap.map {
        it * it
    })

    println(listMap)
    //    println(listMap)
    println(people.map {
        it.zhaobei
    })
    //成员引用
    println(people.map {
        Person5Lambda::zhaobei
    })

    //年龄大于30人的名字
    println(people.filter {
        it.age > 40
    }.map {
        it.name
    })

    //找出年龄最大人的名字
    println(people.filter {
        it.age == people.maxBy(Person5Lambda::age)?.age
    })

    println(people.maxBy { it.age })


    println()
    println("########all any count find##########")
    /**
     * all any count find 对集合应用判断式
     * 查找集合中是否符合某种条件-all / any
     * count 数量
     * find 返回第一个符合条件的元素
     */
    val canBeInClub27 = { p: Person5Lambda -> p.age > 27 }
    println(people.all(canBeInClub27))

    // 查找是否存在至少一个
    println(people.any(canBeInClub27))

    //计数
    println(people.count(canBeInClub27))//更高效
    println(people.filter(canBeInClub27).size)

    //找到一个满足的-元素
    println(people.find(canBeInClub27))
    println(people.find { it.age > 27 })
    println(people.firstOrNull(canBeInClub27))


    println()
    println("######## groupBy ##########")
    /**
     * groupBy-把列表转换成分组的map
     * Map<Int,List<Person5Lambda>>
     */
    println(people.groupBy { it.age })

    val listB = listOf("a", "cv", "av", "bmw", "bbc")
    println(listB.groupBy(String::first))

    println()
    println("######## flatMap  flatten ##########")
    /**
     * 处理嵌套集合中的元素
     * flatMap -合并集合
     *  1.先做映射
     *
     * flatten方法
     *
     */
    val bookA = Book("Kotlin 实战", listOf("Dmitry Jemerov", "Svetlana Isakova"))
    val bookB = Book("hhhh", listOf("Alice", "tiger", "huojin", "Dmitry Jemerov"))
    val listBook = listOf(bookA, bookB)

    //统计所有作者
    val result = listBook.flatMap { it.anthors }.toSet()
    println("------------------------------------flatMap------------------------------------")
    println(result)

    val strings = listOf("abc", "abcdef")
    println(strings.flatMap { it.toList() })
    println(strings.flatMap { it.toList() }.toSet())

    //如果你不需要任何变换，只是需要平铺一个集合-用flatten
    val list1 = listOf(1, 2, 3, 4)
    val list2 = listOf(11, 2, 31, 4)
    val listOfList = listOf(list1, list2)
    println(listOfList.flatten())

    println()
    println("######## 序列 ##########")
    /**
     * 惰性集合操作：序列
     * 前面学到的链式集合调用都会"及早的"创建集合，每一步都返回一个集合：filter/map
     */
    val h = people.map(Person5Lambda::name).filter { it.startsWith("A") }
    println(h)
    // 如果元素个数很多～过百万级别-效率问题突出
//    序列登场 结果一样，但是中间没有创建任何用于存储元素的中间集合，效率高
    val aa = people.asSequence()//可以逐个列举元素的元素序列
            .map(Person5Lambda::name)
            .filter { it.startsWith("A") }
            .toList()//做反向转换
    println(aa)

    //asSequence   toList做反向操作？？序列这么好为啥还要toList
    //只是需要迭代元素，


}