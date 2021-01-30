package com.example.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sqlite.Library
import com.example.sqlite.SqliteHelper
import kotlinx.android.synthetic.main.activity_store.*

class StoreActivity : AppCompatActivity() {
    val helper = SqliteHelper(this, "library.db", 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        btn_putdata.setOnClickListener {
            val price = Integer.parseInt(editPrice.getText().toString())
            val library = Library(null, editTitle.text.toString(), price.toLong(), editWriter.text.toString(), editGenre.text.toString())
            helper.insertLibrary(library)
        }
    }
}