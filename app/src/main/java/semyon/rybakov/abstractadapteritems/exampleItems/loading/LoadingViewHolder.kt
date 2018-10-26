package semyon.rybakov.abstractadapteritems.exampleItems.loading

import android.view.View
import semyon.rybakov.abstractadapteritems.adapter.BaseEvent
import semyon.rybakov.abstractadapteritems.adapter.BaseItem
import semyon.rybakov.abstractadapteritems.adapter.BaseViewHolder

class LoadingViewHolder(view: View) : BaseViewHolder(view) {
    override fun bind(item: BaseItem, payload: MutableList<HashMap<String, Any>>, event: BaseEvent?) = Unit
}