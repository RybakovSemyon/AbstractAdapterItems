package semyon.rybakov.abstractadapteritems.adapter

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import semyon.rybakov.abstractadapteritems.ext.replaceWith
import java.util.*

class BaseAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    private var items = ArrayList<BaseItem>()

    private val events = SparseArray<BaseEvent>()

    private val data = SparseArray<BaseData>()

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

    fun setEvent(event: BaseEvent) {
        events.put(event.type, event)
    }

    fun setData(data: BaseData) {
        this.data.put(data.type, data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val item = items.find { it.type == viewType }
        val data = this.data.get(viewType, null)
        if (item == null) {
            throw IllegalArgumentException("Can't find id for $viewType")
        } else {
            return item.getViewHolder(inflater, parent, data)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = Unit

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int, payloads: MutableList<Any>) {
        val changeData = MutableList(payloads.size) { index -> payloads[index] as HashMap<String, Any> }
        val item = items[position]
        val event = events.get(item.type, null)
        holder.bind(items[position], changeData, event)
    }

}