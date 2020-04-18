package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.YBGroup;
import org.sang.bean.YBSaleRecord;
import org.sang.bean.YBSaleUser;

import java.util.List;

/**
 * @author xupeng
 * @date: 14/04/2020
 * <p>
 * yb业绩表
 */
@Mapper
public interface YBSaleRecordMapper {
  List<YBSaleRecord> getSaleRecord(
          @Param("start_date") String startDate,
          @Param("end_date") String endDate,
          @Param("start") Integer start,
          @Param("count") Integer count
  );

  int getSaleRecordCountByDate(
          @Param("start_date") String startDate,
          @Param("end_date") String endDate
  );
}
