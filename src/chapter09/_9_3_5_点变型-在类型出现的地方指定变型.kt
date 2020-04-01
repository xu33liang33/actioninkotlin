package chapter09


/**
 *  java 中 可以指定  类型参数 是否可以用它的子类型或者超类型替代
 *  --- 使用点变型 java 通配符 （? extends）(? super)
 *
 *  java ---- Function<? super T,? extends R>
 *
 *  kotlin 的使用点变型
 */
fun main(args: Array<String>) {

    val list = mutableListOf(1, 2, 3)
    val any = mutableListOf<Any>()

//    copyData(list,any)
    copyData2(list, any)
//    copyData2(any,list)
    println(any)



}

fun <T> copyData(source: MutableList<T>,
                 destination: MutableList<T>) {
    for (item in source) {
        destination.add(item)
    }
}

fun <T : R, R> copyData2(source: MutableList<T>,
                         destination: MutableList<R>) {
    for (item in source) {
        destination.add(item)
    }
}

fun <T> copyData3(source: MutableList<out T>,
                 destination: MutableList<T>) {
    for (item in source) {
        destination.add(item)
    }
}



