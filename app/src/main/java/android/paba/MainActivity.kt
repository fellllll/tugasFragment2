package android.paba

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.frameContainer)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mFragmentManager = supportFragmentManager
        val mfSatu = fSatu()

        mFragmentManager.findFragmentByTag(fSatu::class.java.simpleName)
        mFragmentManager
            .beginTransaction()
            .add(R.id.tvFrame, mfSatu, fSatu::class.java.simpleName)
            .commit()

        val _btn1 = findViewById<Button>(R.id.btn1)
        _btn1.setOnClickListener {
            val data = intent.getStringExtra("DATA") ?: "0"
            val amount = data.toIntOrNull()?.minus(1)

            val mfSatu = fSatu().apply {
                arguments = Bundle().apply {
                    putString("DATA", amount.toString())
                }
            }
            mFragmentManager.beginTransaction()
                .replace(R.id.tvFrame, mfSatu, fSatu::class.java.simpleName)
                .commit()
        }

        val _btn2 = findViewById<Button>(R.id.btn2)
        _btn2.setOnClickListener {
            val data = intent.getStringExtra("DATA") ?: "0"
            val amount = data.toIntOrNull()?.minus(2)

            val mfDua = fDua().apply {
                arguments = Bundle().apply {
                    putString("DATA", amount.toString())
                }
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.tvFrame, mfDua, fDua::class.java.simpleName)
                .addToBackStack(null)
                .commit()
        }

        val _btn3 = findViewById<Button>(R.id.btn3)
        _btn3.setOnClickListener {
            val data = intent.getStringExtra("DATA") ?: "0"
            val amount = data.toIntOrNull()?.minus(3)

            val mfTiga = fTiga().apply {
                arguments = Bundle().apply {
                    putString("DATA", amount.toString())
                }
            }
            mFragmentManager.beginTransaction()
                .replace(R.id.tvFrame, mfTiga, fTiga::class.java.simpleName)
                .commit()
        }

    }
}