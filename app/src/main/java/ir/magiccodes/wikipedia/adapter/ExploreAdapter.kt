package ir.magiccodes.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.magiccodes.wikipedia.data.ItemPost
import ir.magiccodes.wikipedia.databinding.ItemExploreBinding
import java.util.ArrayList

class ExploreAdapter(private val data: ArrayList<ItemPost> , val itemEvents: ItemEvents) : RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {
    lateinit var binding: ItemExploreBinding

    inner class ExploreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(itemPost: ItemPost){

            Glide.with(itemView)
                .load(itemPost.imgUrl)
                .into(binding.imgExploreMain)

            binding.txtExploreTitle.text = itemPost.txtTitle
            binding.txtExploreSubtitle.text = itemPost.txtSubtitle
            binding.txtExploreDetail.text = itemPost.txtDetail

            itemView.setOnClickListener {
                itemEvents.onItemClicked(itemPost)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        binding = ItemExploreBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ExploreViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bindView(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}