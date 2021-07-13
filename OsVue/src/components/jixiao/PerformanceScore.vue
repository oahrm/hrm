<template>
  <el-button @click="dialogVisible = true" type="primary"
    >新建绩效评分表</el-button
  >
  <el-table
    ref="multipleTable"
    :data="tableData"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange"
  >
    <el-table-column type="selection"> </el-table-column>
    <el-table-column prop="empName" label="人员姓名"> </el-table-column>
    <el-table-column prop="deptName" label="部门"></el-table-column>
    <el-table-column
      label="考核期间"
      prop="scoreDate"
      :formatter="dateFormat"
      show-overflow-tooltip
    >
    </el-table-column>

    <el-table-column
      prop="assessmentScore"
      label="绩效分值"
      show-overflow-tooltip
      :default-sort="{ prop: 'date', order: 'descending' }"
    >
    </el-table-column>

    <el-table-column prop="gradingState" label="状态" show-overflow-tooltip>
    </el-table-column>

    <el-table-column label="操作" show-overflow-tooltip>
      <template #default="scope">
        <el-button @click="updateExamineGrade()">编辑</el-button>
        <el-button type="danger" @click="removePeIndexList(scope.row.scoreId)"
          >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>
  <!-- <div style="margin-top: 20px">
    <el-button @click="toggleSelection([tableData[1], tableData[2]])"
      >切换第二、第三行的选中状态</el-button
    >
    <el-button @click="toggleSelection()">取消选择</el-button>
  </div> -->

  <el-pagination
    @size-change="handleSizeChange"
    @current-change="handleCurrentChange"
    :current-page="pagination.pageSize"
    :page-sizes="[3, 5, 10, 15]"
    :page-size="5"
    layout="total, sizes, prev, pager, next, jumper"
    :total="this.tableDateLength"
  >
  </el-pagination>

  <el-dialog
    title="提示"
    v-model="dialogVisible"
    width="80%"
    :before-close="handleClose"
  >
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

    评分对象：
    <el-select v-model="empValue" placeholder="Select">
      <el-option
        v-for="item in empOptions"
        :key="item.empId"
        :label="item.name"
        :value="item.empId"
      >
      </el-option>
    </el-select>
    评分状态：
    <el-select v-model="gradingStatesValue" placeholder="Select">
      <el-option
        v-for="item in gradingStates"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      >
      </el-option>
    </el-select>
    <el-table :data="peIndexList" style="width: 100%">
      <el-table-column prop="nameOfIndex" label="分类"> </el-table-column>
      <el-table-column prop="type" label="指标类型"> </el-table-column>
      <el-table-column prop="indicatorDescription" label="指标描述">
      </el-table-column>
      <el-table-column prop="weight" label="权重">

      </el-table-column>
      <el-table-column label="目标值">
        <template #default="scope">
          <el-input v-model="scope.row.targetValue"  v-if="scope.row.type==1"> </el-input>
        </template>
      </el-table-column>

      <el-table-column label="完成值">
        <template #default="scope">
          <el-input
          v-show="scope.row.type==1"
            v-model="scope.row.completeValue"
            @change="scope.row.complete"
            
          ></el-input>
        </template>
      </el-table-column>

      <el-table-column label="评分">
        <template #default="scope">
          <el-input v-model="scope.row.score" style="width:30%" v-if="scope.row.type==2">
            
          </el-input>
          {{
            scope.row.type==1?(scope.row.score =scope.row.targetValue / scope.row.completeValue || ""):''
          }}
        </template>
      </el-table-column>
      <!-- prop="goal" -->
      <el-table-column label="得分">
        <template #default="scope">
          {{
            (scope.row.goal =
              scope.row.targetValue / scope.row.completeValue*(scope.row.weight/100) || "")
          }}
        </template>
      </el-table-column>
    </el-table>
    考核得分：{{ scores || "" }}
    <br />
    考核评价
    <el-input
      type="textarea"
      :rows="2"
      placeholder="请输入内容"
      v-model="textarea"
    >
    </el-input>

    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addIndexList">确 定</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script>
