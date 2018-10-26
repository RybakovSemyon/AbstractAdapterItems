package semyon.rybakov.abstractadapteritems.exampleItems.user

import android.view.View
import semyon.rybakov.abstractadapteritems.R
import semyon.rybakov.abstractadapteritems.adapter.BaseData
import semyon.rybakov.abstractadapteritems.adapter.BaseItem
import semyon.rybakov.abstractadapteritems.adapter.BaseType
import semyon.rybakov.abstractadapteritems.adapter.BaseViewHolder

class UserItem : BaseItem(BaseType.USER) {
    override fun getLayoutId(): Int {
        return R.layout.item_user
    }

    override fun createViewHolder(view: View, data: BaseData?): BaseViewHolder {
        return UserViewHolder(view)
    }


}