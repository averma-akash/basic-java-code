import java.util.*;

public class RemoveUnbalanced{
  
  public static void main(String args[]) {
  String x= "())(";
  
  removeMethod(x);
  
  }


static void removeMethod(String str) {
  
  
  Queue<String> x = new LinkedList<>();
  x.add(str);
  HashSet<String> hashSet = new HashSet<>();
  hashSet.add(str);
  boolean y=false;
  String temp= null;
  while(!x.isEmpty()) {
    str = x.peek();
    x.remove();
    if(checkValidString(str)){
      
      System.out.println(str);
      y=true;
    }
    
    if(y){
      continue;
    }
    
    for(int i=0; i<str.length();i++) {
      if(!checkParentheses(str.charAt(i)))
      continue;
      temp = str.substring(0,i) +str.substring(i+1);
      
      if(!hashSet.contains(temp)){
        x.add(temp);
        hashSet.add(temp);
      }
    }
  }
  
}

static boolean checkParentheses(char a) {
  return ((a=='(') || (a==')'));
}

static boolean checkValidString(String str) {
  
    int count=0;
    for(int i =0 ; i<str.length();i++) {
      if(str.charAt(i) == '(') {
        count++;
      }
      else if(str.charAt(i) == ')')
      count--;
      if(count < 0)
      return false;
    }
    return (count==0);
    
  
}


}