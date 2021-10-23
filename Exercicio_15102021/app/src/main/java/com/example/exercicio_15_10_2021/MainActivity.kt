package com.example.exercicio_15_10_2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView

class MainActivity : AppCompatActivity() {

    private lateinit var imagem: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imagem = findViewById(R.id.imagem2)
        var contador = 1

        imagem.setOnClickListener {
            if(contador==1){
                imagem.animate()
                    .scaleX(1.5f)
                    .scaleY(1.5f)
                    .alpha(1f)  //transparência da View que está sendo animada.
                    .setDuration(1000)
                    .withEndAction{
                        imagem.scaleX = 1.5f
                        imagem.scaleY = 1.5f
                        imagem.alpha = 1f
                    }
            }
            else {
                imagem.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .alpha(1f)  //transparência da View que está sendo animada.
                    .setDuration(1000)
                    .withEndAction {
                        imagem.scaleX = 1f
                        imagem.scaleY = 1f
                        imagem.alpha = 1f
                    }
            }

            contador *= -1
        }
    }
}