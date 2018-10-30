let rec ifExist(value, ls) = 
  if (ls = []) then false
  else if(List.hd ls = value) then true 
  else ifExist(value, List.tl ls);;

ifExist(0,[1;2;3]);;
ifExist("Ala", ["Ala"; "ma"; "kota"]);;

let rec filterIfContains(value, ls) = 
  if(ls = []) then []
  else if (ifExist(value, List.hd ls)) then List.hd ls ::filterIfContains(value, List.tl ls)
  else filterIfContains(value, List.tl ls);;

filterIfContains("Ala", [["Ala"; "ma"; "kota"]; ["Tomek"; "nie"; "ma"; "kota"]; ["Ala"; "ma"; "też"; "psa"]]);;
filterIfContains("Ala", []);;
