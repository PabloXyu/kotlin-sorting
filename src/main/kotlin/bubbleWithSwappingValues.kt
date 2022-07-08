fun  MutableList<Int>.bubbleWithValueSwap(): Unit  = with(this) {

    var isStillUnsorted = false

    forEachIndexed { index, value ->
        val nextIndex = index.inc()
        val nextValue = getOrNull(nextIndex)    // when there's no next element,
        val diff = nextValue?.minus(value) ?: 0 // behave like ther's no value difference

        if (diff < 0) { //swap values in the pair
            set(nextIndex, value)
            set(index, nextValue!!)
            isStillUnsorted = true
        }
    }

    if (isStillUnsorted) bubbleWithValueSwap()
}
