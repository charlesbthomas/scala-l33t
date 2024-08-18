/** Write a function to find the longest common prefix string amongst an array
  * of strings.
  *
  * If there is no common prefix, return an empty string "".
  *
  * Example 1:
  *
  * Input: strs = ["flower","flow","flight"] Output: "fl"
  *
  * Example 2:
  *
  * Input: strs = ["dog","racecar","car"] Output: "" Explanation: There is no
  * common prefix among the input strings.
  *
  * Constraints:
  *
  * 1 <= strs.length <= 200 0 <= strs[i].length <= 200 strs[i] consists of only
  * lowercase English letters.
  */
import scala.util.boundary

@main def LongestCommonPrefix: Unit = {
  println(find(Array("flower", "flow", "flight")))
  println(find(Array("dog", "racecar", "car")))
}

case class State(prefix: String, idx: Int)
val DefaultState = State("", 0)

def find(strings: Array[String]): String = {
  val sorted = strings.sortBy(_.length)
  boundary:
    strings(0)
      .foldLeft(DefaultState) { (accum, b) =>
        if (strings.forall(it => it(accum.idx) == b))
          State(accum.prefix + b, accum.idx + 1)
        else
          boundary.break(accum.prefix)
      }
      .prefix
}
