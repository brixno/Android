package com.example.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqliteHelper(context: Context, name:String, version:Int) : SQLiteOpenHelper(context, name, null, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val create = "create table library (" +
                "no integer primary key, " +
                "bookName text, " +
                "price integer, " +
                "writer text, " +
                "genre text" + ")"

        val createRental = "create table rentalLibrary (" +
                "no integer primary key, " +
                "bookName text, " +
                "price integer, " +
                "writer text, " +
                "genre text" + ")"

        db?.execSQL(create)
        db?.execSQL(createRental)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertRentalLibrary(rental: RentalLibrary) {
        val values = ContentValues()
        values.put("bookName",rental.bookName)
        values.put("price", rental.price)
        values.put("writer", rental.writer)
        values.put("genre", rental.genre)

        val wd = writableDatabase
        wd.insert("rentalLibrary", null, values) // 첫번쨰 오류일 수도?
        wd.close()
    }

    fun insertLibrary(library: Library) {
        val values = ContentValues()
        values.put("bookName", library.bookName)
        values.put("price", library.price)
        values.put("writer", library.writer)
        values.put("genre", library.genre)

        val wd = writableDatabase
        wd.insert("library", null, values) // 첫번쨰 오류일 수도?

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

    fun selectLibrary():MutableList<Library> {
        val list = mutableListOf<Library>()
        val select = "select * from library"
        val rd = readableDatabase
        val cursor = rd.rawQuery(select,null)
        while(cursor.moveToNext())
        {
            val no = cursor.getLong(cursor.getColumnIndex("no"))
            val bookName = cursor.getString(cursor.getColumnIndex("bookName"))
            val price = cursor.getLong(cursor.getColumnIndex("price"))
            val writer = cursor.getString(cursor.getColumnIndex("writer"))
            val genre = cursor.getString(cursor.getColumnIndex("genre"))

            list.add(Library(no, bookName, price, writer, genre))
        }

        cursor.close()
        rd.close()

        return list
    }

    fun deleteRentalLibrary(rental:RentalLibrary) {
        val delete = "delete from rentalLibrary where bookName = '${rental.bookName}'"

        val db = writableDatabase
        db.execSQL(delete)
        db.close()
    }

    fun deleteLibrary(library:Library) {
        val delete = "delete from library where bookName = '${library.bookName}'"

        val db = writableDatabase
        db.execSQL(delete)
        db.close()
    }

    fun deleteAllLibrary() {
        val delete = "delete from library"
        val db = writableDatabase
        db.execSQL(delete)
        db.close()
    }

    fun updateLibrary(library:Library, libraryNext:Library) {
        val values = ContentValues()
        values.put("bookName", libraryNext.bookName)
        values.put("price", libraryNext.price)
        values.put("writer", libraryNext.writer)
        values.put("genre", libraryNext.genre)

        val wd = writableDatabase
        wd.update("library", values, "bookName = '${library.bookName}'", null)
        wd.close()
    }

}

data class Library(var no:Long?, var bookName:String, var price:Long, var writer:String, var genre:String)
data class RentalLibrary(var no:Long?, var bookName:String, var price:Long, var writer:String, var genre:String)