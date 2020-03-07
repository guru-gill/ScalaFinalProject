package joinclasses

import accessdata.CalendarData
import caseclasses.{Calendar, JoinOutput, Route, Trip}
import filter.JoinData

class EnrichedTrip {

  def enrichedResult(tripRoute: List[JoinOutput]): Unit = {
    val calendarData = new CalendarData()
    val calendarList: List[Calendar] = calendarData.getCalendarData

    val enrichedTrip = new GenericNestedLoop[Calendar, JoinOutput]((i, j) => i.serviceId == j.left.asInstanceOf[Trip].serviceId)
      .join(calendarList, tripRoute)

       enrichedTrip
      .map(joinOutput => {
        val t = Trip.toCsv(joinOutput.right.getOrElse(" ").asInstanceOf[JoinOutput].left.asInstanceOf[Trip])
        val r = Route.toCsv(joinOutput.right.getOrElse(" ").asInstanceOf[JoinOutput].right.getOrElse(" ").asInstanceOf[Route])
        val c = Calendar.toCsv(joinOutput.left.asInstanceOf[Calendar])
        t + "," + r + "," + c
      })

    new JoinData(enrichedTrip)

  }
}
