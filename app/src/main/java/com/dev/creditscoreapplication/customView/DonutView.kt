package com.dev.creditscoreapplication.customView

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import java.lang.Math.*
import android.graphics.RectF
import androidx.navigation.findNavController
import com.dev.creditscoreapplication.R

/**
 * Create custom circle and arc to represent credit score of a user
 */
class DonutView @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, defStyleAttribute: Int = 0) : View(
    context, attr, defStyleAttribute) {

    private var radius = 0.0f      // Radius of the circle.
    private var creditScoreText: String? = null
    private var sweepAngle: Float? = null

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        textAlign = Paint.Align.CENTER
        textSize = 25.0f
        strokeWidth = 3F
        typeface = Typeface.create( "", Typeface.NORMAL)
    }

    private val arcPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.CYAN
        strokeWidth = 3F
        style = Paint.Style.STROKE
    }

    init {
        isClickable = true   //make custom view clickable
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        radius = (min(width, height) / 1.5).toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //circle
        paint.color = Color.GRAY
        radius = if(width > height){
            (height / 2).toFloat()
        } else {
            (width / 2).toFloat()
        }
        canvas?.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, paint)

        //Inner Arc
        val path = Path()
        val arcRadius = radius - 30
        path.addCircle((width / 2).toFloat(), (height / 2).toFloat(),
            arcRadius, Path.Direction.CW)
        val ovalRect = RectF()
        val centerX = width / 2
        val centerY = height / 2
        ovalRect.set(centerX - arcRadius,
            centerY - arcRadius,
            centerX + arcRadius,
            centerY + arcRadius
        )

        //Draw arc to represent user's credit score
        sweepAngle?.let {
            canvas?.drawArc(ovalRect, 270F, it, false, arcPaint)
        }
        //Set text to show user the credit score progress
        creditScoreText?.let {
            canvas?.drawText(it, (width/2).toFloat(), (height/2).toFloat(), paint)
        }
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true

        //navigate to detail page
        findNavController().navigate(R.id.detailFragment)

        invalidate()
        return true
    }

    /**
     * The method sets the length of the arc, to show the user's credit store progress.
     * Score: User's credit score
     * maxScoreValue: Maximum score value that can be attained
     */
    fun setCircleSpanLength(score: Float, maxScoreValue: Float)  {
        val result: Float = (score / maxScoreValue) * 360
        sweepAngle = result
    }

    /**
     * Set credit score text to display at the centre of the circle
     */
    fun setText(text: String) {
        creditScoreText = text
    }

}