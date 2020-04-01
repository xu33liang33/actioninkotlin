package chapter04.gouzao4_2

/**
 *
 */
class QQUser(override val nickName: String,
             val age: Int) : UserMain(nickName)

// 确保不被实力化加 private
class Secretive private constructor()


