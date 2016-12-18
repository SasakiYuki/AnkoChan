package com.example.yukin.ankochan

import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import org.jetbrains.anko.*
class MainActivityUI : AnkoComponent<MainActivity>{
    override fun createView(ui: AnkoContext<MainActivity>): View = ui.run {
        linearLayout {
            orientation = LinearLayout.VERTICAL

            editText().lparams(width = matchParent, height = wrapContent)
            button {
                gravity = Gravity.RIGHT
            }.lparams(width = wrapContent, height = wrapContent)
        }
    }
}