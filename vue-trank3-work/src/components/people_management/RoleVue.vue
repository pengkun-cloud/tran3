<template>
    <div>
      <div>
      <br style="height: 80%">
        用户列表<br>
      <el-button type="primary" @click="tankuang()">添加</el-button>
        <el-table
          :data="roleList"
          style="width: 100%" @row-click="clickRow" ref="tb">
          <el-table-column
            type="selection"
            width="30">
          </el-table-column>

          <el-table-column
            label="角色名称"
            width="100">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.rolename}}</span>
            </template>
          </el-table-column>

          <el-table-column
            label="用户状态"
            width="110">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.status==1?"是":"否"}}</span>
            </template>
          </el-table-column>

          <el-table-column
            label="角色权限"
            width="100">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.pemissionid}}</span>
            </template>
          </el-table-column>

          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button
                size="mini"
                @click="tankuang(scope.$index, scope.row)">修改</el-button>
              <el-button
                size="mini"
                type="danger"
                @click="deleteAnimal(scope.$index, scope.row)">删除</el-button>
            </template>
          </el-table-column>

        </el-table>


        <el-dialog title="角色" :visible.sync="dialogFormVisible">
          <el-form :model="role" label-width="150px">
            <el-input v-model="role.roleid" style="width: 260px"></el-input>


            <el-form-item label="用户名称:">
              <el-input v-model="role.rolename" style="width: 260px"></el-input>
            </el-form-item>



            <el-form-item label=" 状态 :">
              <template>
                <el-radio v-model="role.status" :label="1">是</el-radio>
                <el-radio v-model="role.status" :label="2">否</el-radio>
              </template>
            </el-form-item>



              <el-form-item label="用户角色" :label-width="formLabelWidth">
                <el-select v-model="role.pemissionid" placeholder="请选择">
                  <el-option v-for="item in pemissionList"
                             :key="item.id"
                             :label="item.name"
                             :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>


          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="updateoradd()">确 定</el-button>
          </div>
        </el-dialog>


      </div>
    </div>
</template>

<script>
    export default {
        name: "PeopleVue",
      data() {
        return {
          pemission:{
            id:"",
            name:"",
          },
          role:{
            roleid:"",
            rolename:"",
            pemissionid:"",

          },
          formLabelWidth:"120px",
          dialogFormVisible: false,
          roleList:[],
          pessionList:[],
        }
      },
      created:function(){
        this.queryRoleList();
        this.queryPemissionList();

      },
      methods: {

        queryRoleList(){
          var self = this;
          this.$axios.post("http://localhost:8085/role/queryRole").then(function (response) {
            console.log(response.data.data);
            self.roleList = response.data.data;
          })
        },

        queryPemissionList(){
          var self = this;
          this.$axios.post("http://localhost:8085/pemission/queryPemission").then(function (response) {
            if(response.code = 200){
              console.log(response.data.data);
              self.pemissionList = response.data.data;
            }

          })
        },

        updateoradd(){
          var self = this;
          console.log(this.role);
          this.$axios.post("http://localhost:8085/role/addOrUpdate",this.$qs.stringify(this.role)).then(function (response) {
            //console.log(response);
            self.dialogFormVisible=false;
            self.queryRoleList();
            // console.log(self.data);
          })
        },

        deleteAnimal:function(index,row){
          var self = this;
          this.$axios.get("http://localhost:8085/role/delRole?roleid="+row.roleid).then(function (response) {
            //console.log(response);
            self.queryRoleList();
          })
        },


        tankuang:function (index, row) {
          if(row!=null){
            this.role = row;
          }else{
            this.role =[];
          }
          this.dialogFormVisible=true;
        },

        clickRow(row){
          this.$refs.tb.toggleRowSelection(row);
        },


      }
    }
</script>

<style scoped>

</style>
