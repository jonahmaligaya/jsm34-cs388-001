package com.example.BitFitPart2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch


class WaterListFragment : Fragment() {
    private val water = mutableListOf<WaterEntity>()
    private lateinit var waterRecyclerView: RecyclerView
    private lateinit var waterAdapter: WaterAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.water_fragment_list, container, false)
        val layoutManager = LinearLayoutManager(context)
        waterRecyclerView = view.findViewById(R.id.water_recycler_view)
        waterRecyclerView.setHasFixedSize(true)
        waterAdapter = WaterAdapter(view.context, water)

        lifecycleScope.launch {
            (activity?.application as BitFitApp).db.waterDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    WaterEntity(entity.waterAmount, entity.waterNotes)
                }.also { mappedList ->
                    water.clear()
                    water.addAll(mappedList)
                    waterAdapter.notifyDataSetChanged()

                }
            }
        }

        waterRecyclerView.adapter = waterAdapter

        layoutManager.also {
            val dividerItemDecoration = DividerItemDecoration(context, it.orientation)
            waterRecyclerView.addItemDecoration(dividerItemDecoration)
        }
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(): WaterListFragment{
            return WaterListFragment()
        }
    }
}