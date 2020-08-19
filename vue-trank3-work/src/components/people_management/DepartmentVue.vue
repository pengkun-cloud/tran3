<template>
    <div>
      <div>
      <br style="height: 80%">

      <el-button type="primary" @click="tankuang()">添加</el-button>
        <el-table
          :data="departmentList"
          style="width: 100%" @row-click="clickRow" ref="tb">
          <el-table-column
            type="selection"
            width="30">
          </el-table-column>

          <el-table-column
            label="部门名称"
            width="100">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.name}}</span>
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


        <el-dialog title="部门" :visible.sync="dialogFormVisible">
          <el-form :model="department" label-width="150px">
            <el-input v-model="department.id" style="width: 260px"></el-input>

            <el-form-item label="部门名称 :">
              <el-input v-model="department.name" style="width: 260px"></el-input>
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
          department:{
            id:"",
            name:"",

          },

          formLabelWidth:"120px",
          dialogFormVisible: false,
          departmentList:[],
        }
      },
      created:function(){
        this.queryDepartmentList();

      },
      methods: {
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
          console.log(this.pemission);
          this.$axios.post("http://localhost:8085/department/addOrUpdate",this.$qs.stringify(this.department)).then(function (response) {
            //console.log(response);
            self.dialogFormVisible=false;
            if(response.code = 200){
              self.queryDepartmentList();
            }

            // console.log(self.data);
          })
        },

        deleteAnimal:function(index,row){
          var self = this;
          this.$axios.get("http://localhost:8085/department/delDepartment?id="+row.id).then(function (response) {
            //console.log(response);
            if(response.code = 200){
              self.queryDepartmentList();
            }
          })
        },


        tankuang:function (index, row) {
          if(row!=null){
            this.department = row;
          }else{
            this.department =[];
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
