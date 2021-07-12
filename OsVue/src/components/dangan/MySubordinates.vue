<template>
	<el-input
	   placeholder="请输入姓名"
	   prefix-icon="el-icon-search"
	   v-model="pageParam.emp.name"
	   @change="byName">
	</el-input>
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
			<el-table-column prop="mobile" label="办公室电话" show-overflow-tooltip></el-table-column>
			<el-table-column prop="mailbox" label="邮箱" show-overflow-tooltip></el-table-column>
			<el-table-column prop="emergencyContactNumber" label="紧急联系人电话" show-overflow-tooltip></el-table-column>
			<el-table-column
			      fixed="right"
			      label="操作"
			      width="100">
			      <template #default="scope">
			        <el-button @click="handleSend(scope.row)" type="text" size="small">发消息</el-button>
					<el-button @click="handleSend(scope.row)" type="text" size="small">下属</el-button>
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
			multipleSelection: [],
			centerDialogVisible: false,
	        empList: [],
			pageParam: {
				size: 5,
				page: 1,
				emp: {}
			},
			num: '',
			form: {},
			msg: '',
			message: {},
	      }
	    },
	    methods: {
			byName(){
				this.empListByName()
				this.empListByDeptAndRanks()
				this.empListByParentId()
			},
			handleSelectionChange(val) {
				this.multipleSelection = val;
			},
			handleSend(row){
				//console.log(row.name+"你好")
				this.centerDialogVisible = true
				this.message.takeId = row.empId
				this.message.sendId = 1
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
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);
				this.pageParam.size = val;
				this.empListByParentId()
			},
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				this.pageParam.page = val;
				this.empListByParentId()
			},
			empListByParentId(){
				var _this=this
				this.axios.post("http://localhost:8088/emp/findByParentId",this.pageParam)//list
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
		},
		created() {
			 this.empListByParentId()
		}
		  
	}
</script>

<style>
</style>
