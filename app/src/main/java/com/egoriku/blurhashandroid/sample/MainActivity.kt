package com.egoriku.blurhashandroid.sample

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.egoriku.blurhashandroid.BlurHashDecoder
import com.egoriku.blurhashandroid.BlurHashEncoder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val buttonProcess = findViewById<View>(R.id.buttonProcess)
        val imageSource = findViewById<ImageView>(R.id.imageSource)
        val imageEncoded = findViewById<ImageView>(R.id.imageEncoded)
        val textHash = findViewById<TextView>(R.id.textHash)

        buttonProcess.setOnClickListener {
            val hash = BlurHashEncoder.encode(imageSource.drawable.toBitmap())

            textHash.text = hash

            val decode = BlurHashDecoder.decode(blurHash = hash, width = 20, height = 12)
            imageEncoded.setImageBitmap(decode)
        }
    }
}