package com.softwaremill.scalatra.servlet.json

import com.softwaremill.scalatra.model.{User, UserRole}
import com.softwaremill.scalatra.servlet.json.support.{Auth, ErrorHandlers, ErrorMessage}
import org.json4s.ext.EnumNameSerializer
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.ScalatraServlet
import org.scalatra.json.JacksonJsonSupport

class JsonComplete extends ScalatraServlet with JacksonJsonSupport with Auth with ErrorHandlers {

  override implicit def jsonFormats: Formats = DefaultFormats + new EnumNameSerializer(UserRole)

  before() {
    contentType = formats("json")
  }

  get("/user") {
    Set(User(1, "John Doe", 20, UserRole.Editor), User(1, "Mary Smith", 25, UserRole.Admin))
  }

  post("/user") {
    val u = parsedBody.extract[User]  // vs parsedBody.extractOpt[User]
    s"I'm creating this user $u"
  }

  put("/user/:userId") {
    (for {
      userId <- params.getAs[Long]("userId")
      body <- parsedBody.extractOpt[User]
    } yield {
      s"I'm updating user with $userId with the following $body"
    }).getOrElse {
      ErrorMessage("Wrong ID or request body")
    }
  }

  get("/hacked") {
    throw new RuntimeException("I hacked U")
  }

}
