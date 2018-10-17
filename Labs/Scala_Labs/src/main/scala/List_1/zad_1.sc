def listSum(numbers: List[Double]): Double = {
  if (numbers.length > 0)
    numbers.head + listSum(numbers.tail);
  else
    0
}

def listSum_(numbers: List[Double]): Double = numbers.sum

listSum(List()) // expected - 0.0
listSum(List(2.3, 4.51, -1.13)) //expected - 5.68
