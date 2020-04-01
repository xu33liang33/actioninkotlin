package chapter08._8_1_2

data class SiteVisit(
        val path: String,
        val dutation: Double,
        val os: OS
)

//函数类型和lambda 一起去除重复代码
enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

fun main(args: Array<String>) {
    val log = listOf(
            SiteVisit("/", 34.0, OS.WINDOWS),
            SiteVisit("/", 22.0, OS.MAC),
            SiteVisit("/login", 12.0, OS.WINDOWS),
            SiteVisit("/signup", 8.0, OS.IOS),
            SiteVisit("/", 16.3, OS.ANDROID)
    )

    println(log.filter { it.os == OS.WINDOWS }
            .map(SiteVisit::dutation))

    //计算windows平均时间
    val averageWindows = log.filter { it.os == OS.WINDOWS }
            .map(SiteVisit::dutation)
            .average()
    println(averageWindows)

//    println(log.filter { it.os == OS.WINDOWS }
//            .map(SiteVisit::dutation))

    val averageMobile = log.filter {
        it.os in setOf(OS.IOS, OS.ANDROID)
    }
            .map(SiteVisit::dutation)
            .average()
    println(averageMobile)


    /**
     * 普通去重方法
     */
    println()
    println("log.averageDuration(OS.ANDROID)")
    println(log.averageDuration(OS.ANDROID))
    println("------------------------")
    /**
     * 将需要的条件抽到函数类型参数中
     */
    println(log.averageDurationFor {
        it.os in setOf(OS.ANDROID, OS.IOS)
    })
    println(log.averageDurationFor {
        it.os == OS.IOS && it.path == "/signup"
    })

}

/**
 * 普通方法去重
 */
fun List<SiteVisit>.averageDuration(os: OS) = filter { it.os == os }
        .map(SiteVisit::dutation)
        .average()

/**
 * 将需要的条件抽到函数类型参数中
 * 不仅抽取重复数据，也能抽取重复行为
 */
fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
        filter(predicate)
                .map(SiteVisit::dutation)
                .average()


