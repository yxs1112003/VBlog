package org.sang.controller;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.sang.bean.YBGroup;
import org.sang.bean.YBInput;
import org.sang.bean.YBSaleUser;
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

  @ApiOperation(value = "销售数据录入", notes = "")
  @PostMapping("/sale_data_input")
  public void saleInput(@RequestBody YBInput ybInput) {
    log.info("====> ybInput: {}", ybInput);
    ybSaleService.addNewSaleInput(ybInput);
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

    log.info("=====> get_sale_user: {} , {}",page,count);

    int totalCount = ybSaleService.getUserCount();
    List<YBSaleUser> ybSaleUserList = ybSaleService.getSaleUser(page, count);
    Map<String, Object> map = new HashMap<>();
    map.put("totalCount", totalCount);
    map.put("articles", ybSaleUserList);
    return map;
  }
}
