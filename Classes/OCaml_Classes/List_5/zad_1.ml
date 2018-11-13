type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let lrepeat k lxs =
  let rec insideRepeat = function
    |(_,LNil) -> LNil
    |(n,(LCons(x,xf) as original)) -> if n < k then LCons(x, function() -> insideRepeat((n + 1),original)) 
        else insideRepeat(0,xf())
  in insideRepeat(0,lxs);;

let rec ltake = function
    (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(x,xf)) -> x::ltake(n-1, xf());;

let rec lfrom k = LCons (k, function () -> lfrom (k+1));;

ltake (21, lrepeat 5 (lfrom 0));;
