package com.example.signupandsignin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context):SQLiteOpenHelper(context,"UserDetails.db",null,1) {
    val sqLiteDatabase:SQLiteDatabase=writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table Users(id integer primary key autoincrement,Name text,Mobile text,Location text,Password text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun saveData(n:String,m:String,l:String,p:String): Long {
        val cv= ContentValues()
        cv.put("Name",n)
        cv.put("Mobile",m)
        cv.put("Location",l)
        cv.put("Password",p)
        var status=sqLiteDatabase.insert("Users",null,cv)
        return status
    }

    fun retrieveData(m:String,p:String):ArrayList<String>{
        val c: Cursor =sqLiteDatabase.rawQuery("SELECT * FROM Users WHERE Mobile=? AND Password=?",
            arrayOf(m,p))
        var user=ArrayList<String>()
        if(c.count>0){
            c.moveToFirst()
            user.add(c.getString(c.getColumnIndex("Name")))
            user.add(c.getString(c.getColumnIndex("Mobile")))
            user.add(c.getString(c.getColumnIndex("Location")))
            user.add(c.getString(c.getColumnIndex("Password")))
        }else{
            user.add("invalid mobile or password")
        }
        return user
    }
}