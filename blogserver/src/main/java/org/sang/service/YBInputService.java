package org.sang.service;

import org.sang.bean.YBGroup;
import org.sang.bean.YBInput;

import java.util.List;

/**
 * @author xupeng
 * @date: 14/04/2020
 */
public interface YBInputService {
  void addNewSaleInput(YBInput ybInput);

  List<YBGroup> querySaleGroup();
}
