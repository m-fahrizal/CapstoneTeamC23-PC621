package com.example.capstoneproject.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.capstoneproject.R

class PhotoButton : AppCompatButton {
    private lateinit var photoButton: Drawable
    private var txtColor: Int = 0
    constructor(context: Context) : super(context) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        setTextColor(txtColor)
        textSize = 10f
        gravity = Gravity.CENTER
    }
    private fun init() {
        txtColor = ContextCompat.getColor(context, android.R.color.background_dark)
        photoButton = ContextCompat.getDrawable(context, R.drawable.button_photo) as Drawable
    }
}