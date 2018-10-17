let rec merge (list1, list2) =
  if(list1 = []) then list2
  else List.hd list1::merge(list2, List.tl list1);;

merge([2;4],[1;3;5]);;
merge([1;3;5],[2;4]);;
merge([],[])
