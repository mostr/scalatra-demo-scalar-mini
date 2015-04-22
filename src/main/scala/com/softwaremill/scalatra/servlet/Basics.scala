package com.softwaremill.scalatra.servlet

import org.scalatra.ScalatraServlet
import org.scalatra.scalate.ScalateSupport

class Basics extends ScalatraServlet with ScalateSupport {

  get("/") {
    "Yup! It's so simple, isn't it?"
  }

  get("/markup") {
    <html>
      <body style="background: #ddd">
        Again, it's still <strong>so simple</strong>
      </body>
    </html>
  }

}
