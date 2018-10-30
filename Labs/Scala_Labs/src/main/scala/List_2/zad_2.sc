def fibonacciRec(n: Int): Int = {
  def fibonacci_tailRec(i: Int, act: Int, fut: Int): Int = {
    if (n == i) {
      act
    } else {
      fibonacci_tailRec(i + 1, fut, act + fut)
    }
  }

  fibonacci_tailRec(0, 0, 1)
}



fibonacciRec(10)
fibonacciRec(0)
fibonacciRec(1)
fibonacciRec(6)
fibonacciRec(19)


def fibocacciPatologiczny(n: Int): Int = {
  if (n == 0) {
    0
  }
  else if (n == 1) {
    1
  } else fibocacciPatologiczny(n - 1) + fibocacciPatologiczny(n - 2)
}

fibocacciPatologiczny(10)
fibocacciPatologiczny(0)
fibocacciPatologiczny(1)
fibocacciPatologiczny(6)
fibocacciPatologiczny(19)