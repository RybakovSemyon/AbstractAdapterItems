package semyon.rybakov.abstractadapteritems.exampleItems.user

import android.view.View
import semyon.rybakov.abstractadapteritems.adapter.BaseEvent
import semyon.rybakov.abstractadapteritems.adapter.BaseType

abstract class UserEvent : BaseEvent(BaseType.USER) {
    abstract fun getUserInfo(
        userItem: UserItem,
        itemView: View
    )
}