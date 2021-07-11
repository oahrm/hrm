<template>
  <div class="layout">
    <el-container v-if="state.showMenu" class="container">
      <el-aside class="aside">
        <div class="head">
          <div>
            <img src="https://s.weituibao.com/1582958061265/mlogo.png" alt="logo">
            <span>vue3 admin</span>
          </div>
        </div>
        <div class="line" />
        <el-menu
          :default-openeds="state.defaultOpen"
          background-color="#222832"
          text-color="#fff"
          :router="true"
          :default-active='state.currentPath'
        >
          <el-submenu index="1">
            <template #title>
              <span>招聘管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="/post"><i class="el-icon-data-line" />职位管理</el-menu-item>
              <el-menu-item index="/job"><i class="el-icon-odometer" />岗位要求</el-menu-item>
              <el-menu-item index="/add"><i class="el-icon-plus" />简历管理</el-menu-item>
			  <el-menu-item index="/add"><i class="el-icon-plus" />面试管理</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2">
            <template #title>
              <span>人事关系</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="/swiper"><i class="el-icon-picture" />劳务合同签署</el-menu-item>
              <el-menu-item index="/hot"><i class="el-icon-star-on" />员工入职</el-menu-item>
              <el-menu-item index="/new"><i class="el-icon-sell" />员工转正</el-menu-item>
              <el-menu-item index="/recommend"><i class="el-icon-thumb" />员工调岗</el-menu-item>
			  <el-menu-item index="/recommend"><i class="el-icon-thumb" />员工离职</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="3">
            <template #title>
              <span>员工档案</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="/category"><i class="el-icon-menu" />员工台账</el-menu-item>
              <el-menu-item index="/good"><i class="el-icon-s-goods" />我的卡片</el-menu-item>
              <el-menu-item index="/guest"><i class="el-icon-user-solid" />我的下属</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="4">
            <template #title>
              <span>考勤管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="/account"><i class="el-icon-lock" />添加员工考勤信息</el-menu-item>
			  <el-menu-item index="/account"><i class="el-icon-lock" />设置考勤时间</el-menu-item>
			  <el-menu-item index="/account"><i class="el-icon-lock" />外勤签到</el-menu-item>
			  <el-menu-item index="/account"><i class="el-icon-lock" />考勤汇总报表</el-menu-item>
			</el-menu-item-group>
          </el-submenu>
		  <el-submenu index="5">
		    <template #title>
		      <span>绩效管理</span>
		    </template>
		    <el-menu-item-group>
		      <el-menu-item index="/account"><i class="el-icon-lock" />绩效评分</el-menu-item>
			  <el-menu-item index="/account"><i class="el-icon-lock" />绩效参数设置</el-menu-item>
			</el-menu-item-group>
		  </el-submenu>
		  <el-submenu index="6">
		    <template #title>
		      <span>项目管理</span>
		    </template>
		    <el-menu-item-group>
		      <el-menu-item index="/account"><i class="el-icon-lock" />创建新项目</el-menu-item>
			  <el-menu-item index="/account"><i class="el-icon-lock" />任务执行</el-menu-item>
			  <el-menu-item index="/account"><i class="el-icon-lock" />我的项目</el-menu-item>
			  <el-menu-item index="/account"><i class="el-icon-lock" />项目验收</el-menu-item>
			  <el-menu-item index="/account"><i class="el-icon-lock" />项目日报</el-menu-item>
			  <el-menu-item index="/account"><i class="el-icon-lock" />项目监控</el-menu-item>
			  <el-menu-item index="/account"><i class="el-icon-lock" />项目看板</el-menu-item>
		    </el-menu-item-group>
		  </el-submenu>
        </el-menu>
      </el-aside>
      <el-container class="content">
        <Header />
        <div class="main">
          <router-view />
        </div>
        <Footer />
      </el-container>
    </el-container>
    <el-container v-else class="container">
      <router-view />
    </el-container>
  </div>
</template>

<script>
import { onUnmounted, reactive } from 'vue'
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
import { useRouter } from 'vue-router'
import { pathMap, localGet } from '@/utils'
export default {
  name: 'App',
  components: {
    Header,
    Footer
  },
  setup() {
    const noMenu = ['/login']
    const router = useRouter()
    const state = reactive({
      defaultOpen: ['1', '2', '3', '4'],
      showMenu: true,
      currentPath: '/dashboard',
      count: {
        number: 1
      }
    })
    // 监听浏览器原生回退事件
    if (window.history && window.history.pushState) {
      history.pushState(null, null, document.URL);
      window.addEventListener('popstate', () => {
        if (!localGet('token')) {
          state.showMenu = false
        }
      }, false);
    }
    const unwatch = router.beforeEach((to, from, next) => {
      if (to.path == '/login') {
        // 如果路径是 /login 则正常执行
        next()
      } else {
        // 如果不是 /login，判断是否有 token
        if (!localGet('token')) {
          // 如果没有，则跳至登录页面
          next({ path: '/login' })
        } else {
          // 否则继续执行
          next()
        }
      }
      state.showMenu = !noMenu.includes(to.path)
      state.currentPath = to.path
      document.title = pathMap[to.name]
    })

    onUnmounted(() => {
      unwatch()
    })

    return {
      state
    }
  }
}
</script>

<style scoped>
  .layout {
    min-height: 100vh;
    background-color: #ffffff;
  }
  .container {
    height: 100vh;
  }
  .aside {
    width: 200px!important;
    background-color: #222832;
    overflow: hidden;
    overflow-y: auto;
    -ms-overflow-style: none;
    overflow: -moz-scrollbars-none;
  }
  .aside::-webkit-scrollbar {
    display: none;
  }
  .head {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 50px;
  }
  .head > div {
    display: flex;
    align-items: center;
  }

  .head img {
    width: 50px;
    height: 50px;
    margin-right: 10px;
  }
  .head span {
    font-size: 20px;
    color: #ffffff;
  }
  .line {
    border-top: 1px solid hsla(0,0%,100%,.05);
    border-bottom: 1px solid rgba(0,0,0,.2);
  }
  .content {
    display: flex;
    flex-direction: column;
    max-height: 100vh;
    overflow: hidden;
  }
  .main {
    height: calc(100vh - 100px);
    overflow: auto;
    padding: 10px;
  }
</style>
<style>
  body {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
  }
  .el-menu {
    border-right: none!important;
  }
  .el-submenu {
    border-top: 1px solid hsla(0, 0%, 100%, .05);
    border-bottom: 1px solid rgba(0, 0, 0, .2);
  }
  .el-submenu:first-child {
    border-top: none;
  }
  .el-submenu [class^="el-icon-"] {
    vertical-align: -1px!important;
  }
  a {
    color: #409eff;
    text-decoration: none;
  }
  .el-pagination {
    text-align: center;
    margin-top: 20px;
  }
  .el-popper__arrow {
    display: none;
  }
</style>
