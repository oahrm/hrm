<template>
	<div>
		<el-table :data="tableData" style="width: 100%" max-height="750">
			<el-table-column prop="name" label="姓名" width="">
			</el-table-column>
			<el-table-column prop="province" label="岗位" width="">
			</el-table-column>
			<el-table-column prop="city" label="手机号码" >
			</el-table-column>
			<el-table-column prop="address" label="邮箱" width="">
			</el-table-column>
			<el-table-column fixed prop="date" label="日期" width="">
			</el-table-column>
			<el-table-column prop="zip" label="状态" width="">
			</el-table-column>
			<el-table-column fixed="right" label="操作" width="">
				<template #default="scope">
					<el-button @click.prevent="deleteRow(scope.$index, tableData)" type="text" size="small">
						移除
					</el-button>
				</template>
			</el-table-column>
		</el-table>
	</div>
	
</template>

<script>
	export default {
		methods: {
			deleteRow(index, rows) {
				rows.splice(index, 1);
			}
		},
		data() {
			return {
				tableData: [{
					date: '2016-05-03',
					name: '王小虎',
					province: '上海',
					city: '普陀区',
					address: '上海市普陀区金沙江路 1518 弄',
					zip: 200333
				}, {
					date: '2016-05-02',
					name: '王小虎',
					province: '上海',
					city: '普陀区',
					address: '上海市普陀区金沙江路 1518 弄',
					zip: 200333
				}, {
					date: '2016-05-04',
					name: '王小虎',
					province: '上海',
					city: '普陀区',
					address: '上海市普陀区金沙江路 1518 弄',
					zip: 200333
				}, {
					date: '2016-05-01',
					name: '王小虎',
					province: '上海',
					city: '普陀区',
					address: '上海市普陀区金沙江路 1518 弄',
					zip: 200333
				}, {
					date: '2016-05-08',
					name: '王小虎',
					province: '上海',
					city: '普陀区',
					address: '上海市普陀区金沙江路 1518 弄',
					zip: 200333
				}]
			}
		}
	}
</script>
