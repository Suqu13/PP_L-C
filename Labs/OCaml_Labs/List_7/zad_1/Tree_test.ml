let rec print_list = function
    h::t -> 
      print_int h;
      print_string " ";
      print_list t
  | [] -> ();;

let print_bool x = if (x = true) then print_string "true\n" 
  else  print_string "false\n";;

let sT = Tree.create();;
print_string"Pushing 4\n";;
Tree.push(4, sT);;
print_string"Does the tree contain 4?: ";;
print_bool(Tree.find(4, sT));;
print_string"Does the tree contain 2?: ";;
print_bool(Tree.find(2, sT));;
print_string"Pushing 2\n";;
Tree.push(2, sT);;
print_string"Pushing 6\n";;
Tree.push(6, sT);;
print_string"Pushing 2\n";;
Tree.push(2, sT);;
print_string"Does the tree contain 2?: ";;
print_bool(Tree.find(2, sT));;
print_string"Pushing 0\n";;
Tree.push(0, sT);;
print_string"Pushing 3\n";;
Tree.push(3, sT);;
print_string"Pushing 10\n";;
Tree.push(10, sT);;
print_string"Does the tree contain 10?: ";;
print_bool(Tree.find(2, sT));;
print_string "Preorder: ";;
print_list (Tree.getPreOrder sT);;
print_string "\n";;
print_string "Postorder: ";;
print_list (Tree.getPostOrder sT);;
print_string "\n";;
print_string "Removing 10 from the tree\n";;
Tree.remove(10, sT);;
print_string "Inorder: ";;
print_list (Tree.getInOrder sT);;
print_string "\nRemoving 4 from the tree\n";;
Tree.remove(4, sT);;
print_string"Does the tree contain 4?: ";;
print_bool(Tree.find(4, sT));;
print_string"Does the tree contain 2?: ";;
print_bool(Tree.find(2, sT));;
print_string"Does the tree contain 6?: ";;
print_bool(Tree.find(6, sT));;
print_string "Removing 3 from the tree\n";;
Tree.remove(3, sT);;
print_string"Does the tree contain 3?: ";;
print_bool(Tree.find(3, sT));;
print_string "Preorder: ";;
print_list (Tree.getPreOrder sT);;
print_string "\n";;
print_string "Postorder: ";;
print_list (Tree.getPostOrder sT);;
print_string "\n";;
print_string "Inorder: ";;
print_list (Tree.getInOrder sT);;
print_string"Does the tree contain 3?: ";;
print_bool(Tree.find(3, sT));;
print_string "Removing 3 from the tree\n";;
Tree.remove(3, sT);;
