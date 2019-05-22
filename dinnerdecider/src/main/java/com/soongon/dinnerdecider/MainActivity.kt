package com.soongon.dinnerdecider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arr = arrayListOf("Chinese", "Dominoz", "Berger King", "China Town", "Food Mart")

        decideBtn.setOnClickListener {
            val random = Random()
            val abc = arr.size
            val a = random.nextInt(abc)
            mainTxt.text = arr[a]
        }

        addBtn.setOnClickListener {
            if (addTxt.text.toString() != ""){
                val qw = addTxt.text.toString()
                arr.add(qw)
                addTxt.text.clear()
            }
        }
    }
}
