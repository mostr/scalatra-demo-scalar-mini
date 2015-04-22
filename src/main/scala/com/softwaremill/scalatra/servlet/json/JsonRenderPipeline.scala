package com.softwaremill.scalatra.servlet.json

import com.softwaremill.scalatra.model.{User, UserRole}
import com.softwaremill.scalatra.servlet.json.support.ErrorMessage
import org.json4s.{DefaultFormats, Formats}
import org.json4s.ext.EnumNameSerializer
import org.scalatra._
import org.scalatra.json.JacksonJsonSupport

class JsonRenderPipeline extends ScalatraServlet with JacksonJsonSupport {

  override implicit def jsonFormats: Formats = DefaultFormats + new EnumNameSerializer(UserRole)

  before() {
    contentType = formats("json")
  }

  get("/:userId") {
    params.getAs[Long]("userId").flatMap {
      case id: Long if id == 123 => Some(User(123, "John Doe", 20, UserRole.Editor))
      case _ => None
    }
  }

  private val renderOption: RenderPipeline = {
    case Some(x) => Ok(x)
    case None => NotAcceptable(ErrorMessage("Bummer"))
  }

  protected override def renderPipeline = renderOption orElse super.renderPipeline

}
