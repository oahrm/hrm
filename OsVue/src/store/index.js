import { createStore } from 'vuex'
const store = createStore({
  state: {
    count: 0,
	employee:{
		empId:"7",
		empName:"熊大"
	}
  },
  getters:{
  	  empId:(state)=>{
  		  return state.employee.empId
  	  }
  }
})
export default store
