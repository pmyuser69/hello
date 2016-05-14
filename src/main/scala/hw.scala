trait RNG {
  def nextInt: (Int, RNG)
}

object RNG {
  def simple(seed: Long): RNG = new RNG {
    def nextInt = {
      val seed2 = (seed * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1)
      ((seed2 >>> 16).asInstanceOf[Int], simple(seed2))
    }
  }
}

object Hi {
  def main(args: Array[String]) = {
    println("Hi Guys! 2")
    var r: RNG = RNG.simple(10)
    println(r.nextInt._1)
  }
}


