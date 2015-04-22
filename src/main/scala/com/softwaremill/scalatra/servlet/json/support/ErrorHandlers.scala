package com.softwaremill.scalatra.servlet.json.support

import com.typesafe.scalalogging.StrictLogging
import org.scalatra._

trait ErrorHandlers extends ScalatraServlet with StrictLogging {

  notFound {
    NotFound(ErrorMessage("I still haven't found what I'm looking for"))
  }

  error {
    case e: Exception =>
      logger.error("Bad thing happened", e)
      BadRequest(ErrorMessage("Something is wrong, officer..."))
  }

  private val renderResponse: RenderPipeline = {
    case e: ErrorMessage => BadRequest(Map("error" -> e.error))
  }

  protected override def renderPipeline = renderResponse orElse super.renderPipeline
}
