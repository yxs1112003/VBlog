<template>
  <div style="text-align: left">
    <el-form :model="userManageModel" label-position="top" ref="userManageModel"
             style="color:#20a0ff;font-size: 14px;">

      <el-form-item>
        <el-label name="sale_group">选择日期：</el-label>
        <el-date-picker
          v-model="date1"
          size="mini"
          type="daterange"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
          :default-time="['00:00:00', '23:59:59']">
        </el-date-picker>

        <el-button type="primary" @click="submitForm" size="mini">检索</el-button>
        <el-table
          ref="multipleTable"
          :data="articles"
          tooltip-effect="dark"
          style="width: 100%;overflow-x: hidden; overflow-y: hidden;"
          max-height="390"
          @selection-change="handleSelectionChange" v-loading="loading">
          <el-table-column
            type="selection"
            width="35" align="left" v-if="showEdit || showDelete">
          </el-table-column>
          <el-table-column
            label="姓名"
            width="120" align="left">
            <template slot-scope="scope"><span style="color: #409eff;cursor: pointer" @click="itemClick(scope.row)">{{ scope.row.username}}</span>
            </template>
          </el-table-column>
          <el-table-column
            label="组别" width="140" align="left">
            <template slot-scope="scope">{{ scope.row.groupId}}</template>
          </el-table-column>
          <el-table-column
            prop="nickname"
            label="角色"
            width="120" align="left">
            <template slot-scope="scope">{{ scope.row.role}}</template>
          </el-table-column>
          <el-table-column
            prop="cateName"
            label="操作占位符"
            width="120" align="left">
          </el-table-column>
          <el-table-column label="操作" align="left" v-if="showEdit || showDelete">
            <template slot-scope="scope">
              <el-button
                size="mini"
                @click="handleEdit(scope.$index, scope.row)" v-if="showEdit">编辑
              </el-button>
              <el-button
                size="mini"
                @click="handleRestore(scope.$index, scope.row)" v-if="showRestore">还原
              </el-button>
              <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)" v-if="showDelete">删除
              </el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-form-item>
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
          groupId: '',
        },
        date1: '',
        userGroupModel: {groupName: '', id: ''}
      }
    },
    methods: {
      mounted: function () {
        this.querySaleGroup();
        this.loadBlogs(1, this.pageSize);
      },

      submitForm() {
        console.info(this.date1);

        axios.post('/sale/check_result_by_date', {
          username: this.userManageModel.username,
          password: this.userManageModel.password,
          phoneNumber: this.userManageModel.phoneNumber,
          display: this.userManageModel.display,
          role: this.userManageModel.role,
          groupId: this.userManageModel.groupId
        }).then(response => (this.info = response))
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      }, querySaleGroup() {
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
      }, loadBlogs(page, count) {
        var _this = this;
        var url = '';
        var url = "/sale/get_sale_user?page=" + page + "&count=" + count;

        getRequest(url).then(resp => {
          _this.loading = false;
          if (resp.status == 200) {
            _this.articles = resp.data.articles;
            _this.totalCount = resp.data.totalCount;
          } else {
            _this.$message({type: 'error', message: '数据加载失败!'});
          }
        }, resp => {
          _this.loading = false;
          if (resp.response.status == 403) {
            _this.$message({type: 'error', message: resp.response.data});
          } else {
            _this.$message({type: 'error', message: '数据加载失败!'});
          }
        }).catch(resp => {
          //压根没见到服务器
          _this.loading = false;
          _this.$message({type: 'error', message: '数据加载失败!'});
        })
      }
    }
  }
</script>
