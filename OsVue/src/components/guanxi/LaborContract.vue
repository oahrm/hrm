<template>
	<div>
		<el-table ref="multipleTable" :data="HuContractoflaborData" style="width: 100%" max-height="750">
			<el-table-column prop="name" label="姓名" width="">
			</el-table-column>
			<el-table-column prop="station" label="岗位" width="">
			</el-table-column>
			<el-table-column prop="phone" label="手机号码">
			</el-table-column>
			<el-table-column prop="mailbox" label="邮箱" width="">
			</el-table-column>
			<el-table-column fixed prop="arrivalTime" label="日期" width="">
			</el-table-column>
			<el-table-column prop="re_entry_applica.contractstatus" label="状态" width="" show-overflow-tooltip>
				<template v-slot="scope">
					<p v-if="scope.row.re_entry_applica.contractstatus==0">未签署</p>
					<p v-if="scope.row.re_entry_applica.contractstatus==1">已签署</p>
				</template>
			</el-table-column>
			<el-table-column fixed="right" label="操作" width="">
				<template #default="scope">
					<el-button @click.prevent="deleteRow(scope.$index, tableData)" type="text" size="small">
						签署合同
					</el-button>
					<!-- <el-button @click.prevent="deleteRow(scope.$index, tableData)" type="text" size="small">
						
					</el-button> -->
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
			
		},
		data() {
			return {
				HuContractoflaborData: []
			}
		},
		created() {
			console.log("-----------")
			const _this = this
			this.axios.get("http://localhost:8088/selectAllOffer_Hu")
				.then(function(response) {
					_this.HuContractoflaborData = response.data.data
					console.log(response)
				}).catch(function(error) {
					console.log(error)
				})

		}


	}
</script>
