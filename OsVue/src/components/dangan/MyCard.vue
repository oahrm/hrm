<template>
	<el-tabs v-model="activeName" @tab-click="handleClick">
	    <el-tab-pane label="基本信息" name="a">
			
		</el-tab-pane>
	    <el-tab-pane label="工作历程" name="b">
			
		</el-tab-pane>
	    <el-tab-pane label="个人信息" name="c">
			
		</el-tab-pane>
		<el-tab-pane label="工作信息" name="d">
			
		</el-tab-pane>
		<el-tab-pane label="资产信息" name="e">
			
		</el-tab-pane>
		<el-tab-pane label="考勤情况" name="f">
			
		</el-tab-pane>
				
	</el-tabs>
</template>

<script>
	export default {
	    data() {
	      return {
	        activeName: 'a'
	      }
	    }
	}
</script>

<style>
</style>
