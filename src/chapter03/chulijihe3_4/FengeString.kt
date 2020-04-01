package chapter03.chulijihe3_4


fun main(args: Array<String>) {
    println("12.345-6.A".split("."))//java 的话 必须 字符转译
    println("12.345-6.A".split("\\.|-".toRegex()))// 变成正则表达式
    println("12.345-6.A".split("\\.|-"))
    println("12.345-6.A".split(".", "-"))

    //3-5-2
    val url = "order.jd.com/center/list.action"
    // substringBeforeLast   substringAfterLast
    parsePath(url)
    println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    parsePath1(url)

    // 3-5-3 三重 引号 """   """ 字符串 不需要进行转译

    val KTLogo = """    
                        | //
                        |//
                        |/\\"""
    println(KTLogo.trimMargin())
    println(KTLogo)

    //  想要使用$必须使用 嵌入式表达式
    val price = """${'$'}99.9"""
    val price1 = """$99.9"""
    println(price)
    println(price1)
}

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir:$directory,\nfullName:$fullName,\nfileName:$fileName,\next:$extension")
}

fun parsePath1(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir:$directory,\nfileName:$fileName,\next:$extension")
    }
}











