# pizza-eveapi

Scala Bindings for the EVE Online API

## Overview

This is a high level API binding for the EVE XML API, it provides asynchronous type-safe access to data held by the EVE API, helping you to utilise the API while minimising errors.

## Usage

### Depending on it

Add this repository to your build system:

```xml
    <repositories>
        <repository>
            <id>andimiller-bintray</id>
            <name>andimiller bintray</name>
            <url>https://dl.bintray.com/andimiller/maven/</url>
        </repository>
    </repositories>
```


And depend upon it like so:

```xml
        <dependency>
            <groupId>moe.pizza</groupId>
            <artifactId>eveapi</artifactId>
            <version>0.5</version>
        </dependency>
```

### Basic example

```scala
  // declare an API key
  implicit val apikey = Some(ApiKey(4, "X"))
  // create API object
  val api = new EVEAPI()
  // do API things
  // Get the IDs of these characters and wait 2 seconds for the result
  val r = Await.result(api.eve.CharacterID(List("Lucia Denniard", "wheniaminspace", "capqu")), 2 seconds)
  // get a list of IDs in a way that fails gracefully
  val characterids = r getOrElse(List()) map(_.characterID)
  // look up the characterinfo asynchronously
  val infoLookups = characterids.map{_.toLong}.map{api.eve.CharacterInfo}
  // attach callbacks
  infoLookups.foreach{_.onSuccess{
    case lookup => lookup.map { char =>
      println("character %s is of bloodline %s and has security status %f".format(char.characterName, char.bloodline, char.securityStatus))
    }
  }}
```
