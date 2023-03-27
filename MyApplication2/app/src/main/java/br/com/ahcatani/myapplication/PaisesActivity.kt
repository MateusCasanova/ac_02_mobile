package br.com.ahcatani.myapplication

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import br.com.ahcatani.myapplication.databinding.ActivityPaisesBinding

class PaisesActivity : DebugActivity() {

    private val context: Context get() = this
    private val binding by lazy { ActivityPaisesBinding.inflate(layoutInflater) }

    data class Pais(
        val nome: String,
        val localizacao: String,
        val area: String,
        val populacao: String,
        val bandeira: Int,
        val imagem: Int
    )

    private val paises = listOf(
        Pais("Brasil", "América do Sul", "8.515.767 km²", "211 milhões", R.drawable.brasil_bandeira, R.drawable.brasil_imagem),
        Pais("Estados Unidos", "América do Norte", "9.525.067 km²", "331 milhões", R.drawable.eua_bandeira, R.drawable.eua_imagem),
        Pais("China", "Ásia", "9.596.961 km²", "1.4 bilhões", R.drawable.china_bandeira, R.drawable.china_imagem),
        Pais("Japão", "Ásia", "377.915 km²", "126 milhões", R.drawable.japao_bandeira, R.drawable.japao_imagem),
        Pais("Alemanha", "Europa", "357.022 km²", "83 milhões", R.drawable.alemanha_bandeira, R.drawable.alemanha_imagem)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnPesquisar.setOnClickListener {
            val nomePais = binding.campoPais.text.toString().trim()
            val paisEncontrado = paises.find { it.nome.equals(nomePais, ignoreCase = true) }

            if (paisEncontrado != null) {
                exibirInformacoes(paisEncontrado)
            } else {
                Toast.makeText(context, "País não encontrado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun exibirInformacoes(pais: Pais) {
        binding.infoPais.text = "Nome: ${pais.nome}\nLocalizacao: ${pais.localizacao}\nÁrea: ${pais.area}\nPopulação: ${pais.populacao}"
        binding.imgBandeira.setImageResource(pais.bandeira)
        binding.imgPais.setImageResource(pais.imagem)
    }
}

