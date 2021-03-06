import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Home from '@/components/Home'
import ArticleList from '@/components/ArticleList'
import CateMana from '@/components/CateMana'
import DataCharts from '@/components/DataCharts'
import PostArticle from '@/components/PostArticle'
import UserMana from '@/components/UserMana'
import BlogDetail from '@/components/BlogDetail'
import YBSaleAdd from "@/components/YBSaleAdd";
import YBSaleList from "../components/YBSaleList";
import YBSystemList from "../components/YBSystemList";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '登录',
      hidden: true,
      component: Login
    }, {
      path: '/home',
      name: '',
      component: Home,
      hidden: true
    },
    {
      path: '/home',
      component: Home,
      name: '销售管理',
      iconCls: 'fa fa-file-text-o',
      // hidden: true,
      children: [
        {
          path: '/articleList',
          name: '销售业绩',
          component: ArticleList,
          iconCls: 'fa fa-file-text-o',
          // hidden: true,
          meta: {
            keepAlive: true
          }
        }
        // , {
        //   path: '/postArticle',
        //   name: '发表文章',
        //   component: PostArticle,
        //   meta: {
        //     keepAlive: false
        //   }
        // }, {
        //   path: '/blogDetail',
        //   name: '博客详情',
        //   component: BlogDetail,
        //   hidden: true,
        //   meta: {
        //     keepAlive: false
        //   }
        // }, {
        //   path: '/editBlog',
        //   name: '编辑博客',
        //   component: PostArticle,
        //   hidden: true,
        //   meta: {
        //     keepAlive: false
        //   }
        // }
      ]
    },
    // , {
    //   path: '/home',
    //   component: Home,
    //   name: '用户管理',
    //   children: [
    //     {
    //       path: '/user',
    //       iconCls: 'fa fa-user-o',
    //       name: '用户管理',
    //       component: UserMana
    //     }
    //   ]
    // }, {
    //   path: '/home',
    //   component: Home,
    //   name: '栏目管理',
    //   children: [
    //     {
    //       path: '/cateMana',
    //       iconCls: 'fa fa-reorder',
    //       name: '栏目管理',
    //       component: CateMana
    //     }
    //   ]
    // },
    // {
    //   path: '/home',
    //   component: Home,
    //   name: '数据统计',
    //   iconCls: 'fa fa-bar-chart',
    //   children: [
    //     {
    //       path: '/charts',
    //       iconCls: 'fa fa-bar-chart',
    //       name: '数据统计',
    //       component: DataCharts
    //     }
    //   ]
    // },
    {
      path: '/home',
      component: Home,
      name: '销售管理',
      iconCls: 'fa fa-bar-chart',
      children: [
        {
          path: '/charts',
          iconCls: 'fa fa-bar-chart',
          name: '销售管理',
          component: YBSaleList
        }
      ]
    },
    {
      path: '/home',
      component: Home,
      name: '用户管理',
      iconCls: 'fa fa-bar-chart',
      children: [
        {
          path: '/system',
          iconCls: 'fa fa-user-o',
          name: '系统管理',
          component: YBSystemList
        }
      ]
    }
    ,
  ]
})
