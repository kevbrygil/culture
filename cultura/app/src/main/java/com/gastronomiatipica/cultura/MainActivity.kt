package com.gastronomiatipica.cultura

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener, AdapterView.OnItemClickListener {
    private var editName: EditText? = null
    private var editAge: EditText? = null
    private var button: Button? = null
    private var name = ""
    private var age = ""
    private var radioM: RadioButton? = null
    private var radioF: RadioButton? = null
    internal var lvsLista: ListView? = null//podran tener acceso solo las clases que esten dentro del mismo modulo MainActivate
    private var genero = ""
    private var mensaje = ""
    var data = 0

    private val num = 10
    private var count = 1
    internal var nombre: Array<String>? = null
    internal var edad: Array<String>? = null
    internal var sexo: Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName = editText_Name

        editAge = editText_Age
        button = button_Ejecutar
        radioM = radioButton_M
        radioF = radioButton_F

        lvsLista = findViewById<ListView>(R.id.lista)

        button!!.setOnClickListener(this)
        editName!!.addTextChangedListener(this)
        editAge!!.addTextChangedListener(this)
        lvsLista!!.setOnItemClickListener(this)
        /*radioM!!.setOnCheckedChangeListener(this)
        radioF!!.setOnCheckedChangeListener(this)*/
        radioM!!.setOnClickListener(this)
        radioF!!.setOnClickListener(this)

        editName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS

        nombre = Array(num, {""})
        edad = Array(num, {""})
        sexo = Array(num, {""})

        //operacion()

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button_Ejecutar -> operacion()
            R.id.radioButton_M -> genero = "Masculino"
            R.id.radioButton_F -> genero = "Femenino"
        }

    }

    override fun afterTextChanged(p0: Editable?) {

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        name = editName?.text.toString()
        if(name?.equals("") ?: (false)){
            editName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
        } else {
            editName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_NORMAL
        }
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        /*when(p0!!.id){
            R.id.radioButton_M ->
                if (p1)
                    Toast.makeText(this, "Ha seleccionado Masculino", Toast.LENGTH_SHORT).show()
            R.id.radioButton_F->
                if (p1)
                    Toast.makeText(this, "Ha seleccionado Femenino", Toast.LENGTH_SHORT).show()
        }*/

    }

    private fun operacion(){
        name = editName?.text.toString()
        age = editAge?.text.toString()
        if(name?.equals("") ?: (false)){
            editName!!.requestFocus()
        } else {

            if (age?.equals("") ?: (false)){
                editAge!!.requestFocus()
            } else{
                if(radioM!!.isChecked || radioF!!.isChecked){
                    var nombres: Array<String>
                    for (i in 0..num){
                        if (nombre?.get(i).equals("")){
                            nombre?.set(i, name)
                            edad?.set(i, age)
                            sexo?.set(i, genero)
                            nombres = Array(count,{""})
                            for (j in 0..i){
                                nombres[j] = nombre?.get(j) as String
                            }
                            var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres)
                            lvsLista!!.adapter = adapter

                            count++
                            break
                        }
                    }
                }
            }
        }
    }
    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        editName!!.setText(nombre?.get(p2))
        editAge!!.setText(edad?.get(p2))
        when(sexo!!.get(p2)){
            "Masculino" -> {
                radioM!!.isChecked = true
                genero = "Masculino"
            }
            "Femenino" ->{
                radioF!!.isChecked = true
                genero = "Femenino"
            }
        }
        pos = p2
        action = "update"
    }

}
