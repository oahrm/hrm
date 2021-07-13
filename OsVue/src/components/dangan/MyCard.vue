<template>
	<el-row>
		<div style="width: 100%;">
			<span style="float: left;margin-top: -25px;margin-bottom: -30px;"><h3>{{$store.state.employee.empName}}</h3></span>
			<span style="float: right;margin-top: -13px;margin-bottom: -30px;">
				<el-button type="primary" v-show="isShow1" @click="update">编辑</el-button>
				<el-button type="primary" v-show="isShow2" @click="add">保存</el-button>
				<el-button type="primary" v-show="isShow2" @click="qx">取消</el-button>
			</span>
		</div>
	</el-row>
	<el-row>
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
					<el-form  ref="emp" :model="emp" :label-position="right" label-width="120px" :inline="true" :rules="rules">
						<el-form-item label="移动电话:" prop="mobile">
						    <el-input v-model="emp.mobile" :disabled="flag"></el-input>
						</el-form-item>
						<el-form-item label="紧急联系人:">
						    <el-input v-model="emp.emergencyContact" :disabled="flag"></el-input>
						</el-form-item>
						<el-form-item label="紧急联系电话:" prop="emergencyContactNumber">
						    <el-input v-model="emp.emergencyContactNumber" :disabled="flag"></el-input>
						</el-form-item>
						<el-form-item label="电子邮箱:" prop="mailbox">
						    <el-input v-model="emp.mailbox" :disabled="flag"></el-input>
						</el-form-item>
					</el-form>
				  </el-collapse-item>
				</el-collapse>
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
				  <el-tag style="float: left;">家庭信息</el-tag>
				  <el-table
					  	:data="familyList"
					  	tooltip-effect="dark"
					  	style="width: 100%">
					  	<el-table-column prop="member" label="成员" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="member" label="称谓" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="workUnit" label="工作单位" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="post" label="职务" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="address" label="地址" show-overflow-tooltip></el-table-column>
						<el-table-column prop="phone" label="手机号" show-overflow-tooltip></el-table-column>
				  </el-table>
				</el-collapse>
			</el-tab-pane>
			<el-tab-pane label="工作信息" name="d">
				<el-collapse v-model="activeNames4" @change="handleChange">
				  <el-collapse-item title="工作信息" name="111" class="item">
				    <el-form :model="emp" :label-position="right"  label-width="200px" :inline="true">
						<el-form-item label="用工性质:">
						    <el-input v-model="emp.onTheJobStatus" disabled></el-input>
						</el-form-item>
						<el-form-item label="入职日期:">
						    <el-input v-model="emp.entryTime" disabled></el-input>
						</el-form-item>
						<el-form-item label="参加工作日期:">
						    <el-input v-model="emp.entryTime" disabled></el-input>
						</el-form-item>
						<el-form-item label="试用期结束日期:">
						    <el-input v-model="emp.syq" disabled></el-input>
						</el-form-item>
						<el-form-item label="工龄:">
						    <el-input v-model="emp.gl" disabled></el-input>
						</el-form-item>
						<el-form-item label="司龄:">
						    <el-input v-model="emp.sl" disabled></el-input>
						</el-form-item>
					</el-form>
					<el-form :model="contractoflabor" :label-position="right"  label-width="120px" :inline="true">
						<el-form-item label="合同开始日期:">
						    <el-input v-model="contractoflabor.signerTime" disabled></el-input>
						</el-form-item>
						<el-form-item label="合同结束日期:">
						    <el-input v-model="contractoflabor.jssignerTime" disabled></el-input>
						</el-form-item>
					</el-form>
				  </el-collapse-item>
				</el-collapse>
				<el-tabs type="border-card">
				  <el-tab-pane label="相关合同">
					  <el-table
					  	:data="ht"
					  	tooltip-effect="dark"
					  	style="width: 100%">
					  	<el-table-column prop="contractName" label="合同" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="contract" label="合同类型" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="signerTime" label="合同开始日期" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="jssignerTime" label="合同结束日期" show-overflow-tooltip></el-table-column>
					  </el-table>
				  </el-tab-pane>
				  <el-tab-pane label="工作记录">
					  <el-table
					  	:data="tgList"
					  	tooltip-effect="dark"
					  	style="width: 100%">
					  	<el-table-column prop="primaryDept" label="原部门" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="newDept" label="新部门" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="primaryStation" label="原岗位" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="newStation" label="新岗位" show-overflow-tooltip></el-table-column>
						<el-table-column prop="transferData" label="调岗时间" show-overflow-tooltip></el-table-column>
					  </el-table>
					  </el-tab-pane>
				  <el-tab-pane label="教育背景">
					  <el-table
					  	:data="jybj"
					  	tooltip-effect="dark"
					  	style="width: 100%">
					  	<el-table-column prop="schoolName" label="学校名称" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="major" label="专业" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="beginTime" label="开始日期" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="endTime" label="结束日期" show-overflow-tooltip></el-table-column>
						<el-table-column prop="education" label="学历" show-overflow-tooltip></el-table-column>
						<el-table-column prop="describes" label="详细描述" show-overflow-tooltip></el-table-column>
					  </el-table></el-tab-pane>
				  <el-tab-pane label="工作经历">
					  <el-table
					  	:data="gzjl"
					  	tooltip-effect="dark"
					  	style="width: 100%">
					  	<el-table-column prop="coName" label="公司名称" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="beginTime" label="开始日期" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="endTime" label="结束日期" show-overflow-tooltip></el-table-column>
					  	<el-table-column prop="post" label="职务" show-overflow-tooltip></el-table-column>
						<el-table-column prop="miaoshu" label="工作描述" show-overflow-tooltip></el-table-column>
						<el-table-column prop="reasonsForLeaving" label="离开原因" show-overflow-tooltip></el-table-column>
					  </el-table>
					</el-tab-pane>
				</el-tabs>
			</el-tab-pane>
			<el-tab-pane label="资产信息" name="e">
				<el-table
					:data="asss"
					tooltip-effect="dark"
					style="width: 1400px">
					<el-table-column prop="id" label="编号" show-overflow-tooltip></el-table-column>
					<el-table-column prop="name" label="名称" show-overflow-tooltip></el-table-column>
					<el-table-column prop="useDeptId" label="使用部门" show-overflow-tooltip></el-table-column>
					<el-table-column label="使用人" show-overflow-tooltip>{{$store.state.employee.empName}}</el-table-column>
					<el-table-column prop="specification" label="规格型号" show-overflow-tooltip></el-table-column>
					<el-table-column prop="assetGroup" label="资产组" show-overflow-tooltip></el-table-column>
					<el-table-column prop="status" label="状态" show-overflow-tooltip></el-table-column>
			    </el-table>
			</el-tab-pane>
			<!-- <el-tab-pane label="考勤情况" name="f">
				
			</el-tab-pane>	 -->
		</el-tabs>
	</el-row>
