package org.sang.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.sang.bean.YBInputEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
public class EnterSaleController {

  @PostMapping("/enter_sale")
  public Map<String, Object> saleInput(@RequestBody YBInputEntity ybInputEntity) {
    log.info("====> ybInputEntity: {}", ybInputEntity);
    return null;
  }
}
