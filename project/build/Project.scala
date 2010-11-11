import sbt._
import de.element34.sbteclipsify._
import fi.jawsy.sbtplugins.jrebel.JRebelWebPlugin

class Project(info: ProjectInfo) extends DefaultWebProject(info) with Eclipsify{
  val mavenLocal = "Local Maven Repository" at
  "file://"+Path.userHome+"/.m2/repository"

  val scalatoolsRelease = "Scala Tools Snapshot" at
  "http://scala-tools.org/repo-releases/"
  
  val eclipseLinkRepo = "EclipseLink Repo" at
   "http://www.eclipse.org/downloads/download.php?r=1&nf=1&file=/rt/eclipselink/maven.repo"
  
  val scalaToolsSnapshots = ScalaToolsSnapshots

  val jpa2 = "org.eclipse.persistence" % "javax.persistence" % "2.0.0"
  
  val eclipselink = "org.eclipse.persistence" % "eclipselink" % "2.0.1"
  
  val logback = "ch.qos.logback" % "logback-classic" % "0.9.26"
  
  val derby = "org.apache.derby" % "derby" % "10.6.2.1" % "test"

  val jetty6 = "org.mortbay.jetty" % "jetty" % "6.1.25" % "test->default" 
  val jetty6jsp = "org.mortbay.jetty" % "jsp-2.1-jetty" % "6.1.25" % "test->default" 
  
  val scalaTest = "org.scalatest" % "scalatest" % "1.2.1-SNAPSHOT" % "test" withSources
  val junit = "junit" % "junit" % "4.8.1" % "test"
  
}
