<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="员工离职" name="first">
		<el-table :data="EmpOersYZzData" style="width: 100%" max-height="550">
			<el-table-column fixed prop="name" label="公司人员" width="">
			</el-table-column>
			<el-table-column prop="deptName" label="人员所属部门" width="">
			</el-table-column>
			<el-table-column prop="mobile" label="联系电话" width="">
			</el-table-column>
			<el-table-column prop="entryTime" label="入职日期" width="">
			</el-table-column>
			<el-table-column prop="becomeTime" label="转正日期" width="">
			</el-table-column>
			<el-table-column prop="quitStatus" label="状态" width="" show-overflow-tooltip>
				<template v-slot="scope">
					<p v-if="scope.row.quitStatus==0">工作中</p>
					<p v-if="scope.row.quitStatus==1">已离职</p>
				</template>
			</el-table-column>
			<el-table-column fixed="right" label="操作" width="">
				<template #default="scope">
					<el-button type="text" @click="showEdit(scope.row)">离职</el-button>
				</template>
			</el-table-column>
		
		</el-table>
	</el-tab-pane>
    <el-tab-pane label="已离职人员" name="second">
		<el-table :data="EmpOersYLZData" style="width: 100%" max-height="550">
			<el-table-column fixed prop="name" label="公司人员" width="">
			</el-table-column>
			<el-table-column prop="deptName" label="人员所属部门" width="">
			</el-table-column>
			<el-table-column prop="mobile" label="联系电话" width="">
			</el-table-column>
			<el-table-column prop="entryTime" label="入职日期" width="">
			</el-table-column>
			<el-table-column prop="becomeTime" label="转正日期" width="">
			</el-table-column>
			<el-table-column prop="quitStatus" label="状态" width="" show-overflow-tooltip>
				<template v-slot="scope">
					<p v-if="scope.row.quitStatus==0">工作中</p>
					<p v-if="scope.row.quitStatus==1">已离职</p>
				</template>
			</el-table-column>
			<el-table-column fixed="right" label="操作" width="">
				<template #default="scope">
					<el-button type="text" @click="showEdit(scope.row)">离职</el-button>
				</template>
			</el-table-column>
		
		</el-table>
		</el-tab-pane>
  </el-tabs>
  <div>
  	<el-dialog v-model="dialogFormVisible" title="员工离职申请" :before-close="cls" destroy-on-close>
  		<el-form :inline="true" :model="form" ref="ruleForm" class="demo-ruleForm">
  			<div style="display: flex; justify-content: space-between;">
  				<el-form-item label="离职人员 :" prop="zxr">
  					<el-input disabled v-model="form.name" style="width:150px"></el-input>
  				</el-form-item>
  	
  				<el-form-item label="离职部门 :" prop="zxr">
  					<el-input v-model="form.deptName" style="width:150px"></el-input>
  				</el-form-item>
  			</div>
  			<div style="display: flex; justify-content: space-between;">
  				<el-form-item label="联系电话 :" prop="lxdh">
  					<el-input disabled v-model="form.mobile" style="width:150px"></el-input>
  				</el-form-item>
  				<el-form-item label="入职日期 :" prop="lxdh">
  					<el-input disabled v-model="form.entryTime" style="width:150px"></el-input>
  				</el-form-item>
  				<el-form-item label="转正日期 :" prop="lxdh">
  					<el-input disabled v-model="form.becomeTime" style="width:150px"></el-input>
  				</el-form-item>
  			</div>
  		</el-form>
  		<template #footer>
  			<span class="dialog-footer">
  				<el-button type="primary" @click="updateEmp_HuLiZhi(form.empId)">提交</el-button>
  				<el-button>取 消</el-button>
  			</span>
  		</template>
  	</el-dialog>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        activeName: 'first',
		dialogFormVisible: false,
		EmpOersYZzData: [],
		EmpOersYLZData:[],
		form: {
			empId: '',
			name: '',
			station: '',
			deptName: '',
			mobile: '',
			entryTime: '',
			becomeTime: ''
		}
      }
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      },
			showEdit(row) {
				console.log(row);
				this.form.empId = row.empId;
				this.form.name = row.name;
				this.form.deptName = row.deptName;
				this.form.entryTime = row.entryTime;
				this.form.becomeTime = row.becomeTime;
				this.form.signerPost = row.station;
				this.dialogFormVisible = true
			},
	  updateEmp_HuLiZhi(empId) {
	  	const _this = this
	  	this.$confirm('确定提交员工合同吗', '提示', {
	  		confirmButtonText: '确定',
	  		cancelButtonText: '取消',
	  		type: 'warning'
	  	}).then(() => {
	  		console.log(empId)
	  		console.log("-=-=--=-=-=")
	  		this.axios.put("http://localhost:8088/emp/updateEmp_HuLiZhi/" + empId)
	  			.then(function(response) {
	  				_this.axios.get("http://localhost:8088/emp/findEmpHuLiZhi")
	  					.then(function(response) {
	  						_this.EmpOersYZzData = response.data.data
	  						console.log(response)
	  					}).catch(function(error) {
	  						console.log(error)
	  					})
						_this.axios.get("http://localhost:8088/emp/findEmpHuYLiZhi")
							.then(function(response) {
								_this.EmpOersYLZData = response.data.data
								console.log(response)
							}).catch(function(error) {
								console.log(error)
							})
	  				_this.dialogFormVisible = false
	  			}).catch(function(error) {
	  				console.log(error)
	  			})
	  	}).catch(function() {
	  		this.$message({
	  			type: 'error',
	  			message: '取消提交'
	  		});
	  	})
	  }
	  // 
    },
	created() {
		console.log("-----------")
		const _this = this
	
		this.axios.get("http://localhost:8088/emp/findEmpHuLiZhi")
			.then(function(response) {
				_this.EmpOersYZzData = response.data.data
				console.log(response)
			}).catch(function(error) {
				console.log(error)
			})
			
			this.axios.get("http://localhost:8088/emp/findEmpHuYLiZhi")
				.then(function(response) {
					_this.EmpOersYLZData = response.data.data
					console.log(response)
				}).catch(function(error) {
					console.log(error)
				})
		}
		
  };
</script>
