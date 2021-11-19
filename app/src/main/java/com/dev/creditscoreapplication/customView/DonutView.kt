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
    private var scoreValueText: String? = null
    private var maxScoreValueText: String? = null
    private var sweepAngle: Float? = null

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        textAlign = Paint.Align.CENTER
        typeface = Typeface.create( "", Typeface.NORMAL)
    }

    private val scoreValuePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        color = context.resources.getColor(R.color.colorGreen)
        textSize = 60.0f
        typeface = Typeface.create( "", Typeface.NORMAL)
    }

    private val paint2 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        color = context.resources.getColor(R.color.text_color)
        textSize = 35.0f
        typeface = Typeface.create( "", Typeface.NORMAL)
    }

    private val arcPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.resources.getColor(R.color.teal_200)
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
        paint.color = context.resources.getColor(R.color.text_color)
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
            canvas?.drawText(it, (width/2).toFloat(), (height/3).toFloat(), paint2)
        }
        scoreValueText?.let {
            canvas?.drawText(it, (width/2).toFloat(), (height/2).toFloat(), scoreValuePaint)
        }
        maxScoreValueText?.let {
            canvas?.drawText(it, (width/2).toFloat(), (height/1.5).toFloat(), paint2)
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
    fun calculateSweepAngle(score: Float, maxScoreValue: Float)  {
        val result: Float = (score / maxScoreValue) * 360
        sweepAngle = result
        invalidate()
    }

    /**
     * Set credit score text to display at the centre of the circle
     */
    fun setText(messageText: String, scoreText: String, maxScoreText: String) {
        creditScoreText = messageText
        scoreValueText = scoreText
        maxScoreValueText = maxScoreText
    }

}