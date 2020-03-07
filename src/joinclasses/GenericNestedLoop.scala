package joinclasses

import caseclasses.JoinOutput

class GenericNestedLoop[Left,Right] (val joinCond: (Left,Right) => Boolean ) extends Join[Left,Right,JoinOutput] {
  override def join(a: List[Left], b: List[Right]): List[JoinOutput] = for {
    l <- a
    r <- b
    if joinCond(l, r)
  } yield JoinOutput(l, Some(r))
}