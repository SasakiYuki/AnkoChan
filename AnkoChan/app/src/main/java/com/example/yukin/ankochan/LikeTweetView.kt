import android.content.Context
import android.content.Intent
import android.view.*
import android.widget.*
import org.jetbrains.anko.*
import android.util.AttributeSet
import org.jetbrains.anko.custom.ankoView

class LikeTweetView : LinearLayout {
    private lateinit var image: ImageView

    private fun init() = AnkoContext.createDelegate(this).apply {
        orientation = LinearLayout.HORIZONTAL

        image = imageView(imageResource = android.R.drawable.ic_menu_report_image) {
            layoutParams = LinearLayout.LayoutParams(dip(80), dip(80))
        }

        linearLayout {
            layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
            orientation = LinearLayout.VERTICAL
            padding = dip(10)

            linearLayout {
                orientation = LinearLayout.HORIZONTAL

                textView(text = "佐々木") {
                }.lparams(width = wrapContent, height = wrapContent) {
                    rightMargin = dip(6)
                }
                textView(text = "@Sasaki_Yuki") {
                    textColor = android.R.color.darker_gray
                }.lparams(width = wrapContent, height = wrapContent)
                imageView {
                    setImageResource(android.R.drawable.ic_lock_lock)
                    visibility = View.VISIBLE
                }.lparams(width = dip(15), height = dip(15)) {
                    gravity = Gravity.CENTER
                }
            }.lparams(width = matchParent, height = wrapContent)
            textView(text = "今日も頑張って仕事をしよう。週末はおいしいものでも食べたいなぁ。") {
                padding = dip(4)
            }.lparams(width = matchParent, height = wrapContent)
        }

    }

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

}

@Suppress("NOTHING_TO_INLINE")
inline fun ViewManager.myLikeTweetView(theme: Int = 0) = myLikeTweetView({}, theme)

inline fun ViewManager.myLikeTweetView(init: LikeTweetView.() -> Unit, theme: Int = 0) = ankoView(::LikeTweetView, theme, init)

