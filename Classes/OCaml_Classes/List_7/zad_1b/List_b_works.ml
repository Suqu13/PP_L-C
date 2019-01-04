module List_b = 
struct
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
end;;
let q = List_b.empty();;
let q1 = List_b.enqueue(1, q);;
let q2 = List_b.enqueue(2, q1);;
List_b.first(q2);;
List_b.dequeue q2;;
List_b.first(List_b.dequeue q2);;
List_b.isEmpty q2;;
List_b.isEmpty(List_b.dequeue(List_b.dequeue q2));;
List_b.first(List_b.dequeue(List_b.dequeue q2));;
