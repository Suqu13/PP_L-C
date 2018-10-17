def root3(a: Double): Double = {
  def helper(a: Double, xi: Double, precision: Double): Double = {
    val end = Math.abs(Math.pow(xi, 3) - a) <= (precision * Math.abs(a))
    if (end) xi else helper(a, xi + (a / Math.pow(xi, 2) - xi) / 3, precision)
  }

  val init = if (a <= 1) a else a / 3
  helper(a, init, Math.pow(10, -15))
}

root3(9)