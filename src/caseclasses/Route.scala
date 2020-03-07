package caseclasses

case class Route(
                  routeId: Int,
                  agencyId: String,
                  routeShortName: String,
                  routeLongName: String,
                  routeType: String,
                  routeUrl: String,
                  routeColor: String,
                  routeTextColor: String
                )

object Route {

  def toCsv(route: Route): String = {
    route.routeId + "," +
      route.agencyId + "," +
      route.routeShortName + "," +
      route.routeLongName + "," +
      route.routeType + "," +
      route.routeUrl + "," +
      route.routeColor + "," +
      route.routeTextColor
  }
  def getRouteHeadings: String = {
    "routeId" + "," +
      "agencyId" + "," +
      "routeShortName" + "," +
      "routeLongName" + ","+
      "routeType" + "," +
      "routeUrl" + "," +
      "routeColor" + "," +
      "routeTextColor"

  }
}