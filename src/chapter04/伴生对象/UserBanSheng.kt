package chapter04.伴生对象

import chapter03.jubuhanshu.User

class UserBanSheng {
    val nickName: String

    constructor(email: String) {
        nickName = email.substringBefore("@")
    }

    constructor(faceBookAccountId: Int) {
        nickName = "asfaf"
    }
}
class NewBanShengUser private constructor(val nickName:String){
    companion object {
        fun newSubUser(email: String) = NewBanShengUser("tom")
        fun newFacebookUser(accoutID:Int) = NewBanShengUser(nickName = "facebook"+ accoutID)//getFaceBookName(acounty:Int)
    }
}

fun main(args: Array<String>) {
    val a = NewBanShengUser.newSubUser("qqq@qqq.com")
    val b = NewBanShengUser.Companion.newFacebookUser(10010)
}



