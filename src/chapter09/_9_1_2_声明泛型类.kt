package chapter09

/**
 * 声明泛型类-----和java一样，通过在类名称后加上一对尖括号，
 * 并把类型参数放在尖括号內来声明泛型及泛型接口
 *
 */
interface List912<T> {
    operator fun get(index: Int): T
}

class StringList : List912<String> {
    override fun get(index: Int): String {
        return "aaa"
    }
}

class ArrayList<TT> : List912<TT> {
    override fun get(index: Int): TT {

        return TODO()
    }
}



