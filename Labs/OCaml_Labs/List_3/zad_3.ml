let rec findOdd(ls) =
  match ls with
    |([])-> 0
    |(hd::tl)-> (lxor) hd (findOdd(tl));;

findOdd([1;2;3;4;5;6;1;2;3;4;5]);;
