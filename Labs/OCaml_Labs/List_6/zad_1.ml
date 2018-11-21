let insert xs v =
  let rec insertToQueue = function 
    | [] -> [v]
    | (hd::tl as ls) -> if (hd < v) then hd::insertToQueue(tl)
        else v::ls
  in insertToQueue(xs);;

insert [2;3;5;6;7] (9);;
insert [-10;-9;34;153;190] (-11);;
insert [2;3;5;6;7] (3);;
insert [2;3;5;6;7] (4);;
