package chapter04.gouzao4_2.interuser

/**
 * 接口可以包含属性
 */
interface InterUser {
    //这个值在实现此接口的类中必须手动重写
    val nickName: String
}

// 主构造方法属性
class PrivateUser(override val nickName: String) : InterUser

class SubscribingUser(val email: String) : InterUser {
    override val nickName: String
        // 自定义getter
        // 访问时计算
        get() = email.substringBefore("@")
}

class FacebookUser(val accountId: Int) : InterUser {
    override val nickName = "test"//属性初始化
}

interface UserInitGet {
    val email: String
    // 每次访问时通过计算得到
    val nickName: String
        get() = email.substringBefore("@")
}

fun main(args: Array<String>) {
    val user = User1("Alice")
    println(user.address)
    user.address = "Ealkjsfla 41,123421 Msalkjs"
    println(user.address)
}

class User1(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            //field 属性（反射知识）
            println("""
                Address was changed for $name:
                "$field" -> "$value".

            """.trimIndent())
            field = value
        }
}