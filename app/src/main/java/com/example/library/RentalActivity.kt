package com.example.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sqlite.Library
import com.example.sqlite.RentalLibrary
import com.example.sqlite.SqliteHelper
import com.example.sqlite.SqliteRentalHelper
import kotlinx.android.synthetic.main.activity_rental.*
import kotlinx.android.synthetic.main.activity_store.*

class RentalActivity : AppCompatActivity() {
    val helper = SqliteHelper(this, "library.db", 1)
    val rentalHelper = SqliteRentalHelper(this, "library.db", 1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rental)

        btn_Rental.setOnClickListener{
            val price = Integer.parseInt(editRentalPrice.getText().toString())
            val library = Library(null, editRentalTitle.text.toString(), price.toLong(), editRentalWriter.text.toString(), editRentalGenre.text.toString())
            val rental = RentalLibrary(null, editRentalTitle.text.toString(), price.toLong(), editRentalWriter.text.toString(), editRentalGenre.text.toString())
            rentalHelper.insertRentalLibrary(rental)
            helper.deleteLibrary(library)
        }
    }
}