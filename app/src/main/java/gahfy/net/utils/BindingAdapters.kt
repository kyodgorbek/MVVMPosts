package gahfy.net.utils

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView

class BindAdapters {
    companion object {
        @BindingAdapter("mutableText")
        @JvmStatic
        fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
            val parentActivity: AppCompatActivity? = view.getParentActivity()
            if (parentActivity != null && text != null) {
                text.observe(parentActivity, Observer { value -> view.text = value ?: "" })
            }
        }

        @BindingAdapter("mutableVisibility")
        @JvmStatic
        fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
            val parentActivity: AppCompatActivity? = view.getParentActivity()
            if (parentActivity != null && visibility != null) {
                visibility.observe(
                        parentActivity,
                        Observer { value -> view.visibility = value ?: View.VISIBLE })
            }
        }

        @BindingAdapter("adapter")
        @JvmStatic
        fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
            view.adapter = adapter
        }
    }
}