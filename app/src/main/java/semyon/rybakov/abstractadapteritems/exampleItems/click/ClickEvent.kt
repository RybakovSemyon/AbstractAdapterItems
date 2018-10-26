package semyon.rybakov.abstractadapteritems.exampleItems.click

import semyon.rybakov.abstractadapteritems.adapter.BaseEvent
import semyon.rybakov.abstractadapteritems.adapter.BaseType

abstract class ClickEvent : BaseEvent(BaseType.CLICK) {
    abstract fun onClick()
}