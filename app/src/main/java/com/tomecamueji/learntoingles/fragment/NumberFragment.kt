package com.tomecamueji.learntoingles.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tomecamueji.learntoingles.MainItem
import com.tomecamueji.learntoingles.R

class NumberFragment:Fragment() {
    private lateinit var rvNum: RecyclerView
    private lateinit var imgNum: ImageView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_number,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val numItens = mutableListOf<MainItem>()



       val adapter = NumAdapter()
        rvNum = view.findViewById(R.id.rv_main)
        rvNum.adapter = adapter
        rvNum.layoutManager = LinearLayoutManager(requireContext())
    }

    class NumAdapter: RecyclerView.Adapter<NumAdapter.NumViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_number,parent,false)
            return NumViewHolder(view)
        }

        override fun getItemCount(): Int {
            return 20
        }

        override fun onBindViewHolder(holder: NumViewHolder, position: Int) {

        }

        class NumViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        }
    }
}