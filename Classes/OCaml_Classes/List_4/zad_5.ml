type 'a graph = Graph of ('a -> 'a list);;
let g = Graph
          (function
              0 -> [3]
            | 1 -> [0;2;4]
            | 2 -> [1]
            | 3 -> []
            | 4 -> [0;2]
            | n -> failwith ("Graph g: node "^string_of_int n^" doesn't exist")
          );;


let depthFirst (Graph succ) startNode =
  let rec search visited queue =
    match queue with
        [] -> []
      | h::t -> if List.mem h visited then search visited t
          else h::search (h::visited) (succ h @ t)
  in search [] [startNode];;


depthFirst g 4;;
