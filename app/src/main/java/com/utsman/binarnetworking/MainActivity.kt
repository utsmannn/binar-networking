package com.utsman.binarnetworking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.utsman.binarnetworking.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickUserReqres()
    }

    private fun clickUserReqres() {
        binding.btnGetReqres.setOnClickListener {
            MainScope().launch {
                val dataResult = getUserReqres()
                binding.textviewResultReqres.text = dataResult
            }
        }
    }

    private suspend fun getUserReqres(): String {
        val webServices = ReqresNetwork.retrofit()
        val response = webServices.getUser(1)
        val data = response.data?.map { item ->
            item?.firstName
        }

        return data.toString()
    }
}