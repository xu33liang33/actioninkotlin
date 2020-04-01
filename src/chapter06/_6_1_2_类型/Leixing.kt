package chapter06._6_1_2_类型

fun main(args: Array<String>) {

    /**
     * 什么是类型？-数据的分类，决定了该类型可能的值，以及该类型的值上可以完成的操作
     */

    /**
     * 安全调用运算符 "?."
     * 它允许你吧一次null检查和一次方法调用合并成一个操作
     *
     *                  ----------(foo!=null)--->foo.bar()
     *                 |
     * foo?.bar()-----
     *                 |
     *                  ----------(foo == null)->null
     *  只会调用非空值的方法
     *
     */
    printAllCaps("abc")
    printAllCaps(null)

    /**
     * 安全 运算符访问属性
     */
    val ceo = Employee("Nan", null)
    val manager = Employee("Tom", ceo)
    println(managerName(ceo))
    println(managerName(manager))

}

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    println(allCaps)
}

fun managerName(employee: Employee): String? = employee.manager?.name

class Address(val street: String)
class Company(val name: String, val address: Address?)
class Person(val neme: String, val company: Company?)

