package caseclasses

case class TripRouteCalendar(
                     routeId: Int,
                     serviceId: String,
                     tripId: String,
                     tripHeadSign: String,
                     directionId: Int,
                     shapeId: Int,
                     wheelChairAccessible: Int,
                     noteFr: Option[String],
                     noteEn: Option[String],
                     routeShortName: String,
                     monday: Int
                   )


