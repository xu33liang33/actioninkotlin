package chapter08._8_1_2

enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

/**
 *
 */
fun main(args: Array<String>) {
    val caculator = getShippingCostCalculator(Delivery.EXPEDITED)
    println("Shipping costs ${caculator(Order(3))}")

}

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return { a ->
            6 + 2.1 * a.itemCount
        }
    }
    return { order ->
        1.2 * order.itemCount
    }
}


/////////////////////////////////////////////








