type 'a t
exception Empty of string
val create: unit -> int t
val push: int * int t -> unit
val remove: int * int t -> unit
val find: int * int t -> bool
val getPreOrder: 'int t -> int list
val getPostOrder: 'int t -> int list
val getInOrder: 'int t -> int list

