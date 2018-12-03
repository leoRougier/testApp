package com.example.leo.testapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.leo.testapp.R
import com.example.leo.testapp.model.Album
import kotlinx.android.synthetic.main.layout_album_row.view.*


class AlbumAdapter(private var album: List<String>) : RecyclerView.Adapter<AlbumAdapter.BankViewHolder>() {

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        holder.bind(album[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            BankViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_album_row, parent, false))


    override fun getItemCount() = album.size


    class BankViewHolder(private val v: View) : ViewHolder(v) {
        fun bind(album: String) {
            v.row_title.text = album
        }
    }
}