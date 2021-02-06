package com.example.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlite.Library
import com.example.sqlite.RentalLibrary
import com.example.sqlite.SqliteRentalHelper
import kotlinx.android.synthetic.main.item_recycler.view.*

class RecyclerRentalAdapter : RecyclerView.Adapter<RecyclerRentalAdapter.Holder>() {
    val rentalHelper : SqliteRentalHelper? = null
    val listData = mutableListOf<RentalLibrary>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerRentalAdapter.Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return Holder(view)
    }

    override fun getItemCount():Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: RecyclerRentalAdapter.Holder, position: Int) {
        val rentalLibrary = listData.get(position)
        holder.setLibrary(rentalLibrary)
    }
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setLibrary(rentalLibrary: RentalLibrary) {
            itemView.textNo.text = "${rentalLibrary}.no}"
            itemView.textBookName.text = rentalLibrary.bookName
            itemView.textWriter.text = rentalLibrary.writer
            itemView.textPrice.text = rentalLibrary.price.toString()
            itemView.textGenre.text = rentalLibrary.genre
        }
    }
}