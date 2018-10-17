let rec replaceNth(list, n, value) =
  match (list, n) with
      ([], _)-> []
    |(hd::tl, 0) -> value::tl
    |(hd::tl, _) -> hd::replaceNth(tl, n-1, value);;


replaceNth([1;2;3;4], 0, -1);;
replaceNth([1;2;3;4], 1, -2);;
