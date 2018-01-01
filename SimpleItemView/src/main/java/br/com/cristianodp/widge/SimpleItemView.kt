package br.com.cristianodp.widge

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by crist on 01/01/2018.
 */
class SimpleItemView : LinearLayout {

    //Text views
    private lateinit var mIcon: ImageView
    private lateinit var mTitle: TextView
    private lateinit var mValue: TextView


    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(attrs)
    }


    /**
     * Initialize view
     */
    private fun init(attrs: AttributeSet?) {

        View.inflate(context, R.layout.simple_item_view_layout, this)

        //Get references to text views
        mIcon = findViewById<ImageView>(R.id.ImageViewIcon)
        mTitle = findViewById<TextView>(R.id.TextViewLabel)
        mValue = findViewById<TextView>(R.id.TextViewValue)

        val customAttrs = context.obtainStyledAttributes(
                attrs,
                R.styleable.SimpleItemView)

        var icon = customAttrs.getDrawable(R.styleable.SimpleItemView_icon)
        var label = customAttrs.getString(R.styleable.SimpleItemView_label)
        var value = customAttrs.getString(R.styleable.SimpleItemView_value)


        mIcon.setImageDrawable(icon)
        mTitle.text = label
        mValue.text = value
    }
}