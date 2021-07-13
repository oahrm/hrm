<template>
	<el-button type="primary" icon="el-icon-edit" style="margin: 0 0 0 -720px;" @click="book =true">外勤签到</el-button>
	<el-input placeholder="请输入内容"  prefix-icon="el-icon-search" v-model="pageInfo.value" style="width: 150px;">
	</el-input>
	<el-button type="primary" icon="el-icon-search" style="margin: 0 0 0 10px;" @click="selectAll">搜索</el-button>

	<el-table :data="tableData" stripe style="width: 100%">
		<el-table-column type="index" :index="indexMethod" width="180" align="center">
		</el-table-column>
		<el-table-column prop="empname" label="姓名" width="180">
		</el-table-column>
		<el-table-column prop="filedname" label="部门" width="180">
		</el-table-column>
		<el-table-column prop="fielddate" label="签到日期">
		</el-table-column>
		<el-table-column prop="fielddatetime" label="签到时间">
		</el-table-column>
		<el-table-column prop="fieldadrss" label="签到地址">
		</el-table-column>
		<el-table-column prop="fieldcustomer" label="备注">
		</el-table-column>
		<el-table-column prop="filedremaeks" label="签到类型">
		</el-table-column>
	</el-table>

	<el-dialog title="外勤签到" v-model="book" >
		<el-form :model="form">
			<div style="margin: 0 0 0 -300px;">
			姓名: <el-select v-model="form.empname" placeholder="请选择员工" >
			    <el-option
			      v-for="item in options"
			      :key="item.value"
			      :label="item.label"
			      :value="item.value"
			      :disabled="item.disabled">
			    </el-option>
			  </el-select>
			  </div>
			<br />
		<div style="margin: 0 0 0 -300px;">
			部门: <el-select v-model="form.filedname" placeholder="请选择部门">
			    <el-option
			      v-for="item in options2"
			      :key="item.value2"
			      :label="item.label2"
			      :value="item.value2"
			      :disabled="item.disabled">
			    </el-option>
			  </el-select>
			</div>
			<el-form-item label="签到地址 :" :label-width="formLabelWidth" style="width:295px ;margin: 15px 0 0 30px;">
				<el-input v-model="form.fieldadrss" placeholder="请输入签到地址" autocomplete="off" ></el-input>
				
			</el-form-item>
			<el-form-item label="备注 :" :label-width="formLabelWidth" style="width:265px ;margin: 15px 0 0 60px;">
				<el-input v-model="form.fieldcustomer" placeholder="请输入备注" autocomplete="off" ></el-input>
				
			</el-form-item>
			<div style="margin: 15px 0 0 -323px;">
			签到类型: <el-select v-model="form.filedremaeks" placeholder="请选择签到类型">
			    <el-option
			      v-for="item in options3"
			      :key="item.value3"
			      :label="item.label3"
			      :value="item.value3"
			      :disabled="item.disabled">
			    </el-option>
			  </el-select>
			  </div>
			
			
		
		
		</el-form>
		
		<template #footer>
			<span class="dialog-footer">
				<el-button type="primary" @click="checkdk">保 存</el-button>
				<el-button @click="book  = false">关 闭</el-button>
			</span>
		</template>
		
	</el-dialog>






	<div class="block" style="margin:20px;display: flex;justify-content: center;">
		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageInfo.currentPage"
		 :page-sizes="[ 6, 8]" :page-size="pageInfo.pagesize" layout="total, sizes, prev, pager, next, jumper" :total="pageInfo.total">
		</el-pagination>
	</div>



</template>

<script>
	import qs from "qs" // eslint-disable-line no-unused-var
	import {
		ElMessage
	} from 'element-plus'
	export default {
		
		data() {
			return {
				addss() {
					ElMessage({
						showClose: true,
						message: '新增成功!',
						type: 'success'
					});
				},
				options: [{
					
				          value: '张三',
				          label: '张三'
				        }, {
				          value: '李四',
				          label: '李四',

				        }, {
				          value: '王五',
				          label: '王五'
				        }, {
				          value: '赵六',
				          label: '赵六'
				        }],
				        value: '',
				
						
				options2: [{
				          value2: '产品部',
				          label2: '产品部'
				        }, {
				          value2: '项目部',
				          label2: '项目部',

				        }, {
				          value2: '研发部',
				          label2: '研发部'
				        }],
				        value2: '',
				options3: [{
				          value3: '出差',
				          label3: '出差'
				        }, {
				          value3: '公出',
				          label3: '公出',
				          
				        }],
				        value3: '',
					
					book:false,
				tableData: [],
				form: {
					fieldId: '',
					empname: '',
					filedname: '',
					fielddate: '',
					fielddatetime: '',
					fieldadrss: '',
					fieldcustomer: '',
					filedremaeks: ''
				},
				
				pageInfo: {
					currentPage: 1, //标识当前页码
					pagesize: 6, //每页多少条数据
					total: 0,
					value:""
				},
			}
		},
		methods: {
			indexMethod(index) {
							return index + 1;
						},
						
			selectAll(){
				const _this = this
				
					this.axios.get("http://localhost:8088/selectBydept", {
						
						params: this.pageInfo
					}).then(function(
						response) {
						console.log(response)
						_this.$message({
							type: 'success',
							message: '查询成功'
						})
						
						_this.tableData = response.data.list
						_this.pageInfo.total = response.data.total
					}).catch(function(error) {
						console.log(error)
						_this.$message({
							type: 'info',
							message: '查询失败'
						})
					})
				 
				
			},
			
			checkdk() {
				         
				          
				
				const _this = this
				
				this.axios.post("http://localhost:8088/insertfile", this.form)
				.then(function(response) {
					console.log(response)
					_this.axios.get("http://localhost:8088/findPage1", {
							
							params: _this.pageInfo,
							
						})
						.then(function(response) {
					
							_this.pageInfo.total = response.data.total
							_this.tableData = response.data.list
							
						}).catch(function(error) {
							console.log(error)
						})
						_this.book=false
						_this.addss()
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
				this.axios.get("http://localhost:8088/findPage1", {

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
				this.axios.get("http://localhost:8088/findPage1", {

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
		
			
			this.axios.get("http://localhost:8088/findPage1", {
					
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
