package com.rpla17an.twibbon17an

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rpla17an.twibbon17an.databinding.RowItemTwibbonBinding

class TwibbonAdapter(private val onClick: (Int) -> Unit) :
    RecyclerView.Adapter<TwibbonAdapter.TwibbonViewHolder>() {
    inner class TwibbonViewHolder(val binding: RowItemTwibbonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onClick(listTwibbon[adapterPosition])
            }
        }
    }

    private val listTwibbon = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwibbonViewHolder =
        TwibbonViewHolder(
            (RowItemTwibbonBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false)
                    )
        )

    override fun onBindViewHolder(holder: TwibbonViewHolder, position: Int) {
        holder.binding.ivTwibbon.setImageResource(listTwibbon[position])
    }

    override fun getItemCount() = listTwibbon.size
}