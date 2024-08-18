import scala.util.boundary, boundary.break
@main def TwoSum(): Unit =
  println(getTwoSumSolution(Array(2, 7, 11, 15), 9))
  println("-----------------------------")
  println(getTwoSumSolution(Array(3, 2, 4), 6))
  println("-----------------------------")
  println(getTwoSumSolution(Array(3, 3), 6))
  println("-----------------------------")
  println(getTwoSumSolution(Array(2, 7), 10))
  println("-----------------------------")

type Result = Error | (Int, Int)

/** Given an array of integers nums and an integer target, return indices of the
  * two numbers such that they add up to target.
  *
  * You may assume that each input would have exactly one solution, and you may
  * not use the same element twice.
  *
  * You can return the answer in any order.
  *
  * Example 1:
  *
  * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because
  * nums[0] + nums[1] == 9, we return [0, 1].
  *
  * Example 2:
  *
  * Input: nums = [3,2,4], target = 6 Output: [1,2]
  *
  * Example 3:
  *
  * Input: nums = [3,3], target = 6 Output: [0,1]
  */
def getTwoSumSolution(nums: Array[Int], target: Int): Result = {
  println(s"array: [${nums.mkString(",")}] target: $target")
  val idxLookup: Map[Int, Int] = nums.zipWithIndex.toMap();
  boundary:
    for (i <- nums.indices) {
      val complement = target - nums(i);
      if (idxLookup.contains(complement) && idxLookup(complement) != i) {
        break((i, idxLookup(complement)))
      }
    }
    Error("No two sum solution")
}
