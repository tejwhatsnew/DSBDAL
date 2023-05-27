object Word{
	def main(args:Array[String]){
	var linesRDD = sc.textFile("input1.txt")
	var wordsRDD = linesRDD.flatMap(_.split(" "))
	var wordsKvRdd = wordsRDD.map((_, 1))
	var wordCounts = wordsKvRdd.reduceByKey(_ + _ )
	wordCounts.saveAsTextFile("myopt1")
	wordCounts.foreach(println)
	}
}
