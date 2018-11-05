type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;
let tt = Node(8,
              Node(3,
                   Node(1,
                        Empty,
                        Empty
                       ),
                   Node(6,
                        Node(4,
                             Empty,
                             Empty
                            ),
                        Node(7,
                             Empty,
                             Empty
                            )
                       )
                  ),
              Node(10,
                   Node(14,
                        Node(13,
                             Empty,
                             Empty
                            ),
                        Empty
                       ),
                   Empty 
                  )
             );;


let rec contains t x = match t with 
  |Empty -> false
  |Node(v,lt,rt) -> if v = x then true
      else contains lt x || contains rt x;;

contains tt 10;;
contains tt (-1);;
contains tt 7;;
contains tt 100;;

let rec sum t = match t with
    Empty -> 0
  |Node(v,lt,rt) -> v + sum lt + sum rt;;

sum tt;;

let rec prod t = match t with
    Empty -> 1
  |Node(v,lt,rt) -> v * prod lt * prod rt;;

prod tt;;
