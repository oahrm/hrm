<template>
	<div>
		<el-table ref="multipleTable" :data="HuContractoflaborData" style="width: 100%" max-height="750">
			<el-table-column prop="name" label="姓名" width="">
			</el-table-column>
			<el-table-column prop="station" label="岗位" width="">
			</el-table-column>
			<el-table-column prop="phone" label="手机号码" >
			</el-table-column>
			<el-table-column prop="mailbox" label="邮箱" width="">
			</el-table-column>
			<el-table-column fixed prop="arrivalTime" label="日期" width="">
			</el-table-column>
			<el-table-column prop="offerStatus" label="状态" width="">
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