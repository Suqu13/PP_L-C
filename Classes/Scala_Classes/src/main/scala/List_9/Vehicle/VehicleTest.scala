package List_9.Vehicle

object VehicleTest {
  def main(args: Array[String]): Unit = {
    val myCar = new Vehicle("Mercedes", "C", "22224")
    println("\n" + myCar.producerName)
    println(myCar.modelName)
    println(myCar.dateOfProduction)
    println(myCar.registrationNum)

    val yourCar = new Vehicle("Opel", "Adam")
    println("\n" + yourCar.producerName)
    println(yourCar.modelName)
    println(yourCar.dateOfProduction)
    println(yourCar.registrationNum)

    val hisCar = new Vehicle("Fiat", "Punto", "mf232fa")
    println("\n" + hisCar.producerName)
    println(hisCar.modelName)
    println(hisCar.dateOfProduction)
    println(hisCar.registrationNum)

    val herCar = new Vehicle("Nissan", "Juck", 2007)
    println("\n" + herCar.producerName)
    println(herCar.modelName)
    println(herCar.dateOfProduction)
    println(herCar.registrationNum)
  }
}
