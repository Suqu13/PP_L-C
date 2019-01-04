type 'a t = 'a list
exception Empty of string

let empty() = []

let rec enqueue(x,xs) = match xs with
  |(hd::tl) -> hd::enqueue(x,tl)
  |[] -> [x]

let dequeue = function
  |(_::tl) -> tl
  |[] -> []

let first = function 
  |[]-> raise (Empty "module QueueList: first")
  |hd::_ -> hd

let isEmpty xs = xs = [] 

