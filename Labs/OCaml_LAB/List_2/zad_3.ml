let separate list_ = 
  let rec sep_(list0, (list1,list2,list3)) =
    if (list0 = []) then (List.rev list1, List.rev list2, List.rev list3) 
    else if(List.hd list0 mod 2 = 0 ) then 
      if(List.hd list0 > 0) then sep_(List.tl list0, (List.hd list0::list1, list2, list3))
      else sep_(List.tl list0, (list1, List.hd list0::list2, list3))
    else sep_(List.tl list0, (list1,list2, List.hd list0::list3))
  in 
    sep_(list_, ([],[],[]));;

separate([-7;-6;-5;-4;-3;-2;-1;0;1;2;3;4;5;6;7]);;

