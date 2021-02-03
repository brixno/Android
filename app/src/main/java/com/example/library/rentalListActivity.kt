package com.example.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqlite.SqliteHelper
import kotlinx.android.synthetic.main.activity_rental_list.*
import kotlinx.android.synthetic.main.activity_show_list.*

class rentalListActivity : AppCompatActivity() {
    val helper = SqliteHelper(this, "library.db",1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rental_list)

        val adapter = RentalRecyclerAdapter()
        adapter.helper = helper

        recyclerRental.adapter = adapter
        recyclerRental.layoutManager = LinearLayoutManager(this)

        adapter.listData.clear()
        adapter.listData.addAll(helper.selectRentalLibrary())
        adapter.notifyDataSetChanged()
    }
}