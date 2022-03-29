package com.example.stockpredicter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stockpredicter.R
import com.example.stockpredicter.databinding.NewsViewBinding
import com.example.stockpredicter.models.Articles

class NewsAdapter(private val context : Context, private val list : ArrayList<Articles>): RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            NewsViewBinding.inflate(
                LayoutInflater.from(context),parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val name : String? = list[position].title
        holder.binding.tvNewsTitle.text = name

//        if (name != null) {
//            if(name.length >30){
//                var newName = name.subSequence(0,28)
//                newName = "$newName..."
//                holder.binding.tvNewsTitle.text = newName
//            }
//            else{
//
//            }
//        }

        Glide.with(context)
            .load(list[position].urlToImage)
            .into(holder.binding.imNews)


        holder.binding.tvNewsReport.text = ""


    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class ViewHolder(val binding : NewsViewBinding) : RecyclerView.ViewHolder(binding.root){

    }


}