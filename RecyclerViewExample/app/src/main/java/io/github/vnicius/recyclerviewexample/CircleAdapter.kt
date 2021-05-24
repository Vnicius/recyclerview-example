package io.github.vnicius.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.vnicius.recyclerviewexample.databinding.ViewCircleShapeBinding
import io.github.vnicius.recyclerviewexample.shape.CircleShape


/**
 * Created by Vinícius Veríssimo on 24/05/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class CircleAdapter(private val onClickItem: (position: Int) -> Unit) :
    RecyclerView.Adapter<CircleAdapter.CircleViewHolder>() {

    private var circles: MutableList<CircleShape> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CircleViewHolder =
        CircleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_circle_shape, parent, false)
        ) { position ->
            onClickItem(position)
        }

    override fun onBindViewHolder(holder: CircleViewHolder, position: Int) {
        holder.bind(circles[position])
    }

    override fun getItemCount(): Int = circles.size

    fun submitList(items: List<CircleShape>) {
        circles.clear()
        circles.addAll(items)
        notifyDataSetChanged()
    }

    class CircleViewHolder(view: View, onClickItem: (position: Int) -> Unit) :
        RecyclerView.ViewHolder
            (view) {
        private val binding = ViewCircleShapeBinding.bind(view)

        init {
            view.setOnClickListener {
                onClickItem(bindingAdapterPosition)
            }
        }

        fun bind(circleShape: CircleShape) {
            binding.number.text = bindingAdapterPosition.toString()
        }
    }
}