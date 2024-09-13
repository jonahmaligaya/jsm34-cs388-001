package com.example.lab1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var counter = 0;
        var goals = 0;
        var next_goal = 200;
        findViewById<TextView>(R.id.counter).setText("$counter")
        findViewById<TextView>(R.id.goals_text).setText("Goals Reached: $goals")
        findViewById<TextView>(R.id.next_goal).setText("Next Goal: $counter / $next_goal")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            findViewById<ImageButton>(R.id.icon_button).visibility = View.INVISIBLE
            findViewById<Button>(R.id.tap_button).setOnClickListener({ v->
                counter++
                findViewById<TextView>(R.id.counter).setText("$counter")
                if (counter >= next_goal) {
                    next_goal = next_goal * 2;
                    goals++;
                }
                findViewById<TextView>(R.id.goals_text).setText("Goals Reached: $goals")
                findViewById<TextView>(R.id.next_goal).setText("Next Goal: $counter / $next_goal")
            })
            findViewById<ImageButton>(R.id.icon_button).setOnClickListener({ v->
                counter++
                findViewById<TextView>(R.id.counter).setText("$counter")
                if (counter >= next_goal) {
                    next_goal = next_goal * 2;
                    goals++;
                }
                findViewById<TextView>(R.id.goals_text).setText("Goals Reached: $goals")
                findViewById<TextView>(R.id.next_goal).setText("Next Goal: $counter / $next_goal")
            })

            findViewById<Button>(R.id.customize_button).setOnClickListener({ v->
                if (counter >= 100) {
                    counter = counter - 100
                    findViewById<TextView>(R.id.counter).setText("$counter")
                    findViewById<Button>(R.id.customize_button).visibility = View.INVISIBLE
                    findViewById<Button>(R.id.tap_button).visibility = View.INVISIBLE
                    findViewById<ImageButton>(R.id.icon_button).visibility = View.VISIBLE
                }
            })

            findViewById<Button>(R.id.double_taps_button).setOnClickListener({ v->
                if (counter >= 100) {
                    counter = counter - 100
                    findViewById<TextView>(R.id.counter).setText("$counter")
                    findViewById<TextView>(R.id.goals_text).setText("Goals Reached: $goals")
                    findViewById<TextView>(R.id.next_goal).setText("Next Goal: $counter / $next_goal")
                    findViewById<Button>(R.id.tap_button).setOnClickListener({ v->
                        counter = counter + 2
                        findViewById<TextView>(R.id.counter).setText("$counter")
                        if (counter >= next_goal) {
                            next_goal = next_goal * 2;
                            goals++;
                        }
                        findViewById<TextView>(R.id.goals_text).setText("Goals Reached: $goals")
                        findViewById<TextView>(R.id.next_goal).setText("Next Goal: $counter / $next_goal")
                    })
                    findViewById<ImageButton>(R.id.icon_button).setOnClickListener({ v->
                        counter = counter + 2
                        findViewById<TextView>(R.id.counter).setText("$counter")
                        if (counter >= next_goal) {
                            next_goal = next_goal * 2;
                            goals++;
                        }
                        findViewById<TextView>(R.id.goals_text).setText("Goals Reached: $goals")
                        findViewById<TextView>(R.id.next_goal).setText("Next Goal: $counter / $next_goal")
                    })
                    findViewById<Button>(R.id.double_taps_button).visibility = View.INVISIBLE
                    findViewById<Button>(R.id.tap_button).setText("ADD 2")
                }
            })

            insets
        }
    }
}