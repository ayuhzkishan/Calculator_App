package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import javax.script.ScriptException
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var resulttext: EditText
    private lateinit var inputtex: EditText

    var check = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button0 = findViewById<Button>(R.id.button0)
        val button00 = findViewById<Button>(R.id.button00)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val buttonpower = findViewById<Button>(R.id.buttonpower)
        val buttonclear = findViewById<Button>(R.id.clear)
        val buttondot = findViewById<Button>(R.id.butondot)
        val buttonequal = findViewById<Button>(R.id.buttonequal)
        val buttonadd = findViewById<Button>(R.id.buttonadd)
        val buttonsub = findViewById<Button>(R.id.buttonminus)
        val buttonmul = findViewById<Button>(R.id.buttonmultiply)
        val buttondivide = findViewById<Button>(R.id.buttondivide)
        val buttonbackspace = findViewById<Button>(R.id.buttonbackspace)

        resulttext = findViewById(R.id.result)
        inputtex = findViewById(R.id.inputnumber)

        inputtex.movementMethod = android.text.method.ScrollingMovementMethod()
        inputtex.setActivated(true)
        inputtex.setPressed(true)

        var text: String

        button1.setOnClickListener {
            text = inputtex.text.toString() + "1"
            inputtex.setText(text)
        }
        button2.setOnClickListener {
            text = inputtex.text.toString() + "2"
            inputtex.setText(text)
        }
        button3.setOnClickListener {
            text = inputtex.text.toString() + "3"
            inputtex.setText(text)
        }
        button4.setOnClickListener {
            text = inputtex.text.toString() + "4"
            inputtex.setText(text)
        }
        button5.setOnClickListener {
            text = inputtex.text.toString() + "5"
            inputtex.setText(text)
        }
        button6.setOnClickListener {
            text = inputtex.text.toString() + "6"
            inputtex.setText(text)
        }
        button7.setOnClickListener {
            text = inputtex.text.toString() + "7"
            inputtex.setText(text)
        }
        button8.setOnClickListener {
            text = inputtex.text.toString() + "8"
            inputtex.setText(text)
        }
        button9.setOnClickListener {
            text = inputtex.text.toString() + "9"
            inputtex.setText(text)
        }
        button0.setOnClickListener {
            text = inputtex.text.toString() + "0"
            inputtex.setText(text)
        }
        button00.setOnClickListener {
            text = inputtex.text.toString() + "00"
            inputtex.setText(text)
        }
        buttondot.setOnClickListener {
            text = inputtex.text.toString() + "."
            inputtex.setText(text)
        }
        buttonadd.setOnClickListener {
            text = inputtex.text.toString() + "+"
            inputtex.setText(text)
            check += 1
        }
        buttonsub.setOnClickListener {
            text = inputtex.text.toString() + "-"
            inputtex.setText(text)
            check += 1
        }
        buttonmul.setOnClickListener {
            text = inputtex.text.toString() + "*"
            inputtex.setText(text)
            check += 1
        }
        buttondivide.setOnClickListener {
            text = inputtex.text.toString() + "/"
            inputtex.setText(text)
            check += 1
        }
        buttonpower.setOnClickListener {
            text = inputtex.text.toString() + "^"
            inputtex.setText(text)
            check += 1
        }
        buttonequal.setOnClickListener {
            val inputText = inputtex.text.toString()
            try {
                val expression = ExpressionBuilder(inputText).build()
                val result = expression.evaluate()
                resulttext.setText(result.toString())
            } catch (e: Exception) {
                resulttext.setText("Error")
            }
        }
        buttonclear.setOnClickListener {
            inputtex.setText(null)
            resulttext.setText(null)
        }
        buttonbackspace.setOnClickListener {
            val currentText = inputtex.text.toString()
            if (currentText.isNotEmpty()) {
                val newText = currentText.substring(0, currentText.length - 1)
                inputtex.setText(newText)
            }
        }
    }
}