</template>

<script>
	export default {
	    data() {
			var chePhone = (rule, value, callback) => {
			   var reg = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/
			   if (reg.test(value)) {
			     callback()
			   } else {
			     return callback(new Error('请输入正确的手机号'))
			   }
			 };
			 var chemail = (rule, value, callback) => {
			    var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/
			    if(value){
			      if (reg.test(value)) {
			        callback()
			      } else {
			        return callback(new Error('请输入正确的邮箱'))
			      }
			    }else{
			      callback()
			    }
			  };
	      return {
			ht: [],
	        activeName: 'a',
			activeNames3: '11',
			activeNames4: '111',
			activeNames: ['1','2'],
			emp: {
				syq: '',
				sl: '',
				gl: ''
			},
			contractoflabor: {},
			flag: true,
			isShow1: true,
			isShow2: false,
			asss: [],
			myInfo: [],
			empCount: '',
			familyList: [],
			tgList: [],
			gzjl: [],
			jybj: [],
			rules: {
			   phone: [
			     {
			       required: true,
			       message: '请填写手机号',
			       trigger: 'blur'
			     },
			     { validator: chePhone, trigger: 'blur' }
			   ],
			   emergencyContactNumber:[
				   { validator: chePhone, trigger: 'blur' }
			   ],
			   mailbox:[{
				   validator: chemail, trigger: 'blur'
			   }]
			}
	      }
	    },
		methods:{
			//计算年
			getage(str) {
			      var date = new Date(str);
			      var d = new Date();
			      var age =
			        d.getFullYear() -
			        date.getFullYear() -
			        (d.getMonth() < date.getMonth() ||
			        (d.getMonth() == date.getMonth() &&
			          d.getDate() < date.getDate())
			          ? 1
			          : 0);
			      return age;
			},
			// 计算天数
			dateDiff: function (targetDate) {
			      let date2 = new Date(targetDate);
			      let date1 = new Date();
			      date1 = new Date(date1.getFullYear(), date1.getMonth(), date1.getDate());
			      date2 = new Date(date2.getFullYear(), date2.getMonth(), date2.getDate());
			      const diff = date1.getTime() - date2.getTime(); //目标时间减去当前时间
			      const diffDate = diff / (24 * 60 * 60 * 1000);
			      return diffDate;
			},
			createBeginDate(date){
			        date.setMonth(date.getMonth()+3);
			        date.toLocaleDateString()
			        var y = date.getFullYear()
			        var m = date.getMonth() + 1
			        m = m < 10 ? ('0' + m) : m
			        var d = date.getDate()
			        d = d < 10 ? ('0' + d) : d
			        const time = y + '-' + m + '-' + d
			        return time;
			},
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
					this.isShow1 = true
					this.countEmp()
					this.findEmployee()
				}else if(tab.index == 1){
					this.selectOne()
					this.findFamilyList()
					this.isShow1 = false
				}else if(tab.index == 2){
					this.findWorkList()
					this.findEmpEdu()
					this.postList()
					this.findContractoflabor()
					this.isShow1 = false
				}else if(tab.index == 3){
					this.findAllAss()
					this.isShow1 = false
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
				this.$refs['emp'].validate(valid => {
				  if (valid) {//valid
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
				  } else {
					this.findEmployee()
				    this.$message.warning("存在非法数据");
				  }
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
						_this.emp.syq = _this.createBeginDate(new Date(_this.emp.entryTime))
						_this.emp.sl = _this.getage(_this.emp.entryTime)
						_this.emp.gl = _this.dateDiff(_this.emp.entryTime)
						console.log(_this.emp.syq)
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
			},
			findFamilyList(){
				var id = this.$store.state.employee.empId
				var _this=this
				this.axios.get("http://localhost:8088/empFamilyInfo/familyList/"+id)
				.then(function(response){
					console.log(response)
					if(response.data.success){
						_this.familyList = response.data.data
					}else{
						_this.$message.error(response.data.message)
					}
				}).catch(function(error){
					console.log(error)
				})
			},
			findWorkList(){
				var id = this.$store.state.employee.empId
				var _this=this
				this.axios.get("http://localhost:8088/empWorkExperience/workList/"+id)
				.then(function(response){
					console.log(response)
					if(response.data.success){
						_this.gzjl = response.data.data
						for(var i=0;i<_this.gzjl.length;i++){
							_this.gzjl[i].beginTime = _this.formatDate(_this.gzjl[i].beginTime)
							_this.gzjl[i].endTime = _this.formatDate(_this.gzjl[i].endTime)
						}
					}else{
						_this.$message.error(response.data.message)
					}
				}).catch(function(error){
					console.log(error)
				})
			},
			findEmpEdu(){
				var id = this.$store.state.employee.empId
				var _this=this
				this.axios.get("http://localhost:8088/edu/empEduList/"+id)
				.then(function(response){
					console.log(response)
					if(response.data.success){
						_this.jybj = response.data.data
						for(var i=0;i<_this.jybj.length;i++){
							_this.jybj[i].beginTime = _this.formatDate(_this.jybj[i].beginTime)
							_this.jybj[i].endTime = _this.formatDate(_this.jybj[i].endTime)
						}
					}else{
						_this.$message.error(response.data.message)
					}
				}).catch(function(error){
					console.log(error)
				})
			},
			findContractoflabor(){
				var id = this.emp.sigerId
				var _this=this
				this.axios.get("http://localhost:8088/contractoflabor/"+id)
				.then(function(response){
					console.log(response)
					if(response.data.success){
						_this.contractoflabor = response.data.data
						_this.ht[0] = response.data.data
						_this.ht[0].signerTime = _this.formatDate(_this.ht[0].signerTime)
						_this.ht[0].jssignerTime = _this.formatDate(_this.ht[0].jssignerTime)
						_this.contractoflabor.signerTime = _this.ht[0].signerTime
						_this.contractoflabor.jssignerTime = _this.ht[0].jssignerTime
					}else{
						_this.$message.error(response.data.message)
					}
				}).catch(function(error){
					console.log(error)
				})
			},
			postList(){
				var id = this.$store.state.employee.empId
				var _this=this
				this.axios.get("http://localhost:8088/huPosttransfer/postList/"+id)
				.then(function(response){
					console.log(response)
					if(response.data.success){
						_this.tgList = response.data.data
						for(var i=0;i<_this.tgList.length;i++){
							_this.tgList[i].transferData = _this.formatDate(_this.tgList[i].transferData)
						}
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
