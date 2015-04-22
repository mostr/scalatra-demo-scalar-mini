import javax.servlet.ServletContext

import com.softwaremill.scalatra._
import com.softwaremill.scalatra.servlet._
import com.softwaremill.scalatra.servlet.json.{JsonRenderPipeline, JsonComplete, JsonBasics}
import org.scalatra.LifeCycle

class ScalatraBootstrap extends LifeCycle {

  override def init(context: ServletContext) = {
    context.setInitParameter(org.scalatra.EnvironmentKey, "production")
    for ((path, handler) <- servlets) {
      context.mount(handler, path)
    }
  }

  lazy val servlets = Map(
    "/basics" -> new Basics,
    "/methods" -> new Methods,
    "/params" -> new Params,
    "/views" -> new Views,
    "/json/basics" -> new JsonBasics,
    "/json/complete" -> new JsonComplete,
    "/json/render" -> new JsonRenderPipeline
  )

}
