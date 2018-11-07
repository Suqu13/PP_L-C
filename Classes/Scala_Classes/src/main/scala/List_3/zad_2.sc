def curry[A, B, C, D](f: (A, B, C) => D) = (a: A) => (b: B) => (c: C) => f(a, b, c)
def addC(a: Int, b: Int, c: Int): Int = a + b + c //przyklad funckji zwiniętej

curry(addC)(1)(2)(3)
val one = curry(addC)(-1)
one(2)(3);
val two = one(2);
two(3)

def uncurry[A, B, C, D](f: A => B => C => D) = (a: A, b: B, c: C) => f(a)(b)(c)
def addNC(a: Int)(b: Int)(c: Int): Int = a + b + c; //przykład funckji rozwiniętej

addNC(1)(2)(3)
uncurry(addNC)(1, 2, 3)