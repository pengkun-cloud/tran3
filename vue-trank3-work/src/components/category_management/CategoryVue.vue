<template>
  <div>
    <h1>考勤类别管理系统</h1>

    <!--- - - -- - - - - - - -- - -- -==============  列表展示================ = = = = = = = -->
    <el-button type="success" round @click="addForm = true">添加</el-button>
    <el-button type="danger" round @click="deleteBatchCategory">批量删除</el-button>

    <el-table
      :data="tableData"
      style="width: 100%"
      @selection-change="handleSelectionChange">

      <el-table-column
        type="selection"
        width="55">
      </el-table-column>

      <el-table-column label="NO">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.$index+1 }}</span>
        </template>
      </el-table-column>

      <el-table-column label="考勤类别">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>

      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle @click="toUpdateCategory(scope.row.id)"></el-button>
          <el-button type="danger" icon="el-icon-delete" circle @click="deleteCategory(scope.row.id)"></el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--==============================================================新增============================-->
    <el-dialog title="新增图书" :visible.sync="addForm">
      <el-form :model="form" label-width="100px" class="demo-ruleForm">
        <el-form-item label="类别名称" prop="name">
          <el-col :span="11">
            <el-input v-model="form.name" style="width: 100%"></el-input>
          </el-col>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="clearAddForm()">取 消</el-button>
        <el-button type="primary" @click="addCategory()">确 定</el-button>
      </div>
    </el-dialog>

    <!--============================================================== 修改 ============================-->
    <el-dialog title="修改类别信息" :visible.sync="updateForm">
      <el-form :model="uform" label-width="100px" class="demo-ruleForm">
        <el-form-item label="类别名称" prop="name">
          <el-col :span="11">
            <el-input v-model="uform.name" style="width: 100%"></el-input>
          </el-col>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="updateForm = false">取 消</el-button>
        <el-button type="primary" @click="updateCategory()">确 定</el-button>
      </div>
    </el-dialog>


  </div>
</template>

<script>
    export default {
        name: "CategoryVue",
        data(){
            return{
                tableData: [],
                multipleSelection: [],
                addForm: false,
                updateForm: false,
                form:{
                    name: ''
                },
                uform:{
                    name: ''
                }
            }
        },
        created() {
            this.queryCategoryList();
        },
        methods:{
            queryCategoryList(){
                var self = this;
                this.$axios.post("http://localhost:8088/category/queryCategoryList").then(function(res){
                    if(res.data.code==200){
                        self.tableData = res.data.data;
                    } else{
                        alert(res.data.data)
                    }
                })
            },
            //新增衣服
            addCategory(){
                var self = this
                  this.$axios.post("http://localhost:8088/category/addCategory",this.$qs.stringify(this.form)).then(function (res) {
                      self.$message.success("新增成功")
                      self.clearAddForm()
                  }).catch(function (res) {
                      self.$message.error("新增失败")
                      self.clearAddForm()
                  })
            },
            // 清空form表单
            clearAddForm(){
              this.form.name=''
                this.addForm = false
                this.queryCategoryList()
            },
            //回显
            toUpdateCategory(id){
                var self = this
                this.$axios.get("http://localhost:8088/category/queryCategoryById?id="+id).then(function (res) {
                    self.uform.id = res.data.data.id
                    self.uform.name = res.data.data.name
                    self.updateForm = true
                })
            },
            //修改衣服信息
            updateCategory(){
                var self = this
                this.updateForm = false
                  this.$axios.post("http://localhost:8088/category/updateCategory",this.$qs.stringify(this.uform)).then(function (res) {
                      self.$message.success("修改成功")
                      self.updateForm = false
                      self.queryCategoryList()
                  }).catch(function (res) {
                      self.$message.error("修改失败")
                      self.updateForm = false
                      self.queryCategoryList()
                  })
            },
            //删除衣服信息
            deleteCategory(id){
                var self = this
                this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$axios.get("http://localhost:8088/category/deleteCategory?id="+id).then(function (res) {
                        self.$message.success("删除成功")
                        self.queryCategoryList()
                    }).catch(function () {
                        self.$message.error("删除失败")
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '取消删除'
                    });
                });
            },
            //批量删除类别信息
            deleteBatchCategory(){
                var ids = [];// 存放类别的id集合
                var self = this
                //如果多选框的值大于0，证明多选框已经被选中
                if(this.multipleSelection.length > 0){
                    this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        //循环遍历多选框里面的值
                        this.multipleSelection.forEach(data =>{
                            //将遍历出来的值放到自定义的数组里面
                            ids.push(data.id)
                        })
                        this.$axios.post("wyApi/category/deleteBatchCategory",this.$qs.stringify({"ids":ids},{indices: false})).then(function (res) {
                            self.$message.success("删除成功")
                            self.queryCategoryList()
                        }).catch(function () {
                            self.$message.error("删除失败")
                        })
                    })
                }else{
                    this.$alert("请选择要删除的商品！")
                }
            },
            //复选框
            handleSelectionChange(val) {
                /* 定义list集合 把复选框的值赋在集合里面 */
                this.multipleSelection = val;
            },
        }
    }
</script>

<style scoped>

</style>
