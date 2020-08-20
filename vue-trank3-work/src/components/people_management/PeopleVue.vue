<template>
    <div>
      <div style="height: 20%">
        查询条件
        <el-form :model="param"  ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-row>
            <el-col :span="8">
              <el-form-item label="用户编号:" prop="name">
                <el-col :span="20">
                <el-input  v-model="param.numbering" ></el-input>
                </el-col>
              </el-form-item>
            </el-col>

            <el-col :span="8">
              <el-form-item label="用户名称:" prop="checkPass">
                <el-col :span="20">
                  <el-input   v-model="param.name"></el-input>
                </el-col>
              </el-form-item>
            </el-col>
            <el-col :span="8">
          <el-form-item>
            <el-button type="primary" @click="submitForm()">提交</el-button>
            <el-button @click="resetForm('queryMovie')">重置</el-button>
          </el-form-item>
            </el-col>
          </el-row>

        </el-form>

      </div>
      <div>
      <br style="height: 80%">
        用户列表<br>
      <el-button type="primary" @click="tankuang()">添加</el-button>
        <el-table
          :data="personnelList"
          style="width: 100%" @row-click="clickRow" ref="tb">
          <el-table-column
            type="selection"
            width="30">
          </el-table-column>

          <el-table-column
            label="用户编号"
            width="100">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.numbering}}</span>
            </template>
          </el-table-column>

          <el-table-column
            label="用户名称"
            width="100">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.name}}</span>
            </template>
          </el-table-column>

          <el-table-column
            label="用户部门"
            width="100">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.department}}</span>
            </template>
          </el-table-column>

          <el-table-column
            label="用户密级"
            width="100">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.security}}</span>
            </template>
          </el-table-column>

          <el-table-column
            label="用户性别"
            width="110">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.sex==1?"男":"女"}}</span>
            </template>
          </el-table-column>

          <el-table-column
            label="用户年龄"
            width="140">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.age}}</span>
            </template>
          </el-table-column>

          <el-table-column
            label="用户职务"
            width="140">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.roleid}}</span>
            </template>
          </el-table-column>

          <el-table-column
            label="用户职称"
            width="140">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.professional}}</span>
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


        <el-dialog title="员工" :visible.sync="dialogFormVisible">
          <el-form :model="personnel" label-width="150px">
            <el-input v-model="personnel.id" style="width: 260px"></el-input>

            <el-form-item label="用户编号:">
              <el-input v-model="personnel.numbering" style="width: 260px"></el-input>
            </el-form-item>

            <el-form-item label="用户名称:">
              <el-input v-model="personnel.name" style="width: 260px"></el-input>
            </el-form-item>

            <el-form-item label="用户部门" :label-width="formLabelWidth">
              <el-select v-model="personnel.department" placeholder="请选择">
                <el-option v-for="item in departmentList"
                           :key="item.id"
                           :label="item.name"
                           :value="item.id">
                </el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="用户密级:">
              <el-input v-model="personnel.security" style="width: 260px"></el-input>
            </el-form-item>

            <el-form-item label=" 年   龄 :">
              <el-input v-model="personnel.age" style="width: 260px"></el-input>
            </el-form-item>

            <el-form-item label=" 性  别 :">
              <template>
                <el-radio v-model="personnel.sex" :label="1">男</el-radio>
                <el-radio v-model="personnel.sex" :label="2">女</el-radio>
              </template>
            </el-form-item>

            <el-form-item label="用户职称:">
              <el-input v-model="personnel.professional" style="width: 260px"></el-input>
            </el-form-item>


              <el-form-item label="用户角色" :label-width="formLabelWidth">
                <el-select v-model="personnel.roleid" placeholder="请选择">
                  <el-option v-for="item in roleList"
                             :key="item.roleid"
                             :label="item.rolename"
                             :value="item.roleid">
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
          param:{
            numbering:"",
            name:"",
          },
          personnel:{
            id:"",
            numbering:"",
            name:"",
            department:"",
            security:"",
            sex:"",
            age:"",
            duty:"",
            professional:"",
            roleid:"",
          },
          role:{
            roleid:"",
            rolename:"",
          },
          department:{
            id:"",
            name:"",
          },
          formLabelWidth:"120px",
          dialogFormVisible: false,
          personnelList:[],
          roleList:[],
          departmentList:[],
        }
      },
      created:function(){
        this.queryPersonneList();
        this.queryRoleList();
        this.queryDepartmentList();

      },
      methods: {
        queryPersonneList(){
          var self = this;
          this.$axios.post("http://localhost:8085/personnel/queryPersonnel").then(function (response) {
            console.log(response.data.data);
            self.personnelList = response.data.data;
          })
        },

        queryRoleList(){
          var self = this;
          this.$axios.post("http://localhost:8085/role/queryRole").then(function (response) {
            console.log(response.data.data);
            self.roleList = response.data.data;
          })
        },

        queryDepartmentList(){
          var self = this;
          this.$axios.post("http://localhost:8085/department/queryDepartment").then(function (response) {
            if(response.code = 200){
              console.log(response.data.data);
              self.departmentList = response.data.data;
            }

          })
        },

        updateoradd(){
          var self = this;
          console.log(this.personnel);
          this.$axios.post("http://localhost:8085/personnel/addOrUpdate",this.$qs.stringify(this.personnel)).then(function (response) {
            //console.log(response);
            self.dialogFormVisible=false;
            self.queryPersonneList();
            // console.log(self.data);
          })
        },

        deleteAnimal:function(index,row){
          var self = this;
          this.$axios.get("http://localhost:8085/personnel/delPersonnel?id="+row.id).then(function (response) {
            //console.log(response);
            self.queryPersonneList();
          })
        },


        tankuang:function (index, row) {
          if(row!=null){
            this.personnel = row;
          }else{
            this.personnel =[];
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
