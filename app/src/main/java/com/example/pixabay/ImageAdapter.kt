package com.example.pixabay
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pixabay.databinding.ItemPixabayBinding
import com.example.pixabay.model.ImageModel

class ImageAdapter(var list: ArrayList<ImageModel>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemPixabayBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addImage(imageModel: ArrayList<ImageModel>) {
        list.addAll(imageModel)
        notifyDataSetChanged()
    }

    fun cleanImage() {
        list.clear()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(list[position])
    }


    inner class ImageViewHolder(var binding: ItemPixabayBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(imageModel: ImageModel) {
            binding.ivItem.load(imageModel.imageUrl)
        }
    }
}
