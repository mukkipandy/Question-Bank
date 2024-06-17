package com.interview.gs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
**  Below formation is called Pascals Triangle.
**
**  Example:
**               1
**              1 1
**             1 2 1
**            1 3 3 1
**           1 4 6 4 1
**         1 5 10 10 5 1
**        1 6 15 20 15 6 1
*
*
*
*
  column
row	0   1   2   3   4   5   6

0   1
1	1   1
2	1   2   1
3	1   3   3   1
4	1   4   6   4   1
5	1   5  10  10   5   1
6	1   6  15  20  15   6   1

**
**  Complete the 'pascal' function below so that given a
**  col and a row it will return the value in that positon.
**   
**  Example, pascal(1,2) should return 2
**
*/
public class _13_PascalTriangle {


  private static HashMap<List<Integer>, Integer> pascalVal = new HashMap<>();

  public static int pascal(int col, int row) {
    List<Integer> p = new ArrayList<>();
    p.add(row);
    p.add(col);
    if (!pascalVal.containsKey(p)) {
      System.out.println(col + " " + row);

      if (row == 0 || row == col || col == 0) {
        pascalVal.put(p, 1);
      } else {
        pascalVal.put(p, pascal(col, row - 1) + pascal(col - 1, row - 1));
      }
    }
    return pascalVal.get(p);
  }

  public static void main(String[] args) {
    if (pascal(0, 0) == 1 && pascal(1, 2) == 2 && pascal(5, 6) == 6 && pascal(4, 8) == 70
        && pascal(6, 6) == 1) {
      System.out.println("Pass");
    } else {
      System.out.println("Failed");
    }
  }

}
