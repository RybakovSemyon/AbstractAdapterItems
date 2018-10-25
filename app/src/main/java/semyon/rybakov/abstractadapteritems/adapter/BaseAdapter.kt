package semyon.rybakov.abstractadapteritems.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BaseAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    private var items = ArrayList<BaseItem>()

    private val events = HashMap<Int, BaseEvents>()

    fun getItemsAdapter() = items

    fun uploadItems(itemsNew: ArrayList<BaseItem>) {
        val diffResult = DiffUtil.calculateDiff(BaseDiffUtil(items, itemsNew))
        diffResult.dispatchUpdatesTo(this)
        items.replaceWith(itemsNew)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return items[position].type
    }

    fun setEvent(event: BaseEvents) {
        if (events.containsKey(event.type)) {
            events.remove(event.type)
        }
        events[event.type] = event
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val item = items.find { it.type == viewType }
        if (item == null) {
            throw IllegalArgumentException("Can't find id for $viewType")
        } else {
            return item.getViewHolder(inflater, parent)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = Unit

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int, payloads: MutableList<Any>) {
        val changeData = MutableList(payloads.size) { index -> payloads[index] as HashMap<String, Any> }
        val item = items[position]
        val events = events[item.type]
        holder.bind(items[position], changeData, events)
    }

}