package chapter10._10_1_4_声明注解

/**
 * 在类前加 annotation
 * 注解类：用来定义 关联到 声明和表达式 的元数据的结构，
 * 不能包含任何代码，编译器禁止为注解类指定类主体
 *
 * Java注解有个叫 value的方法
 * kotlin注解拥有一个name属性
 * @JsonName(name = "first_name")和@JsonName("first_name")含义一样
 */
@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude

/**
 * val强制的
 * 对拥有参数的注解来说，在类的主构造函数中声明这些参数
 */
annotation class JsonName(val name: String)


/** Java */
//public @interface JsonName{
//    String value();
//}
fun main(args: Array<String>) {

}

/**
 * 元注解-可以应用到注解类的注解/控制如何处理一个注解
 * @Target------说明注解可以应用的元素类型～没有则说明都可以 应用
 * @Target(AnnotationTarget.PROPERTY)
 * 声明自己的元注解--用
 * @Target(AnnotationTarget.ANNOTATION_CLASS)
 */
/**
 * java中@Retention(RetentionPolicy.RUNTIME)
 * Retention---说明注解是否会存储到.class文件/和运行时是否可以通过反射访问到
 * java默认保留 注解 但是不会让 他们在运行时被访问到，虽然大多情况需要被访问
 *
 * 所以：
 * Kotlin中默认：注解拥有RUNTIME保留期。
 *
 */


