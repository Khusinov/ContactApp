package com.khusinov.contactapp.db

import com.khusinov.contactapp.models.Contact

interface DatabaseService {
    fun addContact(contact: Contact)

    fun deleteContact(contact: Contact)

    fun updateContact(contact: Contact):Int

    fun getAllContact():List<Contact>
}