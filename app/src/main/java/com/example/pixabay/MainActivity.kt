package com.example.pixabay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pixabay.databinding.ActivityMainBinding
import com.example.pixabay.model.ImageModel
import com.example.pixabay.model.PixabayView

class MainActivity : AppCompatActivity(), PixabayView {

    private lateinit var binding: ActivityMainBinding
    private var presenter = Presenter(this)
    private val adapter = ImageAdapter(arrayListOf())
    private var name =""
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.attachView(this)
        initListener()
    }

    private fun initListener() {
        binding.btnSearch.setOnClickListener {
            name = binding.etText.text.toString()
            presenter.getPixabay(name)
        }
    }

    override fun showPixabay(pixabayModel: ArrayList<ImageModel>) {
        binding.rvImage.adapter = adapter
        adapter.addImage(pixabayModel)
    }

    override fun showError(error: String) {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }
}