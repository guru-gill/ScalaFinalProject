package caseclasses

case class Calendar(
                     serviceId: String,
                     monday: Int,
                     tuesday: Int,
                     wednesday: Int,
                     thursday: Int,
                     friday: Int,
                     saturday: Int,
                     sunday: Int,
                     startDate:String,
                     endDate:String
                   )

object Calendar {

  def toCsv(calendar: Calendar): String = {
    calendar.serviceId + "," +
      calendar.monday + "," +
      calendar.tuesday + "," +
      calendar.wednesday + "," +
      calendar.thursday + "," +
      calendar.friday + "," +
      calendar.saturday + "," +
      calendar.sunday + "," +
      calendar.startDate + "," +
      calendar.endDate
  }

  def getCalendarHeadings: String = {
    "serviceId" + "," +
      "monday" + "," +
      "tuesday" + "," +
      "wednesday" + ","+
      "thursday" + "," +
      "friday" + "," +
      "saturday" + "," +
      "sunday"+","+
    "startDate"+","+
    "endDate"

  }
}
