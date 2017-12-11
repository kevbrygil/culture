package com.gastronomiatipica.cultura

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private var editName: EditText? = null
    private var editAge: EditText? = null
    private var textName: TextView? = null
    private var textAge: TextView? = null
    private var button: Button? = null
    private var name: String? = null
    private var age: String? = null
    private var radioM: RadioButton? = null
    private var radioF: RadioButton? = null
    private var mensaje = ""
    var data = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName = editText_Name

        editAge = editText_Age
        textName = textView_Name
        textAge = textView_Age
        button = button_Ejecutar
        radioM = radioButton_M
        radioF = radioButton_F

        button!!.setOnClickListener(this)
        editName!!.addTextChangedListener(this)
        editAge!!.addTextChangedListener(this)

        /*radioM!!.setOnCheckedChangeListener(this)
        radioF!!.setOnCheckedChangeListener(this)*/
        radioM!!.setOnClickListener(this)
        radioF!!.setOnClickListener(this)

        editName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS

        operacion()

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button_Ejecutar -> operacion()
            R.id.radioButton_M -> Toast.makeText(this, "Ha seleccionado Masculino", Toast.LENGTH_SHORT).show()
            R.id.radioButton_F -> Toast.makeText(this, "Ha seleccionado Femenino", Toast.LENGTH_SHORT).show()
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
        var arrayInt = IntArray(10)
        var doubleArray = DoubleArray(10)
        var charArray = CharArray(10)
        var boleanArray = BooleanArray(10)
        var floatArray = FloatArray(10)
        var byteArray = ByteArray(10)

        var array = arrayOf("Alex", "AJ", "PDHN")
        array.set(1, "AJPZ")
        var count = arrayInt.size
        //count--

        /*for(s in array){
            data = s
        }

        var array2 = Array<String>(3,{""})
        var array2 = Array(3){""}*/
        //var array2 = Array<String?>(3){null}

        arrayInt[0] = 1
        arrayInt.set(1,2)
        var nullArray = arrayOfNulls<String>(3)

        for(i in 0..count){
            data = arrayInt.get(i)
        }

        /*nullArray.forEach {
            a -> data = a.toString()
        }*/


        /*var valor = "Kotlin"
        var dato1 = 1

        when{
            dato1 > 3 ->
                mensaje = valor
            dato1 > 0 ->
                mensaje = valor
            else ->
                mensaje = "No es correcto"
        }

        name = editName?.text.toString()
        age = editAge?.text.toString()
        if(name?.equals("") ?: (false)){
            editName!!.requestFocus()
        } else {
            textName?.text = name
            if (age?.equals("") ?: (false)){
                editAge!!.requestFocus()
            } else{
                textAge?.text = age
            }
        }*/
    }

}
