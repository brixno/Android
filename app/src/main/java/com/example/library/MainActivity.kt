package com.example.library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sqlite.SqliteHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rentalIntent = Intent(this, RentalActivity::class.java)
        val turnInIntent = Intent(this, TurnInActivity::class.java)
        val storeIntent = Intent(this, StoreActivity::class.java)
        val modifyIntent = Intent(this, ModifyActiviy::class.java)
        val listIntent = Intent(this, showListActivity::class.java)
        val rentalListIntent = Intent(this, rentalListActivity::class.java)

        btn_rental.setOnClickListener { startActivity(rentalIntent) }
        btn_turnIn.setOnClickListener { startActivity(turnInIntent) }
        btn_store.setOnClickListener { startActivity(storeIntent) }
        btn_modify.setOnClickListener { startActivity(modifyIntent) }
        btn_showList.setOnClickListener { startActivity(listIntent) }
        btn_rentalList.setOnClickListener { startActivity(rentalListIntent) }
    }
}