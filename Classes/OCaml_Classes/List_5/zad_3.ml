type 'a lBT = LEmpty | LNode of 'a * (unit ->'a lBT) * (unit -> 'a lBT);;
type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec ltake = function
    (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(x,xf)) -> x::ltake(n-1, xf())
;;


let rec createlBT k =
  LNode(k,(function () -> createlBT (2*k)),(function () -> createlBT (2*k+1)))
;;

let breadthlBT bt = 
  let rec breadth = function
      [] -> LNil
    |LEmpty::tl -> breadth tl
    |LNode(v, llt, lrt)::tl -> LCons(v, function () -> breadth (tl@[llt();lrt()]))
  in breadth (bt::[]);;

ltake (10, (breadthlBT (createlBT 1)));;
