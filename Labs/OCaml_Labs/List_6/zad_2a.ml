type 'a llist = LKoniec | LElement of 'a * (unit -> 'a llist);;

let lpowiel = function
    LKoniec -> LKoniec
  | LElement (v, nl) as el ->
      let rec inside = function
          (LKoniec,_) -> LKoniec
        |(LElement (v, nl) as ll, n) -> if n > 0 then LElement( v, fun() -> inside(ll,n-1)) 
            else match nl() with 
              | LKoniec -> LKoniec
              | LElement (v, nl) as ll -> inside(ll,v)
      in inside(el, v);;

let rec ltake = function
    (0, _) -> []
  | (_, LKoniec) -> []
  | (n, LElement(x, xf)) -> x::ltake(n-1, xf());;

let rec lfrom k = LElement (k, fun () -> lfrom (k+1));;

ltake (5, lpowiel (LElement(-1, fun () -> LElement(1, fun () -> LElement(-3, fun () -> LElement(4, fun () -> LKoniec))))));;
ltake (10, lpowiel (lfrom 1));;
ltake (11, lpowiel (LElement(0, fun () -> LElement(7, fun () -> LElement(-10, fun () -> LElement(4, fun () -> LKoniec))))));;
