<template>
  <div>
    <el-form
      class="queryForm"
      :inline="true"
      ref="form"
      :model="form"
      label-width="80px"
      size="small"
    >
      <el-form-item label="收款人">
        <el-input v-model="form.payee" style="width: 180px;"></el-input>
      </el-form-item>
      <el-form-item label="付款人">
        <el-input v-model="form.drawee" style="width: 180px;"></el-input>
      </el-form-item>

      <el-form-item label="收款日期">
        <el-date-picker
          v-model="payTime"
          type="daterange"
          align="right"
          unlink-panels
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
          :picker-options="pickerOptions"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="单号">
        <el-input v-model="form.name" style="width: 180px;"></el-input>
      </el-form-item>
      <el-form-item label="付款方式">
        <el-select v-model="form.paidType" placeholder="请选择" clearable="true">
          <el-option
            v-for="item in paidTypes"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="是否结清">
        <el-select v-model="form.isSettled" placeholder="请选择" clearable="true">
          <el-option
            v-for="item in settledStatus"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="paymentList">查询</el-button>
      </el-form-item>
    </el-form>

    <el-table
      class="payment"
      :data="dataList"
      :show-summary="true"
      :border="true"
      :stripe="true"
      :row-class-name="tableRowClassName"
    >
      <el-table-column prop="flowNo" align="center" header-align="center" label="单号" width="170px"></el-table-column>
      <el-table-column
        prop="paidType"
        align="center"
        header-align="center"
        label="付款方式"
        width="80px"
      ></el-table-column>
      <el-table-column
        prop="totalCost"
        align="center"
        header-align="center"
        label="总需付款"
        width="80px"
      ></el-table-column>
      <el-table-column
        prop="actualPaid"
        align="center"
        header-align="center"
        label="实际付款"
        width="80px"
      ></el-table-column>
      <el-table-column
        prop="isSettled"
        align="center"
        header-align="center"
        label="是否结清"
        width="80px"
      ></el-table-column>
      <el-table-column
        prop="payTime"
        align="center"
        header-align="center"
        label="付款时间"
        width="160px"
      ></el-table-column>
      <el-table-column prop="drawee" align="center" header-align="center" label="付款人" width="70px"></el-table-column>
      <el-table-column prop="payee" align="center" header-align="center" label="收款人" width="70px"></el-table-column>
      <el-table-column prop="version" align="center" header-align="center" label="版本号" width="70px"></el-table-column>
      <el-table-column prop="remark" align="left" header-align="left" label="备注" width="230px"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import request from "@/utils/request";
//处理时间格式
import moment from "moment";

export default {
  name: "paymentList",
  data() {
    return {
      dataList: [],
      form: {
        feeType: 1001,
        name: "",
        paidType: "",
        isSettled: "",
        payee: "",
        drawee: "",
        startPayTime: "",
        endPayTime: "",
      },
      paidTypes: [
        {
          value: 1001,
          label: "支付宝",
        },
        {
          value: 1002,
          label: "微信",
        },
        {
          value: 1003,
          label: "现金",
        },
      ],
      settledStatus: [
        {
          value: 1001,
          label: "已结清",
        },
        {
          value: 1002,
          label: "未结清",
        },
      ],
      payTime: [],
      pickerOptions: {
        shortcuts: [
          {
            text: "最近一周",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit("pick", [start, end]);
            },
          },
          {
            text: "最近一个月",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
              picker.$emit("pick", [start, end]);
            },
          },
          {
            text: "最近三个月",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
              picker.$emit("pick", [start, end]);
            },
          },
        ],
      },
    };
  },
  methods: {
    tableRowClassName({ row, rowIndex }) {
      if (rowIndex % 2 === 1) {
        return "warning-row";
      } else {
        return "success-row";
      }
    },
    paymentList() {
      console.log(this.$data.payTime);
      if (this.$data.payTime != undefined && this.$data.payTime.length !== 0) {
        this.$data.form.startPayTime = moment(this.$data.payTime[0]).format(
          "YYYY-MM-DD HH:mm:ss"
        );
        this.$data.form.endPayTime = moment(this.$data.payTime[1]).format(
          "YYYY-MM-DD HH:mm:ss"
        );
      } else {
        this.$data.form.startPayTime = null;
        this.$data.form.endPayTime = null;
      }

      request({
        method: "post",
        url: "/paymentFee/list",
        data: this.$data.form,
      }).then((result) => {
        if (result.data.code === 1 && result.data.data !== undefined) {
          console.log(result.data.data);
          // //列表和主题内容赋值
          this.$data.dataList = result.data.data.records;
        } else {
        }
      });
    },
  },
  created: function () {
    this.paymentList();
  },
};
</script>

<style>
.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
.queryForm {
  background-color: rgb(255, 255, 255);
  top: 8.8%;
  width: 76%;
  left: 12%;
  height: 16%;
  position: absolute;
  text-align: left;
  opacity: 0.5;
  z-index: 2;
}
.payment {
  background-color: rgb(0, 0, 0);
  top: 25%;
  left: 12%;
  width: 76%;
  /** TODO 如何高度在没达到屏幕高度设置屏幕高度，达到一定值后随内容变化而变化 */
  height: fix;
  /**页面最小高度 */
  min-height: 73.4%;
  position: absolute;
  text-align: left;
  opacity: 0.5;
  z-index: 2;
}
</style>