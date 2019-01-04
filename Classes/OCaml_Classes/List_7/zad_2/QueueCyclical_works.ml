module QueueMutCyclical= 
struct
  type 'a t = { mutable f :int; mutable r: int; mutable length: int; mutable a: 'a option array }
  exception Empty of string
  exception Full of string

  let empty n = { f = 0; r = 0; length = n+1; a = Array.make (n+1) None }

  let enqueue(x,q) = if ((succ q.r) mod q.length = 0) then raise (Full "module QueueMutCyclical: enqueue") 
    else q.a.(q.r) <- Some x; q.r <- (succ q.r) mod q.length

  let dequeue q = if (q.r = q.f) then raise (Empty "module QueueMutCyclical: dequeue") 
    else q.f <- (succ q.f)mod q.length

  let first q = if (q.r = q.f) then raise (Empty "module QueueMutCyclical: dequeue") 
    else match (q.a.(q.f)) with 
        Some value -> value
      |None -> failwith "module QueueMutCyclical: unexpected error"

  let isEmpty q = q.f = q.r

  let isFull q = (succ q.r) mod q.length = 0

end;;

let q = QueueMutCyclical.empty 4;;
QueueMutCyclical.enqueue(1, q);;
QueueMutCyclical.enqueue(2, q);;
QueueMutCyclical.enqueue(3, q);;
QueueMutCyclical.enqueue(4, q);;
QueueMutCyclical.isFull q;;
QueueMutCyclical.first q;;
QueueMutCyclical.dequeue q;;
QueueMutCyclical.first q;;
QueueMutCyclical.dequeue q;;
QueueMutCyclical.first q;;
QueueMutCyclical.dequeue q;;
QueueMutCyclical.first q;;
QueueMutCyclical.dequeue q;;
QueueMutCyclical.isEmpty q;;
