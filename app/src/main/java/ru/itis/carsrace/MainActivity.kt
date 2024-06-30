package ru.itis.carsrace

import android.os.Bundle
import android.view.View.OnTouchListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.core.widget.doOnTextChanged
import com.google.android.flexbox.FlexboxLayout
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private var inputCarsCount: EditText? = null
    private var btn: Button? = null
    private var carsContainer: FlexboxLayout? = null
    private var colors: IntArray? = null
    private var carsArray: MutableList<Car> = mutableListOf()
    private var firstOpImage: ImageView? = null
    private var secondOpImage: ImageView? = null
    private var firstOpInfo: TextView? = null
    private var secondOpInfo: TextView? = null
    private var firstOpRoad: SeekBar? = null
    private var secondOpRoad: SeekBar? = null
    private var winnerTextView: TextView? = null
    private var nextRaceBtn: Button? = null
    private var circleTextView: TextView? = null
    private var cycle: Int = 1
    private var currentPos: Int = 0
    private var currentRace: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initMainComponents()
        // Выключаем возможность редактикрование seekbar
        firstOpRoad?.setOnTouchListener(OnTouchListener { v, event -> true })
        secondOpRoad?.setOnTouchListener(OnTouchListener { v, event -> true })
        inputCarsCount?.doOnTextChanged { text, start, before, count ->
            val intValue: Int = if (text?.length != 0) text.toString().toInt() else -1
            if (intValue in 1..10 && nextRaceBtn?.isEnabled() == false) {
                btn?.setEnabled(true)
            } else {
                btn?.setEnabled(false)
            }
        }
        btn?.setOnClickListener {
            val carsCount = inputCarsCount?.text.toString().toInt()
            var carColors = colors?.clone()
            carColors?.shuffle()
            carColors = carColors?.take(carsCount)?.toIntArray()
            carsContainer?.removeAllViews()
            carsArray.clear()
            for (i in 0..carsCount - 1) {
                val car: Car = createCar(carColors?.let {resources.getColor(it[i]) }, i)
                carsArray.add(car)
                val carImage = ImageView(this)
                carImage.setImageResource(car.icon)
                carImage.setColorFilter(car.color)
                carImage.tag = "carImage" + i
                carsArray.shuffle()
                carsContainer?.addView(carImage)
            }
            cycle = 1
            currentPos = 0
            currentRace = 1
            nextRaceBtn?.setEnabled(true)
            btn?.setEnabled(false)
            nextRaceBtn?.performClick()
        }
        nextRaceBtn?.setOnClickListener {
            circleTextView?.setText("Круг: $cycle, гонка: $currentRace")
            if (currentPos + 1 < carsArray.size) {
                var winner = startRace(carsArray[currentPos], carsArray[currentPos + 1])
                when (winner) {
                    1 -> {
                        for (carImage in carsContainer?.children!!) {
                            if (carImage.tag.equals("carImage" + carsArray[currentPos + 1].id)) {
                                carsContainer?.removeView(carImage)
                                break
                            }
                        }
                        carsArray.removeAt(currentPos + 1)
                    }
                    2 -> {
                        for (carImage in carsContainer?.children!!) {
                            if (carImage.tag.equals("carImage" + carsArray[currentPos].id)) {
                                carsContainer?.removeView(carImage)
                                break
                            }
                        }
                        carsArray.removeAt(currentPos)
                    }
                }
                winnerTextView?.setText("Победитель: ${carsArray[currentPos]}")
            } else if (currentPos + 1 == carsArray.size) {
                startRace(carsArray[currentPos], Car())
                winnerTextView?.setText("Победитель: ${carsArray[currentPos]} (Нет соперника!)")
            }

            currentPos++
            currentRace++
            if (currentPos >= carsArray.size) {
                currentPos = 0
                cycle++
                carsArray.shuffle()
            }
            if (carsArray.size == 1) {
                winnerTextView?.text = "Абсолютный " + winnerTextView?.text
                val intValue: Int? = if (inputCarsCount?.text?.length != 0) inputCarsCount?.text?.toString()?.toInt() else -1
                if (intValue in 1..10) {
                    btn?.setEnabled(true)
                }
                nextRaceBtn?.setEnabled(false)
            }
        }
    }

    private fun initMainComponents() {
        this.inputCarsCount = findViewById(R.id.input_cars_count)
        this.btn = findViewById(R.id.start_race_btn)
        this.carsContainer = findViewById(R.id.cars_container)
        this.colors = R.color::class.java.fields.map { it.getInt(null) }.toIntArray()
        this.firstOpImage = findViewById(R.id.first_op_image)
        this.secondOpImage = findViewById(R.id.second_op_image)
        this.firstOpInfo = findViewById(R.id.first_op_info)
        this.secondOpInfo = findViewById(R.id.second_op_info)
        this.firstOpRoad = findViewById(R.id.seekBar1)
        this.secondOpRoad = findViewById(R.id.seekBar2)
        this.winnerTextView = findViewById(R.id.winnerTextView)
        this.nextRaceBtn = findViewById(R.id.nextRace)
        this.circleTextView = findViewById(R.id.circle)
    }

    private fun createCar(color: Int?, id: Int): Car {
        val types = arrayOf("Cabriolet", "Crossover", "Sedan", "OffRoadCar")
        val brandTypes = arrayOf("Chevrolet", "Ford", "Jeep")
        val modelTypes = arrayOf("Camaro", "Focus", "Jeep", "Mondeo")
        return AutoBuilder(types.random()).setId(id)
            .setBrand(brandTypes.random())
            .setModel(modelTypes.random())
            .setColor(color)
            .setYear((1990..2024).random())
            .setEnginePower((80..200).random())
            .setWheelSize((10..18).random())
            .setHaveAbs(Random.nextBoolean())
            .setDrive(Crossover.Drives.values().random())
            .setRemovableRoof(Random.nextBoolean()).build()
    }

    fun startRace(car1: Car, car2: Car): Int {
        var firstThumb = ImageView(this)
        firstThumb.setImageResource(car1.icon)
        firstThumb.setColorFilter(car1.color)
        firstOpRoad?.thumb = firstThumb.drawable

        var secondThumb = ImageView(this)
        secondThumb.setImageResource(car2.icon)
        secondThumb.setColorFilter(car2.color)
        secondOpRoad?.thumb = secondThumb.drawable

        firstOpImage?.setImageResource(car1.icon)
        firstOpImage?.setColorFilter(car1.color)


        secondOpImage?.setColorFilter(car2.color)
        secondOpImage?.setImageResource(car2.icon)

        firstOpImage?.layoutParams?.height = 180
        firstOpImage?.layoutParams?.width = 180

        secondOpImage?.layoutParams?.height = 180
        secondOpImage?.layoutParams?.width = 180

        firstOpInfo?.setText(car1.toString())
        secondOpInfo?.setText(car2.toString())
        var winner: Int
        if (car1.enginePower >= car2.enginePower) {
            firstOpRoad?.progress = 100
            secondOpRoad?.progress = ((car2.enginePower.toDouble() / car1.enginePower) * 100)
                .toInt()
            winner = 1
        } else {
            secondOpRoad?.progress = 100
            firstOpRoad?.progress = ((car1.enginePower.toDouble() / car2.enginePower) * 100)
                .toInt()
            winner = 2
        }
        return winner
    }

}