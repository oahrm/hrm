<template>
	<el-tabs v-model="activeName" @tab-click="handleClick">
	    <el-tab-pane label="基本信息" name="a">
			<el-collapse v-model="activeNames" @change="handleChange">
			  <el-collapse-item title="基本信息" name="1" class="item">
			    <el-form :model="emp" :label-position="right"  label-width="120px" :inline="true">
					<el-form-item label="岗位:">
					    <el-input v-model="emp.post" disabled></el-input>
					</el-form-item>
					<el-form-item label="职级:">
					    <el-input v-model="emp.ranks" disabled></el-input>
					</el-form-item>
					<el-form-item label="职责描述:">
					    <el-input v-model="emp.jobDescription" disabled></el-input>
					</el-form-item>
					<el-form-item label="办公地点:">
					    <el-input v-model="emp.officeLocation" disabled></el-input>
					</el-form-item>
					<el-form-item label="状态:">
					    <el-input v-model="emp.onTheJobStatus" disabled></el-input>
					</el-form-item>
					<el-form-item label="直接上级:">
					    <el-input v-model="emp.parentId" disabled></el-input>
					</el-form-item>
					<el-form-item label="下属人数:">
					    <el-input v-model="empCount" disabled></el-input>
					</el-form-item>
				</el-form>
			  </el-collapse-item>
			  <el-collapse-item title="通讯信息" name="2">
				<el-form :model="emp" :label-position="right" label-width="120px" :inline="true">
					<el-form-item label="移动电话:">
					    <el-input v-model="emp.mobile" :disabled="flag"></el-input>
					</el-form-item>
					<el-form-item label="紧急联系人:">
					    <el-input v-model="emp.emergencyContact" :disabled="flag"></el-input>
					</el-form-item>
					<el-form-item label="紧急联系人电话:">
					    <el-input v-model="emp.emergencyContactNumber" :disabled="flag"></el-input>
					</el-form-item>
					<el-form-item label="电子邮箱:">
					    <el-input v-model="emp.mailbox" :disabled="flag"></el-input>
					</el-form-item>
				</el-form>
			  </el-collapse-item>
			</el-collapse>
			<el-button type="primary" v-show="isShow1" @click="update">修改</el-button>
			<el-button type="primary" v-show="isShow2" @click="add">保存</el-button>
			<el-button type="primary" v-show="isShow2" @click="qx">取消</el-button>
		</el-tab-pane>
	    <el-tab-pane label="工作历程" name="b">
			
		</el-tab-pane>
	    <el-tab-pane label="个人信息" name="c">
			<el-collapse v-model="activeNames3" @change="handleChange">
			  <el-collapse-item title="个人信息" name="11" class="item">
			    <el-form :model="myInfo" :label-position="right"  label-width="200px" :inline="true">
					<el-form-item label="出生日期:">
					    <el-input v-model="myInfo.dateOfBirth" disabled></el-input>
					</el-form-item>
					<el-form-item label="民族:">
					    <el-input v-model="myInfo.nation" disabled></el-input>
					</el-form-item>
					<el-form-item label="籍贯:">
					    <el-input v-model="myInfo.nativePlace" disabled></el-input>
					</el-form-item>
					<el-form-item label="政治面貌:">
					    <el-input v-model="myInfo.politicalOutlook" disabled></el-input>
					</el-form-item>
					<el-form-item label="身份证:">
					    <el-input v-model="myInfo.idCard" disabled></el-input>
					</el-form-item>
					<el-form-item label="入党日期:">
					    <el-input v-model="myInfo.dateOfJoiningTheParty" disabled></el-input>
					</el-form-item>
					<el-form-item label="学历:">
					    <el-input v-model="myInfo.education" disabled></el-input>
					</el-form-item>
					<el-form-item label="学位:">
					    <el-input v-model="myInfo.academicDegree" disabled></el-input>
					</el-form-item>
					<el-form-item label="现住地:">
					    <el-input v-model="myInfo.currentResidence" disabled></el-input>
					</el-form-item>
				</el-form>
			  </el-collapse-item>
			</el-collapse>
		</el-tab-pane>
		<el-tab-pane label="工作信息" name="d">
			<el-collapse v-model="activeNames4" @change="handleChange">
			  <el-collapse-item title="工作信息" name="111" class="item">
			    <el-form :model="emp" :label-position="right"  label-width="120px" :inline="true">
					<el-form-item label="用工性质:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="入职日期:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="合同开始日期:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="试用期结束日期:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="合同结束日期:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="参加工作日期:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="工龄:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="司龄:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
				</el-form>
			  </el-collapse-item>
			</el-collapse>
		</el-tab-pane>
		<el-tab-pane label="资产信息" name="e">
			<el-table
				ref="multipleTable"
				:data="asss"
				tooltip-effect="dark"
				style="width: 100%">
				<el-table-column prop="id" label="编号" width="120"></el-table-column>
				<el-table-column prop="name" label="名称" width="100"></el-table-column>
				<el-table-column prop="useDeptId" label="使用部门" show-overflow-tooltip></el-table-column>
				<el-table-column label="使用人" show-overflow-tooltip>{{$store.state.employee.empName}}</el-table-column>
				<el-table-column prop="specification" label="规格型号" show-overflow-tooltip></el-table-column>
				<el-table-column prop="assetGroup" label="资产组" show-overflow-tooltip></el-table-column>
				<el-table-column prop="status" label="状态" show-overflow-tooltip></el-table-column>
			</el-table>
		</el-tab-pane>
		<el-tab-pane label="考勤情况" name="f">
			
		</el-tab-pane>
				
	</el-tabs>
