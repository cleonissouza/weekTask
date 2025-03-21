package com.example.weektask

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.weektask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //lista dias da semana
    private val daysOfWeek = arrayOf(
        "Selecione o dia","Monday", "Tuesday", "Wednesday", "Thurday",
        "Friday", "Saturday", "Sunday"
    )

    //mapa de tarefas para cada dia
    private val tasks = mapOf(
        "Monday" to "OFF",
        "Tuesday" to "Zoe, Graca, Rosily, Cleo, Kelly, Ellie",
        "Wednesday" to "Zoe, Cath, Jess, Chantal, Cleo, Kelly, Ellie",
        "Thurday" to "Zoe, Rosily, Adrian, Cleo, Kelly",
        "Friday" to "Graca, Jess, Chantal, Carol, Cleo, Kelly",
        "Saturday" to "OFF",
        "Sunday" to "OFF"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configurar Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, daysOfWeek)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerDays.adapter = adapter

        //Definir evento de selecao do Spinner
        binding.spinnerDays.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedDay = daysOfWeek[position]
                    val task = tasks[selectedDay]?: "Nenhuma Tarefa"
                    binding.tvTask.text = task
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
    }
}