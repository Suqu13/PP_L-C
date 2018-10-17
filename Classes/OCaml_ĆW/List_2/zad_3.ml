let root3 a = 
  let rec helper(a, xi, precision) =
    let ending = (abs_float(xi**3.-.a) <= (precision*.abs_float(a)))
    in
      if (ending) then xi 
      else helper(a,xi+.(a/.(xi**2.)-.xi)/.3., precision)
  in
  let init = if (a<=1.) then a else a/.3. in
    helper(a, init, 10.**(-15.));;

root3(9.);;


