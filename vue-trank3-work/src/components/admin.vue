<template>
  <div>
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
          <span>协同办公系统</span>
        </el-menu-item>
        <div style="padding-top: 10px">
          <el-link type = "info" v-on:click="quit" style = "float: right; margin-right: 20px; margin-top: 15px">退出</el-link>
          <el-link type="warning" v-on:click="tankuang" style = "float: right; margin-right: 20px; margin-top: 15px">修改密码</el-link>
          <el-link type="primary" v-on:click="quit" style = "float: right; margin-right: 20px; margin-top: 15px">欢迎你，{{personnel.numbering}}</el-link>
        </div>

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
                <i class="el-icon-user-solid"></i>
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
                <el-menu-item index="2-1">人员管理</el-menu-item>
                <el-menu-item index="2-2">部门管理</el-menu-item>
                <el-menu-item index="2-3">人员功能授权</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

            <el-submenu index="3">
              <template slot="title">
                <i class="el-icon-folder"></i>
                <span>档案管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="3-1">档案应用</el-menu-item>
                <el-menu-item index="3-2">密级管理</el-menu-item>
                <el-menu-item index="3-3">分类管理</el-menu-item>
                <el-menu-item index="3-4">库位管理</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

            <el-submenu index="4">
              <template slot="title">
                <i class="el-icon-money"></i>
                <span>资产管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="4-1">固定资产</el-menu-item>
                <el-menu-item index="4-2">资产类别</el-menu-item>
                <el-menu-item index="4-3">资产报损</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

            <el-submenu index="5">
              <template slot="title">
                <i class="el-icon-coin"></i>
                <span>办公用品</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="5-1">物品详情</el-menu-item>
                <el-menu-item index="5-2">物品领出</el-menu-item>
                <el-menu-item index="5-3">查看库存</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

            <el-submenu index="6">
              <template slot="title">
                <i class="el-icon-s-home"></i>
                <span>会议管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="6-1">会议信息</el-menu-item>
                <el-menu-item index="6-2">会议室管理</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

            <el-submenu index="7">
              <template slot="title">
                <i class="el-icon-truck"></i>
                <span>车辆管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="7-1">车辆信息</el-menu-item>
                <el-menu-item index="7-2">派车管理</el-menu-item>
                <el-menu-item index="7-3">修车管理</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

            <el-submenu index="8">
              <template slot="title">
                <i class="el-icon-date"></i>
                <span>考勤管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="8-1">考勤信息</el-menu-item>
                <el-menu-item index="8-2">考勤类别</el-menu-item>
              </el-menu-item-group>
            </el-submenu>


          </el-menu>
        </el-col>
      </el-aside>
      <el-main><router-view></router-view>


        <div>
          <el-dialog title="员工" :visible.sync="dialogFormVisible">
          <el-form :model="personnels" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

            <el-form-item label="密码:" prop="password">
              <el-input type="password" v-model="personnels.password" autocomplete="off" style="width: 260px"></el-input>
            </el-form-item>
            <el-form-item label="确认密码:" prop="checkpassword">
              <el-input type="password" v-model="personnels.checkpassword" autocomplete="off" style="width: 260px"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" style="margin-left: 30px" @click="updatepassword('ruleForm')">提交</el-button>
              <el-button style="margin-left: 30px" @click="dialogFormVisible = false">取消</el-button>
            </el-form-item>
          </el-form>
          </el-dialog>
        </div>

      </el-main>
    </el-container>
  </el-container>


</div>
</template>

<script>
  export default {
    name: 'Shop-admin',
    data() {
      return {
        personnel:"",
        dialogFormVisible:false,
        personnels:{
          password:"",
          checkpassword:"",

        },
      }
    },
    created(){
      if(this.personnel.numbering == null){
        this.queryPersonne();
      }

    },
    methods: {

      queryPersonne(){
        var self = this;
        this.$axios.post("http://localhost:8085/login/longinPersonnel").then(function (response) {

          console.log(response.data.data);
          self.personnel = response.data.data;
        })
      },
      updatepassword(){

        if(this.personnels.password!=null){
          if(this.personnels.password !== this.personnels.checkpassword){
            alert("两次密码不一致")
          }else{
            var self = this;
            this.personnel.password = this.personnels.password
            this.$axios.post("http://localhost:8085/personnel/updatePassword",this.$qs.stringify(this.personnel)).then(function (response) {

                self.dialogFormVisible=false;

            })
          }
        }else{
          alert("密码不能为空")
        }

      },

      tankuang:function (index, row) {
        this.dialogFormVisible=true;
      },
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
