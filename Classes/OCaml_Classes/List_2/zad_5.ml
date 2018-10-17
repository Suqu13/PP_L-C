let rec initSegment(l1, l2) = 
  match (l1, l2) with
      ([],_) -> true
    |(_,[]) -> false
    |(h1::t1, h2::t2)-> if (h1 = h2) then initSegment(t1, t2) 
        else false;; 

initSegment([], [1;2;3]);;
initSegment([1;2;3;4;5], []);;
initSegment([1;2], [1;2;3;4;5]);;
