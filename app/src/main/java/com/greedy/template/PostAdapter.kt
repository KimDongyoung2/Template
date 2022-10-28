package com.greedy.template

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greedy.template.API.Item
import com.greedy.template.databinding.PostRecyclerBinding


class PostsAdapter(var itemList: MutableList<Item?>) : RecyclerView.Adapter<PostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        return PostHolder(PostRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return if (itemList == null) 0 else itemList!!.size
    }

    override fun onBindViewHolder(viewHolder: PostHolder, position: Int) {
        val item = itemList!![position]
        viewHolder.setItem(item)
    }

}

class PostHolder(val binding: PostRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var item: Item

    init {
        binding.root.setOnClickListener {
            //val intent = Intent(it.context, PostDetailActivity::class.java)
            //intent.putExtra("postId", post.id)
            //it.context.startActivity(intent)
        }
    }

    fun setItem(item: Item?) {
        binding.title.text = "${item?.contentId}. ${item?.facltNm}"

        this.item = item!!
    }

}