package com.github.daggerok

import org.junit.runner.RunWith
import org.scalatest._
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AppTest extends FunSpec {
  it("should measure time") {
    val args = Array("1", "2")
    App.main(args)
  }
}
