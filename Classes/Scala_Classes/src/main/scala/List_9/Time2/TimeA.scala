package List_9.Time2

class TimeA(private var hours: Int, private var minutes: Int) {
  if (!(hours >= 0 && hours < 24 && minutes >= 0 && minutes < 60)) throw new IllegalArgumentException
  //require(minutes >= 0 && minutes < 60) throw new Exception("Wrong data")

  def getHours: Int = hours

  def getMinutes: Int = minutes

  def getTime: (Int, Int) = (getHours, getMinutes)

  def setHours(newH: Int): Unit = {
    if (newH < 0 || newH >= 24) throw new IllegalArgumentException
    //require(newH >= 0 && newH < 24)
    hours = newH
  }

  def setMinutes(newM: Int): Unit = {
    if (!(newM >= 0 && newM < 60)) throw new IllegalArgumentException
    //require(newM >= 0 && newM < 60)
    minutes = newM
  }

  def setTime(newH: Int, newM: Int): Unit = {
    setHours(newH)
    setMinutes(newM)
  }

  def before(other: TimeA): Boolean = {
    if (this.hours < other.hours) {
      true
    } else if (this.hours == other.hours && this.minutes < other.minutes) {
      true
    } else {
      false
    }
  }

}
