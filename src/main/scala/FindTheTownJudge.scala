import scala.util.boundary
@main def FindTheTownJudge(): Unit =
  println("Hello, FindTheTownJudge!")
  println(findTrust(2, Array(Array(1, 2))))
  println(findTrust(3, Array(Array(1, 3), Array(2, 3))))
  println(findTrust(3, Array(Array(1, 3), Array(2, 3), Array(3, 1))))

type Trust = Array[Array[Int]]

def findTrust(n: Int, trust: Trust): Int =
  val trustCount = Array.fill(n + 1)(0)
  for Array(a, b) <- trust do
    trustCount(a) -= 1
    trustCount(b) += 1

  boundary:
    for i <- 1 to n do {
      if trustCount(i) == n - 1 then boundary.break(i)
    }
    -1
