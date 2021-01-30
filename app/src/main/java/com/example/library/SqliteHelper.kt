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

        db?.execSQL(create)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

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

    fun deleteLibrary(library:Library) {
        val delete = "delete from memo where no = ${library.no}"

        val db = writableDatabase
        db.execSQL(delete)
        db.close()
    }

    fun updateMemo(library:Library) {
        val values = ContentValues()
        values.put("bookName", library.bookName)
        values.put("price", library.price)
        values.put("writer", library.writer)
        values.put("genre", library.genre)

        val wd = writableDatabase
        wd.update("memo", values, "no = ${library.no}", null)
        wd.close()
    }

}

data class Library(var no:Long?, var bookName:String, var price:Long, var writer:String, var genre:String)