@main def PalindromeNumber(): Unit =
  println(isPalindrome(121))
  println(isPalindrome(-121))
  println(isPalindrome(10))
  println(isPalindrome(-101))

def isPalindrome(x: Int): Boolean = {
  if (x < 0) false
  else
    val str = x.toString
    str == str.reverse
}
