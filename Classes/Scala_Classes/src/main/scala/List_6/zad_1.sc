def whileLoop(condition: =>Boolean)(expression: => Unit): Unit = {
  if (condition) {
    expression
    whileLoop(condition)(expression)
  }
}

//tworząc funkcje whileLoop zależy nam tylko i wyłącznie na efektach obliczeniowych
//Efekt jest to zmana stanu w środowisku zewnętrznym funckji lub wykonaie i/o

var i = 0;
whileLoop(i <= 5) {
  print(i)
  i+=1
}