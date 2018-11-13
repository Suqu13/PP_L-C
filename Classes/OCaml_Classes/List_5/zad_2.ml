type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let lFib = 
  let rec fib first second = 
    LCons(first + second, function () -> fib (second) (first+second))
  in LCons(0, function () ->  LCons(1, function () ->fib 0 1));;

let rec ltake = function
    (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(x,xf)) -> x::ltake(n-1, xf())
;;

ltake(10,lFib);;
