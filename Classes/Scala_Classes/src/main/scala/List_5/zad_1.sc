def lrepeat[A](k: Int)(lxs: Stream[A]): Stream[A] = {
  def insideRepeat[A](n: Int, ll: Stream[A]): Stream[A] = {
    (n, ll) match {
      case (_, Stream.Empty) => Stream.Empty
      case (n, lazyList@(v#::r))  => if (n < k) {
        v#::insideRepeat(n + 1, lazyList)
      } else {
        insideRepeat(0, r)
      }
    }
  }
  insideRepeat(k, lxs)
}

lrepeat(5)(Stream.from(1)).take(25).force