package org.sang.service;

import org.sang.bean.YBGroup;
import org.sang.bean.YBSaleRecord;
import org.sang.bean.YBSaleUser;

import java.util.List;

/**
 * @author xupeng
 * @date: 14/04/2020
 */
public interface YBSaleRecordService {
  List<YBSaleRecord> getSaleRecord(String startDate, String endDate, Integer page, Integer totalCount);

  int getSaleRecordCountByDate(String startDate, String endDate);
}
