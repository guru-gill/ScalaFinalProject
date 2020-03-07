package stm

import joinclasses.{EnrichedTrip, TripRoute}
import caseclasses.JoinOutput

case object MainObject
{
  def main(args: Array[String]) {
    val tripRouteData=new TripRoute
    val enrichmentTrip=new EnrichedTrip
    val tripRoute: List[JoinOutput]=tripRouteData.enrichTripRoute
    enrichmentTrip.enrichedResult(tripRoute)
  }
}
