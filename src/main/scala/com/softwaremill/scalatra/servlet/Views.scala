package com.softwaremill.scalatra.servlet

import org.scalatra.scalate.ScalateSupport
import org.scalatra.{ApiFormats, ScalatraServlet}

class Views extends ScalatraServlet with ScalateSupport {

  get("/") {
    contentType = "html"
    scaml("hello", "msg" -> "Scalatra is easy")
  }

}
