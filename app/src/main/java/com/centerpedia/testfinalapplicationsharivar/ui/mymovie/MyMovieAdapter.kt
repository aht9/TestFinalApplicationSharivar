package com.centerpedia.testfinalapplicationsharivar.ui.mymovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.centerpedia.testfinalapplicationsharivar.common.loadUrl
import com.centerpedia.testfinalapplicationsharivar.model.MyMovies
import com.centerpedia.testfinalapplicationsharivar.databinding.RcItemLayoutBinding


class MyMovieAdapter (val clickListener: (String) -> Unit) :
    ListAdapter<MyMovies, MyMovieAdapter.MyMovieVH>(MyMovieDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMovieVH =
        MyMovieVH(
            RcItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: MyMovieVH, position: Int) =
        holder.onBind(getItem(position))

    inner class MyMovieVH(private val binding: RcItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: MyMovies) {
            binding.imgPoster.loadUrl(item.poster)
            binding.txtMovieTitle.text = item.title
            binding.txtYear.text = item.year
            binding.root.setOnClickListener {
                clickListener(item.imdbId)
            }
        }
    }

    class MyMovieDiffUtils : DiffUtil.ItemCallback<MyMovies>() {
        override fun areItemsTheSame(oldItem: MyMovies, newItem: MyMovies) =
            oldItem.imdbId == newItem.imdbId

        override fun areContentsTheSame(oldItem: MyMovies, newItem: MyMovies) =
            oldItem.title == newItem.title &&
                    oldItem.actors == newItem.actors &&
                    oldItem.plot == newItem.plot

    }
}