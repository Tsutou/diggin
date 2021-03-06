package jp.co.geisha.diggin.binding

import androidx.databinding.BindingAdapter
import android.view.View

object ViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("visibleGone")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }
}