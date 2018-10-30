def filterIfContains[A](value: A, list: List[List[A]]): List[List[A]] = {
  list match {
    case (Nil) => Nil
    case (hd :: tl) => if (hd.contains(value)) {
      hd :: filterIfContains(value, tl)
    } else {
      filterIfContains(value, tl)
    }
  }
}


filterIfContains(2, List(List(1, 2, 3), List(9, 0), List(2, 5, 6)))
filterIfContains("Ala", List(List("Ala", "bez", "Kota"), List("Ala", "Karbowiak"), List("Piotrek", "też", "próbuje")))



def ifExist[A](value: A, list: List[A]): Boolean = {
  list match {
    case (Nil) => false
    case (hd :: tl) => if (hd == value) true else ifExist(value, tl)
  }
}

def filterIfContains_[A](value: A, list: List[List[A]]): List[List[A]] = {
  if (list == Nil) {
    Nil
  } else if (ifExist(value, list.head)) {
    list.head :: filterIfContains_(value, list.tail)
  } else {
    filterIfContains_(value, list.tail)
  }
}

filterIfContains_(2, List(List(1, 2, 3), List(9, 0), List(2, 5, 6)))
filterIfContains_("Ala", List(List("Piotrek", "też", "próbuje"), List("Ala", "bez", "Kota"), List("Ala", "Karbowiak")))
