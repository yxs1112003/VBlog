package org.sang.service;

import org.sang.bean.YBGroup;
import org.sang.bean.YBSaleRecord;
import org.sang.bean.YBSaleUser;

import java.util.List;

/**
 * @author xupeng
 * @date: 14/04/2020
 */
public interface YBSaleService {
  void addNewSaleInput(YBSaleRecord ybSaleRecord);

  List<YBGroup> querySaleGroup();

  void addSale(YBSaleUser ybSaleUser);

  List<YBSaleUser> getSaleUser(Integer page, Integer count);

  int getUserCount();

  List<YBSaleRecord> getSaleResult(String startDate, String endDate);
}
