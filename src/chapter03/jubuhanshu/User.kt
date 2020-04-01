package chapter03.jubuhanshu

class User(val id: Int, val name: String, val address: String)

fun User.validateBeforeSave(user: User) {
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