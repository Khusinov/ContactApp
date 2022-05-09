package com.khusinov.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khusinov.contactapp.adapters.ContactAdapter
import com.khusinov.contactapp.databinding.ActivityMainBinding
import com.khusinov.contactapp.db.MyDbHelper
import com.khusinov.contactapp.models.Contact

class MainActivity : AppCompatActivity() {

    lateinit var myDbHelper: MyDbHelper
    lateinit var list: List<Contact>
    lateinit var contactAdapter: ContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDbHelper = MyDbHelper(this)

        list = myDbHelper.getAllContact()
        contactAdapter = ContactAdapter(list)
        binding.rv.adapter = contactAdapter




    }
}