<template>
    <div style="margin-left: 35%;margin-top: 13%">
      <el-form ref="form" :model="personnel" label-width="80px">
        <el-form-item label="账户">
          <el-input v-model="personnel.name" style="width: 260px"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="personnel.password" style="width: 260px"></el-input>
        </el-form-item>

        <!--<el-form-item label="手机号:" prop="phone">
          <el-input v-model="user.phone" style="width: 260px"></el-input>
          <el-button size="small" @click="getcoud()" type="primary" round>获取验证码</el-button>
        </el-form-item>
        <el-form-item label="验证码:" prop="code">
          <el-input v-model="user.code" style="width: 260px"></el-input>
        </el-form-item>-->

        <!--<template>
          <el-form-item>
            <el-checkbox v-model="user.remeber">记住我</el-checkbox>
          </el-form-item>
        </template>-->

        <el-form-item>
          <el-button type="primary" size="medium" style="margin-left: 50px" @click="onSubmit">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
</template>

<script>
  import Cookies from 'js-cookie'
  export default {
    data() {
      return {

        personnel: {
          remeber: false,
          name: '张三',
         password:"123",
         /* phone:"15137970287",
          code:"3479",*/
        }
      }
    },
    methods: {
    /*  getcoud(){
        var self = this;
        this.$axios.post("http://localhost:8080/member/getcode",this.$qs.stringify({'phone': this.user.phone})).then(function (response) {
          alert("发送验证码成功 请注意查收");

        })
      },*/
      onSubmit() {
        var self = this;
        this.$axios.post("http://localhost:8085/login/login",this.$qs.stringify(this.personnel)).then(function (response) {

          if(response.data.code==200){
            Cookies.set("token",response.data.data)

            self.$router.push("/PeopleVue");

          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
