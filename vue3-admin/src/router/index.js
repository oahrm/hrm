import { createRouter, createWebHashHistory } from 'vue-router'

const router = createRouter({
  history: createWebHashHistory(), // hash模式：createWebHashHistory，history模式：createWebHistory
  routes: [
    {
      path: '/',
      redirect: '/introduce'
    },
    {
      path: '/post',
      name: 'post',
      component: () => import('../views/rec/RecPost.vue')
    },
    {
      path: '/job',
      name: 'job',
      component: () => import('../views/rec/RecJob.vue')
    },
	{
	  path: '/noe',
	  name: 'noe',
	  component: () => import('../views/rec/RecNoe.vue')
	},
	{
	  path: '/inter',
	  name: 'inter',
	  component: () => import('../views/rec/RecInter.vue')
	},
	{
	  path: '/res',
	  name: 'res',
	  component: () => import('../views/rec/RecRes.vue')
	},
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/Login.vue')
    },
	{
	  path: '/perBarw',
	  name: 'perBarw',
	  component: () => import( '../views/per/PerBarw.vue')
	},
	{
	  path: '/perEnt',
	  name: 'perEnt',
	  component: () => import( '../views/per/PerEnt.vue')
	},
	{
	  path: '/perPost',
	  name: 'perPost',
	  component: () => import( '../views/per/PerPost.vue')
	},
	{
	  path: '/perQuid',
	  name: 'perQuid',
	  component: () => import( '../views/per/PerQuid.vue')
	},
	{
	  path: '/perCont',
	  name: 'perCont',
	  component: () => import( '../views/per/PerCont.vue')
	},
	{
	  path: '/arcCard',
	  name: 'arcCard',
	  component: () => import('../views/archives/ArcCard.vue')
	},
	{
	  path: '/arcMail',
	  name: 'arcMail',
	  component: () => import('../views/archives/ArcMail.vue')
	},
	{
	  path: '/arcMySub',
	  name: 'arcMySub',
	  component: () => import('../views/archives/ArcMySub.vue')
	},
	{
	  path: '/atteAdd',
	  name: 'atteAdd',
	  component: () => import( '../views/atte/AtteAdd.vue')
	},
	{
	  path: '/atteFci',
	  name: 'atteFci',
	  component: () => import( '../views/atte/AtteFci.vue')
	},
	{
	  path: '/atteSet',
	  name: 'atteSet',
	  component: () => import( '../views/atte/AtteSet.vue')
	},
	{
	  path: '/atteSum',
	  name: 'atteSum',
	  component: () => import( '../views/atte/AtteSum.vue')
	},
	{
	  path: '/achScore',
	  name: 'achScore',
	  component: () => import( '../views/ach/AchScore.vue')
	},
	{
	  path: '/achSet',
	  name: 'achSet',
	  component: () => import( '../views/ach/AchSet.vue')
	},
	//7
	{
	  path: '/mypro',
	  name: 'mypro',
	  component: () => import( '../views/pro/Mypro.vue')
	},
	{
	  path: '/proadd',
	  name: 'proadd',
	  component: () => import( '../views/pro/ProAdd.vue')
	},
	{
	  path: '/procba',
	  name: 'procba',
	  component: () => import( '../views/pro/ProCba.vue')
	},
	{
	  path: '/proday',
	  name: 'proday',
	  component: () => import( '../views/pro/ProDay.vue')
	},
	{
	  path: '/proimp',
	  name: 'proimp',
	  component: () => import( '../views/pro/ProImp.vue')
	},
	{
	  path: '/prokan',
	  name: 'prokan',
	  component: () => import( '../views/pro/ProKan.vue')
	},
	{
	  path: '/promon',
	  name: 'promon',
	  component: () => import( '../views/pro/ProMon.vue')
	},
    {
      path: '/swiper',
      name: 'swiper',
      component: () => import( '../views/Swiper.vue')
    },
    {
      path: '/hot',
      name: 'hot',
      component: () => import('../views/IndexConfig.vue')
    },
    {
      path: '/new',
      name: 'new',
      component: () => import('../views/IndexConfig.vue')
    },
    {
      path: '/recommend',
      name: 'recommend',
      component: () => import('../views/IndexConfig.vue')
    },
    {
      path: '/category',
      name: 'category',
      component: () => import('../views/Category.vue'),
      children: [
        {
          path: '/category/level2',
          name: 'level2',
          component: () => import('../views/Category.vue'),
        },
        {
          path: '/category/level3',
          name: 'level3',
          component: () => import('../views/Category.vue'),
        }
      ]
    },
    {
      path: '/good',
      name: 'good',
      component: () => import('../views/Good.vue')
    },
    {
      path: '/guest',
      name: 'guest',
      component: () => import('../views/Guest.vue')
    },
    {
      path: '/order',
      name: 'order',
      component: () => import('../views/Order.vue')
    },
    {
      path: '/order_detail',
      name: 'order_detail',
      component: () => import('../views/OrderDetail.vue')
    }
  ]
})

export default router