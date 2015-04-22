package com.softwaremill.scalatra.model

import UserRole.UserRole

case class User(id: Long, name: String, age: Int, role: UserRole)


