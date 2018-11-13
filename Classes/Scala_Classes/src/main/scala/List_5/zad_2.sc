def Fib: Stream[Int] = {
  def createFib(first: Int)(second: Int): Stream[Int] = {
    (first + second) #:: createFib(second)(first + second)
  }
  0#::1#::createFib(0)(1)
}

Fib.take(10).force