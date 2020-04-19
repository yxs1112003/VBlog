package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.YBGroup;
import org.sang.bean.YBSaleRecord;
import org.sang.bean.YBSaleUser;

import java.util.List;

/**
 * @author xupeng
 * date: 14/04/2020
 */
@Mapper
public interface YBSaleMapper {

  List<YBGroup> querySaleGroup();

  void addSale(YBSaleUser ybSaleUser);

  List<YBSaleUser> getSaleUser(@Param("page") Integer page, @Param("start") Integer start, @Param("count") Integer count);

  int getUserCount();

  List<YBSaleRecord> getSaleResult(@Param("start_date") String startDate, @Param("end_date") String endDate);

  void addSaleGroup(@Param("group_name") String groupName);
}
