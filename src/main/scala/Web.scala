
object Web extends App {

  import org.apache.spark.sql.SparkSession

  val spark = SparkSession
    .builder()
    .appName("Spark SQL example")
    .master("local[*]")
    .getOrCreate()

  val people = spark
    .read
    .option("header", value = true)
    .option("inferSchema", value = true)
    .csv(path)

  val path = if (args.length > 0) args.head else "data.csv"

  import org.apache.spark.sql.functions.upper

  val upperColumn = upper(people("name"))
  val peopleUpper = people.withColumn("UPPER", upperColumn)
  peopleUpper.show()
}
