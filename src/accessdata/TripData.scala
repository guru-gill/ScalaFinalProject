package accessdata

import caseclasses.Trip
import scala.io.Source

class TripData {

  def getTripData: List[Trip] =
  {
    val fSource = Source.fromFile("/Users/apple/Desktop/FinalScalaProject/gtfs_stm/trips.txt")
    val tripList:List[Trip]=fSource
      .getLines()
      .toList
      .tail
      .map(_.split(",",-1))
      .map(t => Trip(t(0).toInt, t(1), t(2), t(3), t(4).toInt, t(5).toInt, t(6).toInt,
        if (t(7).isEmpty) None else Some(t(7)),
        if (t(8).isEmpty) None else Some(t(8))))
    fSource.close()
    tripList
  }
}
