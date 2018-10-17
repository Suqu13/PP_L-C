def fibonacci(n: Int): Int = {
  def fibonacci_tailRec(i: Int, act: Int, fut: Int): Int = {
    if (n == i) {
      act
    } else {
      fibonacci_tailRec(i + 1, fut, act + fut)
    }
  }

  fibonacci_tailRec(0, 0, 1)
}

fibonacci(10)
fibonacci(0)
fibonacci(1)
fibonacci(6)
fibonacci(19)