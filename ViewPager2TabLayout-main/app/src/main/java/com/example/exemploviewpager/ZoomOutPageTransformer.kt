package com.example.exemploviewpager

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

private const val MIN_SCALE = 0.75f

class ZoomOutPageTransformer: ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.apply{
            val pageWidth = width
            val pageHeight = height

            when{
                position < -1 ->{
                    alpha = 0f
                }
                position <= 1 ->{
                    val scaleFactor = Math.max(MIN_SCALE,1 - abs(position))
                    val verticalImagem = pageHeight * (1-scaleFactor)/2
                    val horizontalImagem = pageWidth * (1-scaleFactor)/2
                    translationX = if(position < 0){
                        horizontalImagem - verticalImagem/2
                    } else{
                        horizontalImagem + verticalImagem/2
                    }
                    scaleX = scaleFactor
                    scaleY = scaleFactor

                    val var1 = scaleFactor - MIN_SCALE
                    val var2 = 1 - MIN_SCALE
                    val var3 = 0.5f
                    alpha = (0.5f + (var1)/var2)*var3
                }
                else -> {
                    alpha = 0f
                }
            }
        }
    }
}