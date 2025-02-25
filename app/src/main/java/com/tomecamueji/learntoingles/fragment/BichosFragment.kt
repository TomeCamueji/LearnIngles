package com.tomecamueji.learntoingles.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tomecamueji.learntoingles.MainItem
import com.tomecamueji.learntoingles.R

class BichosFragment: Fragment() {

    private lateinit var rvMain: RecyclerView
    private var mediaPlayer = MediaPlayer()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bichos,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val mainItens = mutableListOf<MainItem>()
        mainItens.add(MainItem(id = 1, drawebleId = R.drawable.cao, rawRes = R.raw.dog))
        mainItens.add(MainItem(id = 2, drawebleId = R.drawable.leao, rawRes = R.raw.lion))
        mainItens.add(MainItem(id = 3, drawebleId = R.drawable.gato, rawRes = R.raw.cat))
        mainItens.add(MainItem(id = 4, drawebleId = R.drawable.macaco, rawRes = R.raw.monkey))
        mainItens.add(MainItem(id = 5, drawebleId = R.drawable.ovelha, rawRes = R.raw.sheep))
        mainItens.add(MainItem(id = 6, drawebleId = R.drawable.vaca, rawRes = R.raw.cow))
        mainItens.add(MainItem(id = 7, drawebleId = R.drawable.result_banteng, rawRes = R.raw.dog))
        mainItens.add(MainItem(id = 8, drawebleId = R.drawable.result_kelinci, rawRes = R.raw.dog))
        mainItens.add(MainItem(id = 9, drawebleId = R.drawable.rato, rawRes = R.raw.dog))

        val adapter = MainAdapter(mainItens){ soundRes ->
            playSound(soundRes)
        }
        rvMain = view.findViewById(R.id.rv_main)
        rvMain.adapter = adapter
        rvMain.layoutManager = GridLayoutManager(requireContext(),2)
       // rvMain.addItemDecoration(SpaceItemDecoration(8))


    }

    private fun playSound(soundRes: Int){
        mediaPlayer.release() // Libera o player anterior antes de criar um novo
        mediaPlayer = MediaPlayer.create(requireContext(),soundRes)
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release() // Libera o recurso ao sair do fragmento
    }

    class  MainAdapter(
        private val mainItem: List<MainItem>,
        private val onItemClick: (Int) -> Unit
    ):RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bichos,parent,false)
            return MainViewHolder(view)
        }

        override fun getItemCount(): Int = mainItem.size


        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val item = mainItem[position]
            holder.bind(item, onItemClick)
        }

        inner class  MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            fun bind(item:MainItem, onItemClick: (Int) -> Unit){
                val imgAnimol: ImageView = itemView.findViewById(R.id.img_animol)
                imgAnimol.setImageResource(item.drawebleId)

                imgAnimol.setOnClickListener {
                    onItemClick(item.rawRes) // Chama a função de clique com o som correspondente
                }
            }

        }
    }
}