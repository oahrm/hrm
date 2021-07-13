<template>
	<h2 style="margin: 50px 0 0 -100px;">考勤时间表</h2>
	<el-table :data="tableData" border style="width: 361px ;margin: 20px 0 0 400px;">
		<el-table-column prop="morningTime" label="上班打卡时间" width="180">
		</el-table-column>
		<el-table-column prop="nightTime" label="下班打卡时间" width="180">
		</el-table-column>

	</el-table>

</template>

<script>
	import {
		ElMessage
	} from 'element-plus'
	export default {
		data() {
			return {
				tableData: [],
			}


		},
		
		created() {
			const _this = this
			this.axios.get("http://localhost:8088/selectBytime")
				.then(function(response) {
					console.log(response)
					_this.tableData = response.data

				}).catch(function(error) {
					console.log(error)
				})

		},
	}
</script>

<style>
</style>
