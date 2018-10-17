def separate(list: List[Int]): (List[Int], List[Int], List[Int]) = {
  def separate_(list_ : List[Int], result: (List[Int], List[Int], List[Int])): (List[Int], List[Int], List[Int]) = {
    if (list_.isEmpty) {
      (result._1.reverse, result._2.reverse, result._3.reverse)
    } else if (list_.head % 2 == 0) {
      separate_(list_.tail, (list_.head :: result._1, result._2, result._3))
    } else {
      if (list_.head < 0) {
        separate_(list_.tail, (result._1, result._2, list_.head :: result._3))
      } else {
        separate_(list_.tail, (result._1, list_.head :: result._2, result._3))
      }
    }
  }
  separate_(list,(List[Int](), List[Int](), List[Int]()))
}

separate((List(-52,-51,-3,-2,-1,0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))