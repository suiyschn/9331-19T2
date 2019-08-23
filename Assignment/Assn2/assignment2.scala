// Use the named values (val) below whenever your need to
// read/write inputs and outputs in your program. 
val inputFilePath  = "/Users/Stan/Desktop/9313/Assignment/Assn2/sample_input.txt"
val outputDirPath = "/Users/Stan/Desktop/9313/Assignment/Assn2/output"
// Write your solution here


// Create Rdd from outside file
val inputRDD = sc.textFile(inputFilePath)
// Remove blank line and transform to new Rdd with only website and its payload
val webRDD = inputRDD.filter(line => line.contains("http"))
val pairs = webRDD.map(x => (x.split(",").head, x.split(",").last))

// Turning MB and KB to Bytes
// If using "if-else" in a map function you have to add "else" at the end, can't just "if else-if else-if..."
// if not, can't use groupBy function.(took me 1 hour to figure out whats wrong..)
val cal_pairs = pairs.map(x => { 
	if (x._2.contains("MB")) (x._1, x._2.dropRight(2).toLong * 1048576) 
		else if (x._2.contains("KB")) (x._1, x._2.dropRight(2).toLong * 1024) 
			else (x._1, x._2.dropRight(1).toLong)
} )
// Using gruopby to integrate different payloads to same website
val group_pairs = cal_pairs.groupByKey()
// Calculate min, max, mean, variance of each website 
val result = group_pairs.map(data => {
	val pre_mean = data._2.toList.map(x=>(x, 1)).reduce((x, y)=>(x._1+y._1,x._2+y._2))
	val mean = (pre_mean._1.toFloat / pre_mean._2.toFloat).toLong
	val pre_variance = data._2.toList.map(x=>((x - mean)*(x - mean), 1)).reduce((x, y)=>(x._1+y._1,x._2+y._2))
	val variance = (pre_variance._1.toFloat / pre_variance._2.toFloat).toLong
	val finall = data._1+","+data._2.min+"B,"+data._2.max+"B,"+ mean +"B,"+ variance +"B"
	finall
})

// result.take(5).foreach(println)
// Write finale result to a file 
result.coalesce(1).saveAsTextFile(outputDirPath)









