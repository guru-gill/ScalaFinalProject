package filter

import java.io.{BufferedWriter, FileWriter}

import caseclasses.{Calendar, JoinOutput, Route, Trip, TripRouteCalendar}

class JoinData(val Data:List[JoinOutput]) {

   val listData:List[TripRouteCalendar]=Data.map(outputdata=>{
     val t =outputdata.right.getOrElse(" ").asInstanceOf[JoinOutput].left.asInstanceOf[Trip]
     val r=outputdata.right.getOrElse(" ").asInstanceOf[JoinOutput].right.getOrElse(" ").asInstanceOf[Route]
     val c=outputdata.left.asInstanceOf[Calendar]
    val dataList= TripRouteCalendar(t.routeId,t.serviceId,t.tripId,t.tripHeadSign,t.directionId,t.shapeId,
      t.wheelChairAccessible,t.noteFr,t.noteEn,r.routeShortName,c.monday)
    dataList
  })

 var map:List[TripRouteCalendar]= listData.filter(t=>t.routeId==1|t.routeId==2|t.routeId==3|t.routeId==4|t.routeId==5)
  var filteredMap:List[TripRouteCalendar]=map.filter(f=>f.monday==1)

  val shortedTrips:List[String]=filteredMap.map(tripData=>{
    val t= tripData.routeId + "," +
      tripData.serviceId + "," +
      tripData.tripId + "," +
      tripData.tripHeadSign + "," +
      tripData.directionId + "," +
      tripData.shapeId + "," +
      tripData.wheelChairAccessible + "," +
      tripData.monday.toString + "," +
      tripData.noteEn.getOrElse("")
    t
  })


    val outputFile = new BufferedWriter(new FileWriter("/Users/apple/Desktop/FinalScalaProject/output.csv"))
      outputFile.write(Trip.getTripHeadings)
      for (i <- shortedTrips) {
        outputFile.newLine()
        outputFile.write(i)
        println(i)
      }
      outputFile.close()



}
