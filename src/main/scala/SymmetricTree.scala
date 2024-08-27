case class TreeNode(
    value: Int,
    left: Option[TreeNode] = None,
    right: Option[TreeNode] = None
)

@main def SymmetricTree(): Unit =
  println("Hello, SymmetricTree!")
  val tree = TreeNode(
    1,
    Some(TreeNode(2, Some(TreeNode(3)), Some(TreeNode(4)))),
    Some(TreeNode(2, Some(TreeNode(4)), Some(TreeNode(3))))
  )
  println(isMirror(Some(tree)))

def breadthFirstSearch(node: TreeNode): List[Int] =
  val queue = collection.mutable.Queue[TreeNode]()
  val result = collection.mutable.ListBuffer[Int]()
  queue.enqueue(node)
  while queue.nonEmpty do
    val current = queue.dequeue()
    result += current.value
    current.left.foreach(queue.enqueue(_))
    current.right.foreach(queue.enqueue(_))
  result.toList

def isMirror(root: Option[TreeNode]): Boolean =
  def isMirror(left: Option[TreeNode], right: Option[TreeNode]): Boolean =
    (left, right) match
      case (None, None) => true
      case (Some(l), Some(r)) if l.value == r.value =>
        isMirror(l.left, r.right) && isMirror(l.right, r.left)
      case _ => false
  isMirror(root, root)
