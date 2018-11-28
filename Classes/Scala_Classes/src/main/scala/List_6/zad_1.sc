def whileLoop(condition: => Boolean)(expression: => Unit): Unit =
  if (condition) {
    expression
    whileLoop(condition)(expression)
  }

var i = 0;
whileLoop(i <= 5) {
  print(i)
  i += 1
}