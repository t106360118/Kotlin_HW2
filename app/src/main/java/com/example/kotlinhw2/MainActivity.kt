package com.example.kotlinhw2

import android.content.Intent
import android.content.SyncRequest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.sent);
        btn.setOnClickListener{
            val i = Intent();
            i.setClass(this,Main2Activity::class.java);
            startActivityForResult(i,0);

        }

    }
    override fun onActivityResult(requestCode: Int,resultCode: Int, data: Intent?){
        if (requestCode == 0)
        {
            if (resultCode == 101)
            {
                val str1 = data?.getBundleExtra("key")?.getString("drink_level");
                val str2 = data?.getBundleExtra("key")?.getString("sugar_level");
                val str3 = data?.getBundleExtra("key")?.getString("ice_level");

                val t_drink = findViewById<TextView>(R.id.drink);
                val t_sugar = findViewById<TextView>(R.id.sugar);
                val t_ice = findViewById<TextView>(R.id.ice);

                t_drink.setText(str1);
                t_sugar.setText(str2);
                t_ice.setText(str3);
            }
        }
    }

}
