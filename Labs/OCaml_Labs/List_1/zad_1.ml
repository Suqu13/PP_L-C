let rec listSum(numbers: float list): float =
  if(List.length numbers > 0) then List.hd numbers +. listSum(List.tl numbers)
  else 0.0;;



listSum(1.0::4.0::3.2::[]);;
listSum([]);;
