import java.util.*

enum class SortAs {

    //@formatter:off
    TRIVIAL                  { override val doSort = ::trivial               }, // this:: ...
    BUBBLE_WITH_VALUE_SWAP   { override val doSort = ::bubbleWithValueSwap   },
    BUBBLE_WITH_ELEMENT_SWAP { override val doSort = ::bubbleWithElementSwap }
    //@formatter:on
    ;

    abstract val doSort: (MutableList<Int>) -> MutableList<Int>

    companion object {
        fun MutableList<Int>.listPrint() = this.forEachIndexed { index, value -> println("[$index]: $value") }
        private fun trivial(list: MutableList<Int>) = list.sortedBy { it }.toMutableList()
        private fun bubbleWithValueSwap(list: MutableList<Int>): MutableList<Int> = with(list) {

            var isStillUnsorted = false

            forEachIndexed { index, value ->
                val nextIndex = index.inc()
                val nextValue = getOrNull(nextIndex)    // when there's no next element,
                val diff = nextValue?.minus(value) ?: 0 // behave like there's no value difference

                if (diff < 0) { //swap values in the pair
                    set(nextIndex, value)
                    set(index, nextValue!!)
                    isStillUnsorted = true
                }
            }
            if (isStillUnsorted) bubbleWithValueSwap(list)
            return@with list
        }
        private fun bubbleWithElementSwap(list: MutableList<Int>): MutableList<Int> = with(list) {

            var isStillUnsorted = false

            forEachIndexed { index, value ->
                val nextIndex = index.inc()
                val nextValue = getOrNull(nextIndex)    // when there's no next element,
                val diff = nextValue?.minus(value) ?: 0 // behave like there's no value difference

                //swap elements in the pair
                if (diff < 0) {
                    println("indices: $index, $nextIndex")
                    Collections.swap(this, index, nextValue!!)
                    isStillUnsorted = true
                }
            }
            if (isStillUnsorted) bubbleWithElementSwap(list)
            return@with list
        }
    }
}