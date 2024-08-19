/** You are given an integer array height of length n. There are n vertical
  * lines drawn such that the two endpoints of the ith line are (i, 0) and (i,
  * height[i]).
  *
  * Find two lines that together with the x-axis form a container, such that the
  * container contains the most water.
  *
  * Return the maximum amount of water a container can store.
  *
  * Notice that you may not slant the container.
  */
import scala.collection.mutable

@main def WaterContainer: Unit = {
  val height = Array(1, 8, 6, 2, 5, 4, 8, 3, 7)
  println(maxArea(height));
}

def maxArea(edges: Array[Int]): Int = {

  val leftEdge = 0 to edges.length - 1
  def rightEdge = (i: Int) => (i to edges.length - 1)
  def calculateArea = (i: Int, j: Int) =>
    val height = Math.min(edges(i), edges(j))
    val width = j - i
    height * width

  leftEdge.foldLeft(0) { (accum, i) =>
    rightEdge(i).foldLeft(accum) { (accum, j) =>
      val area = calculateArea(i, j)
      if (area > accum) area else accum
    }
  }
}
