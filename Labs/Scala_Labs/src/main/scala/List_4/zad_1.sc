import scala.Numeric.Implicits._
sealed trait BT[+Int]
case object Empty extends BT[Nothing]
case class Node[+Int](elem: Int, left: BT[Int], right: BT[Int]) extends BT[Int]

val tt = Node(8,
  Node(3,
    Node(1,
      Empty,
      Empty
    ),
    Node(6,
      Node(4,
        Empty,
        Empty
      ),
      Node(7,
        Empty,
        Empty
      )
    )
  ),
  Node(10,
    Node(14,
      Node(13,
        Empty,
        Empty
      ),
      Empty
    ),
    Empty
  )
)

def contains(bt: BT[Int],value: Int) : Boolean = {
  bt match {
    case Empty => false
    case Node(v, t1, t2) => if (v == value) true else
      contains(t1, value) || contains(t2, value);
  }
}

contains(tt, 6)
contains(tt, -1)

def sum(bt: BT[Int]) : Int = {
  bt match {
    case Empty => 0
    case Node(v, t1, t2) => v + sum(t1) + sum(t2)
  }
}

sum(tt)

def product(bt: BT[Int]) : Int = {
  bt match {
    case Empty => 1
    case Node(v, t1, t2) => v * product(t1) * product(t2)
  }
}

product(tt)

