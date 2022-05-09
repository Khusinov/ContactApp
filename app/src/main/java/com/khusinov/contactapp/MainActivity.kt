package com.khusinov.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khusinov.contactapp.db.MyDbHelper
import com.khusinov.contactapp.models.Contact

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDbHelper = MyDbHelper(this)

        val contact = Contact(1,"Shaxriyor" , "+998 94 233 17 05")
       // myDbHelper.addContact(contact)

        myDbHelper.deleteContact(contact)
    }
}