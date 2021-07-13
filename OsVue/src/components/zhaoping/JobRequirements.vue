<template>	
	<el-row>
	  <el-col :span="24"><div class="grid-content bg-purple-dark">岗位需求</div></el-col>	  
	</el-row>
	<el-row :gutter="20">
	  <el-col :span="12"><div class="bg-purple">
	    岗位数量
		<div id="bzrs">{{sumdemand}}</div>
	  </div></el-col>
	  <el-col :span="12"><div class="bg-purple">
		岗位需求人数
		<div id="bzrs">{{demandNumsum}}</div>
	  </div></el-col>	
	</el-row>
	
	<div>
			<el-table ref="multipleTable" :data="HuContractoflaborData" style="width: 100%" max-height="750">
				<el-table-column prop="jobName" label="岗位名称" width="">
				</el-table-column>
				<el-table-column prop="placeOfWork" label="工作地点" width="">
				</el-table-column>
				<el-table-column prop="natureOfWork" label="工作性质" >
				</el-table-column>
				<el-table-column prop="demandNum" label="需求人数" width="">
				</el-table-column>				
				<el-table-column prop="applicationDept" label="发布部门" width="">					
				</el-table-column>
								
								
				<el-table-column prop="stats"  label="岗位状态" width="">
					
				</el-table-column>
				
				<el-table-column fixed="right" label="操作" width="">
					<template #default="scope">
						<el-button @click.prevent="chakRow(scope.row, tableData);dialogFormVisible = true" type="text" size="small">
							查看
						</el-button>
						<el-button @click.prevent="deleteRow(scope.row, tableData)" type="text" size="small">
							移除
						</el-button>
						<el-button @click.prevent="madeayRow(scope.row, tableData)" type="text" size="small">
							岗位发布
						</el-button>
						<el-button @click.prevent="cehuiRow(scope.row, tableData)" type="text" size="small">
							岗位撤回
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
		<el-button type="text" @click="dialogFormVisible = true">用工单位申请</el-button>
		
		<el-dialog title="用人需求申请单" v-model="dialogFormVisible">
		  <el-form :model="form">
		    <el-form-item label="申请人" :label-width="formLabelWidth">
		      <el-input v-model="form.applicant" autocomplete="off"></el-input>
		    </el-form-item>
		   <el-form-item label="申请部门" :label-width="formLabelWidth">
		     <el-input v-model="form.applicationDept" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="增补岗位名称" :label-width="formLabelWidth">
		     <el-input v-model="form.jobName" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="需求人数" :label-width="formLabelWidth">
		     <el-input v-model="form.demandNum" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="用工来源" :label-width="formLabelWidth">
		     <el-input v-model="form.source" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="增补理由" :label-width="formLabelWidth">
		     <el-input v-model="form.reason" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="工作性质" :label-width="formLabelWidth">
		     <el-input v-model="form.natureOfWork" autocomplete="off"></el-input>
		   </el-form-item>		  
		   <el-form-item label="工作地点" :label-width="formLabelWidth">
		     <el-input v-model="form.placeOfWork" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="工作经验" :label-width="formLabelWidth">
		     <el-input v-model="form.workExperience" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="岗位职责" :label-width="formLabelWidth">
		     <el-input v-model="form.jobResponsibilities" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="薪资下限" :label-width="formLabelWidth">
		     <el-input v-model="form.salaryFloor" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="薪资上限" :label-width="formLabelWidth">
		     <el-input v-model="form.salaryCap" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="英语等级" :label-width="formLabelWidth">
		     <el-input v-model="form.englishLevel" autocomplete="off"></el-input>
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
	import { ElMessage } from 'element-plus'
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
				//发布 修改状态
				madeayRow(index, rows){
					
					const _this = this
					this.axios.put("http://localhost:8088/job/modifyjob",index)
					.then(function(response) {	
						ElMessage.success({
						          message: '操作成功',
						          type: 'success'
						        });
						console.log(response)
					}).catch(function(error) {
						console.log(error)
					})
					
					
					
					_this.init()
					
				},
				
				//撤回发布 修改状态
				cehuiRow(index, rows){
					
					const _this = this
					this.axios.put("http://localhost:8088/job/modifyjob",index)
					.then(function(response) {
						ElMessage.success({
						          message: '操作成功',
						          type: 'success'
						        });
						console.log(response)
					}).catch(function(error) {
						console.log(error)
					})
					
				
					
					_this.init()
					
				},
				
				
				 //删除
				deleteRow(index, rows) {				 						
						
							 
				
					console.log(index);
					this.rePosi=index;
					console.log(this.rePosi);
					console.log("-----------")					
					
					const _this = this
					this.axios.put("http://localhost:8088/job/deljob",this.rePosi)
					.then(function(response) {	
						ElMessage.success({
						          message: '操作成功',
						          type: 'success'
						        });
						console.log(response)
					}).catch(function(error) {
						console.log(error)
					})
					ElMessage.success({
					          message: '操作成功',
					          type: 'success'
					        });
					
					_this.init()				
					 
				
				},
				//添加
				aaaa(){
					console.log("-----------")
					const _this = this
					this.axios.put("http://localhost:8088/job/addjob",this.form)
					.then(function(response) {					
						ElMessage.success({
						          message: '操作成功',
						          type: 'success'
						        });
					}).catch(function(error) {
						console.log(error)
					})
					
					
					_this.init()
				}
				,
				a(num){
					console.log(num)
				},				
				init(){
					console.log("-----------")
					const _this = this
					this.axios.post("http://localhost:8088/job",this.formData)
					.then(function(response) {
						_this.HuContractoflaborData = response.data.data.posinmenlist				
						_this.sumdemand=response.data.data.sumdemand
						_this.demandNumsum=response.data.data.demandNumsum
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
								sumdemand:"",
								demandNumsum:"",
								tit:"",
					formData: {
					  page: 1,
					  pagesize: 10				 
					},
					rePosi:[],
					dialogFormVisible: false,
				        form: {
						  applicant:'',
				          jobId: '',
				          jobName: '',
				          demandNum: '',
				          applicant: '',
				          applicationDept: '',
						  applicationTime:'',
						  source:'',
						  reason:'',
						  natureOfWork:'',
						  jobResponsibilities:'',
						  education:'',
						  workExperience:'',
						  placeOfWork:'',
						  
						  lowerAgeLimit: '',
						  upperAgeLimit: '',
						  salaryFloor:'',
						  salaryCap:'',
						  major:'',
						  englishLevel:'',
						  other:'',
						  stats:''
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
