package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

/**
 * ClassName:InitSet
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-2
 * @author:liujianming
 */

fun main() {
//    initSet()
//    useSetMethods()
//    createMap()
//    useMapMethods()
//    mapIterator()
    mutableMap()
}

fun initSet() {
    //创建不可变集合，返回值是Set
    var set = setOf("Java", "Kotlin", "Go")
    println(set) //集合元素按添加顺序排列
    //创建可变集合，返回值是MutableSet
    var mutableSet = mutableSetOf("Java", "Kotlin", "Go")
    println(mutableSet) //集合元素按添加顺序排列
    println("setOf的返回对象的实际类型:${set.javaClass}")
    println("mutableSetOf的返回对象的实际类型：${mutableSet.javaClass}")
    //创建HashSet集合
    var hashSet = hashSetOf("Java", "Kotlin", "Go")
    println(hashSet)  //不保证元素的顺序
    //创建LinkedHashSet集合
    var linkedHashSet = linkedSetOf("Java", "Kotlin", "Go")
    println(linkedHashSet)  //集合元素按添加顺序排列
    //创建TreeSet集合
    var treeSet = sortedSetOf("Java", "Kotlin", "Go")
    println(treeSet)  //集合元素从小到大排列
}

fun useSetMethods() {
    //创建不可变结合，返回值是Set
    var set = setOf("Java", "Kotlin", "Go")
    //判断是否所有元素的长度都大于4
    println(set.all ({ it.length > 4 }))  //输出false
    //判断是否任一元素的长度都大于4
    println(set.any({it.length > 4}))  //输出true
    //以lambda表达式的值为key，集合元素为value,组成Map集合
    val map = set.associateBy { "《疯狂" + it + "讲义》" }
    println(map)
    //由于有contains()方法，所以可用in、!in运算符
    println("Java" in set)
    println("Go" !in set)
    //返回删除Set集合前面两个元素后的集合
    val dropedList = set.drop(2)
    println(dropedList)
    //对Set集合元素过滤：要求集合元素包含li
    val filteredList = set.filter { "li" in it }
    println(filteredList)
    //查找Set集合涨包含li的元素，如果找到就返回该元素，否则返回null
    val foundStr1 = set.find { "li" in it }
    println(foundStr1)
    //查找Set集合中包含gang的元素，如果找到就返回该元素，否则返回null
    val foundStr2 = set.find { "gang" in it }
    println(foundStr2)
    //将Set集合中的所有字符串拼接在一起
    val foldeList = set.fold("", {acc, e -> acc + e})
    println(foldeList)
    //查找某个元素的出现位置
    println(set.indexOf("Go"))
    //将每个集合元素映射成新值,返回所有新值组成的Set集合
    val mappedList = set.map { "《疯狂" + it + "讲义》" }
    println(mappedList)
    //获取最大值
    println(set.maxOrNull())
    //获取最小值
    println(set.minOrNull())
    //反转集合顺序
    val reversedList = set.reversed()
    println(reversedList)
    var bSet = setOf("Lua", "Erlang", "Kotlin")
    //计算两个集合的交集
    println(set intersect bSet)
    //计算两个集合的并集
    println(set union bSet)
    //集合相加，相当于并集
    println(set + bSet)
    //集合相减，减去它们公共的元素
    println(set - bSet)
}

fun testMutableList() {
    //创建可变集合，返回值是List
    var mutableList = mutableListOf("Kotlin", null, "Go")
    //索引2处插入一个新元素
    mutableList.add(2, "Java")
    println(mutableList)
    //删除索引1处的元素
    mutableList.removeAt(1)
    println(mutableList)
    //将索引1处的元素替换为“Lua ”
    mutableList[1] = "Lua"
    println(mutableList)
    //清空List集合的所有元素
    mutableList.clear()
    println(mutableList.size)
}

fun createMap() {
    //创建不可变集合，返回值是Map
    var map = mapOf<String, Int>("Java" to 86, "Kotlin" to 92, "Go" to 78)
    println(map)
    //创建可变集合，返回值是MutableMap
    var mutableMap = mutableMapOf<String, Int>("Java" to 86, "Kotlin" to 92, "Go" to 78)
    println(mutableMap)
    println("mapOf的返回对象的实际类型：${map.javaClass}")
    println("mutableMapOf的返回对象的实际类型：${mutableMap.javaClass}")
    //创建HashMap集合
    var hashMap = hashMapOf("Java" to 86, "Kotlin" to 92, "Go" to 78)
    println(hashMap)
    //创建LinkedHashMap集合
    var linkedHashMap = linkedMapOf("Java" to 86, "Kotlin" to 92, "Go" to 78)
    println(linkedHashMap)
    //创建TreeMap集合
    var treeMap = sortedMapOf("Java" to 86, "Kotlin" to 92, "Go" to 78)
    println(treeMap)
}

fun useMapMethods() {
    //创建不可变集合，返回值是Map
    var map = mapOf("Java" to 86, "Kotlin" to 92, "Go" to 76)
    //判断是否所有key-Value对的key的长度都大于4、value都大于80
    println(map.all { it.key.length > 4 && it.value > 80 })  //输出false
    //判断是否任一key-value对的key的长度都大于4、value都大于80
    println(map.any { it.key.length > 4 && it.value > 80 })  //输出false
    println("Java" in map)  //输出true
    println("Go" !in map)  //输出false

    //对Map集合元素进行过滤：要求key包含li
    val filteredMap = map.filter { "li" in it.key }
    println(filteredMap)
    //将每个key-value对映射成新值，返回所有新值组成的Map集合
    val mappedList = map.map { "《疯狂${it.key}讲义》 价格为：${it.value}" }
    println(mappedList)
    //根据key获取最大值
    println(map.maxByOrNull { it.key })
    //根据value获取最小值
    println(map.minByOrNull { it.value })
    var bMap = mapOf("Lua" to 67, "Erlang" to 73, "Kotlin" to 92)
    //集合相加，相当于并集
    println(map + bMap)
    //集合相减，减去它们公共的元素
    println(map - bMap)
}

fun mapIterator() {
    //创建不可变集合，返回值是Map
    var map = mapOf("Java" to 86, "Kotlin" to 92, "Go" to 76)
    //遍历Map的key-value对，entris元素返回key-value对组成的
    for (en in map.entries) {
        println("${en.key} -> ${en.value}")
    }
    //先遍历Map的key，再通过key获取value
    for (key in map.keys) {
        println("${key} -> ${map[key]}")
    }
    //直接用for-in循环遍历Map
    for( (key,value) in map) {
        println("${key} -> ${value}")
    }
    //用lambda表达式遍历Map
    map.forEach({println("${it.key} -> ${it.value}")})
}

fun mutableMap() {
    var mutableMap = mutableMapOf("OC" to 96, "PHP" to 3400,
            "Perl" to 4300, "Ruby" to 5600, "Go" to 5600)
    //以方括号语法放入key-value对
    mutableMap["Swift"] = 9000
    println(mutableMap)
    //用put方法放入key-value对
    mutableMap.put("OC", 8600)
    println(mutableMap)
    //删除key为“Perl”的key-value对
    mutableMap.remove("Perl")
    println(mutableMap)
    println(mutableMap.size)
    //删除所有元素
    mutableMap.clear()
    println(mutableMap)
    println(mutableMap.size)
}


class TestSet {
}