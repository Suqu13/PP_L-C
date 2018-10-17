def merge[A](list1: List[A], list2:List[A]) : List[A]= {
  if (list1.isEmpty) list2
  else list1.head::merge(list2, list1.tail)
}

merge(List(1,3,5,7,9,11), List(2,4,6,8))
merge(List('a', 'a','a'), List('b','b','b','b','b'))
merge(List('b','b','b','b','b'), List('a', 'a','a'))
merge(Nil, Nil)