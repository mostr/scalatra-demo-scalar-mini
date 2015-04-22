package com.softwaremill.scalatra.servlet

import org.scalatra.ScalatraServlet
import org.scalatra.scalate.ScalateSupport

class Params extends ScalatraServlet with ScalateSupport {

   get("/:name") {
     val name = params("name")
     s"Hello $name"
   }

   get("/multi") {
     val names = multiParams("name")
     s"All names provided $names"
   }

   get("/domain/*.*") {
     val splat = multiParams("splat")
     val name = splat.head
     val ext = splat.tail.head
     s"Domain is: $name, extension is: $ext"
   }

 }
