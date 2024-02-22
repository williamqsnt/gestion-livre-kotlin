package com.example.projet_gestion_livres
import com.squareup.picasso.Picasso

import Livres
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


class LivresAdapter(private val livresList: List<Livres>) :
    RecyclerView.Adapter<LivresAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titreTextView: TextView = itemView.findViewById(R.id.titreTextView)
        val photoImageView: ImageView = itemView.findViewById(R.id.photoImageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_livre, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val livre = livresList[position]
        holder.titreTextView.text = livre.titre

        Picasso.get()
            .load(livre.photo) 
            .into(holder.photoImageView)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java).apply{
                putExtra("titre", livre.titre)
                putExtra("auteur", livre.auteur)
                putExtra("description", livre.description)
                putExtra("photo", livre.photo)
            }
            holder.itemView.context.startActivity(intent)

        }
    }

    
    override fun getItemCount(): Int {
        return livresList.size
    }
}
