package com.example.justgeek_base_app.custom

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.widget.ImageView
import androidx.annotation.IdRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.example.justgeek_base_app.R

class JGBottomNavigation @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val item1: ImageView = findViewById(R.id.indicator)
    private val item2: ImageView = findViewById(R.id.indicator2)
    private val item3: ImageView = findViewById(R.id.indicator3)
    private val item4: ImageView = findViewById(R.id.indicator4)
    private val item5: ImageView = findViewById(R.id.indicator5)
    private val home: ConstraintLayout = findViewById(R.id.first_item)
    private val catalog: ConstraintLayout = findViewById(R.id.second_item)
    private val more: ConstraintLayout = findViewById(R.id.third_item)
    private val favorites: ConstraintLayout = findViewById(R.id.fourth_item)
    private val profile: ConstraintLayout = findViewById(R.id.fifth_item)

    fun setCurrentItem(@IdRes item: Int){
        when {
            item == R.id.first_item -> {
                item1.isVisible = true
                item2.isVisible = false
                item3.isVisible = false
                item4.isVisible = false
                item5.isVisible = false
            }
            item == R.id.second_item -> {
                item2.isVisible = true
                item1.isVisible = false
                item3.isVisible = false
                item4.isVisible = false
                item5.isVisible = false
            }
            item == R.id.third_item -> {
                item3.isVisible = true
                item1.isVisible = false
                item2.isVisible = false
                item4.isVisible = false
                item5.isVisible = false
            }
            item == R.id.fourth_item -> {
                item4.isVisible = true
                item1.isVisible = false
                item2.isVisible = false
                item3.isVisible = false
                item5.isVisible = false
            }
            item == R.id.fifth_item -> {
                item5.isVisible = true
                item1.isVisible = false
                item2.isVisible = false
                item3.isVisible = false
                item4.isVisible = false
            }
        }
    }

    fun setIntent(intent: Intent){

    }

}