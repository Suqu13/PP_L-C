case class computer[A](contains: A => Boolean)

val myComputer = computer((x: Int) => x match {
  case 1 => true
  case 2 => false
  case 4 => false
  case 3 => true
  case 6 => false
  case _ => throw new Exception("This device doesn't support your computer")
})

myComputer.contains(1)
myComputer.contains(6)
myComputer.contains(3)
myComputer.contains(4)
myComputer.contains(2)
myComputer.contains(9)
