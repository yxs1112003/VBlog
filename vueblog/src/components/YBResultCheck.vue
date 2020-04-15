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
        }
      }
    },
    methods: {
      submitForm() {
        axios.post('/sale/enter_sale', {
          visitName: this.submitModel.visitName,
          wholeSale: this.submitModel.wholeSale,
          salerName: this.submitModel.salerName,
          display: this.submitModel.display,
          other: this.submitModel.other,
        })
          .then(response => (this.info = response))
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      }
    }
  }
</script>
