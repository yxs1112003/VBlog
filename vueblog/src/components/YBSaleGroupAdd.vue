<template>
  <div style="text-align: left">
    <!--<el-button type="primary" @click="submitForm" size="mini">查询用户</el-button>-->
    <el-form :model="userManageModel" :label-position="left" ref="userManageModel"
             style="color:#20a0ff;font-size: 14px;">
      <el-form-item label="组名：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="groupName" placeholder="组名" size="mini">
        </el-input>
      </el-form-item>
      <el-button type="primary" @click="submitAddGroupReq" size="mini">提交</el-button>
    </el-form>
  </div>
</template>

<script>
  const axios = require('axios');

  export default {
    data() {
      return {
        groupName: ''
      }
    },
    methods: {
      submitAddGroupReq() {
        var url = '/sale/add_group?groupName=' + this.groupName;
        console.info(url)
        axios.get(url).then(resp => {
          if (resp.status == 200) {
            alert('添加成功！')
            this.clearData()
          } else {
            alert('添加失败！')
          }
        }).catch(function (error) { // 请求失败处理
          console.log(error);
        });
      }
    }
  }
</script>
