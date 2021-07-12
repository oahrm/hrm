<template>
	<el-tabs v-model="activeName" @tab-click="handleClick">
	    <el-tab-pane label="基本信息" name="a">
			<el-collapse v-model="activeNames" @change="handleChange">
			  <el-collapse-item title="基本信息" name="1" class="item">
			    <el-form :model="emp" :label-position="right"  label-width="120px" :inline="true">
					<el-form-item label="岗位:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="职级:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="职责描述:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="办公地点:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="状态:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="直接上级:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="下属:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
				</el-form>
			  </el-collapse-item>
			  <el-collapse-item title="通讯信息" name="2">
				<el-form :model="emp" :label-position="right" label-width="120px" :inline="true">
					<el-form-item label="移动电话:">
					    <el-input v-model="emp.name" :disabled="flag"></el-input>
					</el-form-item>
					<el-form-item label="办公室电话:">
					    <el-input v-model="emp.name" :disabled="flag"></el-input>
					</el-form-item>
					<el-form-item label="紧急联系人电话:">
					    <el-input v-model="emp.name" :disabled="flag"></el-input>
					</el-form-item>
					<el-form-item label="电子邮箱:">
					    <el-input v-model="emp.name" :disabled="flag"></el-input>
					</el-form-item>
				</el-form>
			  </el-collapse-item>
			</el-collapse>
			<el-button type="primary" v-show="isShow1" @click="update">修改</el-button>
			<el-button type="primary" v-show="isShow2" @click="add">保存</el-button>
			<el-button type="primary" v-show="isShow2" @click="qx">取消</el-button>
		</el-tab-pane>
	    <el-tab-pane label="工作历程" name="b">
			
		</el-tab-pane>
	    <el-tab-pane label="个人信息" name="c">
			<el-collapse v-model="activeNames3" @change="handleChange">
			  <el-collapse-item title="个人信息" name="11" class="item">
			    <el-form :model="emp" :label-position="right"  label-width="120px" :inline="true">
					<el-form-item label="出生日期:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="民族:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="籍贯:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="政治面貌:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="身份证:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="入党日期:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="学历:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="学位:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="现住地:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
				</el-form>
			  </el-collapse-item>
			</el-collapse>
		</el-tab-pane>
		<el-tab-pane label="工作信息" name="d">
			<el-collapse v-model="activeNames4" @change="handleChange">
			  <el-collapse-item title="工作信息" name="111" class="item">
			    <el-form :model="emp" :label-position="right"  label-width="120px" :inline="true">
					<el-form-item label="用工性质:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="入职日期:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="合同开始日期:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="试用期结束日期:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="合同结束日期:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="参加工作日期:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="工龄:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
					<el-form-item label="司龄:">
					    <el-input v-model="emp.name" disabled></el-input>
					</el-form-item>
				</el-form>
			  </el-collapse-item>
			</el-collapse>
		</el-tab-pane>
		<el-tab-pane label="资产信息" name="e">
			<el-table
				ref="multipleTable"
				:data="zc"
				tooltip-effect="dark"
				style="width: 100%">
				<el-table-column prop="isItOnline" label="编号" width="120"></el-table-column>
				<el-table-column prop="name" label="名称" width="100"></el-table-column>
				<el-table-column prop="sex" label="使用部门" show-overflow-tooltip></el-table-column>
				<el-table-column prop="post" label="使用人" show-overflow-tooltip></el-table-column>
				<el-table-column prop="deptName" label="规格型号" show-overflow-tooltip></el-table-column>
				<el-table-column prop="mobile" label="资产组" show-overflow-tooltip></el-table-column>
				<el-table-column prop="mobile" label="状态" show-overflow-tooltip></el-table-column>
			</el-table>
		</el-tab-pane>
		<el-tab-pane label="考勤情况" name="f">
			
		</el-tab-pane>
				
	</el-tabs>
</template>

<script>
	export default {
	    data() {
	      return {
	        activeName: 'a',
			activeNames3: '11',
			activeNames4: '111',
			formData:{},
			zc: [],
			activeNames: ['1','2'],
			emp: {},
			flag: true,
			isShow1: true,
			isShow2: false
	      }
	    },
		methods:{
			handleClick(tab, event) {
	
			},
			update(){
				this.isShow1 = false
				this.isShow2 = true
				this.flag = false
			},
			add(){
				this.isShow1 = true
				this.isShow2 = false
				this.flag = true
			},
			qx(){
				this.isShow1 = true
				this.isShow2 = false
				this.flag = true
			}
		}
	}
</script>

<style>
	.item{
		color: blue;
		font-size: 20px;
	}
</style>
