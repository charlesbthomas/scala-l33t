@main def MergeSortedList(): Unit = {
  val l1 = Array(1, 2, 4)
  val l2 = Array(1, 3, 4)
  val result = mergeTwoLists(l1, l2)
  println(result)
}

def mergeTwoLists(l1: Array[Int], l2: Array[Int]): Array[Int] = {
  val merged = l1 ++ l2
  merged.sorted
}
