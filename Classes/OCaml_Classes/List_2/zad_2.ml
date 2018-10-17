let rec aFib n = 
  match n with
    |0 -> 0
    |1 -> 1
    |_ -> aFib(n-2) + aFib(n-1);;

aFib 10;;


let rec fHelp(n, w1, w2) = 
  match n with
      0 -> w2
    |_-> fHelp(n-1, w1 + w2, w1);;

let rec bFib n = fHelp(n, 1, 0);;

bFib 10;;





