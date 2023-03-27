package br.com.ahcatani.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import br.com.ahcatani.myapplication.databinding.ActivityMainBinding

class MainActivity : DebugActivity() {

    private val context: Context get() = this

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnMain.setOnClickListener {
            onClickLogin()
        }

        binding.btnMain.setOnClickListener {
            onClickContinuar()
        }
    }

    fun onClickLogin() {
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
    }


    fun onClickContinuar() {
        val intent = Intent(context, PaisesActivity::class.java)
        startActivity(intent)
    }
}