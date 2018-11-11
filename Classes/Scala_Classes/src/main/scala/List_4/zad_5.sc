sealed trait Graphs[A]
case class Graph[A](succ: A => List[A]) extends Graphs[A]
val g = Graph((i: Int) => i match {
  case 0 => List(3,6)
  case 1 => List(0, 2, 4)
  case 2 => List(1,5,6)
  case 3 => Nil
  case 4 => List(0, 2)
  case 5 => Nil
  case 6 => List(1,4)
  case n => throw new Exception("Graph g: node " + n + " doesn't exist")
})

def depthFirstSearch[A](graph: Graph[A])(startNode: A): List[A] = {
  def search (visited: List[A])(toVisit: List[A]): List[A] = {
    toVisit match {
      case Nil => Nil
      case hd::tl => if (visited.contains(hd)) search(visited)(tl) else
        hd::search(hd::visited)((graph succ hd)++tl)
    }
  }
  search(Nil)(startNode::Nil)
}

depthFirstSearch(g)(4);