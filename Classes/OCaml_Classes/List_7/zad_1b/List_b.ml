type 'a t = 'a list * 'a list
exception Empty of string

let empty() = ([],[])

let rec enqueue(x,xs) = match xs with
    ([],_) -> ([x],[])
  |(fs,sc) -> (fs,x::sc)

let dequeue = function
    ([],[]) -> ([],[])
  |([x], sc) -> (List.rev sc, [])
  |(hd::tl,sc) -> (tl,sc)
  |([],sc) -> failwith "Unexpected"

let first = function 
    (hd::tl,_) -> hd
  |([],_) -> raise (Empty "module List_b: first")

let isEmpty xs = xs = ([],[]) 
