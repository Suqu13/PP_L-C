def insertionSort[A](order: A => A => Boolean) : List[A] => List[A] =( list: List[A]) => { // generic type, in argument we have function
                                                                           // which returns boolean and will find if head is higher
  def insert(elem: A, accList: List[A]): List[A] =                         // accList is the place where we put elem in the right order
    accList match {
      case Nil => elem :: Nil
      case hd :: tl => if (order(elem)(hd)) elem :: accList else hd :: insert(elem, tl) // here we know that elem is smaller than head
                                                                                        // so we have to forward it to the next fun
                                                                                        // and then we are working on the list with smaller head
    }

  list.foldLeft(List[A]())((acc: List[A], x: A) => insert(x, acc))         // here we are forwarding element from the source list
                                                                           // from left to right
}

val list = List(4, 4, 7, 21, 0)

insertionSort((x: Int) => (y: Int) => x <= y)(list);