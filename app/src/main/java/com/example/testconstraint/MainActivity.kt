package com.example.testconstraint

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inputUser:EditText
    private lateinit var botaoL: Button
    private lateinit var botaoC: Button
    private lateinit var cadastroUser:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    //usuario digita o produto
    inputUser =findViewById(R.id.editTextU)
        //usuario cadstra o produto
        botaoC = findViewById(R.id.buttonC)
        //usuario pode limpar os produtos cadastrados
        botaoL  = findViewById(R.id.buttonL)
        //usuario ocnsegue ver os produtos cadastrados na tela
    cadastroUser = findViewById(R.id.textUser)
        //lista de produtos
      val produtos = mutableListOf<String>()

        botaoC.setOnClickListener(){
          //pegar oq o user digitou
            var userInput = inputUser.text.toString()

            when{
                userInput.isNotBlank() -> {
                    //add na lista de produtos
                   produtos.add(userInput)

                    //mandar a lista de profutos do pra exibir na tela
                    produtosLista(produtos,cadastroUser)
                }
                else -> Toast.makeText(this, "Por favor, insira um produto para ser cadastrado",Toast.LENGTH_SHORT).show()
            }

            inputUser.text.clear()
        }

        botaoL.setOnClickListener{

            produtos.clear()
            cadastroUser.text = ""



        }

}}
//funçao que pega os produtos cadastrados e exibe
private fun produtosLista( array: MutableList<String>, produtosC:TextView,){
 var prod = array.joinToString(separator = "\n")
    produtosC.text = prod

}