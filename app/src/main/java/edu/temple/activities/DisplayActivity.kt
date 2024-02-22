package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class DisplayActivity : AppCompatActivity() {

    // Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value

    // Step 3: Use returned value for lyricsDisplayTextView text size

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        textSizeSelectorButton.setOnClickListener{
            val launchIntent = Intent(this@DisplayActivity, TextSizeActivity::class.java)
            //startActivityForResult(launchIntent, 1) //deprecated
            launcher.launch(launchIntent)
        }

    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode== RESULT_OK){
            it.data?.apply {
                val size = getIntExtra("SIZE", 22)
                lyricsDisplayTextView.textSize = size.toFloat()
            }
        }
    }

    //deprecated
    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1){
            if(resultCode== RESULT_OK){
                val size = data!!.getIntExtra("SIZE", 22)
                lyricsDisplayTextView.textSize=size!!.toFloat()
            }
        }
    }*/
}