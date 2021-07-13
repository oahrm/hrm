<template>
  <el-table
    ref="multipleTable"
    :data="tableData"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange"
  >
    <el-table-column type="selection"> </el-table-column>
    <el-table-column label="人员姓名">
      <template #default="scope">{{ scope.row.date }}</template>
    </el-table-column>
    <el-table-column prop="name" label="岗位"> </el-table-column>
    <el-table-column prop="address" label="考核期间" show-overflow-tooltip>
    </el-table-column>

    <el-table-column prop="address" label="绩效分值" show-overflow-tooltip>
    </el-table-column>

    <el-table-column prop="address" label="状态" show-overflow-tooltip>
    </el-table-column>

    <el-table-column label="操作" show-overflow-tooltip> </el-table-column>
  </el-table>
  <div style="margin-top: 20px">
    <el-button @click="toggleSelection([tableData[1], tableData[2]])"
      >切换第二、第三行的选中状态</el-button
    >
    <el-button @click="toggleSelection()">取消选择</el-button>
  </div>

  <span class="demonstration">完整功能</span>
  <el-pagination
    @size-change="handleSizeChange"
    @current-change="handleCurrentChange"
    :current-page="currentPage4"
    :page-sizes="[100, 200, 300, 400]"
    :page-size="100"
    layout="total, sizes, prev, pager, next, jumper"
    :total="400"
  >
  </el-pagination>
</template>

<script>
// import moment from 'moment'
export default {
  name: "App",
  data() {
    return {
      baseUrl: "http://localhost:9999" /* , */,
      // baseUrl:"http://localhost:7777/vueaxiosmvc"
      empOptions: [],
      empValue: "",
      payment: [
        {
          value: "11",
          label: "现金",
        },
        {
          value: "12",
          label: "微信",
        },
        {
          value: "13",
          label: "支付宝",
        },
      ],
      paymentValue: "",
      originStation: [],
      originStaNameValue: "",
      originStaNoValue: "",
      destinationStation: [],
      destinationStaNameValue: "",
      destinationStaNoValue: "",
      ticketRates: "",
      price: "",
      tableData: "",
      currentPage3: 0,
	  pagination: {
        page: 1,
        pageSize: 10,
	  }
    };
  },
  components: {},
  methods: {
    handleCurrentChange(val) {
      this.page = val
    },

    dateFormat: function (row, column) {
      var date = row[column.property];

      if (date == undefined) {
        return "";
      }

      return moment(date).format("YYYY-MM-DD HH:mm:ss");
    },

    findUser: function () {
      const url = this.baseUrl;
      this.axios({
        method: "get",
        url: this.baseUrl + "/restuser",
        params: {
          id: 9,
          uname: "Fred",
          pwd: "12345678",
        },
      })
        .then(function (response) {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    findUser1: function () {
      this.axios
        .request(this.baseUrl + "/restuser/4", {
          headers: {
            "X-Requested-With": "XMLHttpRequest",
          },
        })
        .then(function (response) {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    editUser: function () {
      this.axios
        .put(
          this.baseUrl + "/restuser",
          {
            uid: "23",
            uname: "Tom",
            pwd: "12355",
          },
          {
            headers: {
              "X-Requested-With": "XMLHttpRequest",
            },
          }
        )
        .then(function (response) {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    getStation() {
      var _this = this;
      this.axios
        .request(this.baseUrl + "/station", {
          headers: {
            "X-Requested-With": "XMLHttpRequest",
          },
        })
        .then(function (response) {
          _this.originStation = response.data;
          _this.destinationStation = response.data;
          console.log(response.data);
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    getTicketRecord() {
      var _this = this;
      this.axios
        .request(this.baseUrl + "/station/tickRecord")
        .then(function (response) {
          _this.tableData = response.data;
          console.log(response.data);
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    buy() {
      const _this = this;
      this.axios
        .post(
          this.baseUrl + "/station/buy",
          {
            originStaName: this.originStaNameValue,
            destinationStaName: this.destinationStaNameValue,
            ticMoney: this.price,
            ticWay: this.paymentValue,
          },
          {
            headers: {
              "X-Requested-With": "XMLHttpRequest",
            },
          }
        )
        .then(function (response) {
          if (response.data == 1) {
            _this.$message({
              message: "购买成功",
              type: "success",
            });
            _this.getTicketRecord();
          }
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    computePrice() {
      const _this = this;

      if (this.originStaNameValue != "" && this.destinationStaNameValue != "") {
        console.log("进来了");
        for (let i = 0; i < _this.originStation.length; i++) {
          if (_this.originStaNameValue == _this.originStation[i].staName) {
            _this.originStaNoValue = _this.originStation[i].staNo;
            console.log(_this.originStation[i].staNo);
          }

          if (_this.destinationStaNameValue == _this.originStation[i].staName) {
            _this.destinationStaNoValue = _this.originStation[i].staNo;
            console.log(_this.originStation[i].staNo);
          }
        }

        _this.ticketRates =
          _this.originStaNoValue - _this.destinationStaNoValue;
        _this.ticketRates = Math.abs(_this.ticketRates);
        if (_this.ticketRates < 4) {
          _this.price = 2;
        } else if (_this.ticketRates < 8) {
          _this.price = 3;
        } else if (_this.ticketRates < 13) {
          _this.price = 4;
        } else if (_this.ticketRates < 21) {
          _this.price = 5;
        } else if (_this.ticketRates < 29) {
          _this.price = 6;
        }
        console.log(_this.ticketRates);
      }
    },
  },
  created() {
    this.getStation();
  },
  mounted() {
    this.getTicketRecord();
  },
  watch: {
    destinationStaNameValue: function () {
      this.computePrice();
    },
    originStaNameValue: function () {
      this.computePrice();
    },
  },
};
</script>

<style>
</style>
