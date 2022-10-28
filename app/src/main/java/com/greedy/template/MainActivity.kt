package com.greedy.template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.greedy.template.API.Body
import com.greedy.template.API.Item
import com.greedy.template.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PostsAdapter
    private lateinit var body: Body
    private lateinit var itemList: MutableList<Item?>
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        recyclerView = binding.postsView
        loadData()
        initScrollListener()

    }

    private fun loadData() {

        CoroutineScope(Dispatchers.Main).launch {

            withContext(Dispatchers.IO) {
                val response = PostsService.getPostsService().posts()
                if (response.isSuccessful) {
                    body = response.body()!!
                    itemList =body.items.items.toMutableList()
                } else {
                    Log.d("Error", "${response.message()}")
                }
            }

            adapter = PostsAdapter(itemList)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(baseContext)
        }

    }

    private fun initScrollListener() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == itemList.size - 1) {
                        //bottom of list!
                        loadMore()
                        isLoading = true
                    }
                }
            }
        })
    }

    private fun loadMore() {

        CoroutineScope(Dispatchers.Main).launch {

            val skip = if (body.pageNo + 20 < body.totalCount) body.pageNo + 20 else body.totalCount

            withContext(Dispatchers.IO) {
                val response = PostsService.getPostsService().posts(skip)

                if (response.isSuccessful) {
                    body = response.body()!!
                    Log.d("posts", body.toString())
                    itemList.addAll(body.items.items.toMutableList())

                } else {
                    Log.d("Error", "${response.message()}")
                }
            }

            adapter.notifyDataSetChanged()
            isLoading = false
        }
    }
}