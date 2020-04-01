package chapter04.gouzao4_2

/**
 * 如果主构造方法没有注解或可见性修饰符，
 * 可以去掉constructor关键字
 * val 意味着相应的属性会用构造方法的参数
 * 来初始化
 *
 */
class User02(_nickName: String) {
    val nickName = _nickName
}


