package com.admin.gastronomia

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_food.*
import kotlinx.android.synthetic.main.activity_main.*

class FoodActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private val food = ArrayList<ModelFood>()
    private var des:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        des = textViewDes

        initFood()

        val objAdapter : CustomAdapter
        objAdapter = CustomAdapter(applicationContext,food)
        lv_food.adapter=objAdapter

        lv_food!!.onItemClickListener = this
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val intent = Intent(this, RecipeActivity::class.java)
        startActivity(intent)
    }

    private fun initFood(){
        var b:Bundle = intent.extras
        var state = b.getString("state")
        des!!.text = "Comida típica de " + state

        when(state){
            "Aguascalientes"-> addAguascalientes()
            "Baja California"->addBajaCal()
            "Baja California Sur"->addBajaCalSur()
            "Campeche"->addCampeche()
            "Chiapas"->addChiapas()
            "Chihuahua"->addChihuahua()
            "Ciudad de México"->addCdMexico()
            "Coahuila"->addCoahuila()
            "Colima"->addColima()
            "Durango"->addDurango()
            "Guanajuato"->addGuanajuato()
            "Guerrero"->addGuerrero()
            "Hidalgo"->addHidalgo()
            "Jalisco"->addJalisco()
            "México"->addMexico()
            "Michoacán"->addMichoacan()
            "Morelos"->addMorelos()
            "Nayarit"->addNayarit()
            "Nuevo León"->addNvoLeon()
            "Oaxaca"->addOaxaca()
            "Puebla"->addPuebla()
            "Querétaro"->addQueretaro()
            "Quintana Roo"->addQuintana()
            "San Luis Potosí"->addSanLuis()
            "Sinaloa"->addSinaloa()
            "Sonora"->addSonora()
            "Tabasco"->addTabasco()
            "Tamaulipas"->addTama()
            "Tlaxcala"->addTlaxcala()
            "Veracruz"->addVeracruz()
            "Yucatán"->addYucatan()
            "Zacatecas"->addZacatecas()
        }
    }

    private fun addAguascalientes(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addBajaCal(){
        food.add(ModelFood("Langosta estilo Puerto Nuevo",R.drawable.bajacal_langosta,"Las esposas de pescadores lo inventaron cuando sus esposos llegaban con carga de langostas."))

        food.add(ModelFood("Comida china",R.drawable.bajacal_china,"Por más extraño que suene, la comida china es un platillo típico."))

        food.add(ModelFood("Tacos de pescado a la tempura",R.drawable.bajacal_pezcado,"Todo estado tiene su taco y Baja California es famoso por sus tacos de pescado."))

        food.add(ModelFood("Baja Med",R.drawable.bajacal_med,"Es una corriente que combina técnicas e ingredientes mediterráneos, asiáticos y mexicanos."))
    }

    private fun addBajaCalSur(){
        food.add(ModelFood("Tacos de pescado",R.drawable.bajasur_taco,"Los tacos de pescado, iniciaron su auge popular, en ciudades como La Paz."))

        food.add(ModelFood("Empanadas de carne",R.drawable.bajasur_empanada,"Empanadas de carne de res, con chile colorado y verduras."))

        food.add(ModelFood("Tamales",R.drawable.aguas_campesina,"Tamales de res o de puerco con papas o camote, y verduras, en hoja de plátano."))

        food.add(ModelFood("Cocido de res",R.drawable.aguas_chile,"El cocido de res, ocupa uno de los primeros lugares en popularidad."))
    }

    private fun addCampeche(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addChiapas(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addChihuahua(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addCdMexico(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addCoahuila(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addColima(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addDurango(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addGuanajuato(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addGuerrero(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addHidalgo(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addJalisco(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addMexico(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addMichoacan(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addMorelos(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addNayarit(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addNvoLeon(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addOaxaca(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }
    private fun addPuebla(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addQueretaro(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addQuintana(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }
    private fun addSanLuis(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }
    private fun addSinaloa(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }
    private fun addSonora(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addTabasco(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }
    private fun addTama(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }
    private fun addTlaxcala(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addVeracruz(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addYucatan(){
        food.add(ModelFood("Panuchos",R.drawable.panuchos,"Costumbre y tradición con sabor a Yucatán"))

        food.add(ModelFood("Sopa de Lima",R.drawable.sopa_de_lima,"Sabor sutil de la tierra yucateca"))

        food.add(ModelFood("Huevos Motuleños",R.drawable.huevos_motulenos,"Un platillo con historia y mucho sabor"))

        food.add(ModelFood("Cochinita Pibil",R.drawable.cochinita_pibil,"El sabor más reconocido de la comida yucateca"))
    }

    private fun addZacatecas(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa.."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }


}
