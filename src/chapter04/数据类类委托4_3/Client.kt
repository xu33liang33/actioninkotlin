package chapter04.数据类类委托4_3

/**
 * Java定义了许多需要在类中实现的机械方法/toString/equals/hashCode
 *
 */
class Client(val name: String, val postalCode: Int) {
    override fun toString() = "Client(name=$name,postalCode=$postalCode)"
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client)
            return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int {
        return name.hashCode() * 234 + postalCode
    }

    fun copy(name: String = this.name, postalCode: Int = this.postalCode) = Client(name, postalCode)
}

fun main(args: Array<String>) {
    val client1 = Client("taylor", 10010)
    val client2 = Client("taylor", 10010)
    println(client1)
    /**
     * java'分基本数据类型和引用数据类型
     * kotlin中"=="检查对象是否相等而不是引用，编译器调用equals
     * kotlin中想要进行引用比较，用"==="
     */

    println(client1 == client2)
    println(client1 === client2)
    // 如果两个对象相等，必须有着相同的hash值
    val processed = hashSetOf(Client("Alice", 333))
    println(processed.contains(Client("Alice", 333)))

}