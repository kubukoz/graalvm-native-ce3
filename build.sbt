val root = project
  .in(file("."))
  .settings(
    scalaVersion := "3.0.0",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-effect" % "3.1.1",
      compilerPlugin("com.kubukoz" % "better-tostring" % "0.3.3" cross CrossVersion.full),
    ),
    resolvers += "OSS Maven" at "https://artifactory.us-east-1.bamgrid.net/artifactory/oss-maven/",
    scalacOptions -= "-Xfatal-warnings",
    Compile / mainClass := Some("com.disneystreaming.strum.Main"),
    nativeImageOptions += "-H:+ReportExceptionStackTraces",
    nativeImageOptions += s"-H:ReflectionConfigurationFiles=${(Compile / resourceDirectory).value / "reflect-config.json"}",
  )
  .enablePlugins(NativeImagePlugin)