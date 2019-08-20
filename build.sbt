name := "library"
 
version := "1.0" 
      
lazy val `library` = (project in file(".")).enablePlugins(PlayJava)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  javaJdbc ,
  guice,
  javaWs,
  "com.h2database"          %         "h2"                        %         "1.4.197",
  javaJpa,
  "org.hibernate"           %         "hibernate-entitymanager"   %         "5.1.0.Final",
  "com.github.stijndehaes"  %%        "play-prometheus-filters"   %         "0.4.0",
  "io.prometheus" % "simpleclient" % "0.4.0"



)
unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      