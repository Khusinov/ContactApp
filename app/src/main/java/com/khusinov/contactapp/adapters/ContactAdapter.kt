package com.khusinov.contactapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khusinov.contactapp.databinding.ContactItemBinding
import com.khusinov.contactapp.models.Contact

class ContactAdapter(var list: List<Contact>) : RecyclerView.Adapter<ContactAdapter.VH>() {

    inner class VH(private val binding: ContactItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(contact: Contact) {
            binding.tv.text = contact.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ContactItemBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}