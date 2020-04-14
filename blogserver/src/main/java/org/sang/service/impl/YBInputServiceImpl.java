package org.sang.service.impl;

import org.sang.bean.YBInput;
import org.sang.mapper.YBInputMapper;
import org.sang.service.YBInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xupeng
 * @date: 14/04/2020
 */
@Service
public class YBInputServiceImpl implements YBInputService {

  @Autowired
  private YBInputMapper ybInputMapper;

  @Override
  public void addNewSaleInput(YBInput ybInput) {
    ybInputMapper.addNewSaleInput(ybInput);

  }
}
