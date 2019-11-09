package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager
    private val fragmentTransaction = fragmentManager.beginTransaction()

    var remainingTime: Int  = 300
    var minutes: Int = 0
    var seconds: Int = 0
    var handler: Handler = Handler()
    var runnable: Runnable = Runnable {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        actionBar?.title = "Choose Menu"
        supportActionBar?.title = "Choose Menu"
        startTimer()

        val menuFragment = MenuFragment()
        fragmentTransaction.add(R.id.menu_fragment, menuFragment)
        fragmentTransaction.commit()
    }

    fun startTimer() {
        remainingTime = 300

        runnable = object: Runnable {
            override fun run() {

                timer.text = "05:00"
                remainingTime--

                minutes = remainingTime / 60
                seconds = remainingTime % 60

                timer.text = String.format("%02d:%02d", minutes, seconds)

                handler.postDelayed(this, 1000)
            }
        }
        handler.post(runnable)
    }
}
