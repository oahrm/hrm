<template>
	  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="考核指标项" name="first">
		<el-button>新建指标项</el-button>
		<el-table :data="peAssessmentIndicators" style="width: 100%">
      <el-table-column prop="nameOfIndex" label="指标名称"> </el-table-column>
	  <el-table-column prop="nameOfIndex" label="描述"> </el-table-column>
      <el-table-column prop="type" label="指标类型"> </el-table-column>

      <el-table-column prop="score" label="是否启用">
		<template #default="scope">
          <el-input v-model="scope.row.completeValue"></el-input>
        </template>
      </el-table-column>

      <el-table-column prop="goal" label="得分">
      </el-table-column>
    </el-table>
	</el-tab-pane>
    <el-tab-pane label="配置管理" name="second">配置管理</el-tab-pane>
    <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
    <el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane>
  </el-tabs>
</template>

<script>
import moment from 'moment'
export default {
  name: "App",
  data() {
    return {
      baseUrl: "http://localhost:8088" /* , */,
      // baseUrl:"http://localhost:7777/vueaxiosmvc"
      empOptions: [],
      empValue: "",
      paymentValue: "",
      originStation: [],
      originStaNameValue: "",
      originStaNoValue: "",
      destinationStation: [],
      destinationStaNameValue: "",
      destinationStaNoValue: "",
      ticketRates: "",
      price: "",
      tableData: [],
      pagination: {
        page: 1,
        pageSize: 10,
      },
      tableDateLength:'',
      dialogVisible: false,
      peAssessmentIndicators:[]
    };
  },
  components: {},
  methods: {

    handleSizeChange(val){
      this.pagination.pageSize=val
      this.getScore();
    },

    handleClose(done) {
      this.$confirm("确认关闭？")
        .then((_) => {
          this.dialogVisible = false
          done();
        })
        .catch((_) => {});
    },

     dateForma:function(row,column){

        var date = row[column.property];

        if(date == undefined){return ''};

        return moment(date).format("YYYY-MM-DD HH:mm:ss")

    },

    handleCurrentChange(val) {
      this.pagination.page = val;
      this.getScore();
    },

    dateFormat: function (row, column) {
      var date = row[column.property];

      if (date == undefined) {
        return "";
      }

      return moment(date).format("YYYY-MM-DD HH:mm:ss");
    },


    getPeAssessmentIndicators() {
      var _this = this;
      this.axios
        .post(this.baseUrl + "/peAssessmentIndicators/findAllDicators", {
			deptId:1
		})
        .then(function (response) {
          _this.peAssessmentIndicators = response.data.data.list;
          _this.tableDateLength = response.data.data.total
          console.log(_this.tableData);
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    getEmps(){

       var _this = this;
      this.axios
        .get(this.baseUrl + "/emp/empList")
        .then(function (response) {
          _this.empOptions = response.data.data.list;
          console.log("员工列表",_this.empOptions);
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    getPeIndexList() {
      var _this = this;
      this.axios
        .post(this.baseUrl + "/peIndexList/findAll", {
          empId:1,
        })
        .then(function (response) {
          _this.peIndexList = response.data.data;
          console.log("值",_this.peIndexList);
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    removePeIndexList(id){
         var _this = this;
         console.log(id)
        this.$confirm("确认删除？")
        .then((_) => {
                _this.axios
        .delete(_this.baseUrl + "/peExamineGrade/"+id)
        .then(function (response) {
          
          this.getScore();
          done()
        })
        .catch(function (error) {
          console.log(error);
        });
          
        })
        .catch((_) => {});
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
    this.getPeAssessmentIndicators();
  },
  mounted() {
    // this.getTicketRecord();
    this.getEmps();
  },
  watch: {
    // pagination.is: function () {
    //   this.getScore();
    // },
    dialogVisible: function () {
      this.getPeIndexList();
    },
  },
};
</script>

<style>
</style>
