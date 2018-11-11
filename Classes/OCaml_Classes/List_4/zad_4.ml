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

let internalPathLength root = 
  let rec count(root,n) = match root with
    |Empty -> 0
    |Node(v, lt, rt) -> n + count(lt,(n+1)) + count(rt,(n+1))
  in count (root,0);;

internalPathLength tt;;

let externalPathLength root = 
  let rec count(root,n) = match root with
    |Empty -> n
    |Node(v, lt, rt) -> count(lt,(n+1)) + count(rt,(n+1))
  in count (root,0);;

externalPathLength tt;;
