<template>
	 <el-tabs v-model="activeName" @tab-click="handleClick">
	    <el-tab-pane label="全部员工" name="first">
			<el-table
				ref="multipleTable"
				:data="tableData"
				tooltip-effect="dark"
				style="width: 100%"
				@selection-change="handleSelectionChange">
				<el-table-column type="selection" width="55"></el-table-column>
				<el-table-column prop="name" label="是否在线" width="120"></el-table-column>
				<el-table-column prop="name" label="姓名" width="120"></el-table-column>
				<el-table-column prop="address" label="部门" show-overflow-tooltip></el-table-column>
				<el-table-column prop="address" label="电话" show-overflow-tooltip></el-table-column>
				<el-table-column prop="address" label="办公室电话" show-overflow-tooltip></el-table-column>
				<el-table-column prop="address" label="邮箱" show-overflow-tooltip></el-table-column>
				<el-table-column prop="address" label="紧急联系人电话" show-overflow-tooltip></el-table-column>
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
				:data="tableData"
				tooltip-effect="dark"
				style="width: 100%"
				@selection-change="handleSelectionChange">
				<el-table-column type="selection" width="55"></el-table-column>
				<el-table-column prop="name" label="是否在线" width="120"></el-table-column>
				<el-table-column prop="name" label="姓名" width="120"></el-table-column>
				<el-table-column prop="address" label="部门" show-overflow-tooltip></el-table-column>
				<el-table-column prop="address" label="电话" show-overflow-tooltip></el-table-column>
				<el-table-column prop="address" label="办公室电话" show-overflow-tooltip></el-table-column>
				<el-table-column prop="address" label="邮箱" show-overflow-tooltip></el-table-column>
				<el-table-column prop="address" label="紧急联系人电话" show-overflow-tooltip></el-table-column>
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
	    <el-tab-pane label="我的下属" name="third"><el-table
				ref="multipleTable"
				:data="tableData"
				tooltip-effect="dark"
				style="width: 100%"
				@selection-change="handleSelectionChange">
				<el-table-column type="selection" width="55"></el-table-column>
				<el-table-column prop="name" label="是否在线" width="120"></el-table-column>
				<el-table-column prop="name" label="姓名" width="120"></el-table-column>
				<el-table-column prop="address" label="部门" show-overflow-tooltip></el-table-column>
				<el-table-column prop="address" label="电话" show-overflow-tooltip></el-table-column>
				<el-table-column prop="address" label="办公室电话" show-overflow-tooltip></el-table-column>
				<el-table-column prop="address" label="邮箱" show-overflow-tooltip></el-table-column>
				<el-table-column prop="address" label="紧急联系人电话" show-overflow-tooltip></el-table-column>
			</el-table>
			<div class="block">
			    <el-pagination
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
			tableData: [],
			multipleSelection: []
	      };
	    },
	    methods: {
	      handleClick(tab, event) {
	        console.log(tab, event);
	      },
		  handleSelectionChange(val) {
			this.multipleSelection = val;
		  }
	   }
	};
</script>

<style>
</style>
