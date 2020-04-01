package chapter10

import chapter06._6_1_4_Elvis.Person615
import chapter10.json.kotlin.JsonExclude
import chapter10.json.kotlin.JsonName
import chapter10.json.kotlin.deserialization.deserialize
import chapter10.json.kotlin.serialization.serialize

/**
 * 一般--要调用一个函数，你需要知道它定义在那个类，--注解和反射 赋予你 超越这个规则的能力
 * 使用事先未知的任意类的代码
 * 反射---允许你在运行时分析 这些类的结构
 * 注解---允许你把额外的 元数据 关联到一个声明上----赋予这些类库特定的语义
 */
@Synchronized
fun main(args: Array<String>) {

    listOf("args :", *args)

    val person = Person615("F", "L")
    val person1 = PersonIntro10("F", 32)
    println(serialize(person))
    println(serialize(person1))

    val json = """
        {"firstName": "FFF", "lastName": "LLL"}
        """.trimIndent()
    val json1 = """{"alias": "F"}"""
    println(deserialize<Person615>(json))
    println(deserialize<Person615>(json).firstName)

    println()
    println(deserialize<PersonIntro10>(json1).firstName)

    // 差评
//    val list = mutableListOf(1, 2, 3, 4, 5)
//    println(serialize(list))

    val a = setOf(1, 2, 3, 1, 121, 3, 2, 1)
    println(a)
    println(a.size)


}

/**
 * @JsonExclude 排除在序列化之外
 */
data class PersonIntro10(
        @JsonName("alias") val firstName: String,
        //Exclude 不包括
        @JsonExclude val age: Int? = null
)

/**
 * ReplaceWith:注解作为参数传递时的示例
 * ReplaceWith 加强了Deprecated的用法
 * IDE 会直接提示你并更换好
 */
@Deprecated("Deprecated", ReplaceWith("oleioleiolei(index)"))
fun ggo() {
    @Suppress("UNCHECKED_CAST")
    val a = ""

}

/**
 * 注解  只能拥有如下类型参数：
 * 基本数据类型
 * 字符串
 * 枚举
 * 类引用
 * 其他的注解类
 * 上述类型的数组
 *
 * 把一个类指定为  注解实参---在类名后加上 " ::class "
 * 把另一个注解类指定为实参，去掉注解名称前的@
 * 把数组指定为实参---用" arrayOf " @RequestMapping(path = arrayOf("/foo","/bar"))
 *
 * Only 'const val' can be used in constant expressions
 *
 */


/**
 * 使用点目标：放在@符号和注解名称之间：  "@get:Rule"
 *
 *  Kotlin支持的点目标：
 *  property----Java注解不能应用这种使用点目标
 *  field-------为属性生成的字段
 *  get---------属性的 getter
 *  set---------属性的 setter
 *  receiver----扩展函数或者扩展属性的接收者参数
 *  param-------构造方法参数
 *  setparam----属性 setter 的参数
 *  delegate----为委托属性存储委托实例的字段
 *  file--------包含在文件中声明的顶层函数和属性的类
 *  （应用到file的注解必须放到文件顶层，package 指定之前）
 *
 */


/**
 *
 * @JvmName 将改变由Kotlin生成的Java方法或字段的名称
 * @JvmStatic 用在对象声明或 伴生对象的方法上，把他们暴露成Java的静态方法
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


