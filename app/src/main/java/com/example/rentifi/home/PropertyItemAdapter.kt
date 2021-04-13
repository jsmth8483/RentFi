package com.example.rentifi.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rentifi.R
import com.example.rentifi.database.models.Property

class PropertyItemAdapter : RecyclerView.Adapter<PropertyItemAdapter.ViewHolder>() {
    var data = listOf<Property>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.property_title)
        val address: TextView = itemView.findViewById(R.id.property_address_text)

        fun bind(item: Property) {
            val res = itemView.context.resources
            title.text = item.title
            address.text = item.address
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.property_row_item, parent, false)
                return ViewHolder(view)
            }
        }

    }
}