package accessdata

import caseclasses.Route
import scala.io.Source

class RouteData {

  def getRouteData: List[Route] =
  {
    val fSource = Source.fromFile("/Users/apple/Desktop/FinalScalaProject/gtfs_stm/routes.txt")
    val routeList: List[Route] = fSource
      .getLines()
      .toList
      .tail
      .map(_.split(",", -1))
      .map(r => Route(r(0).toInt, r(1), r(2), r(3), r(4), r(5),r(6),r(7)))
    fSource.close()
       routeList
  }
}
