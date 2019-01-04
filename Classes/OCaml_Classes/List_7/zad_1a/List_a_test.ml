let q = List_a.empty();;
let q1 = List_a.enqueue(1, q);;
let q2 = List_a.enqueue(2, q1);;
List_a.first(q2);;
List_a.dequeue q2;;
List_a.first(List_a.dequeue q2);;
List_a.isEmpty q2;;
List_a.isEmpty(List_a.dequeue(List_a.dequeue q2));;
List_a.first(List_a.dequeue(List_a.dequeue q2));;
