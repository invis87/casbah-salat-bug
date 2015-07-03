name := "casbah-salat-bug"

version := "1.0"

scalaVersion := "2.11.7"

resolvers += "repo-for-sigar" at "https://repository.jboss.org/nexus/content/repositories/thirdparty-uploads/"

libraryDependencies += "org.json4s" %% "json4s-native" % "3.2.11"

libraryDependencies += "org.mongodb" %% "casbah" % "2.8.1"

libraryDependencies += "com.novus" %% "salat" % "1.9.9"

//why documentation says I need this??? https://github.com/salat/salat/wiki/Quick-start
//libraryDependencies += "com.novus" %% "salat-core" % "0.0.7"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.12"