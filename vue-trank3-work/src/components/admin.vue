<template>
  <el-container>
    <el-header class="headStyle">
      <el-menu
        :default-active="'2'"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <el-menu-item index="1">
          <i class="el-icon-platform-eleme"></i>
          <span>档案管理系统</span>
        </el-menu-item>
        <el-link type = "info" v-on:click="quit" style = "float: right; margin-right: 20px; margin-top: 15px">退出</el-link>
      </el-menu>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <el-col :span="24">
          <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            @open = "handleOpen"
            @close="closeHandle"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b">
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-user"></i>
                <span>个人信息</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="1-1">我的申请单</el-menu-item>
                <el-menu-item index="1-2">我的审批单</el-menu-item>
                <el-menu-item index="1-3">修改密码</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>系统管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="2-1">部门管理</el-menu-item>
                <el-menu-item index="2-2">密集管理</el-menu-item>
                <el-menu-item index="2-3">人员管理</el-menu-item>
                <el-menu-item index="2-4">人员功能授权</el-menu-item>
                <el-menu-item index="2-4">库位管理</el-menu-item>
                <el-menu-item index="2-4">档案分类管理</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

            <el-submenu index="3">
              <template slot="title">
                <i class="el-icon-notebook-2"></i>
                <span>档案应用</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="3-1">档案著录</el-menu-item>
                <el-menu-item index="3-2">档案导入</el-menu-item>
                <el-menu-item index="3-3">档案查询</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

            <el-submenu index="4">
              <template slot="title">
                <i class="el-icon-notebook-1"></i>
                <span>档案统计</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="4-1">入库统计</el-menu-item>
                <el-menu-item index="4-2">借阅统计</el-menu-item>
                <el-menu-item index="4-3">借阅记录查询</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-col>
      </el-aside>
      <el-main><router-view></router-view></el-main>
    </el-container>
  </el-container>
</template>

<script>
  export default {
    name: 'Shop-admin',
    created(){

    },
    methods: {
      quit(){

      },
      handleSelect(key, keyPath) {
        console.log(key, keyPath)
      },
      handleOpen(key, keyPath){
        console.log(key, keyPath);
      },
      closeHandle(key, keyPath){
        console.log(key, keyPath);
      }
    }
  }
</script>

<style scoped>
  .headStyle{
    padding: 0;
  }
</style>
