<template>
	<el-button type="primary" icon="el-icon-edit" style="margin: 0 0 0 -740px;" @click="checkdk">打卡</el-button>
	<el-select v-model="value" placeholder="请选择" style="margin: 0 0 0 100px;">
		<el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
		</el-option>
	</el-select>
	<el-button type="primary" icon="el-icon-search" style="margin: 0 0 0 10px;">搜索</el-button>

	<el-table :data="tableData" stripe style="width: 100%">
		<el-table-column prop="checkId" label="编号" width="180">
		</el-table-column>
		<el-table-column prop="empname" label="姓名" width="180">
		</el-table-column>
		<el-table-column prop="deptname" label="部门" width="180">
		</el-table-column>
		<el-table-column prop="checkdata" label="打卡日期">
		</el-table-column>
		<el-table-column prop="checkdatatime" label="打卡时间">
		</el-table-column>
		<el-table-column prop="typezt" label="是否早退">
		</el-table-column>
		<el-table-column prop="typecd" label="是否迟到">
		</el-table-column>
		<el-table-column prop="typelq" label="打卡类型">
		</el-table-column>
	</el-table>







	<div class="block" style="margin:20px;display: flex;justify-content: center;">
		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageInfo.currentPage"
		 :page-sizes="[ 6, 8]" :page-size="pageInfo.pagesize" layout="total, sizes, prev, pager, next, jumper" :total="pageInfo.total">
		</el-pagination>
	</div>



</template>

<script>
	import qs from "qs" // eslint-disable-line no-unused-var
	export default {
		data() {
			return {
				tableData: [],
				form: {
					checkId: '',
					empname: '',
					deptname: '',
					checkdata: '',
					checkdatatime: '',
					typezt: '',
					typecd: '',
					typelq: ''
				},
				pageInfo: {
					currentPage: 1, //标识当前页码
					pagesize: 6, //每页多少条数据
					total: 0
				},
			}
		},
		methods: {
			checkdk() {
				this.$alert('打卡成功', {
				          confirmButtonText: '确定',
				          
				        });
				const _this = this
				this.axios.post("http://localhost:8088/insertcheck", this.form)
					this.axios.get("http://localhost:8088/findPage", {
							
							params: this.pageInfo,
							
						})
						.then(function(response) {
					
							_this.pageInfo.total = response.data.total
							_this.tableData = response.data.list
							for (var key in _this.form) {
								delete _this.form[key]
							}
						}).catch(function(error) {
							console.log(error)
						})
					
			},
			handleCurrentChange(currentPage) {
				var _this = this
				this.pageInfo.currentPage = currentPage
				var ps = qs.stringify(this.pageInfo)
				console.log(ps)
				this.axios.get("http://localhost:8088/findPage", {

						params: this.pageInfo,
						
					})
					.then(function(response) {
						console.log(response.data)
						_this.tableData = response.data.list
					}).catch(function(error) {
						console.log(error)
					})
			},
			handleSizeChange(pagesize) {
				var _this = this
				this.pageInfo.pagesize = pagesize
				var ps = qs.stringify(this.pageInfo) // eslint-disable-line no-unused-vars
				this.axios.get("http://localhost:8088/findPage", {

						params: this.pageInfo,
						
					})
					.then(function(response) {
						console.log(response.data)
						_this.tableData = response.data.list
					}).catch(function(error) {
						console.log(error)
					})
			},
			handleSelectionChange(val) {
				this.multipleSelection = val;
			},
		},
	
	created() {
		const _this = this
		
			
			this.axios.get("http://localhost:8088/findPage", {
					
					params: this.pageInfo,
					
				})
				.then(function(response) {
			
					_this.pageInfo.total = response.data.total
					_this.tableData = response.data.list
				}).catch(function(error) {
					console.log(error)
				})


	},
	}
</script>

<style>
</style>
