package chapter04.gouzao4_2

/**
 * constructor 开始一个主构造或从构造方法的声明
 * init用来引入一个 初始化语句块（可多个）
 * 主构造方法不能包含初始化代码所以得用init
 *
 */
class User01 constructor(_nickName: String) {
    val nickName: String

    init {
        nickName = _nickName
    }
}


