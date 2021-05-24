package io.github.vnicius.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.github.vnicius.recyclerviewexample.databinding.ActivityMainBinding
import io.github.vnicius.recyclerviewexample.shape.CircleShape
import io.github.vnicius.recyclerviewexample.shape.Shape
import io.github.vnicius.recyclerviewexample.shape.SquareShape

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    private val shapes : List<Shape> = listOf(
        CircleShape(),
        SquareShape(),
        CircleShape(),
        SquareShape(),
        CircleShape(),
        SquareShape(),
        CircleShape(),
        SquareShape(),
        CircleShape(),
        SquareShape(),
        CircleShape(),
        SquareShape(),
        CircleShape(),
        SquareShape(),
        CircleShape(),
        SquareShape(),
        CircleShape(),
        SquareShape(),
        CircleShape(),
        SquareShape()
    )

    private val circles = listOf<CircleShape>(
        CircleShape(),
        CircleShape(),
        CircleShape(),
        CircleShape(),
        CircleShape(),
        CircleShape(),
        CircleShape(),
        CircleShape(),
        CircleShape(),
        CircleShape(),
        CircleShape(),
        CircleShape(),
        CircleShape()
    )

    private val squares = listOf<SquareShape>(
        SquareShape(),
        SquareShape(),
        SquareShape(),
        SquareShape(),
        SquareShape(),
        SquareShape(),
        SquareShape(),
        SquareShape(),
        SquareShape(),
        SquareShape(),
        SquareShape()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // Single ViewHolder example

        viewBinding.recylerView.adapter = CircleAdapter { position ->
            Toast.makeText(this, position.toString(), Toast.LENGTH_SHORT).show()
        }

        (viewBinding.recylerView.adapter as? CircleAdapter)?.submitList(circles)

        // Multiple ViwHolder example

//        viewBinding.recylerView.adapter = ShapeAdapter()
//
//        (viewBinding.recylerView.adapter as? ShapeAdapter)?.submitList(shapes)

        // Async List Differ example

//        viewBinding.recylerView.adapter = SquareAdapter()
//
//        (viewBinding.recylerView.adapter as? SquareAdapter)?.submitList(squares)
    }
}