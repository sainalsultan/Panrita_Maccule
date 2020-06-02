package co.id.panritamaccule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_pertanyaan.*

class PertanyaanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertanyaan)

        edittext_masukan.setOnTouchListener (object : View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                if (edittext_masukan.hasFocus()){
                    v!!.parent.requestDisallowInterceptTouchEvent(true)
                    when(event!!.action){
                        MotionEvent.ACTION_SCROLL->{
                            v.parent.requestDisallowInterceptTouchEvent(false)
                            return true
                        }
                    }
                }
             return false
            }
        })
    }
}
