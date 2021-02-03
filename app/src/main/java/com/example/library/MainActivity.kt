package com.example.library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val removeIntent = Intent(this, RemoveActivity::class.java)

        btn_goRental.setOnClickListener { startActivity(rentalIntent) }
        btn_goTurnIn.setOnClickListener { startActivity(turnInIntent) }
        btn_goStore.setOnClickListener { startActivity(storeIntent) }
        btn_goModify.setOnClickListener { startActivity(modifyIntent) }
        btn_goShowList.setOnClickListener { startActivity(listIntent) }
        btn_goRentalList.setOnClickListener { startActivity(rentalListIntent) }
        btn_goRemove.setOnClickListener { startActivity(removeIntent) }
    }
}