name := "imaging"

organization := "net.liftmodules"

homepage := Some(url("https://github.com/liftmodules/imaging"))

version := "1.3"

liftVersion <<= liftVersion ?? "2.6-SNAPSHOT"

liftEdition <<= liftVersion apply { _.substring(0,3) }

moduleName <<= (name, liftEdition) { (n, e) =>  n + "_" + e }

scalaVersion := "2.11.2"

crossScalaVersions := Seq("2.11.2", "2.10.0")

resolvers += "CB Central Mirror" at "http://repo.cloudbees.com/content/groups/public"

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

libraryDependencies <++= liftVersion { v =>
  "net.liftweb" %% "lift-webkit" % v % "provided" ::
  "net.liftweb" %% "lift-util" % v % "provided" ::
  Nil
}

libraryDependencies += "org.apache.sanselan" % "sanselan" % "0.97-incubator"

libraryDependencies += "org.specs2" %% "specs2" % "2.4.1" % "test"

publishTo <<= version { _.endsWith("SNAPSHOT") match {
 	case true  => Some("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
 	case false => Some("releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
  }
 }


// For local deployment:

credentials += Credentials( file("sonatype.credentials") )

// For the build server:

credentials += Credentials( file("/private/liftmodules/sonatype.credentials") )

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }


pomExtra := (
	<url>https://github.com/liftmodules/imaging</url>
	<licenses>
		<license>
	      <name>Apache 2.0 License</name>
	      <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
	      <distribution>repo</distribution>
	    </license>
	 </licenses>
	 <scm>
	    <url>git@github.com:liftmodules/imaging.git</url>
	    <connection>scm:git:git@github.com:liftmodules/imaging.git</connection>
	 </scm>
	 <developers>
	    <developer>
	      <id>liftmodules</id>
	      <name>Lift Team</name>
	      <url>http://www.liftmodules.net</url>
	 	</developer>
	 </developers>
 )

 
// Configuration for generating json files for publishing at http://ls.implicit.ly
seq(lsSettings :_*)

(LsKeys.tags in LsKeys.lsync) := Seq("lift", "images", "liftmodules")

(description in LsKeys.lsync) := "a Lift module for providing image-related utilities."

(LsKeys.ghUser in LsKeys.lsync) := Some("liftmodules")

(LsKeys.ghRepo in LsKeys.lsync) := Some("imaging")

(LsKeys.ghBranch in LsKeys.lsync) := Some("master")
