let fibonacci n =
  let rec fibonacciRec(i, act,fut) =
    if (n = i) then act
    else fibonacciRec(i+1, fut, act + fut)
  in
    fibonacciRec(0,0,1);;

fibonacci(10)
