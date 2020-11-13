<template>
  <div id="app">
    <el-container>
      <el-header id="el-header">
        <div>
          <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
          >
            <el-menu-item index="index">  首页  </el-menu-item>
            <el-submenu index="java">
              <template slot="title">java学习笔记</template>
              <el-menu-item index="java-base">基础知识</el-menu-item>
              <el-menu-item index="java-spring">Spring</el-menu-item>
              <el-menu-item index="java-mybatis">MyBatis</el-menu-item>
            </el-submenu>
            <el-submenu index="mom">
              <template slot="title">中间件</template>
              <el-menu-item index="mom-rmq">RabbitMQ</el-menu-item>
              <el-menu-item index="mom-kfk">Kafka</el-menu-item>
              <el-menu-item index="mom-red">Redis</el-menu-item>
            </el-submenu>
            <el-submenu index="database">
              <template slot="title">数据库</template>
              <el-menu-item index="database-mysql">MySQL</el-menu-item>
              <el-menu-item index="database-orac">ORACLE</el-menu-item>
            </el-submenu>
            <el-menu-item index="linux" disabled>Linux</el-menu-item>
            <el-menu-item index="redirect">
              <a href="https://www.baidu.com" target="_blank">A标签跳转</a>
            </el-menu-item>
            <el-submenu index="payment">
              <template slot="title">账务管理</template>
              <el-menu-item index="payment-list">记录</el-menu-item>
            </el-submenu>
            <el-menu-item index="login">登录</el-menu-item>
            <el-menu-item index="register">注册</el-menu-item>
            <el-menu-item index="logout">退出</el-menu-item>
          </el-menu>
        </div>
      </el-header>
      <el-main id="el-main">
        <router-view></router-view>
        <vue-particles
          color="#fff"
          :particleOpacity="0.7"
          :particlesNumber="60"
          shapeType="star"
          :particleSize="4"
          linesColor="#fff"
          :linesWidth="1"
          :lineLinked="false"
          :lineOpacity="0.4"
          :linesDistance="150"
          :moveSpeed="2"
          :hoverEffect="false"
          hoverMode="bubble"
          :clickEffect="true"
          clickMode="push"
          class="lizi"
        ></vue-particles>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      activeIndex:
        this.$route.path.replace("/", "") === ""
          ? "index"
          : this.$route.path.replace("/", "") === "index" ||
            this.$route.path.replace("/", "") === "logout"
          ? "index"
          : this.$route.path.replace("/", "")
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      if (key === "login" && this.$route.path !== "/login") {
        this.$router.push({ path: "/login" });
      } else if (key === "register" && this.$route.path !== "/register") {
        this.$router.push({ path: "/register" });
      } else if (key === "logout") {
        localStorage.setItem("token", "");
        this.$message({
          message: "退出成功！",
          type: "success"
        });
        //TODO 待优化
      } else if (key.match(/^payment*/)) {
        this.$router.push({ path: "/payment/list" });
      }  else {
        //因为我要访问同一个页面，每次点击的内容不同，所以传入参数indexName配合watch: {"$route.query.indexName": function() {}} 使用， 因为路由两次不能相同，所以加了个随机数
        this.$router.push({
          path: "/index",
          query: { indexName: key, "request-id": Math.random() }
        });
      }
    }
  }
};
</script>

<style>
body {
  padding: 0px;
  margin: 0px auto;
  background: #000000;
}
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  color: #0c0c0c;
  padding: 0px;
}
.lizi {
  z-index: -20;
  width: 100%;
  height: 100%;
  position: fixed;
}

#el-header {
  width: 100%;
  text-align: center;
  padding: 0px;
  /** 页面固定在某一个地方，不随页面滑动而改变 */
  position: fixed;
  z-index: 2;
}

#el-main {
  text-align: center;
  padding: 0px;
}
</style>
