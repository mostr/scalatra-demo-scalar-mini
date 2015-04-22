package com.softwaremill.scalatra.servlet.json.support

import org.scalatra.ScalatraServlet

trait Auth extends ScalatraServlet {

  before() {
    fakeAuth()
  }

  def fakeAuth(): Unit = if(true) pass() else halt(403, ErrorMessage("Sorry bro, cannot enter"))

}
