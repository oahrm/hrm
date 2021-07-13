<template>
   <el-container>
      <el-aside width="200px">
		  <el-scrollbar>
		  <div class="head">
			  <img src="./assets/mlogo.png" alt="logo"/>
			  <h4>oa后台管理系统</h4>
		  </div>
		  <el-menu default-active="2"  
			background-color="#55557f"
			text-color="#fff"
		  	 class="el-menu-vertical-demo" :collapse="isCollapse"
		  	 unique-opened>
		        <el-submenu index="1">
		          <template #title><i class="el-icon-message"></i>招聘管理</template>
		          <el-menu-item-group >
					<router-link to="/PostManagement">
						<el-menu-item index="1-1">职位管理</el-menu-item>
					</router-link>
		          </el-menu-item-group>
				  <el-menu-item-group >
					 <router-link to="/JobRequirements">
						<el-menu-item index="1-2">岗位需求</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
					 <router-link to="/NoticeOfEntry">
						<el-menu-item index="1-3">简历中心</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
				  	<router-link to="/InterviewManagement">
						<el-menu-item index="1-4">面试管理</el-menu-item>
				  	</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
				  	<router-link to="/ResumeCenter">
				  		<el-menu-item index="1-5">入职通知</el-menu-item>
				  	</router-link>
				  </el-menu-item-group>
				</el-submenu>
				
				<el-submenu index="2">
				  <template #title><i class="el-icon-message"></i>人事关系</template>
				  <el-menu-item-group >
					<router-link to="/EmployeeInduction">
						<el-menu-item index="2-1">员工入职</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
					 <router-link to="/LaborContract">
						<el-menu-item index="2-2">劳动合同签署</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
					 <router-link to="/EmployeesBecomeRegular">
						<el-menu-item index="2-3">员工转正</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
				  	<router-link to="/StaffTransfer">
						<el-menu-item index="2-4">员工调岗</el-menu-item>
				  	</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
				  	<router-link to="/EmployeeTurnover">
				  		<el-menu-item index="2-5">员工离职</el-menu-item>
				  	</router-link>
				  </el-menu-item-group>
				</el-submenu>
				
				<el-submenu index="3">
				  <template #title><i class="el-icon-message"></i>员工档案</template>
				  <el-menu-item-group >
					<router-link to="/EmployeeAccount">
						<el-menu-item index="3-1">员工台账</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
					 <router-link to="/MyCard">
						<el-menu-item index="3-2">我的卡片</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
					 <router-link to="/MySubordinates">
						<el-menu-item index="3-3">我的下属</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				</el-submenu>
				
				<el-submenu index="4">
				  <template #title><i class="el-icon-message"></i>考勤管理</template>
				  <el-menu-item-group >
					<router-link to="/NewAttendance">
						<el-menu-item index="4-1">添加员工考勤</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
					 <router-link to="/AttendanceTime">
						<el-menu-item index="4-2">设置考勤时间</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
					 <router-link to="/FieldCheckIn">
						<el-menu-item index="4-3">外勤签到</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
				  	<router-link to="/AttendanceReport">
						<el-menu-item index="4-4">考勤报表</el-menu-item>
				  	</router-link>
				  </el-menu-item-group>
				</el-submenu>
				
				<el-submenu index="5">
				  <template #title><i class="el-icon-message"></i>绩效管理</template>
				  <el-menu-item-group >
					<router-link to="/ParameterSetting">
						<el-menu-item index="5-1">绩效设置</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
					 <router-link to="/PerformanceScore">
						<el-menu-item index="5-2">绩效评分</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				</el-submenu>
				
				<el-submenu index="7">
				  <template #title><i class="el-icon-message"></i>项目管理</template>
				  <el-menu-item-group >
					<router-link to="/NewProject">
						<el-menu-item index="6-1">新建项目</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
					 <router-link to="/TaskExecution">
						<el-menu-item index="6-2">任务执行</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
					 <router-link to="/TaskApproval">
						<el-menu-item index="6-3">任务审批</el-menu-item>
					</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
				  	<router-link to="/MyProject">
						<el-menu-item index="6-4">我的项目</el-menu-item>
				  	</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
				  	<router-link to="/ProjectImp">
				  		<el-menu-item index="6-5">项目执行</el-menu-item>
				  	</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
				  	<router-link to="/ProjectAcceptance">
				  		<el-menu-item index="6-6">项目验收</el-menu-item>
				  	</router-link>
				  </el-menu-item-group>
				  <el-menu-item-group >
				  	<router-link to="/ProjectDaily">
				  		<el-menu-item index="6-7">项目日报</el-menu-item>
				  	</router-link>
				  </el-menu-item-group>
				</el-submenu>	
			</el-menu>
		</el-scrollbar>
				
	  </el-aside>
      <el-container>
        <el-header>后台管理系统</el-header>
        <el-main>
			<router-view></router-view>
		</el-main>
      </el-container>
    </el-container>

</template>

<script>
export default{
	data(){
		return{
			// isCollapse:true
		}
	}
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0;
}
	.el-header {
		border: #2C3E50 solid 1px;
		/* background-color: #2C3E50; */
		font-size: 20px;
		line-height: 60px;
		font-size: 22px;
	}
	
	.el-aside {
		/* background: #4591e9 !important; */
		/* background-color: #2C3E50; */
		border: #2C3E50 solid 1px;
		display: block;
		overflow-y: scroll;
		height:100%;
	}

	.el-main {
		/* background-color: #2C3E50; */
		border: #2C3E50 solid 1px;
		color: #333;
		text-align: center;
		height:100%;
	}

	.el-container {
		height: 100%;
	}
</style>
