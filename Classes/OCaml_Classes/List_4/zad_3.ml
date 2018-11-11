type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;
let tt = Node(1,
              Node(2,
                   Node(4,
                        Empty,
                        Empty
                       ),
                   Empty
                  ),
              Node(3,
                   Node(5,
                        Empty,
                        Node(6,
                             Empty,
                             Empty
                            )
                       ),
                   Empty
                  )
             );;

let breadthBT root = 
  let rec inside = function 
    |[]->[]
    |Empty::xs -> inside xs
    |Node(v, lt, rt)::xs -> v::inside(xs@[lt;rt])
  in inside(root::[])
;;
breadthBT tt;;
