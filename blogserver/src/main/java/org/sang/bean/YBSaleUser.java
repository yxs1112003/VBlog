package org.sang.bean;

import lombok.Data;

/**
 * @author xupeng
 * @date: 16/04/2020
 */

@Data
public class YBSaleUser {
  private String username;
  private String password;
  private String phoneNumber;
  private Integer groupId;
  private String role;

  public YBSaleUser() {
  }
}
