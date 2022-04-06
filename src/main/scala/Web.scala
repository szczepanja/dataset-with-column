import org.apache.spark.sql.functions.lit

object Web extends App {

  import org.apache.spark.sql.SparkSession

  val spark = SparkSession
    .builder()
    .appName("Spark SQL example")
    .master("local[*]")
    .getOrCreate()

  val df = spark.read.csv("data.csv")
  df.withColumn("C5", lit("six")).withColumn("C6", lit("seven")).show()
}
