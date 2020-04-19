<template>
  <div style="text-align: left">
    <el-form :model="submitModel" ref="submitModel"
             style="color:#20a0ff;font-size: 14px;" :label-position="right" label-width="120px">
      <el-form-item label="拜访客户(家)：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.username" placeholder="姓名" size="mini">
        </el-input>
      </el-form-item>
      <el-form-item label="批发：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.wholesale" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="制高点：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.phoneNumber" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="陈列：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.display" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="其他：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.role" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="走线拜访：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.visitByRoute" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="电话拜访：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.visitByPhone" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="订单（张）：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.orderCount" placeholder="批发" size="mini"></el-input>
      </el-form-item>

      <el-form-item label="水销量（箱）：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.waterSaleCount" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="333水：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.water333" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="555水：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.water555" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="1.5L水：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.water1500" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="4.5L水：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.water4500" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="饮料量（箱）：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.drinkSaleCount" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="火咖：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.huojia" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="蜜水：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.mishui" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="其他：">
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
          username: '',
          password: '',
          phoneNumber: '',
          display: '',
          role: '',
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
          username: this.submitModel.username,
          password: this.submitModel.password,
          phoneNumber: this.submitModel.phoneNumber,
          display: this.submitModel.display,
          role: this.submitModel.role,
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

