package com.example.wishlist

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    var wishlist: MutableList<WishlistItem> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val wishlist_recycler_view = findViewById<RecyclerView>(R.id.wishlist_recycler_view)

        findViewById<Button>(R.id.submit_button).setOnClickListener {
            val name = findViewById<TextInputEditText>(R.id.name_text_input).text.toString()
            val price = findViewById<TextInputEditText>(R.id.price_text_input).text.toString()
            val link = findViewById<TextInputEditText>(R.id.link_text_input).text.toString()

            val wishlist_item = WishlistItem(name, price, link)
            wishlist.add(wishlist_item)
            val adapter = WishlistAdapter(wishlist)
            wishlist_recycler_view.adapter = adapter
            wishlist_recycler_view.layoutManager = LinearLayoutManager(this)
            adapter.notifyDataSetChanged()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}