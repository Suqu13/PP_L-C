def greaterThan(n: Int, numbers: List[Int]): List[Int] = {
  if (numbers == Nil) Nil
  else if (numbers.head > n)
    numbers.head :: greaterThan(n, numbers.tail)
  else
    greaterThan(n, numbers.tail)
}



greaterThan(13, Nil) //expected - List()
greaterThan(-4, List(-15, -3, 0, 1, 14)) //expected - List(-3, 0, 1, 14)
