package com.example.yukin.ankochan

import android.app.ListActivity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import org.jetbrains.anko.*
import java.util.*

class MSListActivity : ListActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val items = listOf(
                "地球連邦軍" to listOf("ジム", "ガンキャノン", "陸戦型ガンダム"),
                "ジオン公国軍" to listOf("ザク", "ギャン", "イフリート改"))

        val list = ArrayList<TextListItem>()
        list.addAll(items.flatMap {
            listOf(SectionHeaderItem(it.first)) + it.second.map(::LitItem)
        })

        listAdapter = MSListAdapter(this, list)
    }
}

internal class MSListAdapter(context: Context, items: List<ListItem>) : AnkoListAdapter(context, items) {
    override val listItems = listOf(SectionHeaderItem::class.java, LitItem::class.java)
}

internal class LitItem(text: String = "") : TextListItem(text)

internal class SectionHeaderItem(text: String = "") : TextListItem(text) {
    override fun createView(ui: AnkoContext<AnkoListAdapter>) = createTextView(ui) {
        gravity = Gravity.CENTER_VERTICAL
        padding = dip(10)
        textColor = Color.BLUE
        backgroundColor = Color.GRAY
        textSize = 17f
    }
}
