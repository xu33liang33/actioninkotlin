package chapter04.数据类类委托4_3

import chapter02.leishuxing.Person

/**
 * object的类是没有class的-单例
 * 不允许出现构造方法
 */
object Payroll {
    val allEmployees = arrayListOf<Person>()
    fun caculateSalary() {
        for (person in allEmployees) {
            // ....
        }
    }
}

fun main(args: Array<String>) {
    Payroll.allEmployees.add(Person("rose"))
    Payroll.caculateSalary()
}