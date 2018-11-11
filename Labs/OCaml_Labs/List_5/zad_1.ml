type 'a nlist = Koniec | Element of 'a * ('a nlist);;
type 'a llist = LKoniec | LElement of 'a * (unit -> 'a llist);;

let podziel nl = 
  let rec odd = function
      (_,Koniec) -> Koniec
    | (n,Element(v, nl)) -> if n mod 2 <> 0 then Element(v, odd(n+1, nl)) 
        else odd(n+1, nl)
  in
  let rec even = function
      (_,Koniec) -> Koniec
    | (n,Element(v, nl)) -> if n mod 2 = 0 then Element(v, even(n+1, nl)) 
        else even(n+1, nl)
  in (odd((0), nl), even((0), nl));;


podziel (Element(5, Element(6, Element(3, Element(2, Element(1, Koniec))))));;
podziel (Element(5, Element(3, Element(1, Koniec))));;
podziel (Element(6, Element(2, Koniec)));;


let rec lfrom k = LElement (k, function () -> lfrom (k+1));;

let rec ltake = function
    (0, _) -> []
  | (_, LKoniec) -> []
  | (n, LElement(x, xf)) -> x::ltake(n-1, xf());;

let lpodziel nl = 
  let rec odd = function
      (_,LKoniec) -> LKoniec
    | (n,LElement(v, nl)) -> if n mod 2 <> 0 then LElement(v, function() -> odd(n+1, nl())) 
        else odd(n+1, nl())
  in
  let rec even = function
      (_,LKoniec) -> LKoniec
    | (n,LElement(v, nl)) -> if n mod 2 = 0 then LElement(v, function() -> even(n+1, nl())) 
        else even(n+1, nl())
  in (odd((0), nl), even((0), nl));;

lpodziel (lfrom 20);;
ltake (5, fst (lpodziel (lfrom 2)));; 
ltake (5, snd (lpodziel (lfrom 2)));;
