sealed trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem: A, left: () => lBT[A], right: () => lBT[A]) extends lBT[A]

def createlBT(n: Int): lBT[Int] = {
  LNode(n, () => createlBT(2 * n), () => createlBT(2 * n + 1))
}

def breadthlBT(root: lBT[Int]): Stream[Int] = {
  def breadth(queue: List[lBT[Int]]): Stream[Int] = {
    queue match {
      case (Nil) => Stream.Empty
      case (LEmpty :: tl) => breadth(tl)
      case (LNode(v, llt, lrt) :: tl) => v #:: breadth(tl++List(llt(),lrt()))
    }
  }
  breadth(root::Nil)
}

breadthlBT(createlBT(1)).take(10).force