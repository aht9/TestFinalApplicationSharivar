package com.centerpedia.testfinalapplicationsharivar.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.centerpedia.testfinalapplicationsharivar.R
import com.centerpedia.testfinalapplicationsharivar.common.loadUrl
import com.centerpedia.testfinalapplicationsharivar.databinding.RcItemLayoutBinding
import com.centerpedia.testfinalapplicationsharivar.model.Search

class MovieAdapter (val clickListener: (String) -> Unit) :
    ListAdapter<Search, MovieAdapter.MovieVH>(MovieDiffUtils()) {


    inner class MovieVH(val binding: RcItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Search) {
            binding.txtMovieTitle.text = item.Title
            binding.txtYear.text = item.Year
            binding.imgPoster.loadUrl(item.Poster)

            binding.root.setOnClickListener {
                clickListener(item.imdbID)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        val binding = RcItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return MovieVH(binding)
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        holder.binding.root.animation = AnimationUtils.loadAnimation(
            holder.itemView.context,
            R.anim.recycler_animation
        )
        return holder.onBind(getItem(position))
    }

}

class MovieDiffUtils : DiffUtil.ItemCallback<Search>() {
    override fun areItemsTheSame(oldItem: Search, newItem: Search): Boolean {
        return oldItem.imdbID == newItem.imdbID
    }

    override fun areContentsTheSame(oldItem: Search, newItem: Search): Boolean {
        return oldItem.Title == newItem.Title
                && oldItem.Poster == newItem.Poster
                && oldItem.Year == newItem.Year
    }

}