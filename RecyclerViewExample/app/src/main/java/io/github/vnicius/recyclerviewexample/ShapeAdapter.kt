package io.github.vnicius.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.vnicius.recyclerviewexample.databinding.ViewCircleShapeBinding
import io.github.vnicius.recyclerviewexample.databinding.ViewSquareShapeBinding
import io.github.vnicius.recyclerviewexample.shape.CircleShape
import io.github.vnicius.recyclerviewexample.shape.Shape
import io.github.vnicius.recyclerviewexample.shape.ShapeType
import io.github.vnicius.recyclerviewexample.shape.SquareShape


/**
 * Created by Vinícius Veríssimo on 19/05/21.
 * github: @vnicius
 * vinicius.matheus252@gmail.com
 */
class ShapeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val shapes: MutableList<Shape> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            ShapeType.Circle.ordinal -> CircleViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_circle_shape, parent, false)
            )
            else -> SquareViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_square_shape, parent, false)
            )
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CircleViewHolder -> (shapes[position] as? CircleShape)?.let { holder.bind(it) }
            is SquareViewHolder -> (shapes[position] as? SquareShape)?.let { holder.bind(it) }
        }
    }

    override fun getItemCount(): Int = shapes.size

    override fun getItemViewType(position: Int): Int = shapes[position].shapeType.ordinal

    fun submitList(list: List<Shape>) {
        shapes.clear()
        shapes.addAll(list)
        notifyDataSetChanged()
    }

    class CircleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val viewBinding = ViewCircleShapeBinding.bind(view)

        fun bind(circleShape: CircleShape) {
            viewBinding.number.text = bindingAdapterPosition.toString()
        }
    }

    class SquareViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val viewBinding = ViewSquareShapeBinding.bind(view)

        fun bind(squareShape: SquareShape) {
            viewBinding.number.text = bindingAdapterPosition.toString()
        }
    }
}