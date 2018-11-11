sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem:A, left:BT[A], right:BT[A]) extends BT[A]

val tt = Node(1, Node(2, Node(4, Empty, Empty), Empty), Node(3, Node(5, Empty, Node(6, Empty, Empty)), Empty))

def internalPathLength[A](root: BT[A]): Int = {
  def inside(node: BT[A])(n: Int) : Int = {
    node match {
      case Empty => 0
      case Node (v, lt, rt) => n + inside(lt)(n+1) + inside(rt)(n+1)
    }
  }
  inside(root)(0);
}

internalPathLength(tt);

def externalPathLength[A](root: BT[A]): Int = {
  def inside(node: BT[A])(n: Int) : Int = {
    node match {
      case Empty => n
      case Node (v, lt, rt) => inside(lt)(n+1) + inside(rt)(n+1)
    }
  }
  inside(root)(0);
}

externalPathLength(tt);