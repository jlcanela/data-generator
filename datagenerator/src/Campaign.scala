import java.time.format.DateTimeFormatter
case class Campaign(location: String, name: String, id: Int, startDateTime: String, endDateTime: String, segments: String)
object Campaign {
    
    val random = new scala.util.Random
    
    val locations = Array("FRA", "SPA")
    def genLocation = locations(random.nextInt(locations.length))
    
    def genName(id: Int) = s"campaign${id}"

    val segmentAges = Array("AGE_0_17", "AGE_18_20", "AGE_21_100")
    def genAge = segmentAges(random.nextInt(segmentAges.length))

    val segmentGenders = Array("GENDER_M", "GENDER_F", "GENDER_BOTH")
    def genGender = segmentGenders(random.nextInt(segmentGenders.length))

    def genSegments = Array(genAge, genGender).mkString(";")

    val fmt: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    def genDateTime = {
        val now = java.time.LocalDateTime.now 
        now.format(fmt)
    }

    def fromId(id: Int) = Campaign(genLocation, genName(id), id, genDateTime, genDateTime, genSegments)
}
