<template>
	 <el-tabs v-model="activeName" @tab-click="handleClick">
	    <el-tab-pane label="全部员工" name="first">
			<el-table
				ref="multipleTable"
				:data="empList"
				tooltip-effect="dark"
				style="width: 100%"
				@selection-change="handleSelectionChange">
				<el-table-column type="selection" width="55"></el-table-column>
				<el-table-column prop="isItOnline" label="是否在线" width="120"></el-table-column>
				<el-table-column prop="name" label="姓名" width="120"></el-table-column>
				<el-table-column prop="deptId" label="部门" show-overflow-tooltip></el-table-column>
				<el-table-column prop="mobile" label="电话" show-overflow-tooltip></el-table-column>
				<el-table-column prop="mobile" label="办公室电话" show-overflow-tooltip></el-table-column>
				<el-table-column prop="mailbox" label="邮箱" show-overflow-tooltip></el-table-column>
				<el-table-column prop="emergencyContactNumber" label="紧急联系人电话" show-overflow-tooltip></el-table-column>
			</el-table>
			<div class="block">
			    <el-pagination
			      :current-page="1"
			      :page-sizes="[5, 10, 15]"
			      :page-size="5"
			      layout="total, prev, pager, next, sizes, jumper"
			      :total="5">
			    </el-pagination>
			</div>
		</el-tab-pane>
	    <el-tab-pane label="同部门" name="second">
			<el-table
				ref="multipleTable"
				:data="empList"
				tooltip-effect="dark"
				style="width: 100%"
				@selection-change="handleSelectionChange">
				<el-table-column type="selection" width="55"></el-table-column>
				<el-table-column prop="isItOnline" label="是否在线" width="120"></el-table-column>
				<el-table-column prop="name" label="姓名" width="120"></el-table-column>
				<el-table-column prop="deptId" label="部门" show-overflow-tooltip></el-table-column>
				<el-table-column prop="mobile" label="电话" show-overflow-tooltip></el-table-column>
				<el-table-column prop="mobile" label="办公室电话" show-overflow-tooltip></el-table-column>
				<el-table-column prop="mailbox" label="邮箱" show-overflow-tooltip></el-table-column>
				<el-table-column prop="emergencyContactNumber" label="紧急联系人电话" show-overflow-tooltip></el-table-column>
			</el-table>
			<div class="block">
			    <el-pagination
			      :current-page="1"
			      :page-sizes="[5, 10, 15]"
			      :page-size="5"
			      layout="total, prev, pager, next, sizes, jumper"
			      :total="5">
			    </el-pagination>
			</div>
		</el-tab-pane>
	    <el-tab-pane label="我的下属" name="third">
			<el-table
				ref="multipleTable"
				:data="empList"
				tooltip-effect="dark"
				style="width: 100%"
				@selection-change="handleSelectionChange">
				<el-table-column type="selection" width="55"></el-table-column>
				<el-table-column prop="isItOnline" label="是否在线" width="120"></el-table-column>
				<el-table-column prop="name" label="姓名" width="120"></el-table-column>
				<el-table-column prop="deptId" label="部门" show-overflow-tooltip></el-table-column>
				<el-table-column prop="mobile" label="电话" show-overflow-tooltip></el-table-column>
				<el-table-column prop="mobile" label="办公室电话" show-overflow-tooltip></el-table-column>
				<el-table-column prop="mailbox" label="邮箱" show-overflow-tooltip></el-table-column>
				<el-table-column prop="emergencyContactNumber" label="紧急联系人电话" show-overflow-tooltip></el-table-column>
			</el-table>
			<div class="block">
			    <el-pagination
				  @size-change="handleSizeChange"
				  @current-change="handleCurrentChange"
			      :current-page="1"
			      :page-sizes="[5, 10, 15]"
			      :page-size="5"
			      layout="total, prev, pager, next, sizes, jumper"
			      :total="5">
			    </el-pagination>
			</div></el-tab-pane>
	</el-tabs>
</template>

<script>
	export default {
	    data() {
	      return {
	        activeName: 'second',
			empList: [],
			multipleSelection: [],
			pageParam: {
				size: 5,
				page: 1,
				keywords: ''
			}
	      }
	    },
	    methods: {
		  handleSizeChange(val) {
			console.log(`每页 ${val} 条`);
			this.pageParam.size = val;
		  },
		  handleCurrentChange(val) {
			console.log(`当前页: ${val}`);
			this.pageParam.page = val;
		  },
	      handleClick(tab, event) {
	        console.log(tab, event);
	      },
		  handleSelectionChange(val) {
			this.multipleSelection = val;
		  },
		  empListByName(){
			  var _this=this
			  this.axios.get("http://localhost:8088/emp/empListByName"+this.pageParam)
			  .then(function(response){
			  	if(response.data.success){
			  		_this.empList = response.data.data
					_this.message.success(response.data.message);
			  	}else{
					_this.message.success(response.data.message);
				}
			  }).catch(function(error){
			  	console.log(error)
			  })
		  }
	   },
	   created() {
	   	 this.empListByName()
	   }
	}
</script>

<style>
</style>
