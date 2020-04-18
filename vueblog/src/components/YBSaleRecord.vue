<template>
  <div style="text-align: left">
    <el-form :model="no_use" label-position="top" ref="no_use"
             style="color:#20a0ff;font-size: 14px;">

      <el-form-item>
        <el-label name="sale_group">选择日期：</el-label>
        <el-date-picker
          v-model="start_date"
          size="mini"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="开始日期">
        </el-date-picker>
        <el-date-picker
          v-model="end_date"
          size="mini"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="结束日期">
        </el-date-picker>

        <el-button type="primary" @click="getSaleRecord" size="mini">检索</el-button>
        <el-table
          ref="multipleTable"
          :data="articles"
          tooltip-effect="dark"
          style="width: 100%;overflow-x: hidden; overflow-y: hidden;"
          max-height="390"
          @start_date="" v-loading="">
          <el-table-column
            type="selection"
            width="35" align="left" v-if="">
          </el-table-column>
          <el-table-column
            label="组别" width="140" align="left">
            <template slot-scope="scope">{{ scope.row.groupId}}</template>
          </el-table-column>
          <el-table-column
            label="销售"
            width="120" align="left">
            <template slot-scope="scope"><span style="color: #409eff;cursor: pointer" @click="itemClick(scope.row)">{{ scope.row.salerName}}</span>
            </template>
          </el-table-column>
          <el-table-column
            prop="nickname"
            label="拜访客户"
            width="120" align="left">
            <template slot-scope="scope">{{ scope.row.visitName}}</template>
          </el-table-column>
          <el-table-column
            prop="cateName"
            label="批发"
            width="120" align="left">
            <template slot-scope="scope">{{ scope.row.wholeSale}}</template>
          </el-table-column>

          <el-table-column
            prop="cateName"
            label="制高点"
            width="120" align="left">
            <template slot-scope="scope">{{ scope.row.dominantPosition}}</template>
          </el-table-column>

          <el-table-column
            prop="cateName"
            label="陈列"
            width="120" align="left">
            <template slot-scope="scope">{{ scope.row.display}}</template>
          </el-table-column>
          <el-table-column
            prop="cateName"
            label="走线拜访"
            width="120" align="left">
            <template slot-scope="scope">{{ scope.row.visitByRoute}}</template>
          </el-table-column>
          <el-table-column
            prop="cateName"
            label="电话拜访"
            width="120" align="left">
            <template slot-scope="scope">{{ scope.row.visitByPhone}}</template>
          </el-table-column>
          <el-table-column
            prop="cateName"
            label="订单量"
            width="120" align="left">
            <template slot-scope="scope">{{ scope.row.orderCount}}</template>
          </el-table-column>
          <el-table-column
            prop="cateName"
            label="水销量"
            width="120" align="left">
            <template slot-scope="scope">{{ scope.row.waterSaleCount}}</template>
          </el-table-column>

          <el-table-column
            prop="cateName"
            label="饮料销量"
            width="120" align="left">
            <template slot-scope="scope">{{ scope.row.drinkSaleCount}}</template>
          </el-table-column>


          <el-table-column label="操作" align="left" v-if="">
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

        <div class="blog_table_footer">
          <!--<el-button type="danger" size="mini" style="margin: 0px;" v-show="this.articles.length>0 && showDelete"-->
          <!--:disabled="this.selItems.length==0" @click="deleteMany">批量删除-->
          <!--</el-button>-->
          <!--<span></span>-->
          <el-pagination
            background
            :page-size="pageSize"
            layout="prev, pager, next"
            :total="totalCount" @current-change="currentChange" v-show="this.articles.length>0">
          </el-pagination>
        </div>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  const axios = require('axios');

  export default {
    data() {
      return {
        articles: [],
        totalCount: '',
        start_date: '',
        end_date: '',
        currentPage: 1,
        totalCount: -1,
        pageSize: 5,
        no_use: {

        }
      }
    },
    methods: {
      mounted: function () {
        var _this = this;
        this.loading = true;
        this.currentChange(1, this.pageSize);
        // var _this = this;
        // window.bus.$on('blogTableReload', function () {
        //   _this.loading = true;
        //   _this.loadBlogs(_this.currentPage, _this.pageSize);
        // })
      },

      currentChange(currentPage) {
        this.currentPage = currentPage;
        this.loading = true;
        console.info(this.currentPage);
        console.info(this.pageSize);
        this.getSaleRecord(currentPage, this.pageSize);
      },
      getSaleRecord(page, count) {
        var url = "/sale/get_sale_record?start_date=" + this.start_date + "&end_date=" + this.end_date + "&page=" + page + "&count=" + count;
        console.info("url:" + url);

        axios.get(url).then(resp => {
          var _this = this;
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
        });
      }
    }
  }
</script>
