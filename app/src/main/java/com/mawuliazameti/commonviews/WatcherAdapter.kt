package com.mawuliazameti.commonviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import com.mawuliazameti.commonviews.databinding.ItemWatcherBinding

class WatcherAdapter(private val onWatcherClicked: (Watcher) -> Unit) :
    ListAdapter<Watcher, WatcherAdapter.WatcherViewHolder>(WatcherDiff()) {

    class WatcherViewHolder(
        private val binding: ItemWatcherBinding,
        private val onWatcherClicked: (Watcher) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(watcher: Watcher) {
            binding.watcherName.text = watcher.name
            binding.engagement.text = watcher.engagement
            binding.photo.load(watcher.photoUrl)

            binding.root.setOnClickListener { onWatcherClicked(watcher) }

        }
    }

    class WatcherDiff : DiffUtil.ItemCallback<Watcher>() {
        override fun areItemsTheSame(oldItem: Watcher, newItem: Watcher): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Watcher, newItem: Watcher): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatcherViewHolder {
        val view = ItemWatcherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WatcherViewHolder(view, onWatcherClicked)
    }

    override fun onBindViewHolder(holder: WatcherViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}