import java.util.*

// Program arguments by IDE: Run ->  Edit Configurations -> file: SortListArgs
fun main(args: Array<String>) {
    //todo: args check

    val size: Int = args[0].toInt()
    val maxNumberOfElement = args[1].toInt()

    println("Preparing list to sort with with $size integer numbers...")
    println("Range of random numbers in the list: From 0 to $maxNumberOfElement ")

    // making random unsorted list:
    val theList = MutableList(size) { (0..maxNumberOfElement).random() }

    //println("$theList")

    SortAs.values().forEach {
        print("\nSorting method: ${it.name.enumDescription()}.\n")
        //println("${it.doSort(theList)}")
        val begin = System.nanoTime()
        it.doSort(theList)
        val end = System.nanoTime()
        println("Elapsed time in ms.: ${(end-begin)/1000000f}")
    }

}