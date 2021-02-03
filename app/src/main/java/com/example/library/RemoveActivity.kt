package com.example.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sqlite.Library
import com.example.sqlite.SqliteHelper
import kotlinx.android.synthetic.main.activity_remove.*
import kotlinx.android.synthetic.main.activity_store.*

class RemoveActivity : AppCompatActivity() {
    val helper = SqliteHelper(this, "library.db", 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remove)

        btn_remove.setOnClickListener {
            val price = Integer.parseInt(editRmPrice.getText().toString())
            val library = Library(null, editRmTitle.text.toString(), price.toLong(), editRmWriter.text.toString(), editRmGenre.text.toString())
            helper.deleteLibrary(library)
        }

        btn_removeAll.setOnClickListener {
            helper.deleteAllLibrary()
        }
    }
}