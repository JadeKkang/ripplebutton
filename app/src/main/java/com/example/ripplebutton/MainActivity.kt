package com.example.ripplebutton

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.ripples.OnClick
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt.setOnclick(this)
    }

    override fun onClick(view: TextView) {
        Toast.makeText(this, "点我了", Toast.LENGTH_SHORT).show()
    }
}
