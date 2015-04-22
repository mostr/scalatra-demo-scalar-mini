package com.softwaremill.scalatra.model

object UserRole extends Enumeration {
  type UserRole = Value
  val Admin, Editor = Value
}
