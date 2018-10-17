def initSegemnt(l1: List[Int], l2: List[Int]): Boolean = {
  (l1, l2) match {
    case (Nil, _) => true
    case (_, Nil) => false
    case (hl1 :: tl1, hl2 :: tl2) => if(hl1 == hl2) initSegemnt(tl1, tl2) else false
  }
}

initSegemnt(List.empty, List(1,2,3,4))
initSegemnt(List(1,2,3,4), List.empty)
initSegemnt(List(1,4,2), List(1,4,2,5,6,7,10))