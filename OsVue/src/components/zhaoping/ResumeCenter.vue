<template>	
	<el-row>
	  <el-col :span="24"><div class="grid-content bg-purple-dark">入职通知</div></el-col>	  
	</el-row>
	
	
	<div>
			<el-table ref="multipleTable" :data="HuContractoflaborData" style="width: 100%" max-height="750">
				<el-table-column prop="name" label="候选人姓名" width="">
				</el-table-column>				
				<el-table-column prop="station" label="岗位" >
				</el-table-column>
				<el-table-column prop="phone" label="手机号码" width="">
				</el-table-column>
				<el-table-column prop="department" label="所属部门" width="">
				</el-table-column>		
									
				<el-table-column prop="officeLocation"  label="办公地点" width="">					
				</el-table-column>						
				<el-table-column prop="arrivalTime"  label="到岗时间" width="">					
				</el-table-column>							
				<el-table-column prop="mailbox"  label="邮箱" width="">					
				</el-table-column>
				
				<el-table-column fixed="right" label="操作" width="">
					<template #default="scope">
						<el-button @click.prevent="chakRow(scope.row, tableData);dialogFormVisible = true" type="text" size="small">
							查看
						</el-button>	
						<el-button @click.prevent="madeayRow(scope.row, tableData)" type="text" size="small">
							确认
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
		<el-button type="text" @click="dialogFormVisible = true ">发出offer</el-button>
		
		<el-dialog title="offer" v-model="dialogFormVisible">
		  <el-form :model="form">
		    <el-form-item label="offer名称" :label-width="formLabelWidth">
		      <el-input v-model="form.offername" autocomplete="off"></el-input>
		    </el-form-item>	
		   <el-form-item label="候选人姓名" :label-width="formLabelWidth">
		     <el-input v-model="form.name" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="性别" :label-width="formLabelWidth">
		     <el-input v-model="form.sex" autocomplete="off"></el-input>
		   </el-form-item>		  
		   <el-form-item label="籍贯" :label-width="formLabelWidth">
		     <el-input v-model="form.place" autocomplete="off"></el-input>
		   </el-form-item>		
		   <el-form-item label="手机号码" :label-width="formLabelWidth">
		     <el-input v-model="form.phone" autocomplete="off"></el-input>
		   </el-form-item>
		    <el-form-item label="出生年月">
		       <el-col :span="11">
		         <el-date-picker type="date" placeholder="选择日期" v-model="form.dateOfBirth" style="width: 100%;"></el-date-picker>
		       </el-col>		      
		     </el-form-item>
			 <el-form-item label="身份证号码" :label-width="formLabelWidth">
			   <el-input v-model="form.idcard" autocomplete="off"></el-input>
			 </el-form-item>
			 <el-form-item label="民族" :label-width="formLabelWidth">
			   <el-input v-model="form.nation" autocomplete="off"></el-input>
			 </el-form-item>
			 <el-form-item label="婚姻状况" :label-width="formLabelWidth">
			   <el-input v-model="form.maritaStatus" autocomplete="off"></el-input>
			 </el-form-item>
			 <el-form-item label="最高学历" :label-width="formLabelWidth">
			   <el-input v-model="form.highestEducation" autocomplete="off"></el-input>
			 </el-form-item>
			 <el-form-item label="学位" :label-width="formLabelWidth">
			   <el-input v-model="form.academicDegree" autocomplete="off"></el-input>
			 </el-form-item>
			 <el-form-item label="邮箱" :label-width="formLabelWidth">
			   <el-input v-model="form.mailbox" autocomplete="off"></el-input>
			 </el-form-item>
			 <el-form-item label="offer状态" :label-width="formLabelWidth">
			   <el-input v-model="form.offerStatus" autocomplete="off"></el-input>
			 </el-form-item>
			 <el-form-item label="所属部门" :label-width="formLabelWidth">
			   <el-input v-model="form.department" autocomplete="off"></el-input>
			 </el-form-item>
			 <el-form-item label="直接上级" :label-width="formLabelWidth">
			   <el-input v-model="form.directsuperior" autocomplete="off"></el-input>
			 </el-form-item>
			 <el-form-item label="岗位" :label-width="formLabelWidth">
			   <el-input v-model="form.station" autocomplete="off"></el-input>
			 </el-form-item>
			 <el-form-item label="办公地点" :label-width="formLabelWidth">
			   <el-input v-model="form.officeLocation" autocomplete="off"></el-input>
			 </el-form-item>
			 <el-form-item label="基本工资" :label-width="formLabelWidth">
			   <el-input v-model="form.basePay" autocomplete="off"></el-input>
			 </el-form-item>
			
			 <el-form-item label="绩效工资" :label-width="formLabelWidth">
			   <el-input v-model="form.meritPay" autocomplete="off"></el-input>
			 </el-form-item>
			 <el-form-item label="转正工资" :label-width="formLabelWidth">
			   <el-input v-model="form.regularSalary" autocomplete="off"></el-input>
			 </el-form-item>
			 <el-form-item label="试用期/月" :label-width="formLabelWidth">
			   <el-input v-model="form.probationPeriod" autocomplete="off"></el-input>
			 </el-form-item>
			 <el-form-item label="试用期工资" :label-width="formLabelWidth">
			   <el-input v-model="form.probationPeriodSalary" autocomplete="off"></el-input>
			 </el-form-item>
			<el-form-item label="出生年月">
			   <el-col :span="11">
			     <el-date-picker type="date" placeholder="选择日期" v-model="form.arrivalTime" style="width: 100%;"></el-date-picker>
			   </el-col>		      
			 </el-form-item>
			
		  
		  </el-form>
		  <template #footer>
		    <span class="dialog-footer">
		      <el-button @click="dialogFormVisible = false">取 消</el-button>
		      <el-button type="primary" @click="dialogFormVisible = false ; aaaa()">确 定</el-button>
		    </span>
		  </template>
		</el-dialog>
		
		
		<!-- 查看简历 -->
		
		
		<el-dialog title="简历" v-model="dialogFormVisible2">
		  <el-form :model="form2"  disabled>
		    <el-form-item label="姓名" :label-width="formLabelWidth">
		      <el-input v-model="form2.name" autocomplete="off"></el-input>
		    </el-form-item>
		   <el-form-item label="性别" :label-width="formLabelWidth">
		     <el-input v-model="form2.sex" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="籍贯" :label-width="formLabelWidth">
		     <el-input v-model="form2.nativePlace" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="居住地" :label-width="formLabelWidth">
		     <el-input v-model="form2.placeOfAbode" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="政治面貌" :label-width="formLabelWidth">
		     <el-input v-model="form2.politicsStatus" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="电话" :label-width="formLabelWidth">
		     <el-input v-model="form2.phone" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="邮箱" :label-width="formLabelWidth">
		     <el-input v-model="form2.email" autocomplete="off"></el-input>
		   </el-form-item>		  
		   <el-form-item label="教育经历" :label-width="formLabelWidth">
		     <el-input v-model="form2.educationExperience" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="荣誉奖励" :label-width="formLabelWidth">
		     <el-input v-model="form2.honorsAndAwards" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="工作经历" :label-width="formLabelWidth">
		     <el-input v-model="form2.workExperience" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="专业技能" :label-width="formLabelWidth">
		     <el-input v-model="form2.professionalSkill" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="自我评价" :label-width="formLabelWidth">
		     <el-input v-model="form2.selfAssessment" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="最高学历" :label-width="formLabelWidth">
		     <el-input v-model="form2.highestEducation" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="应聘岗位" :label-width="formLabelWidth">
		     <el-input v-model="form2.appliedPosition" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="人才渠道来源" :label-width="formLabelWidth">
		     <el-input v-model="form2.channel" autocomplete="off"></el-input>
		   </el-form-item>
		   <el-form-item label="工作经验" :label-width="formLabelWidth">
		     <el-input v-model="form2.expYear" autocomplete="off"></el-input>
		   </el-form-item>
		  </el-form>
		  <template #footer>
		    <span class="dialog-footer">
		      <el-button @click="dialogFormVisible2 = false">取 消</el-button>
		      <el-button type="primary" @click="dialogFormVisible2 = false ">确 定</el-button>
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
				madeayruyong(index, rows){
					const _this = this
					this.axios.put("http://localhost:8088/inter/modifyluyong",index)
					.then(function(response) {						
						console.log(response)
					}).catch(function(error) {
						console.log(error)
					})
					_this.init()
					
					
				}
				,
				//发布 通过
				madeayRow(index, rows){
					
					const _this = this
					this.axios.put("http://localhost:8088/inter/modifytonguo",index)
					.then(function(response) {						
						console.log(response)
					}).catch(function(error) {
						console.log(error)
					})
					_this.init()
					
				},
				//查看简历
				findjian(index){
					
					console.log("-----------")
					const _this = this
					this.axios.post("http://localhost:8088/inter/idjianli",index)
					.then(function(response) {
						_this.jianlirData= response.data.data					
						//_this.form2=response.data.data.posinmenlist		
						_this.form2=_this.jianlirData
					}).catch(function(error) {
						console.log(error)
					})					
					
					
					console.log(this.form2)
					
					this.dialogFormVisible2 = true
				},
				
				//关闭
				modifygaunbi(index, rows){
					
					const _this = this
					this.axios.put("http://localhost:8088/inter/modifygaunbi",index)
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
					this.axios.put("http://localhost:8088/reentry/add",this.form)
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
					this.axios.post("http://localhost:8088/reentry",this.formData)
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
					jianlirData:[],
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
						  title:'',
				          name: '',
				          idcard: '',
				          jobResponsibilities: '',
				          offername: '',
				          sex: '',
						  dateOfBirth:'',
						  place:'',
						  phone:'',
						  nation:'',
						  maritaStatus:'',
						  highestEducation:'',
						  academicDegree:'',
						  mailbox:'',						  
						  offerStatus: '',
						  directsuperior: '',
						  station:'',
						  department:'',
						  officeLocation:'',
						  basePay:'',
						  meritPay:'',
						  regularSalary:'',
						  probationPeriod:'',
						  probationPeriodSalary:'',
						  arrivalTime:''
				        },
				        formLabelWidth: '120px'	,
						
						//简历
						dialogFormVisible2: false,
						    form2: {
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
