<template>
	<div>
		<el-table ref="multipleTable" :data="OfferHuPersonnelbecomeData" style="width: 100%" max-height="750">

			<el-table-column prop="station" label="所属岗位" width="">
			</el-table-column>
			<el-table-column prop="sex" label="性别" width="">
			</el-table-column>
			<el-table-column prop="phone" label="手机号码">
			</el-table-column>
			<el-table-column prop="mailbox" label="邮箱" width="">
			</el-table-column>
			<el-table-column prop="name" label="员工姓名" width="">
			</el-table-column>
			<el-table-column fixed prop="arrivalTime" label="日期" width="">
			</el-table-column>
			<el-table-column prop="re_entry_applica.entrystatus" label="状态" width="" show-overflow-tooltip>
				<template v-slot="scope">
					<p v-if="scope.row.re_entry_applica.entrystatus==0">未入职</p>
					<p v-if="scope.row.re_entry_applica.entrystatus==1">已入职</p>
				</template>
			</el-table-column>
			<el-table-column fixed="right" label="操作" width="">
				<template #default="scope">
					<el-button type="text" @click="showEdit(scope.row)">入职</el-button>
				</template>
			</el-table-column>
		</el-table>
	</div>
	
	<div>
		<el-dialog v-model="dialogFormVisible" title="员工合同签署" :before-close="cls">
			<el-form :inline="true" :model="form" ref="ruleForm" class="demo-ruleForm">
				<div style="display: flex; justify-content: space-between;">
					<el-form-item label="签署人 :" prop="zxr">
						<el-input disabled v-model="form.name" style="width:150px"></el-input>
					</el-form-item>
					<el-form-item label="岗位 :" prop="zxr">
						<el-input disabled v-model="form.station" style="width:150px"></el-input>
					</el-form-item>
				</div>
				<div style="display: flex; justify-content: space-between;">
					<el-form-item label="联系电话 :" prop="lxdh">
						<el-input disabled v-model="form.phone" style="width:150px"></el-input>
					</el-form-item>
					<el-form-item label="邮箱 :" prop="lxdh">
						<el-input disabled v-model="form.mailbox" style="width:150px"></el-input>
					</el-form-item>
	
				</div>
				<div style="display: flex; justify-content: space-between;">
	
					<el-form-item label="签署时间 :" prop="zxnr">
						<el-input disabled type="textarea" v-model="form.arrivalTime"></el-input>
					</el-form-item>
				</div>
			</el-form>
			<template #footer>
				<span class="dialog-footer">
					<el-button type="primary" @click="updateOffer_HuP(form.id)">提交</el-button>
					<el-button>取 消</el-button>
				</span>
			</template>
		</el-dialog>
	</div>

</template>

<script>
	import qs from "qs"
	import {
		defineComponent,
		ref
	} from 'vue'
	
	export default {
		data() {
			return {
				OfferHuPersonnelbecomeData: [],
				dialogFormVisible: false,
				form: {
					id: '',
					name: '',
					station: '',
					phone: '',
					mailbox: '',
					arrivalTime: '',
					sex: '',
					contractstatus: '',
					entrystatus:''
				}
			}
		},
		methods: {
			showEdit(row) {
				console.log(row);
				this.form.id = row.re_entry_applica.id;
				this.form.name = row.name;
				this.form.station = row.station;
				this.form.phone = row.phone;
				this.form.mailbox = row.mailbox;
				this.form.sex = row.sex;
				this.form.arrivalTime = row.arrivalTime;
				this.form.contractstatus = row.contractstatus;
				this.form.entrystatus = row.entrystatus;
				this.dialogFormVisible = true
			},
			updateOffer_HuP(id) {
				console.log(this.form.id)
				const _this = this
				this.axios.put("http://localhost:8088/updateOffer_HuP/" + id)
					.then(function(response) {
						_this.OfferHuPersonnelbecomeData = response.data.data
						console.log(response)
						_this.dialogFormVisible = false
					}).catch(function(error) {
						console.log(error)
					})
			}
		// 	updateOffer_HuP(id) {
		// 			const _this = this
		// 			this.$confirm('确定提交员工合同吗', '提示', {
		// 					confirmButtonText: '确定',
		// 					cancelButtonText: '取消',
		// 					type: 'warning'
		// 				}).then(()=>{
		// 					console.log("-=-=-=-=-=-=-=-=-==-=-")
		// 			this.axios.put("http://localhost:8088/updateOffer_HuP/" + id)
		// 					.then(function(response) {
		// 						_this.axios.get("http://localhost:8088/updateOffer_HuP")
		// 							.then(function(response) {
		// 								_this.OfferHuPersonnelbecomeData = response.data.data
		// 								console.log(response)
		// 							}).catch(function(error) {
		// 								console.log(error)
		// 							})
		// 						_this.dialogFormVisible = false
		// 					}).catch(function(error) {
		// 						console.log(error)
		// 					})
		// 					}).catch(function(){
		// 						this.$message({
		// 							type: 'error',
		// 							message: '取消提交'
		// 						});
		// 					})
		// 			}
		// },
		},
		created() {
			const _this = this
			this.axios.get("http://localhost:8088/selectAllOffer_HuP")
				.then(function(response) {
					_this.OfferHuPersonnelbecomeData = response.data.data
					console.log(response)
				}).catch(function(error) {
					console.log(error)
				})
		}
	}
</script>
