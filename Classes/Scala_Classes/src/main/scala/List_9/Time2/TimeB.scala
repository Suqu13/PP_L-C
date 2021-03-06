package List_9.Time2

class TimeB(hours: Int, minutes: Int) {
  if ((hours < 0 || hours >= 24) || (minutes < 0 || minutes >= 60)) throw new IllegalArgumentException

  private var timeAfterMidnight: Int = hours * 60 + minutes

  def getHours: Int = timeAfterMidnight / 60

  def getMinutes: Int = timeAfterMidnight % 60

  def getTime: (Int, Int) = (getHours, getMinutes)

  def setHours(newH: Int): Unit = {
    if (newH < 0 || newH >= 24) throw new IllegalArgumentException
    timeAfterMidnight = getMinutes + newH * 60
  }

  def setMinutes(newM: Int): Unit = {
    if (newM < 0 || newM >= 60) throw new IllegalArgumentException
    timeAfterMidnight = getHours * 60 + newM
  }

  def setTime(newH: Int, newM: Int): Unit = {
    setHours(newH)
    setMinutes(newM)
  }

  def before(other: TimeB): Boolean = {
    if (this.timeAfterMidnight < other.timeAfterMidnight) {
      true
    } else {
      false
    }
  }
}
