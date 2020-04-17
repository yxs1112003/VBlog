package org.sang.service;

import org.sang.bean.YBGroup;
import org.sang.bean.YBInput;
import org.sang.bean.YBSaleUser;

import java.util.List;

/**
 * @author xupeng
 * @date: 14/04/2020
 */
public interface YBSaleService {
  void addNewSaleInput(YBInput ybInput);

  List<YBGroup> querySaleGroup();

  void addSale(YBSaleUser ybSaleUser);

  List<YBSaleUser> getSaleUser(Integer page, Integer count);

  int getUserCount();
}
