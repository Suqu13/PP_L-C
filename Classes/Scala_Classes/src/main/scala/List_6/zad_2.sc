def swap[A](array: Array[A])(l: Int)(r: Int): Unit = {
  val iElem = array(l)
  array(l) = array(r)
  array(r) = iElem
}

def partition[A](order: A => A => Boolean)(array: Array[A])(l: Int)(r: Int): (Int, Int) = {
  var i = l
  var j = r
  val pivot = array((l + r) / 2)
  while (i <= j) {
    while (order(array(i))(pivot)) i += 1
    while (order(pivot)(array(j))) j -= 1
    if (i <= j) {
      swap(array)(i)(j)
      i += 1
      j -= 1
    }
  }
  (i, j)
}

def quick[A](order: A => A => Boolean)(array: Array[A])(l: Int)(r: Int): Unit = {
  if (l < r) {
    val (i, j) = partition(order)(array)(l)(r)
    if (j-l < r - i) {
      quick(order)(array)(l)(j)
      quick(order)(array)(i)(r)
    } else {
      quick(order)(array)(i)(r)
      quick(order)(array)(l)(j)
    }
  }
}

def quicksort[A](order: A => A => Boolean)(array: Array[A]): Unit = quick(order)(array)(0)(array.length - 1)

val t1 = Array(4,8,1,12,7,3,1,9)
quicksort((x: Int) => (y:Int) => x < y)(t1)
t1

val t2 = Array("kobyla","ma","maly","bok")
quicksort((x: String) => (y:String) => x.length < y.length)(t2)
t2
