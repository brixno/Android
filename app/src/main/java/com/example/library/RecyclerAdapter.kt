package com.example.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlite.Library
import com.example.sqlite.SqliteHelper
import kotlinx.android.synthetic.main.item_recycler.view.*
import java.text.SimpleDateFormat

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.Holder>(){
    var helper: SqliteHelper? = null
    var listData = mutableListOf<Library>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return Holder(view)
    }

    override fun getItemCount():Int {
        return listData.size
    }

    override fun onBindViewHolder(holder:Holder, position:Int) {
        val library = listData.get(position)
        holder.setLibrary(library)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setLibrary(library:Library) {
            itemView.textNo.text = "${library.no}"
            itemView.textBookName.text = library.bookName
            itemView.textWriter.text = library.writer
            itemView.textPrice.text = library.price.toString()
            itemView.textGenre.text = library.genre
        }
    }
}