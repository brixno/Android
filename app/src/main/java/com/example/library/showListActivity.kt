package com.example.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqlite.SqliteHelper
import kotlinx.android.synthetic.main.activity_show_list.*
import kotlinx.android.synthetic.main.activity_store.*

class showListActivity : AppCompatActivity() {
    val helper = SqliteHelper(this, "library.db",1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)

        val adapter = RecyclerAdapter()
        adapter.helper = helper

        recyclerLibrary.adapter = adapter
        recyclerLibrary.layoutManager = LinearLayoutManager(this)

        adapter.listData.clear()
        adapter.listData.addAll(helper.selectLibrary())
        adapter.notifyDataSetChanged()
    }
}