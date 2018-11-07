def sumProd(xs: List[Int]): (Int, Int) = xs.foldLeft(0, 1)((acc: (Int, Int), x: Int) => ((acc._1 + x), (acc._2 * x))) // 0 i 1 inicializuje początkowe wartości krootki
sumProd(List(2, 2, 2))