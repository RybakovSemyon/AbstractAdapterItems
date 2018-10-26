package semyon.rybakov.abstractadapteritems.exampleItems.card

import semyon.rybakov.abstractadapteritems.adapter.BaseEvent
import semyon.rybakov.abstractadapteritems.adapter.BaseType

abstract class CardEvent : BaseEvent(BaseType.CARD) {
    abstract fun clickOnCard(cardName: String?)
}