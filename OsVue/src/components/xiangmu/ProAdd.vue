<template>
	<div>
		<div style="margin-bottom: 20px">
			<el-button @click="add">增加</el-button>
			<el-button @click="dels">批量删除</el-button>
		</div>

		<el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" style="width: 100%"
			@selection-change="selectChange">
			<el-table-column type="selection" width="45"></el-table-column>
			<el-table-column label="日期" width="120">
				<template slot-scope="scope">{{ scope.row.date }}</template>
			</el-table-column>
			<el-table-column prop="name" label="姓名" width="120"></el-table-column>
			<el-table-column prop="address" label="地址" show-overflow-tooltip></el-table-column>
			<el-table-column label="操作" width="180">
				<template slot-scope="scope">
					<el-button size="mini" type="danger" @click="del(scope.row, scope.$index)">删除</el-button>
				</template>
			</el-table-column>
		</el-table>
	</div>
</template>

<script>
	// api
	import tableApi from '@/api'
	export default {
		data() {
			return {
				tableData: [{
						id: '0',
						date: '2016-05-03',
						name: '王小虎',
						address: '上海市普陀区金沙江路 1518 弄'
					},
					{
						id: '1',
						date: '2016-05-02',
						name: '王小虎',
						address: '上海市普陀区金沙江路 1518 弄'
					},
					{
						id: '2',
						date: '2016-05-04',
						name: '王小虎',
						address: '上海市普陀区金沙江路 1518 弄'
					},
					{
						id: '3',
						date: '2016-05-01',
						name: '王小虎',
						address: '上海市普陀区金沙江路 1518 弄'
					},
					{
						id: '4',
						date: '2016-05-08',
						name: '王小虎',
						address: '上海市普陀区金沙江路 1518 弄'
					},
					{
						id: '5',
						date: '2016-05-06',
						name: '王小虎',
						address: '上海市普陀区金沙江路 1518 弄'
					},
					{
						id: '6',
						date: '2016-05-07',
						name: '王小虎',
						address: '上海市普陀区金沙江路 1518 弄'
					}
				],
				multipleSelection: []
			}
		},
		methods: {
			// 增加行
			add() {
				const row = {
					date: '2016-05-03',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄'
				}
				this.tableData.unshift(row)
			},
			/**
			 * 批量删除行
			 * @param {object} row 行数据
			 * @param {number} i 数据的序号
			 */
			dels(row, i) {
				if (row) {
					if (!row.id) {
						this.tableData.splice(i, 1)
						return false
					}

					tableApi
						.dels({
							id: row.id
						})
						.then(res => {
							if (res.status === 200) {
								this.$message.success('删除成功')
								this.getList()
							} else {
								this.$message.error('获取数据失败')
							}
						})
						.catch(e => {
							this.$message.error(e.message)
						})
				} else {
					if (this.multipleSelection.length === 0) {
						this.$message.warning('请至少选择一行数据')
						return false
					}
					const id = this.multipleSelection
						.filter(item => item.id)
						.map(item => item.id)
						.join(',')
					tableApi
						.dels({
							id
						})
						.then(res => {
							if (res.status === 200) {
								this.$message.success('删除成功')
								this.getList()
							} else {
								this.$message.error('获取数据失败')
							}
						})
						.catch(e => {
							this.$message.error(e.message)
						})
				}
			},
			// 获取表格数据
			getList() {
				tableApi
					.getList()
					.then(res => {
						if (res.status === 200) {
							this.tableData = res.data
						} else {
							this.$message.error('获取数据失败')
						}
					})
					.catch(e => {
						this.$message.error(e.message)
					})
			},
			selectChange(val) {
				this.multipleSelection = val
			}
		}
	}
</script>

<style>
</style>
