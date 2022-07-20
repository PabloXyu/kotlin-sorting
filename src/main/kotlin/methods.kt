import java.util.*

fun trivial(list: MutableList<Int>) = list.sortedBy { it }.toMutableList()
fun bubbleWithValueSwap(list: MutableList<Int>): MutableList<Int> = with(list) {

    var isStillUnsorted = false

    forEachIndexed { Int, value ->
        val nextInt = Int.inc()
        val nextValue = getOrNull(nextInt)    // when there's no next element,
        val diff = nextValue?.minus(value) ?: 0 // behave like there's no value difference

        if (diff < 0) { //swap values in the pair
            set(nextInt, value)
            set(Int, nextValue!!)
            isStillUnsorted = true
        }
    }
    if (isStillUnsorted) bubbleWithValueSwap(list)
    return@with list
}

fun bubbleWithElementSwap(list: MutableList<Int>): MutableList<Int> = with(list) {

    var isStillUnsorted = false

    forEachIndexed { Int, value ->
        val nextInt = Int.inc()
        val nextValue = getOrNull(nextInt)    // when there's no next element,
        val diff = nextValue?.minus(value) ?: 0 // behave like there's no value difference

        //swap elements in the pair
        if (diff < 0) {
            println("indices: $Int, $nextInt")
            Collections.swap(this, Int, nextValue!!)
            isStillUnsorted = true
        }
    }
    if (isStillUnsorted) bubbleWithElementSwap(list)
    return@with list
}

fun quicksortWithMiddlePivot(list: MutableList<Int>): List<Int> {
    return quicksort(list) { it / 2 }
}

fun quicksortWithRandomPivot(list: MutableList<Int>): List<Int> {
    return quicksort(list) { (0 until it).random() }
}

private fun quicksort(list: MutableList<Int>, offset: Int = 0, initPivotIndex: (Int) -> Int): List<Int> {
    if (list.size == 0) return emptyList()
    // "inserted" pivot is a selected list element between outer lists: left & right
    // to group their items by lower and greater/equal values comparing to pivot value
    // after grouping the pivot changes its position and becomes a sorted element
    val pivot = with(initPivotIndex(list.size)) { Pivot(this, list[this]) } //relative index

/*
    with(pivot) {print("pivot change: ${list.subList(0, index)} |" +  //old
                "[$index]=$value| ${list.subList(index+1, list.size)} ==> "
    )}
*/

    // list without pivot
    val pivotExcludedList = list.filterIndexed { Int, _ -> Int != pivot.index }

    // pivot divides list into left and right
    val (leftList, rightList) = pivotExcludedList.partition { it < pivot.value }

    // after list split, the pivot gets new relative index
    // this is also a size of the left list
    pivot.index = (leftList).size
    val offsetWithPivot = offset.inc()
    // offset for the right list
    val rightListOffset = offsetWithPivot + (if (leftList.isEmpty()) 0 else pivot.index)

/*
    print("$leftList |[${pivot.index}]=${pivot.value}| $rightList")//new
    println(" index: [${pivot.index + offset}]")
*/

    //@formatter:off
    return with(initPivotIndex) {
        quicksort(leftList as MutableList<Int>, offset) { this(it) } +
        pivot.value +
        quicksort(rightList as MutableList<Int> , rightListOffset) { this(it) }
    }
    //@formatter:on
}

private data class Pivot(var index: Int, val value: Int)

fun String.enumDescription() = this
    .lowercase()
    .replace("_", " ")
    .replaceFirstChar { it.titlecase(Locale.getDefault()) }

