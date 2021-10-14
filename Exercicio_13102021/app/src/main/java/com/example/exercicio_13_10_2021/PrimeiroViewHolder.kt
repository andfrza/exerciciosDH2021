package com.example.exercicio_13_10_2021

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PrimeiroViewHolder(view: View):RecyclerView.ViewHolder(view){
    val titulo = view.findViewById<TextView>(R.id.titulo)
    val descricao = view.findViewById<TextView>(R.id.descricao)
    val preco = view.findViewById<TextView>(R.id.preco)
    val imagem = view.findViewById<ImageView>(R.id.imagem)
}