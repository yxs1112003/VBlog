<template>
  <div style="text-align: left">
    <!--<el-button type="primary" @click="submitForm" size="mini">查询用户</el-button>-->
    <el-form :model="userManageModel" :label-position="left" ref="userManageModel"
             style="color:#20a0ff;font-size: 14px;">
      <el-form-item label="姓名：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="userManageModel.username" placeholder="姓名" size="mini">
        </el-input>
      </el-form-item>
      <el-form-item label="密码：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="userManageModel.password" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="电话：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="userManageModel.phoneNumber" placeholder="批发" size="mini"></el-input>
      </el-form-item>

      <el-form-item label="组别：">
        <el-select name="sale_group_select" size="small" :data="userGroupModel"
                   @visible-change="querySaleGroup"
                   v-model="userManageModel.groupId">
          <el-option v-for="(item,index) in userGroupModel"
                     :value="item.id"
                     :key="index"
                     :label="item.groupName">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="角色：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="userManageModel.role" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-button type="primary" @click="submitForm" size="mini">提交</el-button>
    </el-form>
  </div>
</template>

<script>
  const axios = require('axios');

  export default {
    data() {
      return {
        userManageModel: {
          username: '',
          password: '',
          phoneNumber: '',
          display: '',
          role: '',
          groupId: ''
        },
        userGroupModel: {groupName: '', id: ''}
      }
    },
    methods: {

      created: function () {
        this.querySaleGroup();
      },
      clearData() {
        this.userManageModel.username = '';
        this.userManageModel.password = '';
        this.userManageModel.phoneNumber = '';
        this.userManageModel.display = '';
        this.userManageModel.role = '';
        this.userManageModel.groupId = '';
      },
      submitForm() {
        axios.post('/sale/add_sale', {
          username: this.userManageModel.username,
          password: this.userManageModel.password,
          phoneNumber: this.userManageModel.phoneNumber,
          display: this.userManageModel.display,
          role: this.userManageModel.role,
          groupId: this.userManageModel.groupId
        }).then(resp => {
          if (resp.status == 200) {
            alert('添加成功！')
            this.clearData()
          } else {
            alert('添加失败！')
          }
        })
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      }
      , querySaleGroup() {
        var _this = this;
        axios.get("/sale/query_sale_group", {
          id: this.userGroupModel.id,
          groupName: this.userGroupModel.groupName
        }).then(resp => {
            _this.loading = false;
            if (resp.status == 200) {
              _this.userGroupModel = resp.data;
            } else {
              _this.$message({type: 'error', message: '数据加载失败!'});
            }
            console.info(this.usergroupModel);

          }, resp => {
            _this.loading = false;
            if (resp.response.status == 403) {
              var data = resp.response.data;
              _this.$message({type: 'error', message: data});
            }
          }
        );
      }
    }
  }
</script>
