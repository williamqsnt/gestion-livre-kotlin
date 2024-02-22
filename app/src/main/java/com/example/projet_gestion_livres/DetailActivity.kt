package com.example.projet_gestion_livres

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val titre = intent.getStringExtra("titre")
        val auteur = intent.getStringExtra("auteur")
        val description = intent.getStringExtra("description")
        val photoUrl = intent.getStringExtra("photo")

        val titreTextView: TextView = findViewById(R.id.detailTitreTextView)
        val auteurTextView: TextView = findViewById(R.id.detailAuteurTextView)
        val descriptionTextView: TextView = findViewById(R.id.detailDescriptionTextView)
        val photoImageView: ImageView = findViewById(R.id.detailPhotoImageView)

        titreTextView.text = titre
        auteurTextView.text = auteur
        descriptionTextView.text = description

        Picasso.get().load(photoUrl).into(photoImageView)

        val retour = findViewById<Button>(R.id.retour)
        retour.setOnClickListener {
            finish()
        }
    }
}
