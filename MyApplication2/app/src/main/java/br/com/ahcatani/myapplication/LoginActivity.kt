package br.com.ahcatani.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import br.com.ahcatani.myapplication.databinding.ActivityLoginBinding

class LoginActivity : DebugActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //    setContentView(R.layout.activity_login)

        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            onClickLogin()
        }
    }

    fun onClickLogin() {
        binding.imgLogin.setImageResource(R.drawable.img_sala)
        binding.txtLogin.text = "Faça o seu Login na Empresa"
        val valorUsuario = binding.campoUsuario.text.toString()
        val valorPassword = binding.campoPassword.text.toString()
        Toast.makeText(
            getBaseContext(), "Você Clicou no botão Login, $valorUsuario : $valorPassword",
            Toast.LENGTH_LONG
        ).show()
        binding.txtLogin.text = "Login Efetuado"
    }
}