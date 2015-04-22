package com.softwaremill.scalatra.servlet.json

import com.softwaremill.scalatra.model.UserRole
import org.json4s.ext.EnumNameSerializer
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.ScalatraServlet
import org.scalatra.json.JacksonJsonSupport

class JsonBasics extends ScalatraServlet with JacksonJsonSupport {

  override implicit def jsonFormats: Formats = DefaultFormats

  get("/") {
    contentType = formats("json")
    Map("hello" -> "I'm JSON")
  }

}
