package com.github.daggerok

import org.scalameter._

object App {
  def main(args: Array[String]): Unit = {
    val from = 0
    val to = 1000000
    val time = measure {
      (from until to).toArray.reverse
    }
    println(s"""
            |executed "($from until $to).toArray.reverse" in: $time
            |""".stripMargin)
  }
}
