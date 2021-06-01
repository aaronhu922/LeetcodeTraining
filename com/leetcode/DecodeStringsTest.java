/**
 * 
 */
package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author aahu
 *
 */
public class DecodeStringsTest {

  /**
   * Test method for {@link com.leetcode.DecodeStrings#decodeString(java.lang.String)}.
   */
  @Test
  public void testDecodeString() {
    assertEquals("abcabccdcdcdef", new DecodeStrings().decodeString("2[abc]3[cd]ef"));
  }

}
