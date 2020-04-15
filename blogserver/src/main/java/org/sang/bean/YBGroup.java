package org.sang.bean;

import lombok.Data;

import java.math.BigInteger;

/**
 * @author xupeng
 * @date: 15/04/2020
 */

@Data
public class YBGroup {
  private BigInteger id;
  private String groupName;

  public YBGroup() {
  }
}
