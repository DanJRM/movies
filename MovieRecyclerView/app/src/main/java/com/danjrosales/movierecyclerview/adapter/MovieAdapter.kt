package com.danjrosales.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danjrosales.movierecyclerview.R
import com.danjrosales.movierecyclerview.listener.OnItemMovieSelectedListener
import com.danjrosales.movierecyclerview.model.Movie
import kotlinx.android.synthetic.main.item_contact.view.*

class movieAdapter(
    val contacts: ArrayList<Movie>,
    val context: Context
) : RecyclerView.Adapter<ContactViewHolder>() {

    private lateinit var onItemMovieSelectedListener: OnItemMovieSelectedListener

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_contact,
                p0,
                false
            )
        )
    } //Retorna la vista para agregarla al contexto

    override fun getItemCount(): Int { // Regresa tamaño de la vista
        return contacts.size
    }

    override fun onBindViewHolder(p0: ContactViewHolder, p1: Int) {
        p0.numberphoneButton.setImageResource(android.R.drawable.sym_action_call)
        p0.contactImageView.setImageResource(R.mipmap.ic_launcher)
        p0.nameTextView.setText(contacts[p1].name)
        p0.lastNameTextView.setText(contacts[p1].lastname)
        p0.setContact(contacts[p1])
        p0.setOnItemContactSelectedListener(onItemMovieSelectedListener)
    }

    public fun addContact(contact: Movie, position: Int) { //Agregar nuevos elementos a la lista
        contacts.add(position, contact)
        //notifyDataSetChanged() // Notifica a la lista
        notifyItemInserted(position) //Inserta en una posición
    }

    public fun removeContact(position: Int) { //Agregar nuevos elementos a la lista
        contacts.removeAt(position)
        notifyDataSetChanged() // Notifica a la lista
        notifyItemRemoved(position)
    }

    fun setOnItemContactSelectedListener(onItemContactSelectedListener: OnItemMovieSelectedListener) {
        this.onItemMovieSelectedListener = onItemContactSelectedListener
    }
}

class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val contactImageView = view.contact_imageView
    val nameTextView = view.name_textView
    val lastNameTextView = view.lastname_textView
    val numberphoneButton = view.numberPhone_imageButton
    private lateinit var contact: Movie

    fun setContact(contact: Movie) {
        this.contact = contact
    }

    fun setOnItemContactSelectedListener(onItemContactSelectedListener: OnItemMovieSelectedListener) {
        if (onItemContactSelectedListener != null)
            itemView.setOnClickListener {
                onItemContactSelectedListener.onItemMovieSelected(
                    contact
                )
            }
    }
}