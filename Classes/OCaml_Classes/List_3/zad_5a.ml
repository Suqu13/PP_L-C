let insertionSort comparison xs =
  let rec addInProperPlace x = function
      [] -> [x]
    | hd::tl as list -> if comparison x hd then x::list else hd::addInProperPlace x tl
  in
    List.fold_left (fun sorted x -> addInProperPlace x sorted) [] xs;;

insertionSort (fun x y -> x <= y) [5;2;1;6;7;3;2;1;4;4;1;6;4;3];;
insertionSort (fun x y -> String.length x <= String.length y) ["Boniek";"Jan";"Darek"];;
