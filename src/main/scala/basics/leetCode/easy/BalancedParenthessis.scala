package basics.leetCode.easy

import scala.collection.mutable

object BalancedParenthessis {

  def isValid(s: String): Boolean = {
    var balanced = true
    if(s.length%2==0){
      val openList: List[Char] = List('(', '{', '[')
      var st = new mutable.Stack[Char](s.length)
      for(i <- 0 until s.length){
        if(openList.contains(s(i))){
          st.push(s(i))
        }
        else {
          if(st.nonEmpty){
            val top = st.top
            if(s(i) == ')' && top == '(' ||
              s(i) == '}' && top == '{' ||
              s(i) == ']' && top == '['){
              st.pop()
            }
            else {
              balanced = false
            }
          }
          else{
            balanced = false
          }
        }
      }
      if(st.isEmpty && balanced){
        return balanced
      }
      else {
        balanced = false
      }
    }
    else {
      balanced = false
    }
    balanced
  }

  def isBalanced(s: String): Boolean = {
    var balanced = true
    if(s.length%2 == 0){
      var st = new mutable.Stack[Char](s.length)
      s.foldLeft(st)((stack, char) => {
        char match {
          case '(' => stack.push(char)
          case'{' => stack.push(char)
          case '[' => stack.push(char)
          case ')' => {
            if(stack.nonEmpty && stack.top == '(') stack.pop()
            balanced = false
          }
          case '}' => {
            if(stack.nonEmpty && stack.top == '{') stack.pop()
            balanced = false
          }
          case ']' => {
            if(stack.nonEmpty && stack.top == '[') stack.pop()
            balanced = false
          }
        }
        stack
      }
      )
      if(st.isEmpty && balanced){
        return balanced
      }
      else {
        balanced = false
      }
    }
    else {
      balanced = false
    }
    balanced
  }

  def main(args: Array[String]): Unit = {
    val str = "))"
    println(isValid(str))
    println(isBalanced(str))
  }

}
