<template>
	<div>
		<el-table ref="multipleTable" :data="tableData" style="width: 100%" max-height="750">
			<el-table-column prop="gw" label="所属岗位" width="">
			</el-table-column>
			<el-table-column prop="dgdata" label="到岗日期" width="">
			</el-table-column>
			<el-table-column prop="sex" label="员工性别" >
			</el-table-column>
			<el-table-column prop="phone" label="手机号码" width="">
			</el-table-column>
			<el-table-column fixed prop="name" label="员工姓名" width="">
			</el-table-column>
			<el-table-column fixed prop="rzdate" label="入职时间" width="">
			</el-table-column>
			<el-table-column prop="zip" label="入职状态" width="">
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
	import qs from "qs"
	import {
		defineComponent,
		ref
	} from 'vue'
	export default {
		
		methods: {
			deleteRow(index, rows) {
				rows.splice(index, 1);
			}
		},
		data() {
			return {
				HuContractoflaborData: [],
				tableData: [{
					gw: '研发人员',
					dgdata: '2016-05-03',
					sex: '男',
					phone: '1557066285',
					name: '阿豪',
					rzdate: '2016-05-03',
					zip:'未入职'
				}, {
					date: '2016-05-02',
					name: '王小虎',
					province: '上海',
					city: '普陀区',
					address: '上海市普陀区金沙',
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
		},
		created() {
			console.log("-----------")
			const _this = this
			this.axios.get("http://localhost:8088/selectAllOffer_Hu")
			.then(function(response) {
				_this.HuContractoflaborData = response.data
				console.log(response)
			}).catch(function(error) {
				console.log(error)
			})
			
		}
		
		
	}
</script>