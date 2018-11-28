type 'a bt = Leaf | Node of 'a * 'a bt * 'a bt
type 'a t = {mutable root: int bt }
exception Empty of string

let create()= { root = Leaf }

let push (newElem, bsTree)= 
  let rec pushInside = function 
      Node (v, lt, rt) as org -> if newElem < v then Node(v, pushInside lt,  rt)
        else if newElem > v then Node(v, lt, pushInside rt)
        else org
    |Leaf -> Node(newElem, Leaf, Leaf)
  in bsTree.root <- pushInside bsTree.root

let remove (toRemove, bsTree)= 
  let rec removeInside toR = function 
      Node (v, lt, rt) as org -> if toR < v then Node(v, removeInside toR lt,  rt)
        else if toR > v then Node(v, lt, removeInside toR rt)
        else let findNext = function
            Leaf -> failwith "unexcepted"
          |Node(_, Leaf, Leaf) -> Leaf
          |Node(_, lt, Leaf) -> lt
          |Node(_, Leaf, rt) -> rt
          |Node(_, lt, rt) -> 
              let rec maxValue = function 
                  Leaf -> failwith "unexcepted"
                |Node(max, _, Leaf) -> max
                |Node(_,_,rt) -> maxValue rt
              in let suc = maxValue lt
              in Node(suc, removeInside suc lt, rt)
          in findNext org
    |Leaf -> raise (Empty "module BST -> remove: NotFound")
  in bsTree.root <- removeInside toRemove bsTree.root

let find(toFind, bsTree) =
  let rec findInside = function 
      Node (v, lt, rt) -> if toFind < v then findInside lt
        else if toFind > v then findInside rt
        else true
    |Leaf -> false
  in findInside bsTree.root

let getPreOrder bsTree =
  let rec preOrderInside = function
      Leaf -> []
    |Node(v, lt, rt) -> v:: (preOrderInside lt@preOrderInside rt)
  in preOrderInside bsTree.root

let getInOrder bsTree =
  let rec inOrderInside = function
      Leaf -> []
    |Node(v, lt, rt) -> (inOrderInside lt)@(v::inOrderInside rt)
  in inOrderInside bsTree.root

let getPostOrder bsTree =
  let rec preOrderInside = function
      Leaf -> []
    |Node(v,lt,rt) -> (preOrderInside lt)@(preOrderInside rt)@(v::[])
  in preOrderInside bsTree.root
