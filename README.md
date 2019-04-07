# ScalaMeter
Using `org.scalameter._` package on top of Gradle Kotlin DSL project...

_usage_

```bash
./gradlew clean ; ./gradlew ; java -jar ./build/libs/*-all.jar
```

_output example_

```bash
executed "(0 until 1000000).toArray.reverse" in: 52.108281 ms


executed with warmer "(0 until 1000000).toArray.reverse" in: 6.736713 ms

Scope:   ⠋
Overall: ⠰0:00:00 ◁․․․․․․․․․․․․․․․․․․․․․․․․▷ Fork 1/0 🡺
executed with warmer configuration "(0 until 1000000).toArray.reverse" in: 12.393093 ms
 Starting warmup1
measurements: 12.393093 ms                                             
executed with IgnoringGC "(0 until 1000000).toArray.reverse" in: 8.311437 ms
```

links:

* [YpuTube: Parallel Programming Course (week 1) - Benchmarking Parallel Programs](https://www.youtube.com/watch?v=AxqeZ-3jSJ4&list=PLOhKADai-veUWo2cEAJ4JfC9Ssaa9Isbl&index=8)
* [scalatest](http://www.scalatest.org/user_guide/writing_your_first_test)
