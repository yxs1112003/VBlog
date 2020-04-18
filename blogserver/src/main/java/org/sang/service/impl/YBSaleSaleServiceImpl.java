package org.sang.service.impl;

import org.sang.bean.YBGroup;
import org.sang.bean.YBSaleRecord;
import org.sang.bean.YBSaleUser;
import org.sang.mapper.YBSaleMapper;
import org.sang.service.YBSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xupeng
 * @date: 14/04/2020
 */
@Service
@Transactional
public class YBSaleSaleServiceImpl implements YBSaleService {

  @Autowired
  private YBSaleMapper ybSaleMapper;

  @Override
  public void addNewSaleInput(YBSaleRecord ybSaleRecord) {
    ybSaleMapper.addNewSaleInput(ybSaleRecord);
  }

  @Override
  public List<YBGroup> querySaleGroup() {
    return ybSaleMapper.querySaleGroup();
  }

  @Override
  public void addSale(YBSaleUser ybSaleUser) {
    ybSaleMapper.addSale(ybSaleUser);
  }

  @Override
  public List<YBSaleUser> getSaleUser(Integer page, Integer count) {
    int start = (page - 1) * count;
    return ybSaleMapper.getSaleUser(page, start, count);
  }

  @Override
  public int getUserCount() {
    return ybSaleMapper.getUserCount();
  }

  @Override
  public List<YBSaleRecord> getSaleResult(String startDate, String endDate) {
    return ybSaleMapper.getSaleResult(startDate, endDate);
  }
}
