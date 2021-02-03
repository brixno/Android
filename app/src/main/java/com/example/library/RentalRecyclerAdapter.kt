package com.example.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlite.Library
import com.example.sqlite.RentalLibrary
import com.example.sqlite.SqliteHelper
import kotlinx.android.synthetic.main.item_recycler.view.*

class RentalRecyclerAdapter : RecyclerView.Adapter<RentalRecyclerAdapter.Holder>(){
    var helper: SqliteHelper? = null
    var listData = mutableListOf<RentalLibrary>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return Holder(view)
    }

    override fun getItemCount():Int {
        return listData.size
    }

    override fun onBindViewHolder(holder:Holder, position:Int) {
        val rentalLibrary = listData.get(position)
        holder.setLibrary(rentalLibrary)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setLibrary(rental:RentalLibrary) {
            itemView.textNo.text = "${rental.no}"
            itemView.textBookName.text = rental.bookName
            itemView.textWriter.text = rental.writer
            itemView.textPrice.text = rental.price.toString()
            itemView.textGenre.text = rental.genre
        }
    }
}