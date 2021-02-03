package com.example.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sqlite.Library
import com.example.sqlite.SqliteHelper
import kotlinx.android.synthetic.main.activity_modify_activiy.*
import kotlinx.android.synthetic.main.activity_store.*

class ModifyActiviy : AppCompatActivity() {

    val helper = SqliteHelper(this, "library.db", 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_activiy)

        btn_modify.setOnClickListener{
            val price = Integer.parseInt(edit_mdPrice.getText().toString())
            val library = Library(null, edit_mdTitle.text.toString(), price.toLong(), edit_mdWriter.text.toString(), edit_mdGenre.text.toString())

            val priceNext = Integer.parseInt(edit_mdPriceNext.getText().toString())
            val libraryNext = Library(null, edit_mdTitleNext.text.toString(), priceNext.toLong(), edit_mdWriterNext.text.toString(), edit_mdGenreNext.text.toString())
            helper.updateLibrary(library,libraryNext)
        }
    }
}