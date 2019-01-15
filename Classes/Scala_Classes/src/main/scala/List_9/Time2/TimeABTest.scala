package List_9.Time2

object TimeABTest {
  def main(args: Array[String]): Unit = {
    print("\nTime A: \n")
    var timeA1 = new TimeA(3,3)
    print(timeA1.before(new TimeA(1,59)) + "\n")
    print(timeA1.getTime + "\n")
    timeA1.setHours(12)
    timeA1.setMinutes(39)
    print(timeA1.getTime + "\n")
    timeA1.setTime(0,0)
    print(timeA1.getTime + "\n")
    print(timeA1.before(new TimeA(9,59)) + "\n")

    print("\nTime B: \n")
    var timeB1 = new TimeB(14,55)
    print(timeB1.before(new TimeB(1,59)) + "\n")
    print(timeB1.getTime + "\n")
    timeB1.setHours(2)
    timeB1.setMinutes(-43)
    print(timeB1.getTime + "\n")
    timeB1.setTime(0,0)
    print(timeB1.getTime + "\n")
    print(timeB1.before(new TimeB(9,59)) + "\n")
  }
}
