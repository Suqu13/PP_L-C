let q = List_b.empty();;
let q1 = List_b.enqueue(1, q);;
let q2 = List_b.enqueue(2, q1);;
List_b.first(q2);;
List_b.dequeue q2;;
List_b.first(List_b.dequeue q2);;
List_b.isEmpty q2;;
List_b.isEmpty(List_b.dequeue(List_b.dequeue q2));;
List_b.first(List_b.dequeue(List_b.dequeue q2));;
