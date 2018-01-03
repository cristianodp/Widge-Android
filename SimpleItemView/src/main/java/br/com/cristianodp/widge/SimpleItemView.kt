package br.com.cristianodp.widge

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by crist on 01/01/2018.
 */
class SimpleItemView : LinearLayout {

    private lateinit var mConstraintLayoutContainer: ConstraintLayout
    private lateinit var mIcon: ImageView
    private lateinit var mLabel: TextView
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
    @SuppressLint("Recycle")
    private fun init(attrs: AttributeSet?) {

        val customAttrs = context.obtainStyledAttributes(
                attrs,
                R.styleable.SimpleItemView)

        val icon = customAttrs.getDrawable(R.styleable.SimpleItemView_icon)
        val label = customAttrs.getString(R.styleable.SimpleItemView_label)
        val value = customAttrs.getString(R.styleable.SimpleItemView_value)
        val size = customAttrs.getDimension(R.styleable.SimpleItemView_textSize,0f)
        val color = customAttrs.getColor(R.styleable.SimpleItemView_textColor,0)
        val sizeLabel = customAttrs.getDimension(R.styleable.SimpleItemView_textSizeLabel,0f)
        val colorLabel = customAttrs.getColor(R.styleable.SimpleItemView_textColorLabel,0)
        val sizeValue = customAttrs.getDimension(R.styleable.SimpleItemView_textSizeValue,0f)
        val colorValue = customAttrs.getColor(R.styleable.SimpleItemView_textColorValue,0)
        val backgroundColor = customAttrs.getColor(R.styleable.SimpleItemView_backgroundColor,0)
        val style = customAttrs.getInt(R.styleable.SimpleItemView_style,0)

        var view_layout = R.layout.simple_item_view_layout
        when (style) {
            0 -> view_layout = R.layout.simple_item_view_layout
            1 -> view_layout = R.layout.simple_item_center_view_layout
            else -> { // Note the block
                view_layout = R.layout.simple_item_view_layout
            }
        }

        View.inflate(context, view_layout,this)

        //Get references to text views
        mIcon = findViewById<ImageView>(R.id.ImageViewIcon)
        mLabel = findViewById<TextView>(R.id.TextViewLabel)
        mValue = findViewById<TextView>(R.id.TextViewValue)
        mConstraintLayoutContainer = findViewById<ConstraintLayout>(R.id.ConstraintLayoutContainer)

        mIcon.setImageDrawable(icon)
        mLabel.text = label
        mValue.text = value

        if (size != 0f ){
            mLabel.textSize = size
            mValue.textSize = size

        }

        if (color != 0 ){
            mLabel.setTextColor(color)
            mValue.setTextColor(color)
        }


        if (sizeValue != 0f ){
            mValue.textSize = sizeValue
        }

        if (colorValue != 0 ){
            mValue.setTextColor(colorValue)
        }

        if (sizeLabel != 0f ){
            mLabel.textSize = sizeLabel
        }

        if (colorLabel != 0 ){
            mLabel.setTextColor(colorLabel)
        }


        if (backgroundColor != 0 ) {
            mConstraintLayoutContainer.setBackgroundColor(backgroundColor)
        }



    }


}