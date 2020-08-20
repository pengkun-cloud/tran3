<template>
    <div>
      <div>
      <br style="height: 80%">

      <el-button type="primary" @click="tankuang()">添加</el-button>
        <el-table
          :data="pemissionList"
          style="width: 100%" @row-click="clickRow" ref="tb">
          <el-table-column
            type="selection"
            width="30">
          </el-table-column>

          <el-table-column
            label="权限名称"
            width="100">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.name}}</span>
            </template>
          </el-table-column>

          <el-table-column
            label="路径"
            width="200">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.url}}</span>
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


        <el-dialog title="权限" :visible.sync="dialogFormVisible">
          <el-form :model="pemission" label-width="150px">
            <el-input v-model="pemission.id" style="width: 260px"></el-input>

            <el-form-item label="权限名称 :">
              <el-input v-model="pemission.name" style="width: 260px"></el-input>
            </el-form-item>

            <el-form-item label="路径:">
              <el-input v-model="pemission.url" style="width: 260px"></el-input>
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
            url:"",

          },

          formLabelWidth:"120px",
          dialogFormVisible: false,
          pemissionList:[],
        }
      },
      created:function(){
        this.queryPemissionList();

      },
      methods: {
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
          console.log(this.pemission);
          this.$axios.post("http://localhost:8085/pemission/addOrUpdate",this.$qs.stringify(this.pemission)).then(function (response) {
            //console.log(response);
            self.dialogFormVisible=false;
            if(response.code = 200){
              self.queryPemissionList();
            }

            // console.log(self.data);
          })
        },

        deleteAnimal:function(index,row){
          var self = this;
          this.$axios.get("http://localhost:8085/pemission/delPemission?id="+row.id).then(function (response) {
            //console.log(response);
            if(response.code = 200){
              self.queryPemissionList();
            }
          })
        },


        tankuang:function (index, row) {
          if(row!=null){
            this.pemission = row;
          }else{
            this.pemission =[];
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
