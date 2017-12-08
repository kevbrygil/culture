package com.admin.gastronomia
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)
        setContentView(R.layout.activity_main)

        val food=ArrayList<ModelFood>()
        food.add(ModelFood("Panuchos",R.drawable.panuchos,"Costumbre y tradición con sabor a Yucatán"))

        food.add(ModelFood("Papadzules",R.drawable.papadzules,"Bien embarrados y remojados"))

        food.add(ModelFood("Sopa de Lima",R.drawable.sopa_de_lima,"Sabor sutil de la tierra yucateca"))

        food.add(ModelFood("Huevos Motuleños",R.drawable.huevos_motulenos,"Un platillo con historia y mucho sabor"))

        food.add(ModelFood("Cochinita Pibil",R.drawable.cochinita_pibil,"El sabor más reconocido de la comida yucateca"))

        food.add(ModelFood("Poc Chuc",R.drawable.poc_chuc,"Platillo obligado de la gastronomía de Yucatán"))

        food.add(ModelFood("Dulce de Papaya",R.drawable.dulce_papaya,"Inolvidable sabor de la tradición yucateca"))

        food.add(ModelFood("Queso Relleno",R.drawable.queso_relleno,"Exquisita combinación de sabores y texturas"))

        food.add(ModelFood("Relleno Negro",R.drawable.relleno_negro,"Exuberante combinación de especias e ingredientes"))

        food.add(ModelFood("Vaporcitos",R.drawable.vaporcitos,"Tradicional sabor para disfrutar tras el atardecer yucateco"))


        val objAdapter : CustomAdapter
        objAdapter = CustomAdapter(applicationContext,food)
        lv_flower.adapter=objAdapter
    }

}