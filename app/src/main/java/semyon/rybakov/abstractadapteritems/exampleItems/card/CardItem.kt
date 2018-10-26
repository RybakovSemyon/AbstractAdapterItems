package semyon.rybakov.abstractadapteritems.exampleItems.card

import android.view.View
import semyon.rybakov.abstractadapteritems.R
import semyon.rybakov.abstractadapteritems.adapter.BaseData
import semyon.rybakov.abstractadapteritems.adapter.BaseItem
import semyon.rybakov.abstractadapteritems.adapter.BaseType
import semyon.rybakov.abstractadapteritems.adapter.BaseViewHolder

class CardItem(val imageResId: Int, val cardName: String) : BaseItem(BaseType.CARD) {

    override fun isContentTheSame(other: BaseItem): Boolean {
        if (javaClass != other.javaClass) return false
        other as CardItem
        return imageResId == other.imageResId && cardName == other.cardName
    }

    override fun getLayoutId(): Int {
        return R.layout.item_card
    }

    override fun createViewHolder(view: View, data: BaseData?): BaseViewHolder {
        return CardViewHolder(view)
    }

}