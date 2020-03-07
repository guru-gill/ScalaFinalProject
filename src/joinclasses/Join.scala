package joinclasses

trait Join[L,R,Q] {
  def join(a: List[L], b: List[R]): List[Q]
}
