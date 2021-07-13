<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="考核指标项" name="first">
      选择部门：
      <el-select v-model="deptValue" placeholder="请选择">
        <el-option
          v-for="item in deptOptions"
          :key="item.deptId"
          :label="item.name"
          :value="item.deptId"
        >
        </el-option>
      </el-select>
      <el-button @click="openIndicator()" type="primary">新建指标项</el-button>

      <el-table :data="peAssessmentIndicators" style="width: 100%">
        <el-table-column prop="nameOfIndex" label="指标名称"> </el-table-column>
        <el-table-column prop="indicatorDescription" label="描述">
        </el-table-column>
        <el-table-column prop="type" label="指标类型"> </el-table-column>
        <el-table-column prop="weight" label="权重%"> </el-table-column>
        <el-table-column prop="score" label="是否启用">
          <template #default="scope">
            <el-tooltip
              :content="'Switch value: ' + scope.row.initiateMode"
              placement="top"
            >
              <el-switch
                v-model="scope.row.initiateMode"
                active-color="#13ce66"
                inactive-color="#ff4949"
                active-value="1"
                inactive-value="0"
              >
              </el-switch>
            </el-tooltip>
          </template>
        </el-table-column>
        <el-table-column>
          <template #default="scope">
            <el-button @click="updateIndictorShow(scope.row.indexNumber)"
              >编辑</el-button
            >
            <el-button
              type="danger"
              @click="removeIndictor(scope.row.indexNumber)"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>

      <el-dialog
        title="增加指标项"
        v-model="indicatorsFlag"
        width="60%"
        :before-close="handleClose"
      >
        指标名称：<el-input v-model="nameOfIndex" style="width: 30%"></el-input
        ><br />
        指标描述：<el-input
          v-model="indicatorDescription"
          style="width: 30%"
        ></el-input
        ><br />
        指标类型：
        <el-select v-model="indicatorValue" placeholder="请选择">
          <el-option
            v-for="item in indicators"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          >
          </el-option>
        </el-select>
        <br />

        权重%
        <el-input v-model="weight" style="width:30%"> </el-input>

        <br />
        是否启用：
        <el-tooltip :content="'Switch value: ' + initiateMode" placement="top">
          <el-switch
            v-model="initiateMode"
            active-color="#13ce66"
            inactive-color="#ff4949"
            active-value="1"
            inactive-value="0"
          >
          </el-switch>
        </el-tooltip>
        <template #footer>
          <span class="dialog-footer">
            <el-button
              type="primary"
              @click="
                addOrUpdateFlag === true ? addIndicator() : updateIndictor()
              "
              >提交</el-button
            >
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
import moment from "moment";
import { ElMessage } from "element-plus";
export default {
  name: "App",
  data() {
    return {
      baseUrl: "http://localhost:8088" /* , */,
      // baseUrl:"http://localhost:7777/vueaxiosmvc"
      activeName: "first",
      empOptions: [],
      empValue: "",
      deptOptions: [],
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
      tableDateLength: "",
      dialogVisible: false,
      peAssessmentIndicators: [],
      indicatorsFlag: false,

      indexNumber: "",
      nameOfIndex: "",
      indicatorDescription: "",
      type: "",
      initiateMode: "",
      deptId: "",
      weight: "",
      index:'',

      indicators: [
        {
          value: "1",
          label: "定量",
        },
        {
          value: "2",
          label: "定性",
        },
      ],
      indicatorValue: "",
      indicatorObject: "",
      addOrUpdateFlag: true,
    };
  },
  components: {},
  methods: {
    updateIndictorShow(indexNumber) {
      this.indicatorsFlag = true;
      this.addOrUpdateFlag = false;
      this.index = indexNumber
      var _this = this;
      this.axios
        .post(this.baseUrl + "/peAssessmentIndicators/selectOne/" + indexNumber)
        .then(function (response) {
          _this.indicatorObject = response.data.data;
          _this.nameOfIndex = _this.indicatorObject.nameOfIndex;

          // if (_this.indicatorObject.type == 1) {
          //   _this.indicatorValue = "定量";
          // } else if(_this.indicatorObject.type == 2){
          //   _this.indicatorValue = "定性";
          // }
          _this.initiateMode = _this.indicatorObject.initiateMode;
          console.log("类型值",_this.indicatorObject.initiateMode)
          _this.indicatorDescription =
            _this.indicatorObject.indicatorDescription;
          _this.weight = _this.indicatorObject.weight
          _this.index = _this.indicatorObject.indexNumber
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    updateIndictor() {
      var _this = this;
      if(_this.initiateMode==='定量'){
        _this.initiateMode=1
      }else if(_this.initiateMode==='定性'){
        _this.initiateMode=2
      }
      console.log("类型值",_this.initiateMode)
      console.log("进入了修改方法")
      this.axios
        .put(this.baseUrl + "/peAssessmentIndicators/", {
          indexNumber:_this.index,
          nameOfIndex: _this.nameOfIndex,
          indicatorDescription: _this.indicatorDescription,
          type: _this.indicatorValue,
          initiateMode: _this.initiateMode,
          deptId: _this.deptValue,
          weight:_this.weight
        })
        .then(function (response) {
          if (response.status == "200")
            _this.$message({
              message: "修改成功",
              type: "success",
            });
          _this.getPeAssessmentIndicators();
          _this.indicatorsFlag = false;
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    openIndicator() {
      this.addOrUpdateFlag = true;
      if (this.deptValue == "") {
        ElMessage.warning({
          message: "请先选择部门",
          type: "warning",
        });
        return;
      }
      this.indicatorsFlag = true;
    },

    handleSizeChange(val) {
      this.pagination.pageSize = val;
      this.getScore();
    },

    handleClose(done) {
      this.$confirm("确认关闭？")
        .then((_) => {
          this.dialogVisible = false;
          done();
        })
        .catch((_) => {});
    },

    dateForma: function (row, column) {
      var date = row[column.property];

      if (date == undefined) {
        return "";
      }

      return moment(date).format("YYYY-MM-DD HH:mm:ss");
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

    addIndicator() {
            var _this = this;
      if(_this.initiateMode=='定量'){
        _this.initiateMode=1
      }else if(_this.initiateMode=='定性'){
        _this.initiateMode=2
      }
      this.axios
        .post(this.baseUrl + "/peAssessmentIndicators/", {
          nameOfIndex: _this.nameOfIndex,
          indicatorDescription: _this.indicatorDescription,
          type: _this.indicatorValue,
          initiateMode: _this.initiateMode,
          deptId: _this.deptValue,
        })
        .then(function (response) {
          if (response.status == "200")
            _this.$message({
              message: "添加成功",
              type: "success",
            });
          _this.getPeAssessmentIndicators();
          _this.indicatorsFlag = false;
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    getPeAssessmentIndicators() {
      var _this = this;
      this.axios
        .post(this.baseUrl + "/peAssessmentIndicators/findAllDicators", {
          deptId: _this.deptValue,
        })
        .then(function (response) {
          _this.peAssessmentIndicators = response.data.data;
          if (_this.peAssessmentIndicators != null) {
            _this.peAssessmentIndicators.forEach((element) => {
              if (element.completeValue == 1) {
                element.completeValue = true;
              } else {
                element.completeValue = false;
              }
              if (element.type == 1) {
                element.type = "定量";
              } else if(element.type == 2){
                element.type = "定性";
              }
            });
          }
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    getDepts() {
      var _this = this;
      this.axios
        .get(this.baseUrl + "/dept/deptList")
        .then(function (response) {
          _this.deptOptions = response.data.data;
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    removeIndictor(indexNumber) {
      var _this = this;
      this.$confirm("确认删除？")
        .then((_) => {
          _this.axios
            .delete(_this.baseUrl + "/peAssessmentIndicators/" + indexNumber)
            .then(function (response) {
              _this.getPeAssessmentIndicators();
            })
            .catch(function (error) {
              console.log(error);
            });
        })
        .catch((_) => {});
    },
  },
  created() {
    this.getPeAssessmentIndicators();
  },
  mounted() {
    this.getDepts();
  },
  watch: {
    dialogVisible: function () {
      this.getPeAssessmentIndicators();
    },

    deptValue: function () {
      this.getPeAssessmentIndicators();
    },
  },
};
</script>

<style>
</style>
