package com.charannarukulla.gfgleaderboardfeature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query


class MainActivity : AppCompatActivity() {
    lateinit var adaptopr: LeaderBoardAdaptopr//Adapter object

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//binding layout

        var rrv = findViewById<RecyclerView>(R.id.rr)//binding view
var effect=findViewById<ShimmerFrameLayout>(R.id.shimmerFrameLayout)//binding view
        effect.startShimmerAnimation()//start animation
        FirebaseFirestore.getInstance().collection("numbers")//Fetching score in DESCENDING order
            .orderBy("score", Query.Direction.DESCENDING).addSnapshotListener { value, error ->


            var playerModel = value?.map {
                it.toObject(lldclass::class.java)
            }//mapping to data class list
effect.stopShimmerAnimation()
                effect.visibility= View.GONE//stop animation
                rrv.visibility=View.VISIBLE//set RecyclerView Visible
            adaptopr = LeaderBoardAdaptopr(this, playerModel)//constructor call
            rrv.adapter = adaptopr//Assigning adapter  to recyclerview
            rrv.setHasFixedSize(true)

            rrv.layoutManager = LinearLayoutManager(this)//Assigning layout manager


        }


    }

}