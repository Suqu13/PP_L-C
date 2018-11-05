import scala.Numeric.Implicits._

sealed trait Calculator[A]
case class Value[A](value: A) extends  Calculator[A]
case class Add[A](f_value: Calculator[A], s_value: Calculator[A]) extends Calculator[A]
case class Negate[A](negation: Calculator[A]) extends Calculator[A]

def calculate[A: Numeric](expression: Calculator[A]): A = expression match {
  case Value(value) => value
  case Add(f_value, s_value) => calculate(f_value) + calculate(s_value)
  case Negate(negation) => - calculate(negation)
}

calculate(Add(Value(3.4), Value(223.4)))
calculate(Negate(Add(Value(3.4), Value(223.4))))