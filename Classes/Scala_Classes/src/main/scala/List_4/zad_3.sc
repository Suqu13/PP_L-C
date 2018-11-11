sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem: A, left: BT[A], right: BT[A]) extends BT[A]

val tt = Node(1,
  Node(2,
    Node(4,
      Empty,
      Empty
    ),
    Empty
  ),
  Node(3,
    Node(5,
      Empty,
      Node(6,
        Empty,
        Empty
      )
    ),
    Empty
  )
)

def breadthBT[A](bt: BT[A]):List[A] = {
  def inside[A](list: List[BT[A]]): List[A] = {
    list match {
      case Nil => Nil
      case Empty :: tl => inside(tl)
      case Node(v, lt, rt) :: tl => v :: inside(tl ++ (lt :: rt :: Nil))
    }
  }
  inside(bt :: Nil)
}

breadthBT(tt)
