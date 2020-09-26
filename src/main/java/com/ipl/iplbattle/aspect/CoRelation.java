package com.ipl.iplbattle.aspect;

import org.springframework.stereotype.Component;

/**
 * This is a class which holds the ThreadLocal object for mainting the
 * CorrelationId value.
 * @author DEP Developer.
 *
 */
@Component
public class CoRelation {

  /**
   * ThreadLocal String Object.
   */
  private static final ThreadLocal<String> CORELATIONID = new ThreadLocal<>();

  /**
   * @return return the corelationid.
   */
  public static String getCorelationid() {
    return CORELATIONID.get();
  }

  /**
   * @param corId
   *          is the ID to set.
   */
  public static void setCorelationid(final String corId) {
    CORELATIONID.set(corId);
  }

  /**
   * to remove the ThreadLocal Object.
   */
  public static void cleanup() {

    CORELATIONID.remove();
  }

}
