<template>
  <div style="text-align: left">
    <el-form :model="submitModel" label-position="top" ref="submitModel"
             style="color:#20a0ff;font-size: 14px;">
      <el-form-item>
        <el-label name="hhhhh">拜访客户(家)：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.visitname" placeholder="姓名" size="mini">
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-label name="hhhhh2">批发：</el-label>
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.wholesale" placeholder="批发" size="mini"></el-input>
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
        submitModel: {visitname: '', wholeSale: ''}
      }
    },
    methods: {
      submitForm2() {
        var _this = this;
        this.loading = true;
        postRequest('/sale/enter_sale', {
          visitName: this.submitModel.visitname,
          wholeSale: this.submitModel.wholesale
        }).then(resp => {
          _this.loading = false;
          console.info(resp)
          if (resp.status == 200) {
            // console.info("fkfkfkfkfk")
          }
        }, resp => {
          _this.loading = false;
          _this.$alert('找不到服务器⊙﹏⊙∥!', '失败!');
        });
      },
      submitForm() {
        axios.post('/sale/enter_sale', {
          visitName: this.submitModel.visitname,
          wholeSale: this.submitModel.wholesale
        })
          .then(response => (this.info = response))
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      }

    }
  }
</script>
