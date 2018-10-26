package semyon.rybakov.abstractadapteritems.exampleItems.click

import android.view.View
import android.widget.FrameLayout
import semyon.rybakov.abstractadapteritems.R
import semyon.rybakov.abstractadapteritems.adapter.BaseEvent
import semyon.rybakov.abstractadapteritems.adapter.BaseItem
import semyon.rybakov.abstractadapteritems.adapter.BaseViewHolder

class ClickViewHolder(view: View, data: ClickData?) : BaseViewHolder(view) {

    private val container = view.findViewById<FrameLayout>(R.id.container)

    init {
        data?.let {
            container.layoutParams.height = it.height
        }
    }

    override fun bind(item: BaseItem, payload: MutableList<HashMap<String, Any>>, event: BaseEvent?) {
        container.setBackgroundColor((item as ClickItem).color)
        itemView.setOnClickListener {
            (event as? ClickEvent)?.onClick()
        }
    }

}