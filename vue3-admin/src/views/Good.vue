<template>
  
</template>

<script>
import { onMounted, reactive, ref, toRefs } from 'vue'
import axios from '@/utils/axios'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
export default {
  name: 'Good',
  setup() {
    const multipleTable = ref(null)
    const router = useRouter()
    const state = reactive({
      loading: false,
      tableData: [], // 数据列表
      multipleSelection: [], // 选中项
      total: 0, // 总条数
      currentPage: 1, // 当前页
      pageSize: 10 // 分页大小
    })
    onMounted(() => {
      getGoodList()
    })
    // 获取轮播图列表
    const getGoodList = () => {
      state.loading = true
      axios.get('/goods/list', {
        params: {
          pageNumber: state.currentPage,
          pageSize: state.pageSize
        }
      }).then(res => {
        state.tableData = res.list
        state.total = res.totalCount
        state.currentPage = res.currPage
        state.loading = false
      })
    }
    const handleAdd = () => {
      router.push({ path: '/add' })
    }
    const handleEdit = (id) => {
      router.push({ path: '/add', query: { id } })
    }
    // 选择项
    const handleSelectionChange = (val) => {
      state.multipleSelection = val
    }
    const changePage = (val) => {
      state.currentPage = val
      getGoodList()
    }
    const handleStatus = (id, status) => {
      axios.put(`/goods/status/${status}`, {
        ids: id ? [id] : []
      }).then(() => {
        ElMessage.success('修改成功')
        getGoodList()
      })
    }
    return {
      ...toRefs(state),
      multipleTable,
      handleSelectionChange,
      handleAdd,
      handleEdit,
      getGoodList,
      changePage,
      handleStatus
    }
  }
}
</script>

<style scoped>
  .good-container {
    min-height: 100%;
  }
  .el-card.is-always-shadow {
    min-height: 100%!important;
  }
</style>