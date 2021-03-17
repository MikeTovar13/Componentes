package com.draakoon.componentes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstButton = findViewById<Button>(R.id.firstButton)
        val secondButton = findViewById<Button>(R.id.secondButton)

        firstButton.setOnClickListener {
            this.showFragment(color = RedFragment())
        }
        secondButton.setOnClickListener {
            this.showFragment(color = BlueFragment())
        }
    }

    fun showFragment(color: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, color, null)

        if (color.javaClass.simpleName == "GreenFragment" ) {
            transaction.addToBackStack(null)
        }

        transaction.commit()

    }

}