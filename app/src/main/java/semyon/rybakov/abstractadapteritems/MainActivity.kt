package semyon.rybakov.abstractadapteritems

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import semyon.rybakov.abstractadapteritems.adapter.BaseAdapter
import semyon.rybakov.abstractadapteritems.adapter.BaseItem
import semyon.rybakov.abstractadapteritems.exampleItems.card.CardEvent
import semyon.rybakov.abstractadapteritems.exampleItems.card.CardItem
import semyon.rybakov.abstractadapteritems.exampleItems.click.ClickData
import semyon.rybakov.abstractadapteritems.exampleItems.click.ClickEvent
import semyon.rybakov.abstractadapteritems.exampleItems.click.ClickItem
import semyon.rybakov.abstractadapteritems.exampleItems.loading.LoadingItem
import semyon.rybakov.abstractadapteritems.exampleItems.user.UserEvent
import semyon.rybakov.abstractadapteritems.exampleItems.user.UserItem
import java.util.*
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private val adapter = BaseAdapter()
    private lateinit var list: RecyclerView
    private var snackBar: Snackbar? = null

    private val clickEvent = object : ClickEvent() {
        override fun onClick() {
            Toast.makeText(applicationContext, "CLICK", Toast.LENGTH_SHORT).show()
        }

    }

    private val userEvent = object : UserEvent() {
        override fun getUserInfo(
            userItem: UserItem,
            itemView: View
        ) {
            getThis().startActivity(Intent(getThis(), UserInfoActivity::class.java))
        }

    }

    private val cardEvent = object : CardEvent() {
        override fun clickOnCard(cardName: String?) {
            snackBar = Snackbar.make(list, cardName ?: "", Snackbar.LENGTH_SHORT)
                .setAction("OK", snackBarClickListener)
            snackBar?.show()
        }
    }

    private val snackBarClickListener = object : View.OnClickListener {
        override fun onClick(p0: View?) {
            snackBar?.dismiss()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById(R.id.list)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter
        adapter.setData(generateClickData())
        adapter.setEvent(clickEvent)
        adapter.setEvent(userEvent)
        adapter.setEvent(cardEvent)
        adapter.uploadItems(generateItems())
    }

    private fun generateClickData(): ClickData {
        return ClickData(Random().nextInt(200) + 200)
    }

    private fun generateItems(): ArrayList<BaseItem> {
        val items = ArrayList<BaseItem>()
        items.add(LoadingItem())
        items.add(ClickItem(Color.BLUE))
        items.add(ClickItem(Color.GREEN))
        items.add(ClickItem(Color.MAGENTA))
        items.add(ClickItem(Color.RED))
        items.add(ClickItem(Color.CYAN))
        items.add(UserItem())
        items.add(UserItem())
        items.add(UserItem())
        items.add(CardItem(R.drawable.card_a, "Туз"))
        items.add(CardItem(R.drawable.card_k, "Король"))
        items.add(CardItem(R.drawable.card_q, "Дама"))
        items.add(CardItem(R.drawable.card_j, "Валет"))
        items.add(LoadingItem())
        return items
    }

    private fun getThis(): MainActivity {
        return this
    }
}
