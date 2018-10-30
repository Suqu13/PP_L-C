def checkTriangular(a: (Int, Int), b: (Int, Int), c: (Int, Int)): Boolean = {
  ((a._1 * b._2) + (a._2 * c._1) + (b._1 * c._2) - (b._2 * c._1) - (a._2 * b._1) - (a._1 * c._2)) != 0
}

checkTriangular((1, 1), (2, 2), (3, 3));
checkTriangular((1, 2), (9, 0), (-1, 7));
checkTriangular((1, 1), (2, 2), (3, 0));
checkTriangular((1, 0), (2, 2), (3, 3));
checkTriangular((1, 1), (2, 2), (2, 2));
checkTriangular((1, 0), (2, 2), (1, 0));
