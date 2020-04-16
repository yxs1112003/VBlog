<template>
  <div style="text-align: left">
    <!--<el-form :groupId="submitModel2" label-position="top" ref="submitModel2"-->
             <!--style="color:#20a0ff;font-size: 14px;">-->
      <!--&lt;!&ndash;<el-form-item>&ndash;&gt;-->
        <!--&lt;!&ndash;<el-label name="username">业绩检查：</el-label>&ndash;&gt;-->
        <!--&lt;!&ndash;<el-input type="text" auto-complete="off" style="width: 300px"&ndash;&gt;-->
                  <!--&lt;!&ndash;v-groupId="submitModel.username" placeholder="姓名" size="mini">&ndash;&gt;-->
        <!--&lt;!&ndash;</el-input>&ndash;&gt;-->
      <!--&lt;!&ndash;</el-form-item>&ndash;&gt;-->

      <!--<el-button type="primary" @click="submitForm" size="mini">确定</el-button>-->
    <!--</el-form>-->
  </div>
</template>

<script>

  import {postRequest} from '../utils/api'

  const axios = require('axios');

  export default {
    // data() {
    //   return {
    //     userManageModel: {
    //       username: '',
    //       password: '',
    //       phoneNumber: '',
    //       display: '',
    //       role: '',
    //     }
    //   }
    // },
    // methods: {
    //   submitForm() {
    //     axios.post('/sale/enter_sale', {
    //       username: this.userManageModel.username,
    //       password: this.userManageModel.password,
    //       phoneNumber: this.userManageModel.phoneNumber,
    //       display: this.userManageModel.display,
    //       role: this.userManageModel.role,
    //     })
    //       .then(response => (this.info = response))
    //       .catch(function (error) { // 请求失败处理
    //         console.log(error);
    //       });
    //   }
    // }
  }
</script>
