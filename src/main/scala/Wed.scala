import org.apache.spark.sql.functions
import org.apache.spark.sql.functions.column

object Wed extends App {

  import org.apache.spark.sql.SparkSession

  val spark = SparkSession
    .builder()
    .appName("Spark SQL example")
    .master("local[*]")
    .getOrCreate()

  val df = spark.read.csv("data.csv")
  df.withColumn("_c0", functions.upper(column("_c0"))).show()
}
