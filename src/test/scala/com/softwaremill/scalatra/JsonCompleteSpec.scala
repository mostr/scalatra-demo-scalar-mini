package com.softwaremill.scalatra

import com.softwaremill.scalatra.servlet.json.JsonComplete
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfter}
import org.scalatra.test.scalatest.ScalatraFlatSpec

class JsonCompleteSpec extends ScalatraFlatSpec {

  addServlet(new JsonComplete, "/*")

  "GET /user" should "return list of users" in {
    // when
    get("/user") {
      // then
      header("Content-Type") should equal("application/json; charset=UTF-8")
      status should equal(200)
      val expectedBody = """[{"id":1,"name":"John Doe","age":20,"role":"Editor"},{"id":1,"name":"Mary Smith","age":25,"role":"Admin"}]"""
      body should be(expectedBody)
    }
  }

  "POST /user" should "post new user data" in {
    // given
    val reqBody = """{"id":1,"name":"John Doe","age":20,"role":"Editor"}"""

    // when
    post("/user", reqBody) {
      // then
      header("Content-Type") should equal("application/json; charset=UTF-8")
      status should equal(200)
      val expectedBody = s"I'm creating this user User(1,John Doe,20,Editor)"
      body should be(expectedBody)
    }
  }
}
