package com.example.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqliteRentalHelper(context: Context, name:String, version:Int) : SQLiteOpenHelper(context, name, null, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val create = "create table rentalLibrary (" +
                "no integer primary key, " +
                "bookName text, " +
                "price integer, " +
                "writer text, " +
                "genre text" + ")"

        db?.execSQL(create)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertRentalLibrary(rentalLibrary: RentalLibrary) {
        val values = ContentValues()
        values.put("bookName", rentalLibrary.bookName)
        values.put("price", rentalLibrary.price)
        values.put("writer", rentalLibrary.writer)
        values.put("genre", rentalLibrary.genre)

        val wd = writableDatabase
        wd.insert("rentalLibrary", null, values) // 첫번쨰 오류일 수도?

        wd.close()
    }

    fun selectRentalLibrary():MutableList<RentalLibrary> {
        val list = mutableListOf<RentalLibrary>()
        val select = "select * from rentalLibrary"
        val rd = readableDatabase
        val cursor = rd.rawQuery(select,null)
        while(cursor.moveToNext())
        {
            val no = cursor.getLong(cursor.getColumnIndex("no"))
            val bookName = cursor.getString(cursor.getColumnIndex("bookName"))
            val price = cursor.getLong(cursor.getColumnIndex("price"))
            val writer = cursor.getString(cursor.getColumnIndex("writer"))
            val genre = cursor.getString(cursor.getColumnIndex("genre"))

            list.add(RentalLibrary(no, bookName, price, writer, genre))
        }

        cursor.close()
        rd.close()

        return list
    }

    fun deleteLibrary(RentalLibrary:RentalLibrary) {
        val delete = "delete from RentalLibrary where bookName = '${RentalLibrary.bookName}'"

        val db = writableDatabase
        db.execSQL(delete)
        db.close()
    }

    fun deleteAllLibrary() {
        val delete = "delete from RentalLibrary"
        val db = writableDatabase
        db.execSQL(delete)
        db.close()
    }

    fun updateLibrary(rentalLibrary:RentalLibrary, libraryNext:RentalLibrary) {
        val values = ContentValues()
        values.put("bookName", libraryNext.bookName)
        values.put("price", libraryNext.price)
        values.put("writer", libraryNext.writer)
        values.put("genre", libraryNext.genre)

        val wd = writableDatabase
        wd.update("rentalLibrary", values, "bookName = '${rentalLibrary.bookName}'", null)
        wd.close()
    }

}

data class RentalLibrary(var no:Long?, var bookName:String, var price:Long, var writer:String, var genre:String)