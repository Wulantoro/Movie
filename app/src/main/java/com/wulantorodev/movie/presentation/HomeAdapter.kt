package com.wulantorodev.movie.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.wulantorodev.movie.R
import com.wulantorodev.movie.Result
import com.wulantorodev.movie.databinding.ItemHomeBinding
import com.wulantorodev.movie.presentation.HomeAdapter.*

class HomeAdapter(private val results: List<Result>): Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_home,
                parent,
                false
            )
//            LayoutInflater
//                .from(parent.context)
//                .inflate(
//                    R.layout.item_home,
//                    parent,
//                    false
                )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, posotion: Int) {
        holder.binding.apply {
            viewModel = HomeAdapterViewModel(results[holder.adapterPosition])
            executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return results.count()
    }

    inner class HomeViewHolder(val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root)

//    inner class HomeViewHolder(itemView: View): ViewHolder(itemView) {
//        fun bind(result: Result) {
//            with(itemView) {
//                val title = findViewById<TextView>(R.id.tv_title)
//                title.text = result.title
//
//                val overwiew = findViewById<TextView>(R.id.tv_overview)
//                overwiew.text = result.overview
//            }
//        }
//    }
}