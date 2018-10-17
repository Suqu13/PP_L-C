let rec separate (separator, words) =
  if(words == []) then ""
  else if (List.length words > 1) then List.hd words ^ separator ^ separate(separator, List.tl words)
  else List.hd words;;

separate("z ", "kluski "::"miesem"::[]);;
separate("z", [])



