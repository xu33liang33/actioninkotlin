package chapter04.访问可见性4_2_5

class LengthCounter {
    // 确保只能在类中修改
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main(args: Array<String>) {
    val lengthCounter = LengthCounter()
    lengthCounter.addWord(word = "Taylor Swift")
//    lengthCounter.counter = 40
    println(lengthCounter.counter)
    lengthCounter.addWord(word = "hello")
    println(lengthCounter.counter)
}