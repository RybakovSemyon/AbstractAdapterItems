package semyon.rybakov.abstractadapteritems.exampleItems.card

import android.view.View
import android.widget.ImageView
import semyon.rybakov.abstractadapteritems.R
import semyon.rybakov.abstractadapteritems.adapter.BaseEvent
import semyon.rybakov.abstractadapteritems.adapter.BaseItem
import semyon.rybakov.abstractadapteritems.adapter.BaseViewHolder

class CardViewHolder(view: View) : BaseViewHolder(view) {

    private val cardImage: ImageView = view.findViewById(R.id.image)

    override fun bind(item: BaseItem, payload: MutableList<HashMap<String, Any>>, event: BaseEvent?) {
        val cardItem = item as? CardItem
        val cardEvent = event as? CardEvent
        cardImage.setImageResource(cardItem?.imageResId ?: 0)
        itemView.setOnClickListener {
            cardEvent?.clickOnCard(cardItem?.cardName)
        }
    }

}