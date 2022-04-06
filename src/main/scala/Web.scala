object Web extends App {

  import org.apache.spark.sql.SparkSession

  val spark = SparkSession
    .builder()
    .appName("Spark SQL example")
    .master("local[*]")
    .getOrCreate()

  val df = spark.read.csv("data.csv")
  df.show()
}
