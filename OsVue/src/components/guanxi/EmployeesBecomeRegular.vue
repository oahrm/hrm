<template>
	<el-tabs v-model="activeName" @tab-click="handleClick">
		<el-tab-pane label="待转正员工" name="first">
			<el-table :data="EmpOersZzData" style="width: 100%" max-height="550">
				<el-table-column fixed prop="name" label="转正人员" width="">
				</el-table-column>
				<el-table-column prop="deptName" label="转正人员部门" width="">
				</el-table-column>
				<el-table-column prop="mobile" label="联系电话" width="">
				</el-table-column>
				<el-table-column prop="entryTime" label="入职日期" width="">
				</el-table-column>
				<el-table-column prop="onTheJobStatus" label="状态" width="" show-overflow-tooltip>
					<template v-slot="scope">
						<p v-if="scope.row.onTheJobStatus==0">未转正</p>
						<p v-if="scope.row.onTheJobStatuss==1">已转正</p>
					</template>
				</el-table-column>
				<el-table-column fixed="right" label="操作" width="120">
					<template #default="scope">
							<el-button type="text" @click="showEdit(scope.row)">转正</el-button>
					</template>
				</el-table-column>
			</el-table>
		</el-tab-pane>
		<el-tab-pane label="以转正员工" name="second">
			<el-table :data="EmpOersYZzData" style="width: 100%" max-height="550">
				<el-table-column fixed prop="name" label="转正人员" width="">
				</el-table-column>
				<el-table-column prop="deptName" label="转正人员部门" width="">
				</el-table-column>
				<el-table-column prop="mobile" label="联系电话" width="">
				</el-table-column>
				<el-table-column prop="entryTime" label="入职日期" width="">
				</el-table-column>
				<el-table-column prop="becomeTime" label="转正日期" width="">
				</el-table-column>
				<el-table-column prop="onTheJobStatus" label="状态" width="" show-overflow-tooltip>
					<template v-slot="scope">
						<p v-if="scope.row.onTheJobStatus==0">未转正</p>
						<p v-if="scope.row.onTheJobStatus==1">已转正</p>
					</template>
				</el-table-column>
				<el-table-column fixed="right" label="操作" width="">
					<template #default="scope">
						<el-button type="text" @click="showEdit1(scope.row)">签署合同</el-button>
					</template>
				</el-table-column>

			</el-table>
			
		</el-tab-pane>
		<el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
		<el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane>
	</el-tabs>
	 
	<el-dialog v-model="dialogFormVisible" title="员工转正信息" :before-close="cls" destroy-on-close>
		<el-form :inline="true" :model="form" ref="ruleForm" class="demo-ruleForm">
			<div style="display: flex; justify-content: space-between;">
				<el-form-item label="转正人员 :" prop="zxr">
					<el-input disabled v-model="form.name" style="width:150px"></el-input>
				</el-form-item>
		
				<el-form-item label="转正人员部门 :" prop="zxr">
					<el-input disabled v-model="form.deptName" style="width:150px"></el-input>
				</el-form-item>
			</div>
			<div style="display: flex; justify-content: space-between;">
				<el-form-item label="联系电话 :" prop="lxdh">
					<el-input disabled v-model="form.mobile" style="width:150px"></el-input>
				</el-form-item>
				<el-form-item label="入职日期 :" prop="lxdh">
					<el-input disabled v-model="form.entryTime" style="width:150px"></el-input>
				</el-form-item>
			</div>
		</el-form>
		<template #footer>
			<span class="dialog-footer">
				<el-button type="primary" @click="updateEmpOersZz(form.empId)">提交</el-button>
				<el-button>取 消</el-button>
			</span>
		</template>
	</el-dialog>
		
</template>

<script>
	export default {
		data() {
			return {
				EmpOersZzData: [],
				EmpOersYZzData: [],
				dialogFormVisible: false,
				activeName: 'first',
				form: {
					re_entry_applica: {},
					empId: '',
					name: '',
					station: '',
					deptName:'',
					mobile:'',
					entryTime:'',
					becomeTime:''
				}
			}
		},
		methods: {
			handleClick(tab, event) {
				console.log(tab, event);
			},
			showEdit(row) {
				
				console.log(row);
				this.form.empId =row.empId;
				this.form.name = row.name;
				this.form.station = row.station;
				this.form.station = row.station;
				this.form.deptName = row.deptName;
				this.form.mobile = row.name;
				this.form.signerPhone = row.phone;
				this.form.signerPost = row.station;
				
				this.dialogFormVisible = true
			},


			updateEmpOersZz(empId) {
				const _this = this
				this.$confirm('确定提交员工合同吗', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					console.log(empId)
					this.axios.put("http://localhost:8088/emp/updateEmpOersZz/"+empId)
						.then(function(response) {
							_this.axios.get("http://localhost:8088/emp/findEmpOersZz")
								.then(function(response) {
									_this.EmpOersZzData = response.data.data
									console.log(response)
								}).catch(function(error) {
									console.log(error)
								})
							console.log("-=-=-=-=-=-=-=-=-=-=-=-=")

							// _this.axios.post("http://localhost:8088/AddHuContractoflabor", _this.form)
							// 	.then(function(response) {
							// 		var hu_contractoflabor = response.data.data
							// 		_this.OfferHuContractoflaborData.push(hu_contractoflabor)
							// 		for (var key in _this.form) {
							// 			delete _this.form[key];
							// 			console.log("111")
							// 		}

							// 		console.log("7777777777777777777777")

							// 	}).catch(function(error) {
							// 		console.log(error)
							// 	})

							// AddHuContractoflabor

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

		},
		created() {
			console.log("-----------")
			const _this = this
			this.axios.get("http://localhost:8088/emp/findEmpOersZz")
				.then(function(response) {
					_this.EmpOersZzData = response.data.data
					console.log(response)
				}).catch(function(error) {
					console.log(error)
				})

			this.axios.get("http://localhost:8088/emp/findEmpOersYZz")
				.then(function(response) {
					_this.EmpOersYZzData = response.data.data
					console.log(response)
				}).catch(function(error) {
					console.log(error)
				})

		}
	};
</script>
