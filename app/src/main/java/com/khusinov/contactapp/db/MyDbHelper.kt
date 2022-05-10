package com.khusinov.contactapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.khusinov.contactapp.models.Contact
import com.khusinov.contactapp.utills.Object

class MyDbHelper(context: Context) :
    SQLiteOpenHelper(context, Object.DB_NAME, null, Object.DB_VERSION), DatabaseService {
    override fun onCreate(p0: SQLiteDatabase?) {
        val query =
            "create table ${Object.TABLE_NAME} (${Object.ID} integer not null primary key autoincrement unique, ${Object.NAME} text not null , ${Object.PHONE_NUMBER} text not null)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists ${Object.TABLE_NAME}")
    }

    override fun addContact(contact: Contact) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Object.NAME, contact.name)
        contentValues.put(Object.PHONE_NUMBER, contact.phoneNumber)
        database.insert(Object.TABLE_NAME, null, contentValues)
        //database.close()
    }

    override fun deleteContact(contact: Contact) {
        val database = this.writableDatabase
        database.delete(Object.TABLE_NAME, "${Object.ID} = ? ", arrayOf("${contact.id}"))
        // database.close()
    }

    override fun updateContact(contact: Contact): Int {
        val database = this.writableDatabase
        val cv = ContentValues()
        cv.put(Object.ID, contact.id)
        cv.put(Object.NAME, contact.name)
        cv.put(Object.PHONE_NUMBER, contact.phoneNumber)
        return database.update(
            Object.TABLE_NAME,
            cv,
            "${Object.ID} = ?",
            arrayOf(contact.id.toString())
        )
    }

    override fun getAllContact(): List<Contact> {
        val readableDatabase = this.readableDatabase
        val list = ArrayList<Contact>()
        val query = "SELECT * FROM ${Object.TABLE_NAME}"

        val cursor = readableDatabase.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val phoneNumber = cursor.getString(2)

                val contact = Contact(id, name, phoneNumber)
                list.add(contact)

            } while (cursor.moveToNext())
        }
        return list
    }

}