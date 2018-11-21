let rec powiel = function 
    ([]) -> []
  |(hd::tl) -> let powielElemenet elem =
    if elem < 0 then [] else 
      let rec inside = function
          (0,_) -> []
        |(n,v) -> v::inside(n-1,v)
      in inside(elem, elem)
      in powielElemenet hd @ powiel tl;;

powiel [-1;1;2;5];;
powiel [0;1;4;7];;
powiel [];;
