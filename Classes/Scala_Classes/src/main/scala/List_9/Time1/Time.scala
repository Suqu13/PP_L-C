package List_9.Time1

object Time {
  def apply(t: Int): Time = new Time(t)
}

class Time(t:Int) {

  private var time: Int = if (t >= 0) t else 0

  def getTime:Int = time

  def setTime(time: Int): Unit = {
    if (time > 0) {
      this.time = time
    } else {
      this.time = 0
    }
  }
}


