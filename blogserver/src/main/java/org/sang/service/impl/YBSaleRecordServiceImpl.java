package org.sang.service.impl;

import org.sang.bean.YBSaleRecord;
import org.sang.mapper.YBSaleRecordMapper;
import org.sang.service.YBSaleRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xupeng
 * @date: 18/04/2020
 */
@Service
public class YBSaleRecordServiceImpl implements YBSaleRecordService {

  @Autowired
  private YBSaleRecordMapper ybSaleRecordMapper;

  @Override
  public List<YBSaleRecord> getSaleRecord(
          String startDate, String endDate, Integer page, Integer totalCount) {
    return ybSaleRecordMapper.getSaleRecord(startDate, endDate, page, totalCount);
  }

  @Override
  public int getSaleRecordCountByDate(String startDate, String endDate) {
    return ybSaleRecordMapper.getSaleRecordCountByDate(startDate, endDate);
  }
}
