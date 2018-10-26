package semyon.rybakov.abstractadapteritems.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseItem(val type: Int) {

    open fun isTheSame(other: BaseItem): Boolean {
        return type == other.type
    }

    open fun isContentTheSame(other: BaseItem): Boolean {
        return type == other.type
    }

    open fun getPayloads(otherItem: BaseItem): Map<String, Any> {
        return HashMap()
    }

    fun getViewHolder(inflater: LayoutInflater, parent: ViewGroup, data: BaseData?): BaseViewHolder {
        val view = inflater.inflate(getLayoutId(), parent, false)
        return createViewHolder(view, data)
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun createViewHolder(
        view: View,
        data: BaseData?
    ): BaseViewHolder
}