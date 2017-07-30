# Imaging Lift Module

[![Build Status](https://travis-ci.org/liftmodules/imaging.svg?branch=master)](https://travis-ci.org/liftmodules/imaging)

This module provides image-related utilities.

## Installation

To include this module in your Lift project, add the following to `build.sbt`:

    libraryDependencies += "net.liftmodules" %% "imaging_3.1" % "1.5.0"

## Previous Releases


| Lift Version | Scala Version | Module Version |
|--------------|---------------|----------------|
| 3.1.x        | 2.12, 2.11    | 1.5.0          |
| 3.0.x        | 2.12, 2.11    | 1.4.0          |
| 2.6.x        | 2.10, 2.9     | 1.3            |
| 2.5.x        | 2.10, 2.9     | 1.2            |

#### Historic Snapshots

| Lift Version | Scala Version | Module Version |
|--------------|---------------|----------------|
| 3.0.x        | 2.11          | 1.4-SNAPSHOT   |
| 2.6.x        | 2.11, 2.10    | 1.4-SNAPSHOT   |

## Usage

**Note:** The module package changed from `net.liftweb.imaging` to `net.liftmodules.imaging` in May 2012.  Please consider this when referencing documentation written before that date.

### From Stream to BufferedImage

	var metaImage = ImageResizer.getImageFromStream(fph.fileStream)

### Remove alpha channel (Fix Transparency from PNG)

	var metaImage = ImageResizer.removeAlphaChannel(metaImage)

### Resize and rotate image

	val img = ImageResizer.max(metaImage.orientation, metaImage.image, 800, 600)

### Warning JPEG codec

OpenJDK does not have a native JPEG encoder, try using Sun's JDK, or using an external library like JAI.

## Notes for module developers

Merge to master will trigger a Travis build and publish a SNAPSHOT (if the version is a -SNAPSHOT).
