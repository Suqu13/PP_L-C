let checkList(numbers) =
  (List.hd numbers) > (List.hd (List.tl numbers)) && (List.hd (List.tl numbers)) > (List.hd (List.tl (List.tl numbers)));;

let rec checkKrotka(a,b,c) =
  if(a > b && b > c) then true
  else false;;

checkList(3::1::0::[]);;
checkList(-1::2::-6::[]);;

checkKrotka(1,2,3);;
checkKrotka(3,2,1);;
