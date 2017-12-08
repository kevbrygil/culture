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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName = editText_Name

        editAge = editText_Age
        textName = textView_Name
        textAge = textView_Age
        button = button_Ejecutar
        button!!.setOnClickListener(this)
        editName!!.addTextChangedListener(this)
        editAge!!.addTextChangedListener(this)

        radioM!!.setOnCheckedChangeListener(this)
        radioF!!.setOnCheckedChangeListener(this)

        editName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS

    }

    override fun onClick(v: View?) {
        operacion()
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
        Toast.makeText(this, "Ha seleccionado una opcion", Toast.LENGTH_SHORT).show()
    }

    private fun operacion(){

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
        }
    }

}
