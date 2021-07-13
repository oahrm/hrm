<template>	
	<el-row>
	  <el-col :span="24"><div class="grid-content bg-purple-dark">职位管理</div></el-col>	  
	</el-row>
	<el-row :gutter="20">
	  <el-col :span="12"><div class="bg-purple">
	    岗位编制人数
		<div id="bzrs">{{staffnum}}</div>
	  </div></el-col>
	  <el-col :span="12"><div class="bg-purple">
		岗位实际人数
		<div id="bzrs">{{actualnum}}</div>
	  </div></el-col>	
	</el-row>
	
	<div>
			<el-table ref="multipleTable" :data="HuContractoflaborData" style="width: 100%" max-height="750">
				<el-table-column prop="did" label="部门编号" width="">
				</el-table-column>
				<el-table-column prop="job" label="职务名称" width="">
				</el-table-column>
				<el-table-column prop="organnum" label="编制人数" >
				</el-table-column>
				<el-table-column prop="actualnum" label="实际人数" width="">
				</el-table-column>				
				<el-table-column prop="state" label="状态(1.满编 2.超编 0.缺编)" width="">
				
				</el-table-column>
				<el-table-column fixed="right" label="操作" width="">
					<template #default="scope">
						<el-button @click.prevent="deleteRow(scope.row, tableData)" type="text" size="small">
							移除
						</el-button>
						<el-button @click.prevent="chakRow(scope.row, tableData);dialogFormVisible = true" type="text" size="small">
							查看
						</el-button>
					</template>
				</el-table-column>
			</el-table>
		</div>
		
		  <div class="block">		    
		    <el-pagination
		      @size-change="handleSizeChange"
		      @current-change="handleCurrentChange"
		      v-model:currentPage="formData.page"
		     :page-sizes="[2, 10, 20]"
		     :page-size="10"
		      layout="sizes, prev, pager, next"
		      :total=this.tit>
		    </el-pagination>
		  </div>
		 
		
		<!-- Form -->
		<el-button type="text" @click="dialogFormVisible = true">新建</el-button>
		
		<el-dialog title="职务计划-新建模板" v-model="dialogFormVisible">
		  <el-form :model="form">
		    <el-form-item label="部门" :label-width="formLabelWidth">
		      <el-input v-model="form.did" autocomplete="off"></el-input>
		    </el-form-item>
		   <el-form-item label="职务名称" :label-width="formLabelWidth">
		     <el-input v-model="form.job" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="编制人数" :label-width="formLabelWidth">
		     <el-input v-model="form.organnum" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="实际人数" :label-width="formLabelWidth">
		     <el-input v-model="form.actualnum" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="状态" :label-width="formLabelWidth">
		     <el-input v-model="form.state" autocomplete="off"></el-input>
		   </el-form-item>
		  </el-form>
		  <template #footer>
		    <span class="dialog-footer">
		      <el-button @click="dialogFormVisible = false">取 消</el-button>
		      <el-button type="primary" @click="dialogFormVisible = false ; aaaa()">确 定</el-button>
		    </span>
		  </template>
		</el-dialog>
		
	

</template>

<script>
	/* import qs from "qs"
		import {
			defineComponent,
			ref
		} from 'vue' */
		export default {
			
			methods: {
				
				handleSizeChange(val) {
				   console.log(`每页 ${val} 条`);
				   this.formData.pagesize=val;
				  this.init();
				},
				handleCurrentChange(val) {
				  console.log(`当前页: ${val}`);
				  this.formData.page=val;
				 this.init();
				},     
				//查看
				chakRow(index, rows){
					
					this.form=index
					
				},
				
				 //删除
				deleteRow(index, rows) {
					 						
						
							 
				
					console.log(index);
					this.rePosi=index;
					console.log(this.rePosi);
					console.log("-----------")					
					
					const _this = this
					this.axios.put("http://localhost:8088/recruit/del",this.rePosi)
					.then(function(response) {						
						console.log(response)
					}).catch(function(error) {
						console.log(error)
					})
					_this.init();
					
					 
				
				},
				//添加
				aaaa(){
					console.log("-----------")
					const _this = this
					this.axios.put("http://localhost:8088/recruit/add",this.form)
					.then(function(response) {					
						
					}).catch(function(error) {
						console.log(error)
					})
					_this.init();
				}
				,
				a(num){
					console.log(num)
				},				
				init(){
					console.log("-----------")
					const _this = this
					this.axios.post("http://localhost:8088/recruit",this.formData)
					.then(function(response) {
						_this.HuContractoflaborData = response.data.data.posinmenlist				
						_this.actualnum=response.data.data.actualnum
						_this.staffnum=response.data.data.staffnum
						_this.tit=response.data.data.tit
						console.log(_this.HuContractoflaborData)
					}).catch(function(error) {
						console.log(error)
					})
				}
			},
			data() {
				return {
					HuContractoflaborData:[],
								actualnum:"",
								staffnum:"",
								tit:"",
					formData: {
					  page: 1,
					  pagesize: 10				 
					},
					rePosi:[],
					dialogFormVisible: false,
				        form: {
				          did: '',
				          job: '',
				          organnum: '',
				          actualnum: '',
				          state: ''	
				        },
				        formLabelWidth: '120px'	
					       
					
				}
			},
			created() {				
				this.init();
			}
			
			
		}
	
	
</script>

<style>
	#bzrs{
		font-size: 20px;
	}
	 .el-row {
	    margin-bottom: 20px;
	
	    &:last-child {
	      margin-bottom: 0;
	    }
	  }
	  .el-col {
	    border-radius: 4px;
		
	  }
	  .bg-purple-dark {
	    background: #99a9bf;
	  }
	  .bg-purple {
	    background: #d3dce6;
		font-size: 12px;
		height: 50px;
	  }
	  .bg-purple-light {
	    background: #e5e9f2;
	  }
	  .grid-content {
	    border-radius: 4px;
	    min-height: 36px;
			height: 50px;
			font-size: 30px;
			line-height: 50px;
	  }
	  .row-bg {
	    padding: 10px 0;
	    background-color: #f9fafc;
	  }
</style>
