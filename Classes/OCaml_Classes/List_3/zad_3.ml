let sumProd xs = List.fold_left (fun acc x -> ((x + fst acc),(x * snd acc))) (0,1) xs;;
sumProd [2;2;2];;
