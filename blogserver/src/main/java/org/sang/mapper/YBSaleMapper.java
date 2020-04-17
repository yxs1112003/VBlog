package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sang.bean.YBGroup;
import org.sang.bean.YBInput;
import org.sang.bean.YBSaleUser;

import java.util.List;

/**
 * @author xupeng
 * @date: 14/04/2020
 */
@Mapper
public interface YBSaleMapper {
  int addNewSaleInput(YBInput ybInput);

  List<YBGroup> querySaleGroup();

  void addSale(YBSaleUser ybSaleUser);

  List<YBSaleUser> queryYBSaleUser();
}
