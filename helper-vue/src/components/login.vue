<template>
  <div>
    <el-form ref="form" :model="form" label-width="100px" label-position="left" class="register">
      <el-form-item label="账号" class="formitem top">
        <el-input v-model="form.requester" placeholder="请输入手机号或邮箱号"></el-input>
      </el-form-item>
      <el-form-item label="密码" class="formitem">
        <el-input v-model="form.loginPassword" placeholder="请输入验证码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="login">登录</el-button>
        <el-button type="primary" @click="register">新人注册账户</el-button>
        <el-button type="primary" @click="index">返回首页</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import request from "@/utils/request";
export default {
  name: "register",
  data() {
    return {
      form: {
        requester: "",
        smsEnum: 'USER_LOGIN',
        loginPassword: "",
        requestEnum: "MAIL"
      }
    };
  },
  methods: {
    register() {
      this.$router.push({ path: "/register" });
    },
    index() {
      this.$router.push({ path: "/index" });
    },
    login() {
      request({
        url: "/user/login",
        method: "post",
        data: this.form
      }).then(result => {
        console.log(result);
        if (result.data.code == 1 && result.data.data !== undefined) {
          localStorage.setItem("token", result.data.data.token);
          this.$router.push({ path: "/index" });
          this.$message({
            message: "登陆成功！",
            type: "success"
          });
        }
      });
    }
  }
};
</script>

<style>
.formitem {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  color: #2c3e50;
  text-align: center;
  margin-bottom: 22px;
  margin-right: 40px;
  margin-left: 40px;
}
.top {
  margin-top: 45px;
}
</style>
<style scoped>
.register {
  width: 500px;
  height: 300px;
  background: #ffffff;
  text-align: center;
  display: inline-block;
  vertical-align: middle;
  position: absolute;
  border-radius: 15px;
  margin: auto;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
}
</style>