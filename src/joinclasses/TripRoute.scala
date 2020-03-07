package joinclasses

import accessdata.{RouteData, TripData}
import caseclasses.{JoinOutput, Route, Trip}

class TripRoute {

  def enrichTripRoute: List[JoinOutput] =
  {
    val routeData = new RouteData()
    val tripData=new TripData()
    val routeList: List[Route]=routeData.getRouteData
    val tripList: List[Trip]=tripData.getTripData
    val tripRoute: List[JoinOutput] = new TripRouteMapJoin[Trip, Route](i => i.routeId.toString)(j => j.routeId.toString)
      .join(tripList, routeList)
    tripRoute
  }
}
