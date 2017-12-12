package com.gastronomiatipica.cultura

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private var editName: EditText? = null
    private var editAge: EditText? = null
    private var button: Button? = null
    private var name = ""
    private var age = ""
    private var radioM: RadioButton? = null
    private var radioF: RadioButton? = null
    private var lvsLista: ListView? = null//podran tener acceso solo las clases que esten dentro del mismo modulo MainActivate
    private var genero = ""
    private var mensaje = ""
    var data = 0

    private val num = 10
    private var pos = 0
    private var action = "Insertar"
    private var count = 1
    private var nombre: Array<String>? = null
    private var edad: Array<String>? = null
    private var sexo: Array<String>? = null

    private var vibrator: Vibrator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName = editText_Name

        editAge = editText_Age
        button = button_Ejecutar
        radioM = radioButton_M
        radioF = radioButton_F

        lvsLista = findViewById(R.id.lista)

        button!!.setOnClickListener(this)
        editName!!.addTextChangedListener(this)
        editAge!!.addTextChangedListener(this)
        lvsLista!!.onItemClickListener = this

        lvsLista!!.onItemLongClickListener = this

        /*radioM!!.setOnCheckedChangeListener(this)
        radioF!!.setOnCheckedChangeListener(this)*/
        radioM!!.setOnClickListener(this)
        radioF!!.setOnClickListener(this)

        editName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS

        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?

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
                    when (action){
                        "Insertar" -> addDatos()
                        "Update" -> updateDatos()
                    }
                }
            }
        }
    }

    private fun addDatos(){
        var nombres: Array<String>
        var n = 0
        for (i in n.until(num-1)){
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
        editName!!.setText("")
        editAge!!.setText("")
    }

    private fun updateDatos(){
        count = 1
        var n = 0
        for (i in n.until(num-1)){
            if(nombre?.get(i) != ""){
                if(pos === i){
                    nombre?.set(i,name)
                    edad?.set(i,age)
                    sexo?.set(i,genero)
                }
                val listName = Array(count,{""})
                for(j in n.until(count)){
                    listName?.set(j,nombre?.get(j) as String)
                }
                count ++
                var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listName)
                lvsLista!!.adapter = adapter
            }
        }
        editName!!.setText("")
        editAge!!.setText("")
        action = "Insertar"
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
        action = "Update"
    }

    override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            vibrator?.vibrate(VibrationEffect.createOneShot(3, 10))
        }else{
            vibrator?.vibrate(3)
        }
        alertDialog(position)
        return true
    }

    private fun alertDialog(i: Int){
        val alert = AlertDialog.Builder(this)
        alert.setIcon(R.mipmap.ic_pdhn)
                .setTitle(R.string.app_alertTitle)
                .setPositiveButton("Eliminar"){dialog, which ->
                    //Toast.makeText(this, "Ha vibrado", Toast.LENGTH_SHORT).show()
                    nombre?.set(i,"")
                    edad?.set(i,"")
                    sexo?.set(i,"")
                    mostrar()
                }
                .setNegativeButton("Cancelar"){sialog, which -> }
                .show()
    }

    private fun mostrar(){
        count = 1
        for (i in 0 until num){
            if(nombre!![i] != ""){
                val listName = arrayOfNulls<String>(count)
                for (j in 0 until count){
                    listName[j] = nombre!![i]
                }
                count++
                var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listName)
                lvsLista!!.adapter = adapter
            }
        }
    }
}
