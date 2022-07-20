enum class SortAs {

    //@formatter:off
    TRIVIAL                     { override val doSort = ::trivial }, //this:: …
    BUBBLE_WITH_VALUE_SWAP      { override val doSort = ::bubbleWithValueSwap   },
    BUBBLE_WITH_ELEMENT_SWAP    { override val doSort = ::bubbleWithElementSwap },
    QUICKSORT_WITH_MIDDLE_PIVOT { override val doSort = ::quicksortWithMiddlePivot },
    QUICKSORT_WITH_RANDOM_PIVOT { override val doSort = ::quicksortWithRandomPivot };
    //@formatter:on

    abstract val doSort: (MutableList<Int>) -> List<Int>
}
