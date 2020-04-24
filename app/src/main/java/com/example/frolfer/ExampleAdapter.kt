package com.example.frolfer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_card_view.view.*

//implement methods (ctrl+i select all)
class ExampleAdapter(private val scoreList: List<RecyclerViewItem>) : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_card_view,
            parent, false)                                                           // create a recyclerview adapter
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {           //called repeatedly when scrolling
        val currentItem = scoreList[position]
        holder.recyclerHoleNumber.text = currentItem.holeNumber
        holder.textView1.text= currentItem.text1
        holder.textView2.text= currentItem.text2
    }

    override fun getItemCount() = scoreList.size              //how many items in the list

    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recyclerHoleNumber: TextView = itemView.recycler_hole_number      //equivalent to findViewById
        var textView1: TextView = itemView.text_view_1
        var textView2: TextView = itemView.text_view_2
    }
}