package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    private lateinit var resulttext: EditText

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
        val buttonpercent = findViewById<Button>(R.id.buttonpercent)
        val buttonclear = findViewById<Button>(R.id.clear)
        val buttondot = findViewById<Button>(R.id.butondot)
        val buttonequal = findViewById<Button>(R.id.buttonequal)
        val buttonadd = findViewById<Button>(R.id.buttonadd)
        val buttonsub = findViewById<Button>(R.id.buttonminus)
        val buttonmul = findViewById<Button>(R.id.buttonmultiply)
        val buttondivide = findViewById<Button>(R.id.buttondivide)
        val buttonbackspace = findViewById<Button>(R.id.buttonbackspace)
        resulttext = findViewById(R.id.result)

        val inputtex = findViewById<EditText>(R.id.inputnumber)
        inputtex.movementMethod = android.text.method.ScrollingMovementMethod()
        inputtex.setActivated(true)
        inputtex.setPressed(true)

        var text: String

        button1.setOnClickListener {
            text = inputtex.text.toString() + "1"
            inputtex.setText(text)
            result(text)
        }
        button2.setOnClickListener {
            text = inputtex.text.toString() + "2"
            inputtex.setText(text)
            result(text)
        }
        button3.setOnClickListener {
            text = inputtex.text.toString() + "3"
            inputtex.setText(text)
            result(text)
        }
        button4.setOnClickListener {
            text = inputtex.text.toString() + "4"
            inputtex.setText(text)
            result(text)
        }
        button5.setOnClickListener {
            text = inputtex.text.toString() + "5"
            inputtex.setText(text)
            result(text)
        }
        button6.setOnClickListener {
            text = inputtex.text.toString() + "6"
            inputtex.setText(text)
            result(text)
        }
        button7.setOnClickListener {
            text = inputtex.text.toString() + "7"
            inputtex.setText(text)
            result(text)
        }
        button8.setOnClickListener {
            text = inputtex.text.toString() + "8"
            inputtex.setText(text)
            result(text)
        }
        button9.setOnClickListener {
            text = inputtex.text.toString() + "9"
            inputtex.setText(text)
            result(text)
        }
        button0.setOnClickListener {
            text = inputtex.text.toString() + "0"
            inputtex.setText(text)
            result(text)
        }
        button00.setOnClickListener {
            text = inputtex.text.toString() + "00"
            inputtex.setText(text)
            result(text)
        }
        buttondot.setOnClickListener {
            text = inputtex.text.toString() + "."
            inputtex.setText(text)
            result(text)
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
        buttonpercent.setOnClickListener {
            text = inputtex.text.toString() + "%"
            inputtex.setText(text)
            check += 1
        }
        buttonequal.setOnClickListener {
            text = resulttext.text.toString()
            inputtex.setText(text)
            resulttext.setText(null)
        }
        buttonclear.setOnClickListener {
            inputtex.setText(null)
            resulttext.setText(null)
        }
        buttonbackspace.setOnClickListener {
            var backspace: String? = null
            if (inputtex.text.length > 0) {
                val stringbuilder: StringBuilder = StringBuilder(inputtex.text)
                val find = inputtex.text.toString()
                val find2 = find.last()

                if (find2.equals('+') || find2.equals('-') || find2.equals('*') || find2.equals('/') || find2.equals(
                        '%'
                    )
                ) {
                    check -= 1
                }
                stringbuilder.deleteCharAt(inputtex.text.length - 1)
                backspace = stringbuilder.toString()
                inputtex.setText(backspace)
                result(backspace)
            }
        }
    }


    private fun result(text: String) {

        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any = engine.eval(text)
            var mainresult = result.toString()

            if (check == 0) resulttext.setText(null)
            else{
                resulttext.setText(mainresult)
            }
        } catch (e: ScriptException) {
            if (check == 0) {
                Log.d("TAG","ERROR" )
            }
        }
    }
}


