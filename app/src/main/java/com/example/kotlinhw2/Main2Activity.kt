package com.example.kotlinhw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class Main2Activity : AppCompatActivity() {
    private var sugar = "無糖"
    private var ice_opt = "微冰";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val rg1 = findViewById<RadioGroup>(R.id.radioGroup1);
        rg1.setOnCheckedChangeListener() { _, checkedId ->
            when(checkedId){
                R.id.radio0 ->{
                    sugar = "無糖";
                }
                R.id.radio1 ->{
                    sugar = "少糖";
                }
                R.id.radio2 ->{
                    sugar = "半糖";
                }
                R.id.radio3 ->{
                    sugar = "黃金比例";
                }
            }
        }
        val rg = findViewById<RadioGroup>(R.id.radioGroup);
        rg.setOnCheckedChangeListener() { _, checkedId ->
            when(checkedId){
                R.id.radioButton1 ->{
                    ice_opt = "微冰";
                }
                R.id.radioButton2 ->{
                    ice_opt = "少冰";
                }
                R.id.radioButton3 ->{
                    ice_opt = "正常冰";
                }
            }
        }
        val sent_btn =findViewById<Button>(R.id.sent)
        sent_btn.setOnClickListener(){
            val set_drink = findViewById<EditText>(R.id.editText1)
            val temp = set_drink.text.toString();
            val b = Bundle();
            val i = Intent();
            b.putString("sugar_level",sugar);
            b.putString("drink_level",temp);
            b.putString("ice_level",ice_opt);
            i.putExtra("key",b);
            setResult(101,i);
            finish();
        }
    }
}
