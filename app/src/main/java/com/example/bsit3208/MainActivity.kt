package com.example.bsit3208

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var clearBtn: Button
    private lateinit var operationText: EditText
    private lateinit var resultTv: TextView

    private lateinit var oneBtn: Button
    private lateinit var twoBtn: Button
    private lateinit var threeBtn: Button
    private lateinit var fourBtn: Button
    private lateinit var fiveBtn: Button
    private lateinit var sixBtn: Button
    private lateinit var sevenBtn: Button
    private lateinit var eightBtn: Button
    private lateinit var nineBtn: Button
    private lateinit var zeroBtn: Button
    private lateinit var pointBtn: Button

    private lateinit var equalBtn: Button

    private lateinit var addBtn: Button
    private lateinit var subtractBtn: Button
    private lateinit var multiplyBtn: Button
    private lateinit var divideBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        clearBtn = findViewById(R.id.clear)
        clearBtn.setOnClickListener {
            val operation = findViewById<EditText>(R.id.operation)
            clearEditText(operation as EditText)
            val resultTv = findViewById<TextView>(R.id.result)
            clearTextView(resultTv as TextView)
        }

        val oneBtn = findViewById<Button>(R.id.one)
        oneBtn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.operation)
            editText.append("1")
        }

        val twoBtn = findViewById<Button>(R.id.two)
        twoBtn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.operation)
            editText.append("2")
        }

        val threeBtn = findViewById<Button>(R.id.three)
        threeBtn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.operation)
            editText.append("3")
        }

        val fourBtn = findViewById<Button>(R.id.four)
        fourBtn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.operation)
            editText.append("4")
        }

        val fiveBtn = findViewById<Button>(R.id.five)
        fiveBtn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.operation)
            editText.append("5")
        }

        val sixBtn = findViewById<Button>(R.id.six)
        sixBtn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.operation)
            editText.append("6")
        }

        val sevenBtn = findViewById<Button>(R.id.seven)
        sevenBtn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.operation)
            editText.append("7")
        }

        val eightBtn = findViewById<Button>(R.id.eight)
        eightBtn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.operation)
            editText.append("8")
        }

        val nineBtn = findViewById<Button>(R.id.nine)
        nineBtn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.operation)
            editText.append("9")
        }

        val zeroBtn = findViewById<Button>(R.id.zero)
        zeroBtn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.operation)
            editText.append("0")
        }

        val pointBtn = findViewById<Button>(R.id.point)
        pointBtn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.operation)
            editText.append(".")
        }

        operationText = findViewById(R.id.operation)
        resultTv = findViewById(R.id.result)
        val equalBtn = findViewById<Button>(R.id.equal)
        equalBtn.setOnClickListener {
            val expression = operationText.text.toString()
            val result = evaluateExpression(expression)
            resultTv.setText(result.toString())
        }

        addBtn = findViewById(R.id.add)
        subtractBtn = findViewById(R.id.subtract)
        multiplyBtn = findViewById(R.id.multiply)
        divideBtn = findViewById(R.id.divide)

        addBtn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.operation)
            editText.append("+")
        }

        subtractBtn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.operation)
            editText.append("-")
        }

        multiplyBtn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.operation)
            editText.append("*")
        }

        divideBtn.setOnClickListener {
            val editText = findViewById<EditText>(R.id.operation)
            editText.append("/")
        }
    }

    fun clearTextView(textView: TextView) {
        textView.text = "";
    }

    fun clearEditText(editText: EditText) {
        editText.text.clear()
    }

    fun evaluateExpression(expression: String): Double {
        return try {
            val exp = ExpressionBuilder(expression).build()
            exp.evaluate()
        } catch (e: Exception) {
            Double.NaN
        }
    }
}