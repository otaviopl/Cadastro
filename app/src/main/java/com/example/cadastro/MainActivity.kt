package com.example.cadastro

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editNome = findViewById<EditText>(R.id.editNome)
        val editTelefone = findViewById<EditText>(R.id.editTelefone)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val checkEmail = findViewById<CheckBox>(R.id.checkEmail)
        val radioGroupSexo = findViewById<RadioGroup>(R.id.radioGroupSexo)
        val editCidade = findViewById<EditText>(R.id.editCidade)
        val spinnerUF = findViewById<Spinner>(R.id.spinnerUF)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        val estados = arrayOf("Acre", "Alagoas", "Amazonas", "Bahia", "Ceará", "Distrito Federal")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, estados)
        spinnerUF.adapter = adapter

        btnSalvar.setOnClickListener {
            val nome = editNome.text.toString()
            val telefone = editTelefone.text.toString()
            val email = editEmail.text.toString()
            val listaEmail = checkEmail.isChecked
            val cidade = editCidade.text.toString()
            val uf = spinnerUF.selectedItem.toString()

            val sexoSelecionadoId = radioGroupSexo.checkedRadioButtonId
            val sexo = if (sexoSelecionadoId != -1) {
                findViewById<RadioButton>(sexoSelecionadoId).text.toString()
            } else {
                "Não informado"
            }

            val formulario = Formulario(nome, telefone, email, listaEmail, sexo, cidade, uf)
            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }

        btnLimpar.setOnClickListener {
            editNome.text.clear()
            editTelefone.text.clear()
            editEmail.text.clear()
            checkEmail.isChecked = false
            radioGroupSexo.clearCheck()
            editCidade.text.clear()
            spinnerUF.setSelection(0)
        }
    }
}