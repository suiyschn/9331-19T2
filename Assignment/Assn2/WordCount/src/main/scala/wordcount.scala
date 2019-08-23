import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
object wordcount {
 def main(args: Array[String]) {
 val inputFile = args(0)
 val outputFolder = args(1)
 val conf = new SparkConf().setAppName("wordcount").setMaster("local")
 // Create a Scala Spark Context.
 val sc = new SparkContext(conf)
 // Load our input data.
 val input = sc.textFile(inputFile)
 // Split up into words.
 val words = input.flatMap(line => line.split(" "))
 // Transform into word and count.
 val counts = words.map(word => (word, 1)).reduceByKey(_+_)
 counts.saveAsTextFile(outputFolder)
 }
}
