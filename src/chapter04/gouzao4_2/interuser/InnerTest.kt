package chapter04.gouzao4_2.interuser

class LenthCounter {
    // 不能在类外部修改这个属性
    var conter: Int = 0
        private set

    fun addWord(word: String) {
        conter += word.length
    }

    val a = ""
    val bb = a.toIntOrNull()

}



