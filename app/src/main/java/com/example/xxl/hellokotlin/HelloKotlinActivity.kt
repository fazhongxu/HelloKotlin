package com.example.xxl.hellokotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_hello_kotlin.*

class HelloKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_kotlin)
        initData()
        initEvent()
    }

    private fun initData() {
//        var 变量
//        val 常量
//        vararg 可变参数
//        fun 定义方法
//        Unit 默认方法返回值 类似于Java中的Void ，也可省略
//        in 在某个范围类中
//        intArrayOf() int 类型数组，对应还有 arrayOf(),doubleArrayOf()等
//        $ 字符串模板，取值
//        or或运算 and 与运算 shl左移(有符号) shr 右移（有符号)  ushr右移(无符号） xor (按位异或) inv(按位取反)
//        downTo 递减
//        step 步长
//        when Kotlin中的增强版 switch ,可以匹配值、范围、类型与参数
//        is 判断类型用 相当于java中的instanceof

//        public    默认，总是可见
//        internal 同模块可见
//        protected 子类可见
//        private 声明范围内同模板和子作用域可见

        //常量
        val a: Int = 8
        val b: String = "bbb"
        val c = "ccc"
        val d: Char
        val e: Double
        val f: Boolean

        println(a)
        println(b)
        println(c)

        //变量
        var aa: Int = 10
        println(aa)
        aa = 11
        println(aa)

        val sum = sum(100, 1)
        println(sum)

        pro(1, 2)
        byteArrayOf()
        intArrayOf()
        shortArrayOf()
        doubleArrayOf()
        longArrayOf()
        floatArrayOf()
        var array = intArrayOf(1, 2, 3, 4, 5)//专门类型的数组，intArrayOf是指int类型数组
        val total = sum(1, 2, 3, 4, 5, *array)//结果为30，*array是指把array数组里面的所有元素当可变参数传递到sum方法中
        println(total)

        val strings: String = "Hello,Kotlin"
        for (a in strings) {
            println(a)//遍历strings a 是随便写的，可以是任意字母或字母组合，结果为Hello,Kotlin每个单个字母
        }

        val abcde: String = "abcde"
        println("$abcde.length=" + abcde.length) // 结果 abcde.length=5

        var dd: Int = 1024
        var ee = dd.toLong()    //没有自动向上转型，需要调用toXX

        var ff: Long = 2048L
        println(ff)

        var arr = intArrayOf(1, 2, 3, 4, 5, 6)
        for (a in 0..3) {
            println(arr[a])//1234
        }
        println(arr.indices)//indices数组下标，结果 0..5

        for (i in arr.indices) {
            println(arr[i])//根据下标遍历数组
        }

        var m: Int = 9
        var n: Int = 8

        if (m > n) m else n//相当于java中的三元表达式

        val max = max(m, n)
        println(max)

        if (a in 0..10) {
        }//如果a在0~10内
        if (a !in 0..10) {
        } //如果a不在0~10

        var arrs = intArrayOf(2, 3, 4, 5, 6, 7, 8)//注意创建数组直接是=符号
        var arrays = arrayOf("1", "2", "3", "4", "5", "6", "7")
        for (i in arrs) {
            println(i)
        }

        for (i in 5 downTo 0) {
            println(arrays[i])//结果654321
        }

        for (i in 5 downTo 0 step 2) {//结果6 4 2 step 隔着几个
            println(arrays[i])
        }

        for (i in arrays.reversed()) {//数组反转reversed
            println(i)
        }

        var grade: Int = 68
        when (grade) {//相当于Java的switch 增强版  结果 C
            100 -> println("S")
            in 90..99 -> println("A")
            in 80..89 -> println("B")
            in 60..79 -> println("C")
            else -> println("D")
        }

        var bb: Int = 22
        when (bb) {//结果，整型
            is Int -> println("整型")
            else -> println("不是整型")
        }

        try {
        val abc : Int = 1 /0
        }catch (e:Exception) {
            print(e.message)
        }
    }

    private fun initEvent() {
        btn_login.setOnClickListener {
            showToast(this, et_username.text.toString().trim()+"")
        }
        btn_cancel.setOnClickListener {
            v -> et_username.text = null
        }
    }

    //方法
    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun pro(a: Int, b: Int) {
        showToast(this, "$a * $b =" + a * b) // $字符串模板（取值）
    }

    fun sum(vararg number: Int): Int {
        var result = 0
        for (num in number) {
            result += num
        }
        return result
    }

    fun max(m: Int, n: Int): Int {
        var max = 0
        if (m > n) max = m else max = n
        return max
    }
}
