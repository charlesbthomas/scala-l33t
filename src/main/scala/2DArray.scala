@main def HourglassSum: Unit =
  val matrix = Array(
    Array(-9, -9, -9, 1, 1, 1),
    Array(0, -9, 0, 4, 3, 2),
    Array(-9, -9, -9, 1, 2, 3),
    Array(0, 0, 8, 6, 6, 0),
    Array(0, 0, 0, -2, 0, 0),
    Array(0, 0, 1, 2, 4, 0)
  )
  val max = getMaxSum(matrix)
  println(max)

type Matrix = Array[Array[Int]]

// Will traverse the matrix to get valid
// hourglass shapes.
def getMaxSum(mat: Matrix): ((Int, Int), Int) =
  val sums = for
    y <- (0 to 3)
    x <- (0 to 3)
    cords = (x, y)
  yield (cords, getHourGlassSum(mat, cords))
  sums.maxBy(_._2)

// Given a matrix and a start index, return all values
// that make up the hourglass shape.
//
// Assumes that the provided matrix coordinates have
// a valid hourglass shape
def getHourGlassSum(mat: Matrix, cords: (Int, Int)): Int =
  val (startX, startY) = cords
  val firstRow = (startX to startX + 2).map(mat(startY)(_))
  val secondRow = Array(mat(startY + 1)(startX + 1))
  val thirdRow = (startX to startX + 2).map(mat(startY + 2)(_))
  (firstRow ++ secondRow ++ thirdRow).sum()
