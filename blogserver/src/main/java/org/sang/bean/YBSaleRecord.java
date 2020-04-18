package org.sang.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author xupeng
 * @date: 13/04/2020
 */
@Data
public class YBSaleRecord {
  private String groupId;
  private String salerName;
  private String visitName;
  private String wholeSale;
  private String dominantPosition;
  private String display;
  private String other;
  private String visitByRoute;
  private String visitByPhone;
  private Integer orderCount;
  private Integer waterSaleCount;
  private String water333;
  private String water555;
  private String water1500;
  private String water4500;
  private Integer drinkSaleCount;
  private Integer huojia;
  private Integer mishui;
  private Integer otherDrink;
  private Date createdAt;

  public YBSaleRecord() {
  }

}
