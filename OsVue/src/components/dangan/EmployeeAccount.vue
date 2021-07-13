<template>
	<el-row class="tac">
		<el-col :span="5">
			<el-tree :data="depts" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
			<!-- <el-tree :data="depts" :indent="20">
			   <div class="generalClass" slot-scope="{node,data}" style="width:99%">
			      <span>
			         <span>
			            <span>
			               <i v-if="node.isLeaf" class="fa fa-male"></i>
			               <i v-else :class="node.expanded ? 'fa fa-minus-square-o':'fa fa-plus-square-o'"></i>
			               <span><strong>{{ data.name }}</strong></span>
			            </span>           
			         </span>          
			      </span>
			   </div>
			</el-tree> -->
		</el-col>
		<!-- <el-divider direction="vertical"></el-divider> -->
		<el-col :span="19">
			<el-tabs v-model="activeName" @tab-click="handleClick">
				  <el-input
				     placeholder="请输入姓名"
				     prefix-icon="el-icon-search"
				     v-model="pageParam.emp.name"
					 @change="byName">
				   </el-input>
			    <el-tab-pane label="全部员工" name="first">
					<el-table
						ref="multipleTable"
						:data="empList"
						tooltip-effect="dark"
						style="width: 100%"
						@selection-change="handleSelectionChange">
						<el-table-column type="selection" width="55"></el-table-column>
						<el-table-column prop="isItOnline" label="是否在线" width="120"></el-table-column>
						<el-table-column prop="name" label="姓名" width="100"></el-table-column>
						<el-table-column prop="sex" label="性别" show-overflow-tooltip></el-table-column>
						<el-table-column prop="post" label="岗位" show-overflow-tooltip></el-table-column>
						<el-table-column prop="deptName" label="部门" show-overflow-tooltip></el-table-column>
						<el-table-column prop="mobile" label="电话" show-overflow-tooltip></el-table-column>
						<!-- <el-table-column prop="mobile" label="办公室电话" show-overflow-tooltip></el-table-column> -->
						<el-table-column prop="mailbox" label="邮箱" show-overflow-tooltip></el-table-column>
						<el-table-column prop="emergencyContactNumber" label="紧急联系人电话" show-overflow-tooltip></el-table-column>
						<el-table-column
						      fixed="right"
						      label="操作"
						      width="100">
						      <template #default="scope">
						        <el-button @click="handleSend(scope.row)" type="text" size="small">发消息</el-button>
						      </template>
						    </el-table-column>
					</el-table>
					<div class="block">
					    <el-pagination
						@size-change="handleSizeChange"
						@current-change="handleCurrentChange"
					      :current-page="pageParam.page"
					      :page-sizes="[5, 10, 15]"
					      :page-size="pageParam.size"
					      layout="total, prev, pager, next, sizes, jumper"
					      :total="num">
					    </el-pagination>
					</div>
				</el-tab-pane>
			    <el-tab-pane label="同部门" name="second">
					<el-table
						ref="multipleTable"
						:data="empList2"
						tooltip-effect="dark"
						style="width: 100%"
						@selection-change="handleSelectionChange">
						<el-table-column type="selection" width="55"></el-table-column>
						<el-table-column prop="isItOnline" label="是否在线" width="120"></el-table-column>
						<el-table-column prop="name" label="姓名" width="100"></el-table-column>
						<el-table-column prop="sex" label="性别" show-overflow-tooltip></el-table-column>
						<el-table-column prop="post" label="岗位" show-overflow-tooltip></el-table-column>
						<el-table-column prop="deptName" label="部门" show-overflow-tooltip></el-table-column>
						<el-table-column prop="mobile" label="电话" show-overflow-tooltip></el-table-column>
						<!-- <el-table-column prop="mobile" label="办公室电话" show-overflow-tooltip></el-table-column> -->
						<el-table-column prop="mailbox" label="邮箱" show-overflow-tooltip></el-table-column>
						<el-table-column prop="emergencyContactNumber" label="紧急联系人电话" show-overflow-tooltip></el-table-column>
					</el-table>
					<div class="block">
					    <el-pagination
						  @size-change="handleSizeChange"
						  @current-change="handleCurrentChange"
					      :current-page="pageParam.page"
					      :page-sizes="[5, 10, 15]"
					      :page-size="pageParam.size"
					      layout="total, prev, pager, next, sizes, jumper"
					      :total="num2">
					    </el-pagination>
					</div>
				</el-tab-pane>
			    <el-tab-pane label="我的下属" name="third">
					<el-table
						ref="multipleTable"
						:data="empList3"
						tooltip-effect="dark"
						style="width: 100%"
						@selection-change="handleSelectionChange">
						<el-table-column type="selection" width="55"></el-table-column>
						<el-table-column prop="isItOnline" label="是否在线" width="120"></el-table-column>
						<el-table-column prop="name" label="姓名" width="100"></el-table-column>
						<el-table-column prop="sex" label="性别" show-overflow-tooltip></el-table-column>
						<el-table-column prop="post" label="岗位" show-overflow-tooltip></el-table-column>
						<el-table-column prop="deptName" label="部门" show-overflow-tooltip></el-table-column>
						<el-table-column prop="mobile" label="电话" show-overflow-tooltip></el-table-column>
						<!-- <el-table-column prop="mobile" label="办公室电话" show-overflow-tooltip></el-table-column> -->
						<el-table-column prop="mailbox" label="邮箱" show-overflow-tooltip></el-table-column>
						<el-table-column prop="emergencyContactNumber" label="紧急联系人电话" show-overflow-tooltip></el-table-column>
					</el-table>
					<div class="block">
					    <el-pagination
						  @size-change="handleSizeChange"
						  @current-change="handleCurrentChange"
					      :current-page="pageParam.page"
					      :page-sizes="[5, 10, 15]"
					      :page-size="pageParam.size"
					      layout="total, prev, pager, next, sizes, jumper"
					      :total="num3">
					    </el-pagination>
					</div>
				</el-tab-pane>
			</el-tabs>
		</el-col>
	</el-row>
	<el-dialog
	  title="提示"
	  v-model="centerDialogVisible"
	  width="30%"
	  destroy-on-close
	  center>
	  <el-form :model="form">
		  <el-input placeholder="请输入消息内容" v-model="form.msg" label="消息内容"></el-input>
	  </el-form>
	  <template #footer>
	    <span class="dialog-footer">
	      <el-button @click="centerDialogVisible = false">取 消</el-button>
	      <el-button type="primary" @click="sendMessage()">确 定</el-button>
	    </span>
	  </template>
	
	</el-dialog>
	
