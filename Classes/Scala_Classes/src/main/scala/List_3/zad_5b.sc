def mergeSort[A](order: A => A => Boolean) : List[A] => List[A] = (xs: List[A])=> {
  if (xs.length / 2 == 0) {
    xs
  } else {
    def merge[A](order: A => A => Boolean)(left_xs: List[A])(right_xs: List[A]): List[A] = {
      (left_xs, right_xs) match {
        case (left_xs, Nil) => left_xs
        case (Nil, right_xs) => right_xs
        case (leftHead :: leftTail, rightHead :: rightTail) => if (order(leftHead)(rightHead))  rightHead :: merge(order)(left_xs)(rightTail) else
          leftHead :: merge(order)(leftTail)(right_xs)
      }
    }
    val (left, right) = xs.splitAt(xs.length / 2)
    merge(order)(mergeSort(order)(right))(mergeSort(order)(left))
  }
}

mergeSort((a: Int) => (b: Int) => a >= b)(List(33,12,34,56,0,-1))