</template>

<script>
	export default {
	    data() {
	      return {
	        activeName: 'a',
			activeNames3: '11',
			activeNames4: '111',
			formData:{},
			activeNames: ['1','2'],
			emp: {},
			flag: true,
			isShow1: true,
			isShow2: false,
			asss: [],
			myInfo: [],
			empCount: ''
	      }
	    },
		methods:{
			formatDate(date) {
			  var d = new Date(date),
			    month = '' + (d.getMonth() + 1),
			    day = '' + d.getDate(),
			    year = d.getFullYear();
			
			  if (month.length < 2) month = '0' + month;
			  if (day.length < 2) day = '0' + day;
			
			  return [year, month, day].join('-');
			},
			handleClick(tab, event) {
				if(tab.index == 0){
					this.countEmp()
					this.findEmployee()
				}else if(tab.index == 1){
					
				}else if(tab.index == 2){
					this.selectOne()
				}else if(tab.index == 3){
					
				}else if(tab.index == 4){
					this.findAllAss()
				}else{
					
				}
			},
			update(){
				this.isShow1 = false
				this.isShow2 = true
				this.flag = false
			},
			add(){
				this.isShow1 = true
				this.isShow2 = false
				this.flag = true
				var id = this.$store.state.employee.empId
				var _this=this
				if(_this.emp.onTheJobStatus == "实习"){
					_this.emp.onTheJobStatus = 0
				}else{
					_this.emp.onTheJobStatus = 1
				}
				this.axios.put("http://localhost:8088/emp/updateEmp",_this.emp)
				.then(function(response){
					console.log(response)
					if(response.data.success){
						_this.$message.success(response.data.message)
					}else{
						_this.$message.error("操作失败")
					}
				}).catch(function(error){
					console.log(error)
				})
			},
			qx(){
				this.isShow1 = true
				this.isShow2 = false
				this.flag = true
				this.findEmployee()
			},
			findAllAss(){
				var id = this.$store.state.employee.empId
				var _this=this
				this.axios.get("http://localhost:8088/ass/findByEmpId/"+id)
				.then(function(response){
					console.log(response)
					if(response.data.success){
						_this.asss = response.data.data
					}else{
						_this.$message.error(response.data.message)
					}
				}).catch(function(error){
					console.log(error)
				})
			},
			selectOne(){
				var id = this.$store.state.employee.empId
				var _this=this
				this.axios.get("http://localhost:8088/empInfo/selectOne/"+id)
				.then(function(response){
					console.log(response)
					if(response.data.success){
						_this.myInfo = response.data.data
						_this.myInfo.dateOfBirth = _this.formatDate(_this.myInfo.dateOfBirth)
						_this.myInfo.dateOfJoiningTheParty = _this.formatDate(_this.myInfo.dateOfJoiningTheParty)
					}else{
						_this.$message.error(response.data.message)
					}
				}).catch(function(error){
					console.log(error)
				})
			},
			findEmployee(){
				var id = this.$store.state.employee.empId
				var _this=this
				this.axios.get("http://localhost:8088/emp/findEmp/"+id)
				.then(function(response){
					console.log(response)
					if(response.data.success){
						_this.emp = response.data.data
						if(_this.emp.onTheJobStatus == 0){
							_this.emp.onTheJobStatus = "实习"
						}else{
							_this.emp.onTheJobStatus = "正式"
						}
						
					}else{
						_this.$message.error(response.data.message)
					}
				}).catch(function(error){
					console.log(error)
				})
			},
			countEmp(){
				var id = this.$store.state.employee.empId
				var _this=this
				this.axios.get("http://localhost:8088/emp/empCount/"+id)
				.then(function(response){
					console.log(response)
					if(response.data.success){
						_this.empCount = response.data.data
					}else{
						_this.$message.error(response.data.message)
					}
				}).catch(function(error){
					console.log(error)
				})
			}
		},
		created() {
			this.countEmp()
			this.findEmployee()
		}
	}
</script>

<style>
	.item{
		color: blue;
		font-size: 20px;
	}
</style>
