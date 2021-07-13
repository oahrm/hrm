<template>	
	<el-row>
	  <el-col :span="24"><div class="grid-content bg-purple-dark">简历</div></el-col>	  
	</el-row>

	
	<div>
			<el-table ref="multipleTable" :data="HuContractoflaborData" style="width: 100%" max-height="750">
				<el-table-column prop="name" label="姓名" width="">
				</el-table-column>
				<el-table-column prop="sex" label="	性别" width="">
				</el-table-column>
				<el-table-column prop="appliedPosition" label="应聘岗位" >
				</el-table-column>
				<el-table-column prop="channel" label="人才渠道来源" width="">
				</el-table-column>				
				<el-table-column prop="highestEducation" label="最高学历" width="">					
				</el-table-column>
				<el-table-column prop="expYear"  label="工作经验" width="">
				</el-table-column>							
				<el-table-column fixed="right" label="操作" width="">
					<template #default="scope">
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
		
		
		<el-dialog title="简历" v-model="dialogFormVisible">
		  <el-form :model="form" disabled>
		    <el-form-item label="姓名" :label-width="formLabelWidth">
		      <el-input v-model="form.name" autocomplete="off"></el-input>
		    </el-form-item>
		   <el-form-item label="性别" :label-width="formLabelWidth">
		     <el-input v-model="form.sex" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="籍贯" :label-width="formLabelWidth">
		     <el-input v-model="form.nativePlace" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="居住地" :label-width="formLabelWidth">
		     <el-input v-model="form.placeOfAbode" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="政治面貌" :label-width="formLabelWidth">
		     <el-input v-model="form.politicsStatus" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="电话" :label-width="formLabelWidth">
		     <el-input v-model="form.phone" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="邮箱" :label-width="formLabelWidth">
		     <el-input v-model="form.email" autocomplete="off"></el-input>
		   </el-form-item>		  
		   <el-form-item label="教育经历" :label-width="formLabelWidth">
		     <el-input v-model="form.educationExperience" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="荣誉奖励" :label-width="formLabelWidth">
		     <el-input v-model="form.honorsAndAwards" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="工作经历" :label-width="formLabelWidth">
		     <el-input v-model="form.workExperience" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="专业技能" :label-width="formLabelWidth">
		     <el-input v-model="form.professionalSkill" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="自我评价" :label-width="formLabelWidth">
		     <el-input v-model="form.selfAssessment" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="最高学历" :label-width="formLabelWidth">
		     <el-input v-model="form.highestEducation" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="应聘岗位" :label-width="formLabelWidth">
		     <el-input v-model="form.appliedPosition" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="人才渠道来源" :label-width="formLabelWidth">
		     <el-input v-model="form.channel" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="工作经验" :label-width="formLabelWidth">
		     <el-input v-model="form.expYear" autocomplete="off"></el-input>
		   </el-form-item>
		  </el-form>
		  <template #footer>
		    <span class="dialog-footer">
		      <el-button @click="dialogFormVisible = false">取 消</el-button>
		      <el-button type="primary" @click="dialogFormVisible = false ">确 定</el-button>
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
				//发布 修改状态
				madeayRow(index, rows){
					
					const _this = this
					this.axios.put("http://localhost:8088/job/modifyjob",index)
					.then(function(response) {						
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
						console.log(response)
					}).catch(function(error) {
						console.log(error)
					})
					_this.init()				
					 
				
				},
				//添加
				aaaa(){
					console.log("-----------")
					const _this = this
					this.axios.put("http://localhost:8088/job/addjob",this.form)
					.then(function(response) {					
						
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
					this.axios.post("http://localhost:8088/recruit/jianli",this.formData)
					.then(function(response) {
						_this.HuContractoflaborData = response.data.data.posinmenlist	
						
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
						  name:'',
				          sex: '',
				          birthday: '',
				          nativePlace: '',
				          placeOfAbode: '',
				          politicsStatus: '',
						  phone:'',
						  email:'',
						  educationExperience:'',
						  honorsAndAwards:'',
						  workExperience:'',
						  highestEducation:'',
						  appliedPosition:'',
						  channel:'',
						  
						  expYear: ''
						 
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
