package fr.gobelins.dmi1

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnHomeCompute: Button
    private lateinit var btnHomeSOS: Button
    private lateinit var btnHomeSearch: Button
    private lateinit var btnHomeShare: Button
    private lateinit var btnHomeItinerary: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnHomeCompute = findViewById(R.id.btn_home_compute)
        btnHomeCompute.setOnClickListener {
            val intent = Intent(this, ComputeActivity::class.java)
            //intent.extras?.putString("operation", "ADD")
            startActivity(intent)
        }
        // Si l'utilisateur clique sur SOS
        btnHomeSOS= findViewById(R.id.btn_home_sos)
        btnHomeSOS.setOnClickListener {
            val intent= Intent(Intent.ACTION_DIAL)
            val number="0761728378"
            intent.data = Uri.parse ("tel:$number")
            startActivity(intent)
        }

        // Si l'utilisateur clique sur Search
        btnHomeSearch= findViewById(R.id.btn_home_search)
        btnHomeSearch.setOnClickListener {
            val intent= Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY,"https://google.fr")
            startActivity(intent)
        }

        // Si l'utilisateur clique sur Share
        btnHomeShare= findViewById(R.id.btn_home_share)
        btnHomeShare.setOnClickListener {
            val intent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Ceci est un test.")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(intent, null)
            startActivity(shareIntent)
        }


        // Si l'utilisateur clique sur Itinerary
        btnHomeItinerary= findViewById(R.id.btn_home_itinerary)
        btnHomeItinerary.setOnClickListener {
            val gmmIntentUri =
                Uri.parse("google.navigation:q=Bureau Vallée Paris V (métro les Gobelins) - papeterie et photocopie, 86 Bd Saint-Marcel, 75005 Paris")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}