package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = if (c == 0 || c == r) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
  
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    @tailrec
    def loopBalance(chars: List[Char], input: String): Boolean = {
      if (chars.isEmpty) input.isEmpty
      else if (chars.head == '(') loopBalance(chars.tail, chars.head + input)
      else if (chars.head == ')') !input.isEmpty && loopBalance(chars.tail, input.tail)
      else loopBalance(chars.tail, input)
    }

    loopBalance(chars, "")
  }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if(money == 0 && coins.nonEmpty) 1
      else if(money > 0 && coins.nonEmpty) countChange(money - coins.head, coins) + countChange(money, coins.tail)
      else 0
    }
  }