import moment from "moment";
export default {
  name: "App",
  data() {
    return {
      baseUrl: "http://localhost:8088" /* , */,
      // baseUrl:"http://localhost:7777/vueaxiosmvc"
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
      peIndexList: [],
      gradingStates: [
        {
          value: "0",
          label: "未考核",
        },
        {
          value: "1",
          label: "考核中",
        },
        {
          value: "2",
          label: "已完成",
        },
      ],
      gradingStatesValue: "",
      scores: 0,
      textarea: "",
      empName: "",
      deptName: "",
    };
  },
  components: {},
  methods: {
    updateExamineGrade() {},

    sumTotal(val) {
      var _this = this;
      _this.sum += val;
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

    getScore() {
      var _this = this;
      this.axios
        .post(this.baseUrl + "/peExamineGrade/findAllDicators", this.pagination)
        .then(function (response) {
          _this.tableData = response.data.data.list;
          _this.tableData.forEach((e) => {
            if (e.gradingState === 0) {
              e.gradingState = "未开始";
            } else if (e.gradingState === 1) {
              e.gradingStates = "考核中";
            } else {
              e.e.gradingState = "已结束";
            }
          });
          _this.tableDateLength = response.data.data.total;
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

    getEmps() {
      var _this = this;
      this.axios
        .post(this.baseUrl + "/emp/findEmpsByDeptId", {
          deptId: _this.deptValue,
        })
        .then(function (response) {
          _this.empOptions = response.data.data;
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    getEmpId() {
      var _this = this;
      this.axios
        .get(this.baseUrl + "/emp/findEmp/" + _this.empValue)
        .then(function (response) {
          _this.empName = response.data.data.name;
          _this.deptName = response.data.data.deptName;
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    getPeIndexList() {
      var _this = this;
      this.axios
        .post(this.baseUrl + "/peIndexList/findAllIndexList", {
          empId: this.empValue,
          deptId: this.deptValue,
        })
        .then(function (response) {
          _this.peIndexList = response.data.data;
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    removePeIndexList(id) {
      var _this = this;
      console.log(id);
      this.$confirm("确认删除？")
        .then((_) => {
          _this.axios
            .delete(_this.baseUrl + "/peExamineGrade/" + id)
            .then(function (response) {
              _this.getScore();
            })
            .catch(function (error) {
              console.log(error);
            });
        })
        .catch((_) => {});
    },

    addIndexList() {
      this.dialogVisible = false;
      const _this = this;

      _this.empOptions.forEach((e) => {
        if (e.empId == _this.empValue) {
          _this.empName = e.name;
        }
      });

      _this.deptOptions.forEach((e) => {
        if (e.deptId == _this.deptValue) {
          _this.deptName = e.name;
        }
      });

      this.axios
        .post(this.baseUrl + "/peExamineGrade/examineGrade", {
          performanceScoringObject: _this.empValue,
          gradingState: _this.gradingStatesValue,
          graderDepartment: _this.deptValue,
          assessmentScore: _this.sum,
          evaluate: _this.textarea,
          empName: _this.empName,
          deptName: _this.deptName,
        })
        .then(function (response) {})
        .catch(function (error) {
          console.log(error);
        });

      this.axios
        .post(this.baseUrl + "/peIndexList/addIndexList", _this.peIndexList)
        .then(function (response) {
          _this.$message({
            message: "添加成功",
            type: "success",
          });
          _this.getScore();
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  },
  created() {
    this.getScore();
  },
  mounted() {
    this.getEmps();
    this.getDepts();
  },
  watch: {
    // pagination.is: function () {
    //   this.getScore();
    // },
    deptValue: function () {
      this.empValue = "";
      this.getEmps();
      // this.getEmpId();
    },
    empValue: function () {
      this.getPeIndexList();
    },

    // 监控评分状态字段
    gradingStatesValue: function () {},
  },
  computed: {
    sumScore() {
      return this.peIndexList
        .map((row) => row.targetValue / row.completeValue)
        .reduce((acc, cur) => cur + acc, 0);
    },
    scores: function () {
      return this.sumScore;
    },
  },
};
</script>

<style>
</style>
