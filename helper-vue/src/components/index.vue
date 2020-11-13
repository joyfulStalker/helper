<template>
  <div>
    <!-- 用户信息 -->
    <el-card class="userInfo">
      <td>博主信息 开发中···</td>
    </el-card>
    <!-- 搜索文章 -->
    <el-card class="searchNote" body-style=" padding:8px;">
      <td style="color:black;font-weight:bold;padding:1.5px;">相关文章</td>
      <!-- Avoid using non-primitive value as key, use string/number value instead. -->
      <!-- 可以把key值改为index或者id，就可以避免这个情况（这里key最好用id，才能达到key值唯一，就地复用的原则，大大节省了dom的渲染 -->
      <!-- 此处换行问题未解决 TODO -->
      <el-link
        style="padding:1.5px;margin:0px;"
        v-for="(item,index) in noteList"
        :key="index"
        class="text item"
        type="primary"
        @click="queryById(item.id)"
      >{{index+1}}、{{publicMethod.StrLenUtil(item.noteTitle,12)}}</el-link>
    </el-card>

    <!-- 评论 -->
    <el-card class="comment">
      <td>开发中···</td>
    </el-card>

    <div v-if="noteTitle">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span v-text="noteTitle" />
          <el-button
            style="float: right; padding: 3px 0;color : blue"
            type="text"
            @click="onPrase"
          >点个赞吧</el-button>
        </div>
        <div v-html="noteContent"></div>
      </el-card>
    </div>
    <div v-else>
      <el-card class="box-card">
        <div v-html="noteContent"></div>
      </el-card>
    </div>
    <el-card class="talkRoom">
      <div slot="header">
        <el-input v-model="talkComment" style="width:70%"></el-input>
        <el-button type="success" @click="talk" size="small">动一动</el-button>
      </div>
      <div v-for="o in 4" :key="o">
        <span style="color:blue">张三:</span>今天天气好啊
        <br />
        <span style="color:rgb(130, 155, 131);font-size:12px;">5分钟前(5评)</span>
      </div>
    </el-card>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "index",
  data() {
    return {
      noteTitle: "",
      noteContent: "",
      noteList: [],
      talkComment: ""
    };
  },
  methods: {
    talk() {},
    queryById(id) {
      request({
        method: "get",
        url: "/note/detail",
        params: { id: id }
      }).then(result => {
        if (result.data.code === 1 && result.data.data !== undefined) {
          console.log(result);
          // //列表和主题内容赋值
          this.$data.noteTitle = result.data.data.noteTitle;
          this.$data.noteContent = result.data.data.noteContent;
        } else {
          this.clearDate();
        }
      });
    },
    freshDate(indexName) {
      request({
        url: "/note/list",
        method: "post",
        data: { noteCategory: indexName }
      }).then(result => {
        if (
          result.data.code === 1 &&
          result.data.data.records !== undefined &&
          result.data.data.records.length !== 0
        ) {
          //列表和主题内容赋值
          this.$data.noteList = result.data.data.records;
          //展示主题数据
          this.queryById(this.$data.noteList[0].id);
        } else {
          this.clearDate();
        }
      });
    },
    onPrase() {},
    /**
     * 初始化数据
     */
    clearDate() {
      this.$data.noteTitle = "";
      this.$data.noteContent = "暂未有数据";
      this.$data.noteList = [];
    }
  },
  watch: {
    //配合路由传参使用，监控
    "$route.query.indexName": function() {
      this.freshDate(this.$route.query.indexName);
    }
  },
  created: function() {
    this.freshDate(
      this.$route.query.indexName === undefined
        ? "index"
        : this.$route.query.indexName
    );
  },
  mounted() {
    window.addEventListener("scroll", this.handleScroll, true);
  }
};
</script>


<style>
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix {
  text-align: center;
  font-size: 20px;
}
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}

.box-card {
  background-color: rgb(199, 237, 204);
  top: 7%;
  width: 55%;
  /** TODO 如何高度在没达到屏幕高度设置屏幕高度，达到一定值后随内容变化而变化 */
  height: fix;
  /**页面最小高度 */
  min-height: 100%;
  left: 22%;
  position: absolute;
  text-align: left;
  opacity: 0.5;
}

.talkRoom {
  background-color: rgb(199, 237, 204);
  top: 7%;
  width: 15%;
  height: 92%;
  right: 7%;
  position: fixed;
  text-align: left;
  opacity: 0.5;
  z-index: 1;
}

.userInfo {
  background-color: rgb(199, 237, 204);
  top: 7%;
  width: 15%;
  height: 25%;
  left: 6%;
  position: fixed;
  text-align: left;
  opacity: 0.5;
  z-index: 1;
}
.searchNote {
  background-color: rgb(199, 237, 204);
  top: 33%;
  width: 15%;
  height: 40%;
  left: 6%;
  position: fixed;
  text-align: left;
  opacity: 0.5;
  z-index: 1;
}
.comment {
  background-color: rgb(199, 237, 204);
  top: 74%;
  width: 15%;
  height: 25%;
  left: 6%;
  position: fixed;
  text-align: left;
  opacity: 0.5;
  z-index: 1;
}
</style>