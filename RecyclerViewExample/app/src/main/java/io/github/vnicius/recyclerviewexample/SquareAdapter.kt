package io.github.vnicius.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.github.vnicius.recyclerviewexample.databinding.ViewSquareShapeBinding
import io.github.vnicius.recyclerviewexample.shape.SquareShape


/**
 * Created by Vinícius Veríssimo on 24/05/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class SquareAdapter: RecyclerView.Adapter<SquareAdapter.SquareViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<SquareShape>() {
        override fun areItemsTheSame(oldItem: SquareShape, newItem: SquareShape): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: SquareShape, newItem: SquareShape): Boolean =
            oldItem.shapeType == newItem.shapeType
    }
    private val differ = AsyncListDiffer<SquareShape>(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SquareViewHolder =
        SquareViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_square_shape, parent, false)
        )

    override fun onBindViewHolder(holder: SquareViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun submitList(list: List<SquareShape>) {
        differ.submitList(list)
    }

    class SquareViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val viewBinding = ViewSquareShapeBinding.bind(view)

        fun bind(squareShape: SquareShape) {
            viewBinding.number.text = bindingAdapterPosition.toString()
        }
    }
}