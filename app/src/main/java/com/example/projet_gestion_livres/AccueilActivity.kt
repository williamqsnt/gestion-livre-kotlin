package com.example.projet_gestion_livres

import LivresDAO
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class AccueilActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var livresAdapter: LivresAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accueil)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val livresDAO = LivresDAO()
        val firestore = FirebaseFirestore.getInstance()

        firestore.collection("livres")
            .get()
            .addOnSuccessListener { result ->
                val livresList = livresDAO.creerlivre(result)
                livresAdapter = LivresAdapter(livresList)
                recyclerView.adapter = livresAdapter
            }
            .addOnFailureListener { exception ->
            }
    }
}
