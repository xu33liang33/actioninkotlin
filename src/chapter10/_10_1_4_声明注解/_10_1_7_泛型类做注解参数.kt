package chapter10._10_1_4_声明注解

import chapter10.json.kotlin.CustomSerializer
import chapter10.json.kotlin.DeserializeInterface
import chapter10.json.kotlin.ValueSerializer
import java.util.*


fun main(args: Array<String>) {


}

//interface ValueSerializer<T> {
//    fun toJsonValue(value: T): Any?
//    fun fromJsonValue(jsonValue: Any?): T
//}

class DataSerializer: ValueSerializer<Date> {
    override fun fromJsonValue(jsonValue: Any?): Date {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toJsonValue(value: Date): Any? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

data class Person1017(
        val name:String,
        @CustomSerializer(DataSerializer::class) val birthDay:Date
)