</template>

<script>
	export default {
	    data() {
	      return {
			defaultProps: {
			    label: 'name'
			},
			depts: {},
	        activeName: 'first',
			empList: [],
			empList2: [],
			empList3: [],
			multipleSelection: [],
			pageParam: {
				size: 5,
				page: 1,
				emp: {}
			},
			num: '',
			num2: '',
			num3: '',
			message: {},
			centerDialogVisible: false,
			form: {},
			msg: ''
	      }
	    },
	    methods: {
		  handleNodeClick(data) {
			this.pageParam.emp.deptId = data.deptId
			this.empListByName()
		  },
		  byName(){
			this.pageParam.emp.deptId = null
			this.empListByName()
			this.empListByDeptAndRanks()
			this.empListByParentId()
		  },
		  handleSizeChange(val) {
			console.log(`每页 ${val} 条`);
			this.pageParam.size = val;
			this.empListByName()
		  },
		  handleSend(row){
			  //console.log(row.name+"你好")
			  this.centerDialogVisible = true
			  this.message.takeId = row.empId
			  this.message.sendId = this.$store.state.employee.empId
		  },
		  sendMessage(){
			  this.message.message = this.form.msg
			  var _this=this
			  this.axios.post("http://localhost:8088/message/addMessage",this.message)
			  .then(function(response){
			  	console.log(response)
			  	if(response.data.success){
					_this.$message.success(response.data.message)
			  	}else{
			  		_this.$message.error(response.data.message)			
			  	}
			  }).catch(function(error){
			  	console.log(error)
			  })
			  this.centerDialogVisible = false
		  },
		  handleCurrentChange(val) {
			console.log(`当前页: ${val}`);
			this.pageParam.page = val;
			this.empListByName()
		  },
	      handleClick(tab, event) {
			 this.pageParam.page = 1
			 this.pageParam.size = 5
			 this.num = 0;
	        if(tab.index == 0){
				this.empListByName()
			}else if(tab.index == 1){
				this.empListByDeptAndRanks()
			}else{
				this.empListByParentId()
			}
	      },
		  handleSelectionChange(val) {
			this.multipleSelection = val;
		  },
		  empListByName(){
			  var _this=this
			  this.axios.post("http://localhost:8088/emp/empListByName",this.pageParam)
			  .then(function(response){
				  console.log(response)
			  	if(response.data.success){
			  		_this.empList = response.data.data.rows
					_this.num = response.data.data.total
			  	}else{
					_this.$message.error(response.data.message)
				}
			  }).catch(function(error){
			  	console.log(error)
			  })
		  },
		  empListByDeptAndRanks(){
			this.pageParam.emp.empId = this.$store.state.employee.empId
		  	var _this=this
		  	this.axios.post("http://localhost:8088/emp/findByDeptAndRanks",this.pageParam)//list
		  	.then(function(response){
		  	console.log(response)
		  	if(response.data.success){
		  		_this.empList2 = response.data.data.rows
		  		_this.num2 = response.data.data.total
		  	}else{
		  		_this.$message.error(response.data.message)		
			}
		  	}).catch(function(error){
		  		console.log(error)
		  	})
		  },
		  empListByParentId(){
			this.pageParam.emp.empId = this.$store.state.employee.empId
		  	var _this=this
		  	this.axios.post("http://localhost:8088/emp/findByParentId",this.pageParam)//list
		  	.then(function(response){
				console.log(response)
				if(response.data.success){
					_this.empList3 = response.data.data.rows
					_this.num3 = response.data.data.total
				}else{
					_this.$message.error(response.data.message)			
				}
		  	}).catch(function(error){
		  		console.log(error)
		  	})
		  },
		  deptList(){
			  var _this=this
			  this.axios.get("http://localhost:8088/dept/deptList")//list
			  .then(function(response){
			  	console.log(response)
			  	if(response.data.success){
			  		_this.depts = response.data.data
			  	}else{
			  		_this.$message.error(response.data.message)			
			  	}
			  }).catch(function(error){
			  	console.log(error)
			  })
		  }
	   },
	   created() {
	   	 this.empListByName()
		 this.deptList()
	   }
	}
</script>

<style>
</style>
