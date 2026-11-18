package com.example.mymvvmarchitekturepractise.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mymvvmarchitekturepractise.model.ContactMode

class ContactViewModel : ViewModel() {
    private val _contacts = mutableStateOf<List<ContactMode>>(emptyList())
    val contacts: State<List<ContactMode>> = _contacts

    fun addContacts(contactMode: ContactMode) {
        _contacts.value += contactMode
    }

    fun deleteContact(id: String) {
        _contacts.value = _contacts.value.filter {
            it.id != id
        }
    }

    fun editContact(contact: ContactMode) {
        _contacts.value = _contacts.value.map {
            if (it.id == contact.id) {
                contact
            } else {
                it
            }
        }
    }
}