package chapter03.jubuhanshu

import chapter03.jubuhanshu.validateBeforeSave

// 局部函数-帮助减少代码冗余Do not repeat yourself

fun main(args: Array<String>) {
    saveUser(User(1, "", ""))
    saveUser1(User(1, "", ""))
}

/**

 */
fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("can`t save user ${user.id} :empty Name")
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException("can`t save user ${user.id} :empty Address")
    }
}

fun saveUser1(user: User) {
    fun validate(user: User,
                 value: String,
                 fileName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("can`t save user ${user.id} :empty $fileName")
        }
    }

    validate(user, user.name, "name")
    validate(user, user.address, "address")
}

//局部函数可以访问方法体中所有参数和变量
fun saveUser2(user: User) {
    fun validate(
            value: String,
            fileName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("can`t save user ${user.id} :empty $fileName")
        }
    }

    validate(user.name, "name")
    validate(user.address, "address")
}

fun saveUser3(user: User) {
    user.validateBeforeSave(user)
}













