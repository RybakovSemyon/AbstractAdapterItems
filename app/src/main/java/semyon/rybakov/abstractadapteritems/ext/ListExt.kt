package semyon.rybakov.abstractadapteritems.ext

fun <E> ArrayList<E>.replaceWith(items: List<E>) {
    clear()
    addAll(items)
}