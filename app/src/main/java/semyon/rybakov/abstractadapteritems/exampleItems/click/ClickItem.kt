package semyon.rybakov.abstractadapteritems.exampleItems.click

import android.view.View
import semyon.rybakov.abstractadapteritems.R
import semyon.rybakov.abstractadapteritems.adapter.BaseData
import semyon.rybakov.abstractadapteritems.adapter.BaseItem
import semyon.rybakov.abstractadapteritems.adapter.BaseType
import semyon.rybakov.abstractadapteritems.adapter.BaseViewHolder

class ClickItem(val color: Int) : BaseItem(BaseType.CLICK) {

    override fun getLayoutId(): Int {
        return R.layout.item_click
    }

    override fun createViewHolder(view: View, data: BaseData?): BaseViewHolder {
        return ClickViewHolder(view, data as? ClickData)
    }

}