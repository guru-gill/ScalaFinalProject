package accessdata

import caseclasses.Calendar
import scala.io.Source

class CalendarData {

  def getCalendarData: List[Calendar] =
  {
    val fSource = Source.fromFile("/Users/apple/Desktop/FinalScalaProject/gtfs_stm/calendar.txt")
    val calendarList: List[Calendar] = fSource
      .getLines()
      .toList
      .tail
      .map(_.split(",", -1))
      .map(c => Calendar(c(0), c(1).toInt, c(2).toInt, c(3).toInt, c(4).toInt, c(5).toInt, c(6).toInt,c(7).toInt,c(8),c(9)))
    fSource.close()
    calendarList
  }
}
