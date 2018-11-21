type race = string;;
type vehicle = string;;
type doggo = Doggo of race * (unit -> vehicle);;

let paw = Doggo("dalmatian", fun()-> "rocket" );;
let mickey = Doggo("labrador", fun()-> "roller skates" );;
let doughnut = Doggo("york", fun()-> "limousine" );;
let andrea = Doggo("german shepherd", fun()-> "horse" );;

let rec show = function 
  |[] -> []
  |(hd::tl) -> let Doggo (r,v) = hd 
      in (r,v())::show tl;;

show[paw;mickey;doughnut;andrea]


