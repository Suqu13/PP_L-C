package List_9.Exceptions

object ExceptionsUse {
  def method1(): Unit ={
    method2()
  }

  def method2(): Unit = {
    method3()
  }

  def method3(): Unit = {
    throw new Exception ("Exception thrown in method 3")
  }

  def main(args: Array[String]): Unit = {
    try {
      method1()
    } catch {
      case e : Exception => e.printStackTrace()
    }
  }
}
