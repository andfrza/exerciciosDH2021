package com.example.exercicio_13_10_2021

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@SuppressLint("WrongConstant")
class MainActivity : AppCompatActivity() {

    private lateinit var campoRecyclerView: RecyclerView
    private var lista = mutableListOf(Lista("Tracker","Deixe conceitos ultrapassados pra trás. Na hora de escolher o seu SUV, segurança, tecnologia, economia e design são essenciais. O Tracker é um modelo completo e que não para de evoluir, assim como você. Só ele vem com 6 airbags, MyLink de 8” e o motor turbo mais econômico da categoria. Tudo de série. Em todas as versões.","103.780,00"),
        Lista("Tracker","Deixe conceitos ultrapassados pra trás. Na hora de escolher o seu SUV, segurança, tecnologia, economia e design são essenciais. O Tracker é um modelo completo e que não para de evoluir, assim como você. Só ele vem com 6 airbags, MyLink de 8” e o motor turbo mais econômico da categoria. Tudo de série. Em todas as versões.","103.780,00"),Lista("Tracker","Deixe conceitos ultrapassados pra trás. Na hora de escolher o seu SUV, segurança, tecnologia, economia e design são essenciais. O Tracker é um modelo completo e que não para de evoluir, assim como você. Só ele vem com 6 airbags, MyLink de 8” e o motor turbo mais econômico da categoria. Tudo de série. Em todas as versões.","103.780,00"))

    private val recycler by lazy{
        RecyclerView(this)
    }
    private val manager by lazy{
        LinearLayoutManager(this,VERTICAL,false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        campoRecyclerView = findViewById(R.id.container)
        replicarLista(lista)    //visa aumentar a lista para visualizar mais itens, somente.

        campoRecyclerView.layoutManager = manager
        campoRecyclerView.adapter = Adapter(this,lista)

    }
    fun replicarLista(lista:MutableList<Lista>){
        while(lista.size<10){
            lista.add(lista[0])
        }
    }
}


//Implemento o viewholder, o adapter e crio um novo xml.    //(ViewPager2).