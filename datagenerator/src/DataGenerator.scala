import org.apache.log4j.Logger;
import org.apache.spark.sql.SparkSession

object DataGenerator {
    
    val log = Logger.getLogger(DataGenerator.getClass().getName())

    def createSession = {
         val builder = SparkSession.builder.appName("Spark Batch")
        //.config("spark.eventLog.enabled", true)
        //.config("spark.eventLog.dir", "./spark-logs")
        builder.getOrCreate()
    }

    def generate(path: String, count: Int) = {

        log.info("Data Generation starting")
        val spark = createSession
        import spark.implicits._ 

        val df = (1 to count).map(Campaign.fromId _).toDF
        df.coalesce(1).write.option("header", true).mode("Overwrite").csv(path)

        createSession.close
        log.info("Data Generation completed")
    }
}