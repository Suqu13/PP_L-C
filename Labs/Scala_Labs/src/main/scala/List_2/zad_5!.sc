import scala.annotation.tailrec

def findMin(list: List[Int]): Int = {
  @tailrec
  def findRec(min: Int, ls: List[Int]): Int = {
    ls match {
      case (Nil) => min;
      case (hd :: tl) => if (hd < min) findRec(hd, tl) else findRec(min, tl)
    }
  }

  findRec(Int.MaxValue, list)
}
findMin(List(-20, -9, 2, -21, 0, 100))

def replace(value1: Int, value2: Int, list: List[Int]): List[Int] = {
  if (list.head == value1) {
    value2 :: list.tail
  } else {
    list.head :: replace(value1, value2, list.tail)
  }
}

replace(-21, 1, List(-20, -9, 2, -21, 0, 100))

def findTenMax(list: List[Int]): List[Int] = {
  @tailrec
  def Helper(orgList: List[Int], maxList: List[Int]): List[Int] = {
    if (orgList == Nil) {
      maxList
    } else {
      if (maxList.length < 10) {
        Helper(orgList.tail, orgList.head :: maxList)
      } else {
        if (orgList.head  > findMin(maxList)) {
          Helper(orgList.tail, replace(findMin(maxList), orgList.head, maxList))
        } else {
          Helper(orgList.tail, maxList)
        }
      }
    }
  }
  Helper(list, Nil)
}

findTenMax(List(1,2,3,4,10,12,15,16,3,4,9,0,11,12,60,80,90,1001, -10, 2,3,4,81,34))
