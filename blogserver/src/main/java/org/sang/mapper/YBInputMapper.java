package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sang.bean.YBGroup;
import org.sang.bean.YBInput;

import java.util.List;

/**
 * @author xupeng
 * @date: 14/04/2020
 */
@Mapper
public interface YBInputMapper {
  int addNewSaleInput(YBInput ybInput);

  List<YBGroup> querySaleGroup();
}
