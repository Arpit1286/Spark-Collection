name := "SparkMapReduce"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.3.0",
  "org.apache.spark" %% "spark-streaming" % "1.3.0",
  "org.apache.spark" %% "spark-streaming-kafka" % "1.3.0",
// geolocation API from maxmind 2
  "com.maxmind.geoip2" % "geoip2" % "2.1.0",
  "com.github.nscala-time" %% "nscala-time" % "1.8.0"
)


    