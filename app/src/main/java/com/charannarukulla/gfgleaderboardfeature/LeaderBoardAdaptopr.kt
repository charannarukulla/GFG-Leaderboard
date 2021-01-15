package com.charannarukulla.gfgleaderboardfeature

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class LeaderBoardAdaptopr(
    var context: Context,
    private var options: List<lldclass>?
): RecyclerView.Adapter<LeaderBoardAdaptopr.ViewHolder>() {//RecyclerViewAdaptor
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){


        var rank=view.findViewById<TextView>(R.id.rank)//binding view

        var score=view.findViewById<TextView>(R.id.scorenumber)//binding view
        fun bind(position: Int) {//function that provides data to textviews
            var r=position+1//rank = Recyclerview position+1
            rank.text=(r).toString()

            score.text=  options?.get(position)?.score.toString()//score from data class list
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v= LayoutInflater.from(context).inflate(R.layout.score_list,parent,false)//linking score_list to the adaptor
        return  ViewHolder(v)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)//function call sending position
    }

    override fun getItemCount(): Int {
        return options?.size!!//Size of the list
    }
}