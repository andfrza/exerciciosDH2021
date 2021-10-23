package com.example.exemploviewpager

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class Fragment01 : Fragment() {

    private lateinit var animation: AnimationDrawable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_01, container, false)

        val imagem = view.findViewById<ImageView>(R.id.iv_fg_01)
        imagem.setBackgroundResource(R.drawable.lista_animacao)
        animation = imagem.background as AnimationDrawable
        animation.start()
        imagem.setOnClickListener {
            animation.stop()
        }


        return view
    }


}