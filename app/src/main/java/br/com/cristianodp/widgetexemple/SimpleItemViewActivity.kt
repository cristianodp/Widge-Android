package br.com.cristianodp.widgetexemple

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SimpleItemViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_item_view)

        var incomes = findViewById<br.com.cristianodp.widge.SimpleItemView>(R.id.Incomes);
        incomes.setValue("$ 200.00")
    }
}
