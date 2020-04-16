<template>
  <div style="text-align: left">
    <!--<el-form :model="submitModel2" label-position="top" ref="submitModel2"-->
             <!--style="color:#20a0ff;font-size: 14px;">-->
      <!--&lt;!&ndash;<el-form-item>&ndash;&gt;-->
        <!--&lt;!&ndash;<el-label name="visitName">业绩检查：</el-label>&ndash;&gt;-->
        <!--&lt;!&ndash;<el-input type="text" auto-complete="off" style="width: 300px"&ndash;&gt;-->
                  <!--&lt;!&ndash;v-model="submitModel.visitName" placeholder="姓名" size="mini">&ndash;&gt;-->
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
    //       visitName: '',
    //       wholeSale: '',
    //       salerName: '',
    //       display: '',
    //       other: '',
    //     }
    //   }
    // },
    // methods: {
    //   submitForm() {
    //     axios.post('/sale/enter_sale', {
    //       visitName: this.userManageModel.visitName,
    //       wholeSale: this.userManageModel.wholeSale,
    //       salerName: this.userManageModel.salerName,
    //       display: this.userManageModel.display,
    //       other: this.userManageModel.other,
    //     })
    //       .then(response => (this.info = response))
    //       .catch(function (error) { // 请求失败处理
    //         console.log(error);
    //       });
    //   }
    // }
  }
</script>
