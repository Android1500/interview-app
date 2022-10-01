package com.android1500.interviewapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android1500.interviewapp.R
import com.android1500.interviewapp.room.PostEntity

class PostAdapter :  ListAdapter<PostEntity, PostAdapter.ViewHolder>(PostComparator()) {


    var onItemClick : ((PostEntity) -> Unit)? = null



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val mTitle: TextView = itemView.findViewById(R.id.title)
        fun bind(postEntity: PostEntity){
            mTitle.text = postEntity.title
            itemView.setOnClickListener {
                onItemClick?.invoke(postEntity)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post,null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }



    class PostComparator : DiffUtil.ItemCallback<PostEntity>(){
        override fun areItemsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean {
           return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean {
            return oldItem == newItem
        }

    }
}