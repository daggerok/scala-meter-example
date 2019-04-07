package com.github.daggerok

import org.scalameter._

object App {
  def main(args: Array[String]): Unit = {
    val from = if (args.length < 1 || null == args(0)) 0 else args(0).toInt
    val to = if (args.length < 2 || null == args(1)) 1000000 else args(1).toInt

    val time = measure {
      (from until to).toArray.reverse
    }
    println(s"""
            |executed "($from until $to).toArray.reverse" in: $time
            |""".stripMargin)

    val withWarmerTime = withWarmer(new Warmer.Default) measure {
      (from until to).toArray.reverse
    }
    println(s"""
            |executed with warmer "($from until $to).toArray.reverse" in: $withWarmerTime
            |""".stripMargin)
  }
}
