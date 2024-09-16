package com.example.wordle

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var word = wordToGuess
        var guesses = 0

        findViewById<TextView>(R.id.finalword).setText(word)

        findViewById<TextView>(R.id.guess1word).setTextColor(Color.BLACK)
        findViewById<TextView>(R.id.guess1checkword).setTextColor(Color.BLACK)
        findViewById<TextView>(R.id.guess2word).setTextColor(Color.BLACK)
        findViewById<TextView>(R.id.guess2checkword).setTextColor(Color.BLACK)
        findViewById<TextView>(R.id.guess3word).setTextColor(Color.BLACK)
        findViewById<TextView>(R.id.guess3checkword).setTextColor(Color.BLACK)
        findViewById<TextView>(R.id.finalword).setTextColor(Color.BLACK)
        findViewById<TextInputEditText>(R.id.guessinput).setTextColor(Color.BLACK)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            findViewById<ImageView>(R.id.background).visibility = View.INVISIBLE

            findViewById<Button>(R.id.resetbutton).setOnClickListener({ v->
                wordToGuess = FourLetterWordList.getRandomFourLetterWord()
                word = wordToGuess
                guesses = 0
                findViewById<TextView>(R.id.guess1word).setText("")
                findViewById<TextView>(R.id.guess1checkword).setText("")
                findViewById<TextView>(R.id.guess2word).setText("")
                findViewById<TextView>(R.id.guess2checkword).setText("")
                findViewById<TextView>(R.id.guess3word).setText("")
                findViewById<TextView>(R.id.guess3checkword).setText("")
                findViewById<TextView>(R.id.finalword).setText("")
                findViewById<Button>(R.id.guessbutton).isEnabled = true
                findViewById<TextView>(R.id.guess1).setTextColor(Color.BLACK)
                findViewById<TextView>(R.id.guess1check).setTextColor(Color.BLACK)
                findViewById<TextView>(R.id.guess2).setTextColor(Color.BLACK)
                findViewById<TextView>(R.id.guess2check).setTextColor(Color.BLACK)
                findViewById<TextView>(R.id.guess3).setTextColor(Color.BLACK)
                findViewById<TextView>(R.id.guess3check).setTextColor(Color.BLACK)
                findViewById<TextView>(R.id.guess1word).setTextColor(Color.BLACK)
                findViewById<TextView>(R.id.guess1checkword).setTextColor(Color.BLACK)
                findViewById<TextView>(R.id.guess2word).setTextColor(Color.BLACK)
                findViewById<TextView>(R.id.guess2checkword).setTextColor(Color.BLACK)
                findViewById<TextView>(R.id.guess3word).setTextColor(Color.BLACK)
                findViewById<TextView>(R.id.guess3checkword).setTextColor(Color.BLACK)
                findViewById<TextView>(R.id.finalword).setTextColor(Color.BLACK)
                findViewById<TextInputEditText>(R.id.guessinput).setTextColor(Color.BLACK)
                findViewById<ImageView>(R.id.background).visibility = View.INVISIBLE
            })

            findViewById<Button>(R.id.guessbutton).setOnClickListener({ v->
                var check = checkGuess(findViewById<TextInputEditText>(R.id.guessinput).text.toString().uppercase())
                if (guesses == 0) {
                    findViewById<TextView>(R.id.guess1word).setText(findViewById<TextInputEditText>(R.id.guessinput).text.toString())
                    findViewById<TextView>(R.id.guess1checkword).setText(check)
                    if (check == "OOOO") {
                        findViewById<Button>(R.id.guessbutton).isEnabled = false
                        findViewById<TextView>(R.id.finalword).setText(word)
                        findViewById<ImageView>(R.id.background).visibility = View.VISIBLE
                        findViewById<TextView>(R.id.guess1).setTextColor(Color.WHITE)
                        findViewById<TextView>(R.id.guess1check).setTextColor(Color.WHITE)
                        findViewById<TextView>(R.id.guess2).setTextColor(Color.WHITE)
                        findViewById<TextView>(R.id.guess2check).setTextColor(Color.WHITE)
                        findViewById<TextView>(R.id.guess3).setTextColor(Color.WHITE)
                        findViewById<TextView>(R.id.guess3check).setTextColor(Color.WHITE)
                        findViewById<TextInputEditText>(R.id.guessinput).setTextColor(Color.WHITE)
                        findViewById<TextView>(R.id.guess1word).setTextColor(Color.WHITE)
                        findViewById<TextView>(R.id.guess1checkword).setTextColor(Color.WHITE)
                        findViewById<TextView>(R.id.guess2word).setTextColor(Color.WHITE)
                        findViewById<TextView>(R.id.guess2checkword).setTextColor(Color.WHITE)
                        findViewById<TextView>(R.id.guess3word).setTextColor(Color.WHITE)
                        findViewById<TextView>(R.id.guess3checkword).setTextColor(Color.WHITE)
                        findViewById<TextView>(R.id.finalword).setTextColor(Color.WHITE)
                        findViewById<TextInputEditText>(R.id.guessinput).setTextColor(Color.WHITE)
                    }
                    guesses++
                    findViewById<TextInputEditText>(R.id.guessinput).setText("")
                } else {
                    if (guesses == 1) {
                        findViewById<TextView>(R.id.guess2word).setText(findViewById<TextInputEditText>(R.id.guessinput).text.toString())
                        findViewById<TextView>(R.id.guess2checkword).setText(check)
                        if (check == "OOOO") {
                            findViewById<Button>(R.id.guessbutton).isEnabled = false
                            findViewById<TextView>(R.id.finalword).setText(word)
                            findViewById<ImageView>(R.id.background).visibility = View.VISIBLE
                            findViewById<TextView>(R.id.guess1).setTextColor(Color.WHITE)
                            findViewById<TextView>(R.id.guess1check).setTextColor(Color.WHITE)
                            findViewById<TextView>(R.id.guess2).setTextColor(Color.WHITE)
                            findViewById<TextView>(R.id.guess2check).setTextColor(Color.WHITE)
                            findViewById<TextView>(R.id.guess3).setTextColor(Color.WHITE)
                            findViewById<TextView>(R.id.guess3check).setTextColor(Color.WHITE)
                            findViewById<TextView>(R.id.guess1word).setTextColor(Color.WHITE)
                            findViewById<TextView>(R.id.guess1checkword).setTextColor(Color.WHITE)
                            findViewById<TextView>(R.id.guess2word).setTextColor(Color.WHITE)
                            findViewById<TextView>(R.id.guess2checkword).setTextColor(Color.WHITE)
                            findViewById<TextView>(R.id.guess3word).setTextColor(Color.WHITE)
                            findViewById<TextView>(R.id.guess3checkword).setTextColor(Color.WHITE)
                            findViewById<TextView>(R.id.finalword).setTextColor(Color.WHITE)
                            findViewById<TextInputEditText>(R.id.guessinput).setTextColor(Color.WHITE)
                        }
                        guesses++
                        findViewById<TextInputEditText>(R.id.guessinput).setText("")
                    } else {
                        if (guesses == 2) {
                            findViewById<TextView>(R.id.guess3word).setText(findViewById<TextInputEditText>(R.id.guessinput).text.toString())
                            findViewById<TextView>(R.id.guess3checkword).setText(check)
                            if (check == "OOOO") {
                                findViewById<Button>(R.id.guessbutton).isEnabled = false
                                findViewById<TextView>(R.id.finalword).setText(word)
                                findViewById<ImageView>(R.id.background).visibility = View.VISIBLE
                                findViewById<TextView>(R.id.guess1).setTextColor(Color.WHITE)
                                findViewById<TextView>(R.id.guess1check).setTextColor(Color.WHITE)
                                findViewById<TextView>(R.id.guess2).setTextColor(Color.WHITE)
                                findViewById<TextView>(R.id.guess2check).setTextColor(Color.WHITE)
                                findViewById<TextView>(R.id.guess3).setTextColor(Color.WHITE)
                                findViewById<TextView>(R.id.guess3check).setTextColor(Color.WHITE)
                                findViewById<TextView>(R.id.guess1word).setTextColor(Color.WHITE)
                                findViewById<TextView>(R.id.guess1checkword).setTextColor(Color.WHITE)
                                findViewById<TextView>(R.id.guess2word).setTextColor(Color.WHITE)
                                findViewById<TextView>(R.id.guess2checkword).setTextColor(Color.WHITE)
                                findViewById<TextView>(R.id.guess3word).setTextColor(Color.WHITE)
                                findViewById<TextView>(R.id.guess3checkword).setTextColor(Color.WHITE)
                                findViewById<TextView>(R.id.finalword).setTextColor(Color.WHITE)
                                findViewById<TextInputEditText>(R.id.guessinput).setTextColor(Color.WHITE)
                            }
                            guesses++
                            findViewById<TextInputEditText>(R.id.guessinput).setText("")
                            findViewById<Button>(R.id.guessbutton).isEnabled = false
                            findViewById<TextView>(R.id.finalword).setText(word)
                        }
                    }
                }
            })
            insets
        }
    }
    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    var wordToGuess = FourLetterWordList.getRandomFourLetterWord()
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}