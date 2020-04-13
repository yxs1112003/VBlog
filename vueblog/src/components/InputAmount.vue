<template>
  <div style="text-align: left">
    <el-form :model="submitModel" label-position="top" ref="submitModel"
             style="color:#20a0ff;font-size: 14px;">
      <el-form-item>
        <!--<el-label name="hhhhh">拜访客户（家）</el-label>-->
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.visitname" placeholder="姓名" size="mini"></el-input>
        <el-button type="primary" @click="submitForm" size="mini">确定</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
  import {postRequest} from '../utils/api'

  export default {
    data() {
      return {
        submitModel: {visitname: ''}
      }
    },
    methods: {
      submitForm() {
        var _this = this;
        this.loading = true;
        postRequest('/article/sale_input', {
          visitName: this.submitModel.visitname
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
      }
    }
  }
</script>
