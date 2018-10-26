package semyon.rybakov.abstractadapteritems.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: BaseItem, payload: MutableList<HashMap<String, Any>>, event: BaseEvent?)
}