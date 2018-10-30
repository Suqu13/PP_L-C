let rec binaryToDecimal(ls) = 
  match ls with
      ([]) -> 0.
    |(hd::tl) -> (2.**(float_of_int(List.length ls)-.1.)*.hd)+.(binaryToDecimal(tl));;

binaryToDecimal([1.;1.;1.]);;
binaryToDecimal([0.;1.;1.;1.;1.]);;
