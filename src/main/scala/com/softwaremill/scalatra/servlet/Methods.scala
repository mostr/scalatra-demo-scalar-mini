package com.softwaremill.scalatra.servlet

import org.scalatra.ScalatraServlet

class Methods extends ScalatraServlet {

  post("/") {
    s"You've just sent me this: ${request.body}"
  }

  delete("/") {
    s"Do you really want me to delete stuff?"
  }

}
