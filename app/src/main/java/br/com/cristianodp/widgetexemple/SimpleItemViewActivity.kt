package br.com.cristianodp.widgetexemple

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SimpleItemViewActivity : AppCompatActivity() {
    var i = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_item_view)

        var incomes = findViewById<br.com.cristianodp.widge.SimpleItemView>(R.id.Incomes);
        incomes.setValue("$ 200.00")
        incomes.setOnClickListener {
            if (i==0){
                i = 1
            }else{
                i = 0
            }
            incomes.setAppearance(i)
        }

    }
}
