package com.example.yukin.ankochan

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.LinearLayout
import myLikeTweetView
import org.jetbrains.anko.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity(),AnkoLogger {

    val ui: MainActivityUI by lazy {
        MainActivityUI().apply {
            setContentView(this@MainActivity)
        }
    }

    fun subscribe(ui: AnkoContext<MainActivity>, text: String) {
        ui.doAsync {
            Thread.sleep(500)
            activityUiThreadWithContext {
if (checkCredentials(text)) debug("login success")
else error("login error")
            }
        }
    }

    private fun checkCredentials(name:String) = Pattern.compile(MATCH_ALPHABET).matcher(name).matches();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
        alert {
            customView {
                editText {
                    hint = "こうなったら逃げられまい"
                }
            }
            yesButton {}
            noButton {}
        }.show()
    }

    companion object {
        val MATCH_ALPHABET = "^[a-zA-Z]+$"
    }
}

class MainActivityUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        linearLayout {
            orientation = LinearLayout.VERTICAL

            val name = editText().lparams(width = matchParent, height = wrapContent)
            button(R.string.subscribe) {
                onClick {
                    ui.owner.subscribe(ui,name.text.toString())
                }
                gravity = Gravity.RIGHT
            }.lparams(width = wrapContent, height = wrapContent)
            myLikeTweetView()
        }
    }
}
