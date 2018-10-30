def findOdd(list: List[Int]) : Int = {
  list match {
    case Nil => -1
    case (hd::Nil) => hd
    case (hd::tl) => hd^findOdd(tl)
  }
}



findOdd(List(1,5,6,7,9,1,9,5,7,6,7))


