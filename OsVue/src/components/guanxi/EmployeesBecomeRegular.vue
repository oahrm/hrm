<template>
	<el-tabs v-model="activeName" @tab-click="handleClick">
		<el-tab-pane label="待转正员工" name="first">
			<el-table :data="EmpOersZzData" style="width: 100%" max-height="250">
				<el-table-column fixed prop="date" label="转正人员" width="">
				</el-table-column>
				<el-table-column prop="name" label="转正人员部门" width="">
				</el-table-column>
				<el-table-column prop="province" label="联系电话" width="">
				</el-table-column>
				<el-table-column prop="city" label="入职日期" width="">
				</el-table-column>
				<el-table-column prop="address" label="转正状态" width="">
				</el-table-column>

				<el-table-column fixed="right" label="操作" width="120">
					<template #default="scope">
						<el-button @click.prevent="deleteRow(scope.$index, tableData)" type="text" size="small">
							转正
						</el-button>
					</template>
				</el-table-column>
			</el-table>
		</el-tab-pane>
		<el-tab-pane label="以转正员工" name="second">
			<el-table :data="tableData" style="width: 100%" max-height="250">
				<el-table-column fixed prop="date" label="转正人员" width="">
				</el-table-column>
				<el-table-column prop="name" label="转正人员部门" width="">
				</el-table-column>
				<el-table-column prop="province" label="联系电话" width="">
				</el-table-column>
				<el-table-column prop="city" label="入职日期" width="">
				</el-table-column>
				<el-table-column prop="city" label="转正日期" width="">
				</el-table-column>
				<el-table-column prop="address" label="转正状态" width="">
				</el-table-column>

				<el-table-column fixed="right" label="操作" width="">
					<template #default="scope">
						<el-button type="text" @click="showEdit(scope.row)">签署合同</el-button>
					</template>
				</el-table-column>

			</el-table>
		</el-tab-pane>
		<el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
		<el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane>
	</el-tabs>
</template>

<script>
	export default {
		data() {
			return {
				EmpOersZzData:[],
				activeName: 'first'
			};
		},
		methods: {
			handleClick(tab, event) {
				console.log(tab, event);
			}
		},
		created() {
			console.log("-----------")
			const _this = this
			this.axios.get("http://localhost:8088/emp/findEmpOersZz")
				.then(function(response) {
					_this.EmpOersZzData = response.data.data
					console.log(response)
				}).catch(function(error) {
					console.log(error)
				})
		
		}
	};
	
</script>
