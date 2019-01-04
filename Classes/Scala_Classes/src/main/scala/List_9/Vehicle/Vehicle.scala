package List_9.Vehicle

class Vehicle(val producerName: String, val modelName: String, val dateOfProduction: Int = -1, var registrationNum: String = "") {
  def this(producerName: String, modelName: String, registrationNum: String) {
    this(producerName, modelName, -1, registrationNum)
  }
}
