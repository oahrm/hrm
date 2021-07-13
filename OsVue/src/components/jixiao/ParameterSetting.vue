<template>
	  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="考核指标项" name="first">
		<el-select v-model="deptValue" placeholder="请选择">
			<el-option
			v-for="item in deptOptions"
			:key="item.deptId"
			:label="item.name"
			:value="item.deptId">
			</el-option>
		</el-select>
		<el-button @click="indicatorsFlag=true">新建指标项</el-button>



		<el-table :data="peAssessmentIndicators" style="width: 100%">
      	<el-table-column prop="nameOfIndex" label="指标名称"> </el-table-column>
	  	<el-table-column prop="indicatorDescription" label="描述"> </el-table-column>
      	<el-table-column prop="type" label="指标类型"> </el-table-column>

      	<el-table-column prop="score" label="是否启用">
			<template #default="scope">

				<el-tooltip :content="'Switch value: ' + scope.row.completeValue" placement="top">
					<el-switch
						v-model="scope.row.completeValue"
						active-color="#13ce66"
						inactive-color="#ff4949"
						active-value="1"
						inactive-value="0"
					>
					</el-switch>
				</el-tooltip>


			</template>
      	</el-table-column>

    </el-table>

		<el-dialog
			title="提示"
			v-model="indicatorsFlag"
			width="60%"
			:before-close="handleClose">
			<span>这是一段信息</span>
			<template #footer>
				<span class="dialog-footer">
				<el-button @click="dialogVisible = false">取 消</el-button>
				<el-button type="primary" @click="dialogVisible = false">确 定</el-button>
				</span>
			</template>
		</el-dialog>
	</el-tab-pane>
    <el-tab-pane label="配置管理" name="second">基础设置</el-tab-pane>
    <el-tab-pane label="角色管理" name="third"></el-tab-pane>
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
	  deptOptions:[],
	  deptValue: "",
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
      peAssessmentIndicators:'',
	  indicatorsFlag:false
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
			deptId:_this.deptValue
		})
        .then(function (response) {
          _this.peAssessmentIndicators = response.data.data;
		  _this.peAssessmentIndicators.forEach(element => {
			  if(element.completeValue==1){
				  element.completeValue = true
			  }else{
				  element.completeValue = false
			  } 
		  });
          console.log("peInd",_this.peAssessmentIndicators);
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    getDepts(){
       var _this = this;
      this.axios
        .get(this.baseUrl + "/dept/deptList")
        .then(function (response) {
          _this.deptOptions = response.data.data
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
    this.getDepts();
  },
  watch: {
    // pagination.is: function () {
    //   this.getScore();
    // },
    dialogVisible: function () {
      this.getPeIndexList();
    },

	deptValue:function(){
		this.getPeAssessmentIndicators();
	}
  },
};
</script>

<style>
</style>
