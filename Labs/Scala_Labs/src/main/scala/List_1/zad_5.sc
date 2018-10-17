def count(n: Char, list: List[Char]): Int = {
  if (list == Nil) {
    0
  } else if (list.head == n) {
    1 + count(n, list.tail)
  } else {
    count(n, list.tail)
  }
}

def ifEven(n: Char, list: List[Char]): Boolean = {
  val x = count(n, list)
  if (((x % 2) != 0) || (list == Nil)) {
    false
  } else {
    true
  }
}

ifEven('1', '3' :: '2' :: '1' :: '1' :: '1' :: Nil)
ifEven('1', Nil)
ifEven('1', '3' ::'1':: '2' :: '1' :: '1' :: '1' :: Nil)
