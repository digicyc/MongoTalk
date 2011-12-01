name := "MongoTalk"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
  "com.foursquare" %% "rogue" % "1.0.27" intransitive(),
  "org.specs2" %% "specs2" % "1.6.1",
  "net.liftweb" %% "lift-mongodb-record" % "2.4-M4" % "compile->default",
  "net.liftweb" %% "lift-mongodb" % "2.4-M4" % "compile->default",
  "com.mongodb.casbah" %% "casbah" % "2.1.5-1" % "compile->default"
)

resolvers ++= Seq("snapshots" at "http://scala-tools.org/repo-snapshots",
                  "releases"  at "http://scala-tools.org/repo-releases")
