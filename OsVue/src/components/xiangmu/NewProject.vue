<template>
	<el-tabs v-model="activeName" @tab-click="handleClick">
		<el-tab-pane label="项目信息" name="first">
			项目信息
			<el-form ref="form" :model="form" label-width="100px">
				<div style="display: flex;flex-wrap: wrap;justify-content: space-around;align-content:space-around">
					<div style="width: 400px;margin: 20px 0px;">
						<el-form-item label="项目名称:">
							<el-input type="text" v-model="form.pName"></el-input>
						</el-form-item>
					</div>
					<div style="width: 400px;margin: 20px 0px;">
						<el-form-item label="项目类型:">
							<el-input type="text" v-model="form.pType"></el-input>
						</el-form-item>
					</div>
					<div style="width: 400px;margin: 20px 0px;">
						<el-form-item label="工作类型:">
							<el-input type="text" v-model="form.pWorktype"></el-input>
						</el-form-item>
					</div>
					<div style="width: 400px;margin: 20px 0px;">

						<el-form-item label="项目合同:">
							<el-input type="textarea" v-model="form.pContract"></el-input>
						</el-form-item>
					</div>
					<div style="width: 400px;margin: 20px 0px;">
						<el-form-item label="项目总进度:">
							<el-input type="text" v-model="form.pProgress"></el-input>
						</el-form-item>
					</div>
					<div style="width: 400px;margin: 20px 0px;">
						<el-form-item label="建议书:">
							<el-input type="textarea" v-model="form.pProposal"></el-input>
						</el-form-item>
					</div>
					<div style="width: 400px;margin: 20px 0px;">
						<el-form-item label="计划开始时间:">
							<el-input type="text" v-model="form.pStarttime"></el-input>
						</el-form-item>
					</div>
					<div style="width: 400px;margin: 20px 0px;">
						<el-form-item label="计划结束时间:">
							<el-input type="textarea" v-model="form.pEndtime"></el-input>
						</el-form-item>
					</div>
					<div style="width: 400px;margin: 20px 0px;">
						<el-form-item label="客户名称:">
							<el-input type="text" v-model="form.pCustomer"></el-input>
						</el-form-item>
					</div>
					<div style="width: 400px;margin: 20px 0px;">
						<el-form-item label="客户联系方式:">
							<el-input type="text" v-model="form.pCphone"></el-input>
						</el-form-item>
					</div>
					<div style="width: 400px;margin: 20px 0px;">
						<el-form-item label="项目负责人:">
							<el-input type="text" v-model="form.pEId"></el-input>
						</el-form-item>
					</div>
					<div style="width: 400px;margin: 20px 0px;">

					</div>
				</div>
				<el-button type="primary" @click="add1()">保存</el-button>
				
			</el-form>
		</el-tab-pane>
		<el-tab-pane label="项目任务" name="second">
			项目任务
			<!-- <div>
				<el-table border height="441" :header-cell-style="{background:'#ebebeb'}" stripe :data="tableData"
					tooltip-effect="dark" style="width: 100%">
			
					<el-table-column prop="sid" label="阶段编号" show-overflow-tooltip></el-table-column>
					<el-table-column prop="sname" label="阶段名称" show-overflow-tooltip></el-table-column>
					<el-table-column prop="sdescription" label="阶段描述" show-overflow-tooltip></el-table-column>
			
					<el-table-column label="操作" width="300px">
						<template #default="scope">
							<el-button type="primary" @click="">删除</el-button>
						</template>
					</el-table-column>
			
				</el-table>
				<el-button type="primary" @click="addstage()">添加</el-button>
			</div> -->
		</el-tab-pane>
		<el-tab-pane label="任务阶段" name="third">

			任务阶段
			<div>
				<el-table border height="441" :header-cell-style="{background:'#ebebeb'}" stripe :data="tableData"
					tooltip-effect="dark" style="width: 100%">

					<el-table-column prop="sid" label="阶段编号" show-overflow-tooltip></el-table-column>
					<el-table-column prop="sname" label="阶段名称" show-overflow-tooltip></el-table-column>
					<el-table-column prop="sdescription" label="阶段描述" show-overflow-tooltip></el-table-column>

					<el-table-column label="操作" width="300px">
						<template #default="scope">
							<el-button type="primary" @click="dels(scope.row.sid)">删除</el-button>
						</template>
					</el-table-column>

				</el-table>
				<el-button type="primary" @click="addstage()">添加</el-button>
			</div>
		</el-tab-pane>
	</el-tabs>

	<!-- 添加班级信息 -->
	<el-dialog title="添加项目阶段" v-model="addVisible" width="60%" :before-close="addhandleClose">
		<el-form :model="form2" ref="form2" label-width="100px" class="demo-form2">
			<div style="display: flex;flex-wrap: wrap;justify-content: space-around;">
				<div style="width: 300px;padding-top: 20px;padding-right: 40px;">
					<el-form-item label="阶段名称">
						<el-input v-model="form2.sName"></el-input>
					</el-form-item>
				</div>
			</div>
			<div style="display: flex;flex-wrap: wrap;justify-content: space-around;">
				<div style="width: 300px;padding-top: 20px;padding-right: 40px;">
					<el-form-item label="阶段表述">
						<el-input v-model="form2.sDescription"></el-input>
					</el-form-item>
				</div>
			</div>
			<el-button type="primary" @click="addstage1()">确定</el-button>

		</el-form>
	</el-dialog>

	<!-- 添加班级信息 -->
	<!-- <el-dialog title="" v-model="addVisible" width="60%" :before-close="addhandleClose">
		<el-form :model="form2" ref="form2" label-width="100px" class="demo-ruleForm">
			<div style="display: flex;flex-wrap: wrap;justify-content: space-around;">
				<div style="display: flex;flex-wrap: wrap;justify-content: space-around;">
					<div style="width: 300px;padding-top: 20px;padding-right: 40px;">
						<el-form-item label="班级名称" prop="sId">
							<el-input v-model="rform2.sId"></el-input>
						</el-form-item>
					</div>
				</div>
				<div style="display: flex;flex-wrap: wrap;justify-content: space-around;">
					<div style="width: 300px;padding-top: 20px;padding-right: 40px;">
						<el-form-item label="班级名称" prop="sName">
							<el-input v-model="rform2.sName"></el-input>
						</el-form-item>
					</div>
				</div>
				<div style="display: flex;flex-wrap: wrap;justify-content: space-around;">
					<div style="width: 300px;padding-top: 20px;padding-right: 40px;">
						<el-form-item label="班级名称" prop="sDescription">
							<el-input v-model="rform2.sDescription"></el-input>
						</el-form-item>
					</div>
				</div>
		</el-form>
		<el-button type="primary" @click="addstage1()">确定</el-button>
	</el-dialog> -->
