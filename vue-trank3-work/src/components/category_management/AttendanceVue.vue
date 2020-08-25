<template>
  <div>

    <!--- - - -- - - - - - - -- - -- -==============  条件查询 ================ = = = = = = = -->
    <el-form :inline="true" :model="sform" ref="sForm" class="demo-form-inline">
      <el-form-item>
        <el-input v-model="sform.roleName" placeholder="这里输入关键字"></el-input>
      </el-form-item>
      <el-form-item style="width: 150px">
        <el-date-picker type="date" placeholder="开始日期" v-model="sform.minDate" style="width: 100%;" value-format="yyyy-MM-dd"></el-date-picker>
      </el-form-item>
      <el-form-item style="width: 150px">
        <el-date-picker type="date" placeholder="结束日期" v-model="sform.maxDate" style="width: 100%;" value-format="yyyy-MM-dd"></el-date-picker>
      </el-form-item>
      <el-button @click="queryAttendanceList" size="small" style="height: 38px"><b>全部</b></el-button>
      <el-button @click="queryAttendanceList" size="small" style="height: 38px" icon="el-icon-search"></el-button>
    </el-form>

    <!--- - - -- - - - - - - -- - -- -==============  列表展示================ = = = = = = = -->
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

      <el-table-column label="姓名">
        <template slot-scope="scope">
          {{ scope.row.roleName }}
        </template>
      </el-table-column>

      <el-table-column label="部门">
        <template slot-scope="scope">
          {{ scope.row.departmentName }}
        </template>
      </el-table-column>

      <el-table-column label="编码">
        <template slot-scope="scope">
          {{ scope.row.attCoding }}
        </template>
      </el-table-column>

      <el-table-column label="类别">
        <template slot-scope="scope">
          {{ scope.row.categoryName }}
        </template>
      </el-table-column>

      <el-table-column label="天数">
        <template slot-scope="scope">
          {{ scope.row.attDays }}
        </template>
      </el-table-column>

      <el-table-column label="工时">
        <template slot-scope="scope">
          {{ scope.row.attManHour }}
        </template>
      </el-table-column>

      <el-table-column label="记录时间">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.attWriteTime }}</span>
        </template>
      </el-table-column>

      <el-table-column label="备注说明">
        <template slot-scope="scope">
          {{ scope.row.attExplain }}
        </template>
      </el-table-column>

      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle
                     @click="toUpdateAttendance(scope.row.id)"></el-button>
          <el-button type="danger" icon="el-icon-delete" circle @click="deleteAttendance(scope.row.id)"></el-button>
        </template>
      </el-table-column>
    </el-table><br/>

    <el-button type="info" size="small" @click="addForm = true">新增</el-button>
    <el-button type="danger" size="small" @click="deleteBatchAttendance">批量删除</el-button>

    <!--============================================================== 新增 ============================-->
    <el-dialog title="新增考勤信息" :visible.sync="addForm">
      <el-form :model="form" label-width="100px" class="demo-ruleForm">

        <el-form-item label="记录时间">
          <el-col :span="11">
            <el-form-item prop="attWriteTime">
              <el-date-picker type="date" placeholder="选择日期" v-model="form.attWriteTime" style="width: 100%;" value-format="yyyy-MM-dd"></el-date-picker>
            </el-form-item>
          </el-col>
        </el-form-item>

        <el-form-item label="姓名" prop="roleName">
          <el-col :span="11">
            <el-input v-model="form.roleName" style="width: 100%"></el-input>
          </el-col>
        </el-form-item>

        <el-form-item label="部门" prop="department">
          <el-col :span="11">
            <el-select v-model="form.department" placeholder="请选择部门" style="width: 100%;">
              <el-option :label="item.departmentName" :value="item.departmentId" v-for="item of departmentList"></el-option>
            </el-select>
          </el-col>
        </el-form-item>

        <el-form-item label="编码" prop="attCoding">
          <el-col :span="11">
            <el-input v-model="form.attCoding" style="width: 100%"></el-input>
          </el-col>
        </el-form-item>

        <el-form-item label="类别" prop="category">
          <el-col :span="11">
            <el-select v-model="form.category" placeholder="请选择类别" style="width: 100%;">
              <el-option :label="item.categoryName" :value="item.id" v-for="item of categoryList"></el-option>
            </el-select>
          </el-col>
        </el-form-item>

        <el-form-item label="天数" prop="attDays">
          <el-col :span="11">
            <el-input type="number" v-model="form.attDays" style="width: 100%"></el-input>
          </el-col>
        </el-form-item>

        <el-form-item label="工时" prop="attManHour">
          <el-col :span="11">
            <el-input type="number" v-model="form.attManHour" style="width: 100%"></el-input>
          </el-col>
        </el-form-item>

        <el-form-item label="备注说明" prop="attExplain">
          <el-col :span="11">
            <el-input type="textarea" :rows="4" placeholder="请输入内容" v-model="form.attExplain" style="width: 100%"></el-input>
          </el-col>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="clearAddForm()">取 消</el-button>
        <el-button type="primary" @click="addAttendance()">确 定</el-button>
      </div>
    </el-dialog>

    <!--============================================================== 修改 ============================-->
    <el-dialog title="修改考勤信息" :visible.sync="updateForm">
      <el-form :model="uform" label-width="100px" class="demo-ruleForm">
        <el-form-item label="记录日期">
          <el-col :span="11">
            <el-form-item prop="attWriteTime">
              <el-date-picker type="date" placeholder="选择日期" v-model="uform.attWriteTime" style="width: 100%;" value-format="yyyy-MM-dd"></el-date-picker>
            </el-form-item>
          </el-col>
        </el-form-item>

        <el-form-item label="姓名" prop="roleName">
          <el-col :span="11">
            <el-input v-model="uform.roleName" style="width: 100%"></el-input>
          </el-col>
        </el-form-item>

        <el-form-item label="部门" prop="department">
          <el-col :span="11">
            <el-select v-model="uform.department" placeholder="请选择部门" style="width: 100%;">
              <el-option :label="item.departmentName" :value="item.departmentId" v-for="item of departmentList"></el-option>
            </el-select>
          </el-col>
        </el-form-item>

        <el-form-item label="编码" prop="attCoding">
          <el-col :span="11">
            <el-input v-model="uform.attCoding" style="width: 100%"></el-input>
          </el-col>
        </el-form-item>

        <el-form-item label="类别" prop="category">
          <el-col :span="11">
            <el-select v-model="uform.category" placeholder="请选择类别" style="width: 100%;">
              <el-option :label="item.categoryName" :value="item.id" v-for="item of categoryList"></el-option>
            </el-select>
          </el-col>
        </el-form-item>

        <el-form-item label="天数" prop="attDays">
          <el-col :span="11">
            <el-input type="number" v-model="uform.attDays" style="width: 100%"></el-input>
          </el-col>
        </el-form-item>

        <el-form-item label="工时" prop="attManHour">
          <el-col :span="11">
            <el-input type="number" v-model="uform.attManHour" style="width: 100%"></el-input>
          </el-col>
        </el-form-item>

        <el-form-item label="备注说明" prop="attExplain">
          <el-col :span="11">
            <el-input type="textarea" :rows="4" placeholder="请输入内容" v-model="uform.attExplain" style="width: 100%"></el-input>
          </el-col>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="updateForm = false">取 消</el-button>
        <el-button type="primary" @click="updateAttendance()">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
    export default {
        name: "AttendanceVue",
        data(){
            return{
                tableData: [],
                multipleSelection: [],
                departmentList: [],
                categoryList: [],

                addForm: false,
                updateForm: false,

                form: {
                    attWriteTime: '',
                    roleName: '',
                    department: '',
                    attCoding: '',
                    category: '',
                    attDays: '',
                    attManHour: '',
                    attExplain: ''
                },
                uform: {
                    attWriteTime: '',
                    roleName: '',
                    department: '',
                    attCoding: '',
                    category: '',
                    attDays: '',
                    attManHour: '',
                    attExplain: ''
                },
                sform: {
                    roleName: '',
                    minDate: '',
                    maxDate: ''
                }

            }
        },
        created() {
          this.queryAttendanceList();
          this.queryCategoryList();
        },
        methods:{
            queryAttendanceList(){
                var self = this;
                this.$axios.post("/zuulApi/attendance_management/attendance/queryAttendanceList",this.$qs.stringify(this.sform)).then(function(res){
                    if(res.data.code==200){
                        self.tableData = res.data.data;
                    } else{
                        alert(res.data.data)
                    }
                })
            },
            //查询类别
            queryCategoryList(){
                var self = this;
                this.$axios.post("/zuulApi/attendance_management/category/queryCategoryList").then(function(res){
                    if(res.data.code==200){
                        self.categoryList = res.data.data;
                    } else{
                        alert(res.data.data)
                    }
                })
            },
            //新增考勤
            addAttendance(){
                var self = this
                this.$axios.post("/zuulApi/attendance_management/attendance/addAttendance",this.$qs.stringify(this.form)).then(function (res) {
                    self.$message.success("新增成功")
                    self.clearAddForm()
                }).catch(function (res) {
                    self.$message.error("新增失败")
                    self.clearAddForm()
                })
            },
            // 清空form表单
            clearAddForm(){
                this.form.attWriteTime=''
                this.form.roleName=''
                this.form.department=''
                this.form.attCoding=''
                this.form.category=''
                this.form.attDays=''
                this.form.attManHour=''
                this.form.attExplain=''
                this.addForm = false
                this.queryAttendanceList()
            },
            //回显
            toUpdateAttendance(id){
                var self = this
                this.$axios.get("/zuulApi/attendance_management/attendance/queryAttendanceById?id="+id).then(function (res) {
                    self.uform.id = res.data.data.id
                    self.uform.attWriteTime = res.data.data.attWriteTime
                    self.uform.roleName = res.data.data.roleName
                    self.uform.department = res.data.data.department
                    self.uform.attCoding = res.data.data.attCoding
                    self.uform.category = res.data.data.category
                    self.uform.attDays = res.data.data.attDays
                    self.uform.attManHour = res.data.data.attManHour
                    self.uform.attExplain = res.data.data.attExplain
                    self.updateForm = true
                })
            },
            //修改考勤信息
            updateAttendance(){
                var self = this
                this.updateForm = false
                this.$axios.post("/zuulApi/attendance_management/attendance/updateAttendance",this.$qs.stringify(this.uform)).then(function (res) {
                    self.$message.success("修改成功")
                    self.updateForm = false
                    self.queryAttendanceList()
                }).catch(function (res) {
                    self.$message.error("修改失败")
                    self.updateForm = false
                    self.queryAttendanceList()
                })
            },
            //删除考勤信息
            deleteAttendance(id){
                var self = this
                this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$axios.get("/zuulApi/attendance_management/attendance/deleteAttendance?id="+id).then(function (res) {
                        self.$message.success("删除成功")
                        self.queryAttendanceList()
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
            //批量删除考勤信息
            deleteBatchAttendance(){
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
                        this.$axios.post("/zuulApi/attendance_management/attendance/deleteBatchAttendance",this.$qs.stringify({"ids":ids},{indices: false})).then(function (res) {
                            self.$message.success("删除成功")
                            self.queryAttendanceList()
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
