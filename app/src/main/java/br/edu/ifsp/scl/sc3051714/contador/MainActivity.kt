package br.edu.ifsp.scl.sc3051714.contador

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import br.edu.ifsp.scl.sc3051714.contador.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var initialEt: EditText //lateinit -> nada eh nulo e eh obrigado a inicializar
    private lateinit var visorTv: TextView
    private lateinit var incrementBy: Button

    private var value: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) { //funcao definida na classe mãe -> onCreate unica funcao obrigatoria ao criar telas
        super.onCreate(savedInstanceState)

        //set content faz com que o app exista!! não tem como fazer a linha do initial find antes dessa
        setContentView(R.layout.activity_main)  //classe R tem subclass layout e tem atributo activity_main


        initialEt = findViewById(R.id.initial_et)
        visorTv = findViewById(R.id.visor_tv)
        incrementBy = findViewById(R.id.increment_bt)


        //se tem tela tem listener
        incrementBy.setOnClickListener { //sempre que ultimo parametro de uma func for outra funcao ou interface, posso tira os () do final

            value++.let{visorTv.text = it.toString()}

            setContentView(activityMainBinding.root)

            with (activityMainBinding) {

                initialEt.addTextChangedListener {
                    value = it.toString().toIntOrNull() ?: 0
                }

                incrementBt.setOnClickListener {
                    value++.let { visorTv.text = it.toString() }
                }

            }

        }

    }

}