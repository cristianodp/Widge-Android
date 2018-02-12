package br.com.cristianodp.widge

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.Dimension
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.support.constraint.ConstraintSet
import br.com.cristianodp.widge.R.id.wrap_content


/**
 * Created by crist on 01/01/2018.
 */
class SimpleItemView : LinearLayout {

    private lateinit var mConstraintLayoutContainer: ConstraintLayout
    private lateinit var mIcon: ImageView
    private lateinit var mLabel: TextView
    private lateinit var mValue: TextView

    private lateinit var attrs:AttributeSet

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        init(context,attrs)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context,attrs)
    }

    /**
     * Initialize view
     */
    private fun init(context: Context,attrs: AttributeSet?) {
        this.attrs = attrs!!

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
        val viewBackgroundColor = customAttrs.getColor(R.styleable.SimpleItemView_backgroundColor,0)
        val appearance = customAttrs.getInt(R.styleable.SimpleItemView_appearance,0)

        View.inflate(context, R.layout.simple_item_view_layout,this)

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

        if (viewBackgroundColor != 0 ) {
            mConstraintLayoutContainer.setBackgroundColor(viewBackgroundColor)
        }

       // setAppearance
    }

    fun setValue(text: String){
        mValue.text = text
    }

    fun getValue():String{
        return mValue.text.toString()
    }

    fun setIcon(icon: Drawable){
        mIcon.setImageDrawable(icon)
    }

    fun setLabel(text: String){
        mLabel.text = text
    }

    fun getLabel():String{
        return mLabel.text.toString()
    }

    fun setTextSize(size: Float){
        mValue.textSize = size
        mLabel.textSize = size
    }

    fun setTextSizeLabel(size: Float){
        mLabel.textSize = size
    }

    fun setTextSizeValue(size: Float){
        mValue.textSize = size
    }

    fun setTextColor(color: Int){
        mValue.setTextColor(color)
        mLabel.setTextColor(color)
    }

    fun setTextColorLabel(color: Int){
        mLabel.setTextColor(color)
    }

    fun setTextColorValue(color: Int){
        mValue.setTextColor(color)
    }

    fun setAppearance(appearance: Int){
        when (appearance) {
            0 -> setAppearanceInLine()
            1 -> setAppearanceInPiled()
            else -> { // Note the block
                setAppearanceInLine()
            }
        }
    }

    private fun setAppearanceInLine() {

        mIcon.visibility = View.VISIBLE

        val constraintSet = ConstraintSet()
        constraintSet.clone(mConstraintLayoutContainer)
        val margin = resources.getDimension(R.dimen.medium_padding).toInt()

        //ImageViewIcon
        constraintSet.clear(R.id.ImageViewIcon, ConstraintSet.END)
        constraintSet.connect(R.id.ImageViewIcon, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM,margin)
        constraintSet.connect(R.id.ImageViewIcon, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START,margin)
        constraintSet.connect(R.id.ImageViewIcon, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP,margin)
        constraintSet.constrainDefaultWidth(R.id.ImageViewIcon,wrap_content)
        constraintSet.constrainDefaultHeight(R.id.ImageViewIcon,wrap_content)
        
        //TextViewLabel
        //constraintSet.clear(R.id.TextViewLabel)
        constraintSet.connect(R.id.TextViewLabel, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM,margin)
        constraintSet.connect(R.id.TextViewLabel, ConstraintSet.END, R.id.TextViewValue, ConstraintSet.START,margin)
        constraintSet.connect(R.id.TextViewLabel, ConstraintSet.START, R.id.ImageViewIcon, ConstraintSet.END,margin)
        constraintSet.connect(R.id.TextViewLabel, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP,margin)
        constraintSet.constrainDefaultWidth(R.id.TextViewLabel,wrap_content)
        constraintSet.constrainDefaultHeight(R.id.TextViewLabel,wrap_content)
        constraintSet.setHorizontalBias(R.id.TextViewLabel,0f)

        //TextViewValue
        constraintSet.clear(R.id.TextViewValue,ConstraintSet.START)
        constraintSet.connect(R.id.TextViewValue, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM,margin)
        constraintSet.connect(R.id.TextViewValue, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
        constraintSet.connect(R.id.TextViewValue, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP,margin)
        constraintSet.constrainDefaultWidth(R.id.TextViewValue,wrap_content)
        constraintSet.constrainDefaultHeight(R.id.TextViewValue,wrap_content)
       // constraintSet.setHorizontalBias(R.id.TextViewValue,0f)
       // mValue.textSize = 24f


        constraintSet.applyTo(mConstraintLayoutContainer)


    }

    private fun setAppearanceInPiled() {

        mIcon.visibility = View.GONE

        val constraintSet = ConstraintSet()
        constraintSet.clone(mConstraintLayoutContainer)

        //ImageViewIcon
        constraintSet.clear(R.id.ImageViewIcon, ConstraintSet.START)
        constraintSet.connect(R.id.ImageViewIcon, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        constraintSet.connect(R.id.ImageViewIcon, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        constraintSet.connect(R.id.ImageViewIcon, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
        constraintSet.constrainDefaultWidth(R.id.ImageViewIcon,wrap_content)
        constraintSet.constrainDefaultHeight(R.id.ImageViewIcon,wrap_content)

        //TextViewLabel
        constraintSet.clear(R.id.TextViewLabel,ConstraintSet.BOTTOM)
        //constraintSet.connect(R.id.TextViewLabel, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM,8)
        constraintSet.connect(R.id.TextViewLabel, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END,8)
        constraintSet.connect(R.id.TextViewLabel, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START,8)
        constraintSet.connect(R.id.TextViewLabel, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP,8)
        constraintSet.setHorizontalBias(R.id.TextViewLabel,0.5f)
        constraintSet.constrainDefaultWidth(R.id.TextViewLabel,wrap_content)
        constraintSet.constrainDefaultHeight(R.id.TextViewLabel,wrap_content)

        //mLabel.textAlignment = View.TEXT_ALIGNMENT_CENTER

        //TextViewValue
       //* constraintSet.clear(R.id.TextViewValue)
        constraintSet.connect(R.id.TextViewValue, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM,8)
        constraintSet.connect(R.id.TextViewValue, ConstraintSet.END, R.id.TextViewLabel, ConstraintSet.END)
        constraintSet.connect(R.id.TextViewValue, ConstraintSet.START, R.id.TextViewLabel, ConstraintSet.START)
        constraintSet.connect(R.id.TextViewValue, ConstraintSet.TOP, R.id.TextViewLabel, ConstraintSet.BOTTOM,4)
        constraintSet.constrainDefaultWidth(R.id.TextViewValue,wrap_content)
        constraintSet.constrainDefaultHeight(R.id.TextViewValue,wrap_content)


       // mValue.textAlignment = View.TEXT_ALIGNMENT_CENTER
        //mValue.textSize = 14f

        constraintSet.applyTo(mConstraintLayoutContainer)






    }


}