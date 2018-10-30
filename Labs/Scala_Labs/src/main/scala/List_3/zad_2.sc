def binaryToDecimal(list: List[Int]): Double = {
  list match {
    case (Nil) => 0
    case (hd :: tl) => hd * Math.pow(2, list.length - 1) + binaryToDecimal(tl)
  }
}

binaryToDecimal(List(1, 1, 1, 1));
binaryToDecimal(List(0, 1, 1, 1));
binaryToDecimal(List(1, 0, 1, 1, 1));
binaryToDecimal(List(1, 1));