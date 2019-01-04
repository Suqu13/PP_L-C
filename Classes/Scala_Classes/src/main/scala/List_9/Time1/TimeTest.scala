package List_9.Time1

object TimeTest {
  def main(args: Array[String]): Unit = {
    var time1 = Time(1)
    print(time1.getTime + "\n")
    var time2 = Time.apply(5)
    print(time2.getTime + "\n")
    time2.setTime(-3)
    print(time2.getTime + "\n")
    var time3 = new Time(-4)
    print(time3.getTime + "\n")
    time3.setTime(23)
    print(time3.getTime + "\n")
  }
}
