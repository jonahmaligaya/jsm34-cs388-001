package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.R

class WishlistItem(
    val name: String,
    val price: String,
    val link: String) {
}

class WishlistAdapter(private val dataSet: MutableList<WishlistItem>) :
    RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val item_name_text_view: TextView
        val item_price_text_view: TextView
        val item_link_text_view: TextView

        init {
            // Define click listener for the ViewHolder's View
            item_name_text_view = view.findViewById(R.id.item_name_text_view)
            item_price_text_view = view.findViewById(R.id.item_price_text_view)
            item_link_text_view = view.findViewById(R.id.item_link_text_view)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.wishlist_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val wishlist_item = dataSet[position]

        viewHolder.item_name_text_view.text = wishlist_item.name
        viewHolder.item_price_text_view.text = wishlist_item.price
        viewHolder.item_link_text_view.text = wishlist_item.link
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}