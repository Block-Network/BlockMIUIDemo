package cn.fkj233.blockmiui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import cn.fkj233.blockmiui.pages.*
import cn.fkj233.ui.activity.MIUIActivity

class MainActivity : MIUIActivity() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var activity: MIUIActivity
        private val handler by lazy { Handler(Looper.getMainLooper()) }
        fun showToast(string: String) {
            Log.d("BlockMIUI", "Show Toast: $string")
            handler.post {
                Toast.makeText(activity, string, Toast.LENGTH_LONG).show()
            }
        }
    }

    init {
        activity = this
        registerPage(MainPage::class.java)
        registerPage(MenuPage::class.java)
        registerPage(TestPage::class.java)
        registerPage(Test2Page::class.java)
        registerPage(AsyncPage::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setSP(getPreferences(0))
        super.onCreate(savedInstanceState)
    }
}