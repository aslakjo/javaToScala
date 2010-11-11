import sbt._

class ProjectPlugins(info: ProjectInfo) extends PluginDefinition(info) {
    lazy val eclipse = "de.element34" % "sbt-eclipsify" % "0.6.0"
	val jawsyMavenReleases = "Jawsy.fi M2 releases" at "http://oss.jawsy.fi/maven2/releases"
  	val jrebelPlugin = "fi.jawsy" % "sbt-jrebel-plugin" % "0.1.0"
 }
