import scala.collection.mutable.Queue
import scala.util.boundary
@main def MinimumDepthTree(): Unit =
  println("Hello, MinimumDepthTree!")
  val tree = TreeNode(
    3,
    Some(TreeNode(9)),
    Some(TreeNode(20, Some(TreeNode(15)), Some(TreeNode(7))))
  )
  println(findDepth(tree))

  val tree2 = TreeNode(
    2,
    None,
    Some(
      TreeNode(
        3,
        None,
        Some(TreeNode(4, None, Some(TreeNode(5, None, Some(TreeNode(6))))))
      )
    )
  )
  println(findDepth(tree2))
  val tree3 = TreeNode(1)
  println(findDepth(tree3))

def findDepth(root: TreeNode): Int =
  val q = Queue(root)
  var depth = 0
  boundary:
    while q.size > 0 do
      val node = q.dequeue()
      depth += 1
      node.left.foreach(q.enqueue)
      node.right.foreach(q.enqueue)

      if node.left.isEmpty && node.right.isEmpty then boundary.break(depth)

    depth
