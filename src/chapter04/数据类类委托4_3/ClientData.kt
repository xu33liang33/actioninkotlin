package chapter04.数据类类委托4_3

import chapter02.leishuxing.Person

/**
 * Java定义了许多需要在类中实现的机械方法/toString/equals/hashCode
 *
 */
data class ClientData(val name: String, val postalCode: Int) {
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int {
            return o1.name.compareTo(o2.name)
        }
    }

    fun copy1(name: String = this.name, postalCode: Int = this.postalCode) = ClientData(name, postalCode)
}

fun main(args: Array<String>) {
    val client1 = ClientData("taylor", 10010)
    val client2 = ClientData("taylor", 10010)
    println(client1)
    /**
     * java'分基本数据类型和引用数据类型
     * kotlin中"=="检查对象是否相等而不是引用，编译器调用equals
     * kotlin中想要进行引用比较，用"==="
     */
    println(client1 == client2)
    println(client1 === client2)
    // 如果两个对象相等，必须有着相同的hash值
    val processed = hashSetOf(ClientData("Alice", 333))
    println(processed.contains(ClientData("Alice", 333)))

//    println(client1.copy1(postalCode = 1234))
    println(client1)
}