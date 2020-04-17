package org.sang.controller;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.sang.bean.YBGroup;
import org.sang.bean.YBInput;
import org.sang.bean.YBSaleUser;
import org.sang.service.YBInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
  private YBInputService ybInputService;

  @ApiOperation(value = "销售数据录入", notes = "")
  @PostMapping("/sale_data_input")
  public void saleInput(@RequestBody YBInput ybInput) {
    log.info("====> ybInput: {}", ybInput);
    ybInputService.addNewSaleInput(ybInput);
  }

  @ApiOperation(value = "销售组别查询", notes = "")
  @GetMapping("/query_sale_group")
  public List<YBGroup> querySaleGroup() {
    List<YBGroup> aList = ybInputService.querySaleGroup();
    log.info("=====> {}", aList.toString());
    return aList;
  }

  @ApiOperation(value = "销售组别查询", notes = "")
  @PostMapping("/add_sale")
  public void addSale(@RequestBody YBSaleUser ybSaleUser) {
    log.info("====> ybSaleUser: {}", ybSaleUser);

    ybInputService.addSale(ybSaleUser);
  }

  @ApiOperation(value = "销售组别查询", notes = "")
  @PostMapping("/query_yb_sale_user")
  public void querySale() {
    List<YBSaleUser> ybSaleUserList = ybInputService.queryYBSaleUser();
    log.info("====> query_yb_sale_user: {}", ybSaleUserList);
  }
}
