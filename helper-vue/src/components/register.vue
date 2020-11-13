<template>
  <div>
    <el-form ref="form" :model="form" label-width="100px" label-position="left" class="register">
      <el-form-item label="注册账号" class="formitem top">
        <el-input v-model="form.requester" placeholder="请输入手机号或邮箱号"></el-input>
      </el-form-item>
      <el-form-item label="验证码" class="formitem">
        <el-input v-model="form.verificationCode" placeholder="请输入验证码"></el-input>
      </el-form-item>
      <el-form-item label="设置密码" class="formitem">
        <el-input v-model="form.loginPassword" placeholder="请输入验证码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">注册</el-button>
        <el-button type="primary" @click="sendCodeToUser">获取验证</el-button>
        <el-button type="primary" @click="cancle">已有账户登录</el-button>
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
        verificationCode: "",
        loginPassword: "",
        smsEnum: "USER_REGISTER",
        requestEnum: "MAIL"
      }
    };
  },
  methods: {
    onSubmit() {
      request({
        url: "/user/register",
        method: "post",
        data: this.form
      }).then(result => {
        // console.log(result);
        if (result.data.code == 1) {
          //跳转到登录页面
          this.$router.push({ path: "/login" });
          this.$message({
            message: "注册成功，请登录！",
            type: "success"
          });
        }
      });
    },
    sendCodeToUser() {
      request({
        url: "/message/sendCodeToUser",
        method: "post",
        data: {
          requestEnum: "MAIL",
          requester: this.form.requester,
          smsEnum: "USER_REGISTER"
        }
      }).then(result => {
        if (result.data.code == 1) {
          this.$message({
            message: "验证码下发，请注意查收！",
            type: "success"
          });
        }
      });
    },
    cancle() {
      this.$router.push({ path: "/login" });
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