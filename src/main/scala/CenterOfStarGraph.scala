@main def CenterOfStarGraph(): Unit =
  println("Hello, CenterOfStarGraph!")
  println(findCenter(Array((1, 2), (2, 3), (4, 2))))
  println(findCenter(Array((1, 2), (5, 1), (1, 3), (1, 4))))
  println(findCenter(Array((1, 2), (2, 3), (3, 4), (4, 5), (1, 5))))

def findCenter(edges: Array[(Int, Int)]): Int =
  val first = edges.head
  val it = edges
    .foldLeft(Set(first._1, first._2)) { (accumulator, current) =>
      accumulator.intersect(Set(current._1, current._2))
    }
  it.headOption.getOrElse(-1)
