package com.example.ripples

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.TextView

/**
 * 时间：2018/8/28 15:47
 * 姓名：韩晓康
 * 功能：涟漪效果的按钮
 */
class ripplebt : TextView {
    var pait = Paint();//遮罩层画笔
    var color = 1;//遮罩层颜色
    var widthMeasure: Int = 1;
    var heightMeasure: Int = 1;
    var canvasType: Boolean = true;
    var circleR = 0f;
    var dX = 0f;//点击位置
    var dY = 0f;
    var mContext: Context;
    var isStart:Boolean=true;//防止动画没有执行完 连续点击
    var click:OnClick?=null;

    constructor(mContext: Context, attributeSet: AttributeSet) : this(mContext, attributeSet, -1) {
        this.mContext = mContext
    }

    constructor(mContext: Context, attributeSet: AttributeSet, int: Int) : super(mContext, attributeSet, int) {
         this.mContext = mContext;
        color = ContextCompat.getColor(mContext, R.color.colorAccent)
        var typedArray = mContext.obtainStyledAttributes(attributeSet, R.styleable.RippleButton)
        if (typedArray != null) {
            color = typedArray.getColor(R.styleable.RippleButton_circleColor, ContextCompat.getColor(mContext, R.color.color000000));
        }
        typedArray.recycle()
        pait.color = color;
        this.setOnClickListener{
            if (isStart) {
                start()
            }
            click?.onClick(this)
        }
    }

    private fun start() {
        canvasType = false
        isStart=false;
        var animatorV = 1;
        if (widthMeasure >=heightMeasure) {
            animatorV = widthMeasure
        } else {
            animatorV = heightMeasure
        }
        var animator = ValueAnimator.ofInt(0, animatorV)
        animator.setDuration(800)
        animator.start()
        animator.addUpdateListener { valueAnimator: ValueAnimator? ->
            var value = valueAnimator!!.getAnimatedValue().toString().toFloat()
            circleR = value;
            if (value >=animatorV-dY) {
                canvasType = true
                animator.cancel()
                isStart=true
            }
            postInvalidate()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        dX = event!!.x;
        dY = event.y;
        return super.onTouchEvent(event)
    }



    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        if (!canvasType) {
            pait.color = color;
            canvas!!.drawCircle(dX, dY, circleR, pait)
        }
    }
    fun setOnclick(click: OnClick){
        this.click=click;
//        this.click!!.onClick(this);
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        widthMeasure = widthMeasure(widthMeasureSpec);
        heightMeasure = heightMeasure(heightMeasureSpec);
        setMeasuredDimension(widthMeasure, heightMeasure)
    }

    private fun widthMeasure(widthMeasureSpec: Int): Int {
        var mode = MeasureSpec.getMode(widthMeasureSpec)
        var size = MeasureSpec.getSize(widthMeasureSpec)
        var result: Int
        if (mode == MeasureSpec.EXACTLY) {
            result = size
        } else {
            result = width
            if (mode == MeasureSpec.AT_MOST) {
                result = Math.min(size, result)
            }
        }
        return result
    }

    private fun heightMeasure(heightMeasureSpec: Int): Int {
        var mode = MeasureSpec.getMode(heightMeasureSpec)
        var size = MeasureSpec.getSize(heightMeasureSpec)
        var result: Int
        if (mode == MeasureSpec.EXACTLY) {
            result = size
        } else {
            result = width
            if (mode == MeasureSpec.AT_MOST) {
                result = Math.min(size, result)
            }
        }
        return result
    }

}

