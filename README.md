# Imaging Lift Module

This module provides image-related utilities.

## Installation

To include this module in your Lift project, update your `libraryDependencies` in `build.sbt` to include:

*Lift 2.5.x* for Scala 2.9 and 2.10:

    "net.liftmodules" %% "imaging_2.5" % "1.2"

*Lift 2.6.x*:

    "net.liftmodules" %% "imaging_2.6" % "1.2"

*Lift 3.0.x* for Scala 2.10:

    "net.liftmodules" %% "imaging_3.0" % "1.3-SNAPSHOT"

**Note:** The module package changed from `net.liftweb.imaging` to `net.liftmodules.imaging` in May 2012.  Please consider this when referencing documentation written before that date.

Version list can be found at [Maven Repository](http://repo1.maven.org/maven2/net/liftmodules/)


## Usage

### From Stream to BufferedImage

	var metaImage = ImageResizer.getImageFromStream(fph.fileStream)

### Remove alpha channel (Fix Transparency from PNG)

	var metaImage = ImageResizer.removeAlphaChannel(metaImage)

### Resize and rotate image

	val img = ImageResizer.max(metaImage.orientation, metaImage.image, 800, 600)
	
### Warning JPEG codec

OpenJDK does not have a native JPEG encoder, try using Sun's JDK, or using an external library like JAI.

## Notes for module developers

* The [Jenkins build](https://liftmodules.ci.cloudbees.com/job/imaging/) is triggered on a push to master.

