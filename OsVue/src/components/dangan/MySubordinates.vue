<template>
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
</template>

<script>
	export default{
		data(){
			return{
				empList: [],
				multipleSelection: [],
			}
		},
		methods:{
			handleSelectionChange(val) {
				this.multipleSelection = val;
			}
		}
	} 
</script>

<style>
</style>
