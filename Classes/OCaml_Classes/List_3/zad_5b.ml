let rec mergeSort p xs = 
  if ((List.length xs)/2=0) then xs
  else 
    let rec merge (p, ll, rl) = match (ll,rl) with 
        (ll,[]) -> ll
      |([], rl) -> rl
      |(lhd::ltl, rhd::rtl) -> if (p lhd rhd) then rhd::merge(p,ll,rtl)
          else lhd::merge(p,rl,ltl)
    and split xs =
      let rec helper(n ,lt) = match lt with
          []->([],[])
        | hd::tl -> 
            let nP = helper((n + 1),tl) in
              if n < (List.length lt / 2) then ((hd::fst nP),(snd nP)) 
              else ((fst nP),(hd::snd nP))
      in helper(-1, xs)
    in merge (p,mergeSort p (fst (split xs)), mergeSort p (snd (split xs)));;


mergeSort(fun a b -> a >=b) [33;12;34;56;0;-1;-1;33];;