</template>

<script>
	export default {
		data() {
			return {
				activeName: 'first',
				form: {
					pId: '',
					pName: '',
					pType: '',
					pWorktype: '',
					pContract: '',
					pProgress: '',
					pProposal: '',
					pStatus: '',
					pFstatus: '',
					pStarttime: '',
					pEndtime: '',
					pBegain: '',
					pCustomer: '',
					pCphone: '',
					pEId: ''
				},
				form1: {
					pId: '',
					pName: '',
					pType: '',
					pWorktype: '',
					pContract: '',
					pProgress: '',
					pProposal: '',
					pStatus: '',
					pFstatus: ''
				},
				form2: {
					sId: '',
					sName: '',
					sDescription: ''
				},
				tableData: [],
				Data1s: [],
				Data2s: [],
				Data3s: [],
				Data4s: [],
				addVisible: false,
			};
		},
		methods: {
			clo() {
				this.$refs.ruleForm.resetFields();
				Object.assign(this.ruleForm, this.$options.data().ruleForm);
			},
			dels(id){
				var sid=id;
				const _this = this
				console.log(id+"------------------------------------------------------")
				this.axios.delete("http://localhost:8088/deleteById", sid)
					.then(function(response) {
						_this.axios.get("http://localhost:8088/selectAllprstage")
							.then(function(response) {
								//console.log(response)
								_this.tableData = response.data.data
							}).catch(function(error) {
								console.log(error)
							})
				
					}).catch(function(error) {
						console.log(error)
					})
			},
			add1() {
				const _this = this
				
				this.axios.post("http://localhost:8088/insertpr_project", this.form)
					.then(function(response) {
						console.log(response.data)
				
					}).catch(function(error) {
						console.log(error)
					})
			
			},
			addstage() {
				this.addVisible = true;
			},
			addstage1() {
				console.log(this.form2)
				const _this = this
				this.axios.post("http://localhost:8088/insertprstage", this.form2)
					.then(function(response) {
						_this.axios.get("http://localhost:8088/selectAllprstage")
							.then(function(response) {
								//console.log(response)
								_this.tableData = response.data.data
								console.log(_this.tableData)
								_this.addVisible = false;
								
							}).catch(function(error) {
								console.log(error)
							})
					}).catch(function(error) {
						console.log(error)
					})
			},
		},
		created() {
			const _this = this
			this.axios.get("http://localhost:8088/selectAllprstage")
				.then(function(response) {
					//console.log(response)
					_this.tableData = response.data.data
					console.log(_this.tableData)
				}).catch(function(error) {
					console.log(error)
				})
		}
	};
</script>