package io.github.vnicius.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.vnicius.recyclerviewexample.databinding.ActivityMainBinding
import io.github.vnicius.recyclerviewexample.shape.CircleShape
import io.github.vnicius.recyclerviewexample.shape.SquareShape

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    private val shapes = listOf(
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.recylerView.adapter = ShapeAdapter()

        (viewBinding.recylerView.adapter as? ShapeAdapter)?.submitList(shapes)
    }
}