type 'a lBT = LEmpty | LNode of 'a * (unit ->'a lBT) * (unit -> 'a lBT);;
type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec lTree k =
  LNode(k,(function () -> lTree (2*k)),(function () -> lTree (2*k+1)))
;;

let breadthlBT bt = 
  let rec breadth = function
      [] -> LNil
    |LEmpty::tl -> breadth tl
    |LNode(v, llt, lrt)::tl -> LCons(v, function () -> breadth (tl@[llt();lrt()]))
  in breadth (bt::[]);;


let rec ltake = function
    (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(x,xf)) -> x::ltake(n-1, xf())
;;

ltake (10, (breadthlBT (lTree 1)));;
