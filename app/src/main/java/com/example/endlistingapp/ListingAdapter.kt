package com.example.endlistingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.endlistingapp.model.Products
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.listing_item.view.*

class ListingAdapter(private val model: List<Products>) :
    RecyclerView.Adapter<ListingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder {
        return ListingViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.listing_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return model.size
    }

    override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {
        holder.bind(model, position)
    }
}

class ListingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(model: List<Products>, position: Int) {
        Picasso.get()
            .load(model[position].image)
            .into(itemView.item_image)
        itemView.item_title.text = model[position].name
        itemView.item_description.text = model[position].name
        itemView.item_price.text = model[position].price
    }
}
