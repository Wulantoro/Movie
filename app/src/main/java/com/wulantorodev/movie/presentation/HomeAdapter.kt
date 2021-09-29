package com.wulantorodev.movie.presentation

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.wulantorodev.movie.R
import com.wulantorodev.movie.Result
import com.wulantorodev.movie.domain.executor.HomeEntity
import com.wulantorodev.movie.presentation.HomeAdapter.*
import kotlinx.android.synthetic.main.item_home.view.*
import java.lang.RuntimeException
import javax.net.ssl.HandshakeCompletedEvent

enum class Type {
    DATA,
    LOADING
}

class HomeAdapter(private val results: MutableList<HomeEntity.Result>): Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Type.DATA.ordinal -> {
                HomeViewHolder(
                    LayoutInflater
                    .from(parent.context)
                    .inflate(
                    R.layout.item_home,
                    parent,
                    false
                    )
                )
            }
            Type.LOADING.ordinal -> {
                LoadingViewHolder(
                    LayoutInflater
                        .from(parent.context)
                        .inflate(
                            R.layout.item_loading,
                            parent,
                            false
                        )
                )
            }
            else -> throw RuntimeException("Illegal View Type")
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when {
            results[position] == null -> Type.LOADING.ordinal
            else -> Type.DATA.ordinal
        }
    }

    fun showLoading() {
        results.add(null)
        Handler().post{notifyItemInserted(results.count().minus(1))}
    }

    fun hideLoading() {
        results.removeAt(results.count().minus(1))
        Handler().post{notifyItemRemoved(results.count())}
    }

    fun loadMore(results: MutableList<HomeEntity.Result>) {
        this.results.addAll(results)
        Handler().post{notifyDataSetChanged()}
    }

//    override fun onBindViewHolder(holder: HomeViewHolder, posotion: Int) {
////        holder.bind(results[holder.adapterPosition])
//        when(holder) {
//            is HomeViewHolder -> {
//                holder.bind(results[holder.adapterPosition])
//            }
//        }
//    }

    override fun getItemCount(): Int {
        return results.count()
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(result : HomeEntity.Result?) {
            with(itemView) {
                tv_title.text = result?.title ?: "Untitled"
                tv_overview.text = result?.overview ?: "No Description"
            }
        }
    }

    inner class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is HomeViewHolder -> {
                holder.bind(results[holder.adapterPosition])
            }
        }
    }

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