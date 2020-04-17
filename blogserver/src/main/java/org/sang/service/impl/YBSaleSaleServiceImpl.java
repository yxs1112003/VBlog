package org.sang.service.impl;

import org.sang.bean.YBGroup;
import org.sang.bean.YBInput;
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
  public void addNewSaleInput(YBInput ybInput) {
    ybSaleMapper.addNewSaleInput(ybInput);
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
    return ybSaleMapper.getSaleUser(page, count);
  }

  @Override
  public int getUserCount() {
    return ybSaleMapper.getUserCount();
  }
}
