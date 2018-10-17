def replaceNth[A](index: Int, value: A, list: List[A]): List[A] = {
  (index, list) match {
    case (0, hd :: tl) => value :: tl
    case (_, hd :: tl) => hd::replaceNth(index - 1, value, tl)
    case (_, Nil) => Nil
  }
}

replaceNth(2, 'A', List('B', 'C', 'D','E'))
replaceNth(0, 'A', List('B', 'C', 'D','E'))
replaceNth(3, 'A', List('B', 'C', 'D','E'))