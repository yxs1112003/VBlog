<template>
  <div style="text-align: left">
    <el-form :model="submitModel" ref="submitModel"
             style="color:#20a0ff;font-size: 14px;" :label-position="right" label-width="120px">
      <el-form-item label="组别：">
        <el-select name="sale_group_select" size="small" :data="userGroupModel"
                   @visible-change="querySaleGroup"
                   v-model="submitModel.groupId">
          <el-option v-for="(item,index) in userGroupModel"
                     :value="item.id"
                     :key="index"
                     :label="item.groupName">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="创建时间：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.createdAt" placeholder="创建时间" size="mini">
        </el-input>
      </el-form-item>
      <el-form-item label="拜访客户(家)：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.visitName" placeholder="拜访客户" size="mini">
        </el-input>
      </el-form-item>
      <el-form-item label="销售：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.salerName" placeholder="销售名字" size="mini">
        </el-input>
      </el-form-item>
      <el-form-item label="批发：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.wholeSale" placeholder="批发" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="制高点：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.dominantPosition" placeholder="制高点" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="陈列：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.display" placeholder="陈列" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="其他：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.other" placeholder="其他" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="走线拜访：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.visitByRoute" placeholder="走线拜访" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="电话拜访：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.visitByPhone" placeholder="电话拜访" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="订单（张）：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.orderCount" placeholder="订单（张）" size="mini"></el-input>
      </el-form-item>

      <el-form-item label="水销量（箱）：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.waterSaleCount" placeholder="水销量（箱）" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="333水：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.water333" placeholder="333水" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="555水：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.water555" placeholder="555水" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="1.5L水：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.water1500" placeholder="1.5L水" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="4.5L水：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.water4500" placeholder="4.5L水" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="饮料量（箱）：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.drinkSaleCount" placeholder="饮料量" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="火咖：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.huojia" placeholder="火咖" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="蜜水：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.mishui" placeholder="蜜水" size="mini"></el-input>
      </el-form-item>
      <el-form-item label="其他饮料：">
        <el-input type="text" auto-complete="off" style="width: 300px"
                  v-model="submitModel.otherDrink" placeholder="其他饮料" size="mini"></el-input>
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
          groupId: '',
          salerName: '',
          visitName: '',
          wholeSale: '',
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
          otherDrink: '',
          createdAt: this.curr()
        },
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
    mounted() {

      // var _this = this;
      // getRequest("/currentUserName").then(function (msg) {
      //   //获取当前用户
      //   this.submitModel.salerName = msg.data;
      // }, function (msg) {
      //   this.currentUserName = '游客';
      //   getRequest("/logout")
      // });
      //
      // console.info(this.submitModel.salerName)
    },
    methods: {
      curr() {
        var date = new Date();
        var seperator1 = "-";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
          month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
          strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month + seperator1 + strDate;
        return currentdate;
      },

      submitForm() {

        console.info(this.submitModel.wholeSale)

        axios.post('/sale/sale_data_input', {
          groupId: this.submitModel.groupId,
          salerName: this.submitModel.salerName,
          visitName: this.submitModel.visitName,
          wholeSale: this.submitModel.wholeSale,
          display: this.submitModel.display,
          other: this.submitModel.other,
          dominantPosition: this.submitModel.dominantPosition,
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
          otherDrink: this.submitModel.otherDrink,
          createdAt: this.submitModel.createdAt
        }).then(resp => {
          if (resp.status == 200) {
            alert("插入成功")
          } else {
            alert("插入失败")
          }
        })
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
      },
      querySaleGroup() {
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

