<template>
  <div style="text-align: left">
    <el-form :model="submitModel" label-position="top" ref="submitModel"
             style="color:#20a0ff;font-size: 14px;">
      <el-form-item>
        <el-label name="visitName">拜访客户(家)：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.visitName" placeholder="姓名" size="mini">
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="wholeSale">批发：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.wholesale" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="salerName">制高点：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.salerName" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="display">陈列：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.display" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="other">其他：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.other" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="visitByRoute">走线拜访：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.visitByRoute" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="visitByPhone">电话拜访：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.visitByPhone" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="orderCount">订单（张）：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.orderCount" placeholder="批发" size="mini"></el-input>
      </el-form-item>

      <el-form-item>
        <el-label name="waterSaleCount">水销量（箱）：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.waterSaleCount" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="water333">333水：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.water333" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="water555">555水：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.water555" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="water1500">1.5L水：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.water1500" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="water4500">4.5L水：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.water4500" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="drinkSaleCount">饮料量（箱）：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.drinkSaleCount" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="huojia">火咖：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.huojia" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="mishui">蜜水：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.mishui" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="otherDrink">其他：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.otherDrink" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-button type="primary" @click="submitForm" size="mini">确定</el-button>
    </el-form>
  </div>
</template>

<script>

  import {postRequest} from '../utils/api'

  const axios = require('axios');

  export default {
    data() {
      return {
        submitModel: {
          visitName: '',
          wholeSale: '',
          salerName: '',
          display: '',
          other: '',
          visitByRoute: '',
          visitByPhone: '',
          orderCount: '',
          waterSaleCount: '',
          water333: '',
          water555: '',
          water1500: '',
          water4500: '',
          drinkSaleCount: '',
          huojia: '',
          mishui: '',
          otherDrink: ''
        }
      }
    },
    methods: {
      submitForm() {
        axios.post('/sale/sale_data_input', {
          visitName: this.submitModel.visitName,
          wholeSale: this.submitModel.wholeSale,
          salerName: this.submitModel.salerName,
          display: this.submitModel.display,
          other: this.submitModel.other,
          visitByRoute: this.submitModel.visitByRoute,
          visitByPhone: this.submitModel.visitByPhone,
          orderCount: this.submitModel.orderCount,
          waterSaleCount: this.submitModel.waterSaleCount,
          water333: this.submitModel.water333,
          water555: this.submitModel.water555,
          water1500: this.submitModel.water1500,
          water4500: this.submitModel.water4500,
          drinkSaleCount: this.submitModel.drinkSaleCount,
          huojia: this.submitModel.huojia,
          mishui: this.submitModel.mishui,
          otherDrink: this.submitModel.other_drink
        })
          .then(response => (this.info = response))
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      }
    }
  }
</script>
