// router的函数，createRouter：创建路由管理器的。createWebHashHistory：创建的模式，以锚的形式。
import { createRouter,createWebHashHistory,createWebHistory} from "vue-router"
//引进vue文件
//招聘
import InterviewManagement from '../components/zhaoping/InterviewManagement.vue'
import JobRequirements from '../components/zhaoping/JobRequirements.vue'
import NoticeOfEntry from '../components/zhaoping/NoticeOfEntry.vue'
import PostManagement from '../components/zhaoping/PostManagement.vue'
import ResumeCenter from '../components/zhaoping/ResumeCenter.vue'
//人事关系
import EmployeeInduction from '../components/guanxi/EmployeeInduction.vue'
import EmployeesBecomeRegular from '../components/guanxi/EmployeesBecomeRegular.vue'
import EmployeeTurnover from '../components/guanxi/EmployeeTurnover.vue'
import LaborContract from '../components/guanxi/LaborContract.vue'
import StaffTransfer from '../components/guanxi/StaffTransfer.vue'
//员工档案
import EmployeeAccount from '../components/dangan/EmployeeAccount.vue'
import MyCard from '../components/dangan/MyCard.vue'
import MySubordinates from '../components/dangan/MySubordinates.vue'
import MySubSubordinates from '../components/dangan/MySubSubordinates.vue'
//考勤
import AttendanceReport from '../components/kaoqing/AttendanceReport.vue'
import AttendanceTime from '../components/kaoqing/AttendanceTime.vue'
import FieldCheckIn from '../components/kaoqing/FieldCheckIn.vue'
import NewAttendance from '../components/kaoqing/NewAttendance.vue'
//绩效
import ParameterSetting from '../components/jixiao/ParameterSetting.vue'
import PerformanceScore from '../components/jixiao/PerformanceScore.vue'
//项目
import MyProject from '../components/xiangmu/MyProject.vue'
import NewProject from '../components/xiangmu/NewProject.vue'
import ProjectAcceptance from '../components/xiangmu/ProjectAcceptance.vue'
import ProjectDaily from '../components/xiangmu/ProjectDaily.vue'
import ProjectImp from '../components/xiangmu/ProjectImp.vue'
import TaskApproval from '../components/xiangmu/TaskApproval.vue'
import TaskExecution from '../components/xiangmu/TaskExecution.vue'

// 定义路由的数组
//对象，描述路径与组件的关系的
const routes=[
	//定义每个路径，对应的每个组件
	// {path:'/main',component:Mainview}
	{path:'/MySubSubordinates',component:MySubSubordinates},
	// 招聘
	{path:'/PostManagement',component:PostManagement},
	{path:'/JobRequirements',component:JobRequirements},
	{path:'/NoticeOfEntry',component:NoticeOfEntry},
	{path:'/InterviewManagement',component:InterviewManagement},
	{path:'/ResumeCenter',component:ResumeCenter},
	
	// 关系
	{path:'/EmployeeInduction',component:EmployeeInduction},
	{path:'/LaborContract',component:LaborContract},
	{path:'/EmployeeTurnover',component:EmployeeTurnover},
	{path:'/StaffTransfer',component:StaffTransfer},
	{path:'/EmployeesBecomeRegular',component:EmployeesBecomeRegular},
	// 考勤
	{path:'/NewAttendance',component:NewAttendance},
	{path:'/AttendanceTime',component:AttendanceTime},
	{path:'/FieldCheckIn',component:FieldCheckIn},
	{path:'/AttendanceReport',component:AttendanceReport},
	// 档案
	{path:'/EmployeeAccount',component:EmployeeAccount},
	{path:'/MyCard',component:MyCard},
	{path:'/MySubordinates',component:MySubordinates},
	//绩效
	{path:'/ParameterSetting',component:ParameterSetting},
	{path:'/PerformanceScore',component:PerformanceScore},
	//项目
	{path:'/NewProject',component:NewProject},
	{path:'/TaskExecution',component:TaskExecution},
	{path:'/TaskApproval',component:TaskApproval},
	{path:'/MyProject',component:MyProject},
	{path:'/ProjectImp',component:ProjectImp},
	{path:'/ProjectAcceptance',component:ProjectAcceptance},
	{path:'/ProjectDaily',component:ProjectDaily},
	

]
const router=createRouter({
	history:createWebHistory(),
	// 简写：routes:routes-->键：值
	routes
})
// 导出
export default router