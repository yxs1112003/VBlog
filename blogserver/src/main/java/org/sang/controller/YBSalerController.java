package org.sang.controller;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.sang.bean.YBGroup;
import org.sang.bean.YBSaleRecord;
import org.sang.bean.YBSaleUser;
import org.sang.service.YBSaleRecordService;
import org.sang.service.YBSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xupeng
 * @date: 13/04/2020
 */

@Data
@Slf4j
@Controller
@RestController
@RequestMapping("/sale")
public class YBSalerController {

  @Autowired
  private YBSaleService ybSaleService;

  @Autowired
  private YBSaleRecordService ybSaleRecordService;

  @ApiOperation(value = "销售数据录入", notes = "")
  @PostMapping("/sale_data_input")
  public void saleInput(@RequestBody YBSaleRecord ybSaleRecord) {
    log.info("====> ybSaleRecord: {}", ybSaleRecord);
    ybSaleService.addNewSaleInput(ybSaleRecord);
  }

  @ApiOperation(value = "销售组别查询", notes = "")
  @GetMapping("/query_sale_group")
  public List<YBGroup> querySaleGroup() {
    List<YBGroup> aList = ybSaleService.querySaleGroup();
    log.info("=====> {}", aList.toString());
    return aList;
  }

  @ApiOperation(value = "销售组别查询", notes = "")
  @PostMapping("/add_sale")
  public void addSale(@RequestBody YBSaleUser ybSaleUser) {
    log.info("====> ybSaleUser: {}", ybSaleUser);

    ybSaleService.addSale(ybSaleUser);
  }

  @ApiOperation(value = "销售用户查询", notes = "")
  @GetMapping(value = "/get_sale_user")
  public Map<String, Object> getArticleByState(
          @RequestParam(value = "page", defaultValue = "1") Integer page,
          @RequestParam(value = "count", defaultValue = "10") Integer count) {

    log.info("=====> get_sale_user: {} , {}", page, count);

    int totalCount = ybSaleService.getUserCount();

    log.info("count:{}", count);

    List<YBSaleUser> ybSaleUserList = ybSaleService.getSaleUser(page, count);
    Map<String, Object> map = new HashMap<>();
    map.put("totalCount", totalCount);
    map.put("articles", ybSaleUserList);
    return map;
  }

  @ApiOperation(value = "业务检查", notes = "")
  @GetMapping("/get_sale_record")
  public Map<String, Object> getSaleRecord(
          @RequestParam(value = "start_date") String startDate,
          @RequestParam(value = "end_date") String endDate,
          @RequestParam(value = "page", defaultValue = "1") Integer page,
          @RequestParam(value = "count", defaultValue = "10") Integer count) {
    log.info("====> startDate:{},endDate:{}", startDate, endDate);
    int totalCount = ybSaleRecordService.getSaleRecordCountByDate(startDate, endDate);
    List<YBSaleRecord> list = ybSaleRecordService.getSaleRecord(startDate, endDate, page, count);

    Map<String, Object> map = new HashMap<>();
    map.put("articles", list);
    map.put("totalCount", totalCount);
    return map;
  }

  @ApiOperation(value = "销售数据录入", notes = "")
  @GetMapping("/add_group")
  public void addSaleGroup(@RequestParam(value = "groupName") String groupName) {
    log.info("====> groupName: {}", groupName);
    ybSaleService.addSaleGroup(groupName);
  }
}
