spray-taco
=============

This application was created to explore [Spray](http://spray.io/) routing and [Spring](http://spring.io/). This was an introduction to Spray and getting it work with Spring as well for DI. This approach was lifted from [Eric Woods](https://github.com/ewoods/spray-moviedb) who in turn lifted it
from [Christopher Hunt's repository:](https://github.com/huntc/akka-spring/blob/ba6704703efa45c9c638c3ac3b4b07f022d061ec/src/main/scala/org/typesafe/Akkaspring.scala#L48)

As of right now the app is mainly setup with the Spray routes and returning Mocked Data. I plan to go back and have it use Slick for CRUD operations to a DB.

I used Tacos as examples because everyone loves Tacos. 

Running the app
---------------
The project builds and deploys to an embedded Jetty server using the [xsbt-web-plugin](https://github.com/JamesEarlDouglas/xsbt-web-plugin).
To start the application, cd to the *spray-taco* directory, start `sbt`, and then execute `>container:start`

To import into Eclipse you must first open `sbt` then execute `>eclipse`.  This builds the Eclipse project files.


Request catalog
---------------

You can import the Request Catalog to Postman. You can install Postman plugin to Chrome.

https://www.getpostman.com/collections/2353a533bc498c460e1d





