package org.sang.service.impl;

import org.sang.bean.YBGroup;
import org.sang.bean.YBInput;
import org.sang.mapper.YBInputMapper;
import org.sang.service.YBInputService;
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
public class YBInputServiceImpl implements YBInputService {

  @Autowired
  private YBInputMapper ybInputMapper;

  @Override
  public void addNewSaleInput(YBInput ybInput) {
    ybInputMapper.addNewSaleInput(ybInput);

  }

  @Override
  public List<YBGroup>  querySaleGroup() {
    return ybInputMapper.querySaleGroup();
  }
}
