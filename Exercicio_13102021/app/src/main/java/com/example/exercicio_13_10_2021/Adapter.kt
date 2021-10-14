package com.example.exercicio_13_10_2021

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val context: Context,val lista:List<Lista>): RecyclerView.Adapter<PrimeiroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrimeiroViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.view_holder,parent,false)
        return PrimeiroViewHolder(view)
    }

    override fun onBindViewHolder(holder: PrimeiroViewHolder, position: Int) {
        val item = lista[position]
        val tituloCapturado = item.titulo
        val descricaoCapturado = item.descricao
        val precoCapturado = item.preco

        holder.titulo.text = tituloCapturado
        holder.descricao.text = descricaoCapturado
        holder.preco.text = "R$ $precoCapturado"
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}
