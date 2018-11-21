def ldzialanie[A](s1: Stream[A])(s2: Stream[A])(op: => A => A => A): Stream[A] = {
  (s1, s2) match {
    case (Stream.Empty, Stream.Empty) => Stream.Empty
    case (l1, Stream.Empty) => l1
    case (Stream.Empty, l2) => l2
    case (v1 #:: r1, v2 #:: r2) => op(v1)(v2) #:: ldzialanie(r1)(r2)(op)
  }
}

ldzialanie(Stream.from(3))(Stream.from(7))((a: Int) => (b: Int) => a + b).take(15).force;

val plus = (x: Int, y: Int, z: Int) => x + y + z;
val add = (x: Int) => (y: Int) => (z: Int) => x + y + z;

