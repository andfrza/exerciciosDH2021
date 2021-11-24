package com.example.exercicio_22_11_2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val viewPager2: ViewPager2 by lazy { findViewById(R.id.viewPager2) }
    private val indicador: TabLayout by lazy { findViewById(R.id.indicador) }
    private val botaoEntendi: Button by lazy { findViewById(R.id.botao) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configurarViewPager()
    }

    private fun configurarViewPager(){
        val listaDeFragmentos = listOf(FragmentoDeIntroducao1(),FragmentoDeIntroducao2(),FragmentoDeIntroducao3())
        viewPager2.adapter = FragmentoDeIntroducaoAdapter(this,listaDeFragmentos)

        TabLayoutMediator(indicador,viewPager2){_,_ -> }.attach()
    }
}