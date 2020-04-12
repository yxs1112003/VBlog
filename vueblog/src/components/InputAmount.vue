<template>
  <el-card style="width: 500px" v-loading="loading">
    <el-form>
      <div style="text-align: left">
        <div>组别: {{ message }}
          <el-select slot="append" v-model="select" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">  
            </el-option>
          </el-select>
          <label>日期:</label>
          <!--todo: 缺少日期控件 -->
        </div>

        <div><p>销售名字: {{ login_form }}</p></div>
        <div><label>拜访客户(家)</label><input v-model="message" placeholder="edit me"></div>
        <div>
          <label>批发:</label><input v-model="message" placeholder="edit me">
          <label>制高点:</label><input v-model="message" placeholder="edit me">
        </div>
        <div>
          <label>陈列:</label><input v-model="message" placeholder="edit me">
          <label>其他:</label><input v-model="message" placeholder="edit me">
        </div>
      </div>
    </el-form>
  </el-card>
</template>
<script>
  import {getRequest} from '../utils/api'
  import {putRequest} from '../utils/api'
  import loginForm from '@/components/Login'

  export default {
    data() {
      return {
        emailValidateForm: {
          email: ''
        },
        loading: false
      }
    },
    mounted: function () {
      var _this = this;
      getRequest("/currentUserEmail").then(resp => {
        if (resp.status == 200) {
          _this.emailValidateForm.email = resp.data;
        }
      });
    },
    methods: {
      submitForm(formName) {
        var _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            _this.loading = true;
            putRequest("/updateUserEmail", {email: _this.emailValidateForm.email}).then(resp => {
              _this.loading = false;
              if (resp.status == 200) {
                _this.$message({type: resp.data.status, message: resp.data.msg});
              } else {
                _this.$message({type: 'error', message: '开启失败!'});
              }
            }, resp => {
              _this.loading = false;
              _this.$message({type: 'error', message: '开启失败!'});
            });
          } else {
            _this.$message({type: 'error', message: '邮箱格式不对哦!'})
            return false;
          }
        });
      },
      methods: {
        handleClick(tab, event) {
          console.log(tab, event);
        }
      },
      components: {
        "login_form": loginForm
      }
    }
  }
</script>
