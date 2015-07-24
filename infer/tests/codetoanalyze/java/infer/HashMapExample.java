/*
* Copyright (c) 2013 - present Facebook, Inc.
* All rights reserved.
*
* This source code is licensed under the BSD style license found in the
* LICENSE file in the root directory of this source tree. An additional grant
* of patent rights can be found in the PATENTS file in the same directory.
*/

package codetoanalyze.java.infer;

import java.util.HashMap;

public class HashMapExample {

  public static void putIntegerTwiceThenGetTwice(
    HashMap<Integer, Integer> hashMap
  ) {
    Integer i32 = new Integer(32);
    Integer i52 = new Integer(52);

    hashMap.put(i32, i32);
    hashMap.put(i52, i52);

    Integer a = hashMap.get(i32);
    Integer b = hashMap.get(i52);

    a.intValue();
    b.intValue();
  }

  public static void containsIntegerTwiceThenGetTwice(
    HashMap<Integer, Integer> hashMap
  ) {
    Integer i32 = new Integer(32);
    Integer i52 = new Integer(52);

    if (hashMap.containsKey(i32) && hashMap.containsKey(i52)) {
      Integer a = hashMap.get(i32);
      Integer b = hashMap.get(i52);
      a.intValue();
      b.intValue();
    }
  }

  public static int getOneIntegerWithoutCheck() {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    Integer i32 = new Integer(32);

    Integer a = hashMap.get(i32);

    return a.intValue();
  }

  public static void getTwoIntegersWithOneCheck(
    Integer i,
    Integer j
  ) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    if (hashMap.containsKey(i) && !i.equals(j)) {
      Integer a = hashMap.get(i);
      Integer b = hashMap.get(j);

      a.intValue();
      b.intValue();
    }
  }

  public static Integer getOrCreateInteger(
    final HashMap<Integer, Integer> map,
    final int id) {
      Integer x = null;
      if (map.containsKey(id)) {
          x = map.get(id);
      } else {
          x = new Integer(0);
          map.put(id, x);
      }
      return x;
  }

  public static void getOrCreateIntegerThenDeref(
    final HashMap<Integer, Integer> map) {
      Integer x = getOrCreateInteger(map, 42);
      // dereference x
      x.toString();
  }

}
