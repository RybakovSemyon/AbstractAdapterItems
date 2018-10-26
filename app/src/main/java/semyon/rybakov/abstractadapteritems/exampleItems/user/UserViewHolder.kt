package semyon.rybakov.abstractadapteritems.exampleItems.user

import android.view.View
import semyon.rybakov.abstractadapteritems.adapter.BaseEvent
import semyon.rybakov.abstractadapteritems.adapter.BaseItem
import semyon.rybakov.abstractadapteritems.adapter.BaseViewHolder

class UserViewHolder(view: View) : BaseViewHolder(view) {
    override fun bind(item: BaseItem, payload: MutableList<HashMap<String, Any>>, event: BaseEvent?) {
        itemView.setOnClickListener {
            (event as? UserEvent)?.getUserInfo(item as UserItem, itemView)
        }
    }
}