import SortAs.*
import SortAs.Companion.listPrint

fun main(args: Array<String>) {
    //todo: args check

    val size: Int = args[0].toInt()
    val maxNumberElement = args[1].toInt()

    println("Preparing list to sort with with $size integer numbers...")
    println("Range of random numbers in the list: From 0 to $maxNumberElement ")


    val theList = MutableList(size) { (0 .. maxNumberElement).random() }

    theList.listPrint()

    println("Sorted...")
    TRIVIAL.doSort(theList).listPrint()
    println("Sorted...")
    BUBBLE_WITH_VALUE_SWAP.doSort(theList).listPrint()
    println("Sorted...")
    BUBBLE_WITH_ELEMENT_SWAP.doSort(theList).listPrint()

}