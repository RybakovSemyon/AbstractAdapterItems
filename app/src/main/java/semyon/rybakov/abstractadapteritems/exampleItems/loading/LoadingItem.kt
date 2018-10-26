package semyon.rybakov.abstractadapteritems.exampleItems.loading

import android.view.View
import semyon.rybakov.abstractadapteritems.R
import semyon.rybakov.abstractadapteritems.adapter.BaseData
import semyon.rybakov.abstractadapteritems.adapter.BaseItem
import semyon.rybakov.abstractadapteritems.adapter.BaseType
import semyon.rybakov.abstractadapteritems.adapter.BaseViewHolder

class LoadingItem : BaseItem(BaseType.LOADING) {

    override fun getLayoutId(): Int {
        return R.layout.item_loading
    }

    override fun createViewHolder(view: View, data: BaseData?): BaseViewHolder {
        return LoadingViewHolder(view)
    }

}