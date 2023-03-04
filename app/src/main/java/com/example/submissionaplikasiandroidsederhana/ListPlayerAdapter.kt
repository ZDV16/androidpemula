package com.example.submissionaplikasiandroidsederhana

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListPlayerAdapter(private val listPlayer: ArrayList<Players>) : RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
    val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_player, parent,false)
    return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listPlayer.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, position, birth, photo) = listPlayer[position]
        holder.imgFoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener{
            val intentDetailPlayer = Intent(holder.itemView.context, PlayerDetailActivity::class.java)
            intentDetailPlayer.putExtra(PlayerDetailActivity.KEY_PLAYER, listPlayer[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetailPlayer)
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imgFoto: ImageView= itemView.findViewById(R.id.img_item_photo)
    val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
    val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}