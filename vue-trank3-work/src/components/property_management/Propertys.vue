<template>
  <div>
    <div class="line"></div>
    <!--<el-menu
      :default-active="activeIndex2"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      background-color="#836FFF"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-menu-item>固定资产名称：</el-menu-item>
      <el-menu-item style="width: 150px" ><input type="text"/></el-menu-item>


      <el-menu-item>资产类别：</el-menu-item>
      <el-menu-item style="width: 150px">
        <el-select v-model="ruleForm.typeId" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.typeId"
            :label="item.typeName"
            :value="item.typeId">
          </el-option>
        </el-select>
      </el-menu-item>

      <el-menu-item>所属部门：</el-menu-item>
      <el-menu-item style="width: 150px"><input type="text"/><input type="button" @click="getPropertyList" value="搜索"/></el-menu-item>
    </el-menu>-->


    <!--<el-row>
      <el-col :span="4"><div class="grid-content bg-purple" align="center">资产编号</div></el-col>
      <el-col :span="4"><div class="grid-content bg-purple" align="center">资产名称</div></el-col>
      <el-col :span="4"><div class="grid-content bg-purple" align="center">所属部门</div></el-col>
      <el-col :span="4"><div class="grid-content bg-purple" align="center">数量</div></el-col>
      <el-col :span="4"><div class="grid-content bg-purple" align="center">使用情况</div></el-col>
    </el-row>-->



    <!--条件查询-->
    <el-form :inline="true" :model="param" class="demo-form-inline">
      <el-row>

        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-form-item label="固定资产名称">
              <el-input v-model="param.name" placeholder="固定资产名称"></el-input>
            </el-form-item>
          </div>
        </el-col>

        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-form-item label="类别">
              <el-select v-model="param.typeId" placeholder="请选择">
                <el-option
                  v-for="item in options"
                  :key="item.typeId"
                  :label="item.typeName"
                  :value="item.typeId">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item style="width: 150px"><input type="button" @click="getPropertyList" value="搜索"/></el-form-item>
          </div>
        </el-col>
      </el-row>


    </el-form>


    <el-tooltip class="item" effect="dark" content="新增" placement="right">
      <el-button type="success" style="width: 80px" icon="el-icon-circle-plus" @click="handleAdd"></el-button>
    </el-tooltip>

    <el-tooltip class="item" effect="dark" content="批量删除" placement="right">
      <el-button type="danger" style="width: 80px" icon="el-icon-delete" @click="deleteBatch"></el-button>
    </el-tooltip>



    <!--展示列表-->
    <el-table
      ref="multipleTable"
      :data="tableData"
      v-loading="listLoading"
      element-loading-text="Loading..."
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>

      <el-table-column label="资产名称" width="120">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>

      <el-table-column label="数量" width="100">
        <template slot-scope="scope">
          {{ scope.row.count }}
        </template>
      </el-table-column>

      <el-table-column label="情况" width="100">
        <template slot-scope="scope">
          {{ scope.row.conditions }}
        </template>
      </el-table-column>

      <el-table-column label="地点" width="100">
        <template slot-scope="scope">
          {{ scope.row.site }}
        </template>
      </el-table-column>

      <el-table-column label="价格" width="100">
        <template slot-scope="scope">
          {{ scope.row.price }}
        </template>
      </el-table-column>

      <el-table-column label="购入时间" width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px" value-format="yyyy-MM-dd">{{ scope.row.buyTime }}</span>
        </template>
      </el-table-column>


      <el-table-column label="购入方式" width="100">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.manner==1?"拉":scope.row.manner==2?"送":""}}</span>
        </template>
      </el-table-column>

      <el-table-column label="备注" width="100">
        <template slot-scope="scope">
          {{ scope.row.remark }}
        </template>
      </el-table-column>


      <el-table-column label="类型" width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.typeName }}</span>
        </template>
      </el-table-column>
      <el-table-column  label="操作" width="300">
        <template slot-scope="scope">
          <el-tooltip class="item" effect="dark" content="修改" placement="left">
            <el-button type="info" class="el-icon-edit" @click="handleUpdate(scope.row)" circle></el-button>
          </el-tooltip>
          <el-tooltip class="item" effect="dark" content="删除" placement="right">
            <el-button prop="id" class="el-icon-delete" circle @click="del(scope.row.id)" type="warning"></el-button>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>
    <!--<pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getPropertyList" />-->
    <!--分页-->
    <!--分页-->
    <el-pagination
      background
      :pager-count="9"
      layout="prev, pager, next"
      @current-change="handleCurrentChange"
      :page-size=param.pageSize
      :total=totalCount>
    </el-pagination>

    <!--------表单页面--------->
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form :model="ruleForm"  ref="ruleForm" label-width="100px" class="demo-ruleForm">

        <el-form-item label="资产名称" prop="name">
          <el-col :span="11">
            <el-input v-model="ruleForm.name"></el-input>
          </el-col>
        </el-form-item>

        <el-form-item label="数量" prop="count">
          <el-col :span="11">
            <el-input v-model="ruleForm.count"></el-input>
          </el-col>
        </el-form-item>

        <el-form-item label="情况" prop="conditions">
          <el-col :span="11">
            <el-input v-model="ruleForm.conditions"></el-input>
          </el-col>
        </el-form-item>

        <el-form-item label="地点" prop="site">
          <el-col :span="11">
            <el-input v-model="ruleForm.site"></el-input>
          </el-col>
        </el-form-item>


        <el-form-item label="价格" prop="price">
          <el-col :span="11">
            <el-input v-model="ruleForm.price"></el-input>
          </el-col>
        </el-form-item>


        <el-form-item label="购入时间" required>
          <el-col :span="11">
            <el-form-item prop="buyTime">
              <el-date-picker type="date" placeholder="选择日期" value-format="yyyy-MM-dd" v-model="ruleForm.buyTime" style="width: 100%;"></el-date-picker>
            </el-form-item>
          </el-col>
        </el-form-item>


        <el-form-item label="购入方式" prop="manner">
          <el-radio-group v-model="ruleForm.manner">
            <el-radio :label=1 >拉</el-radio>
            <el-radio :label=2 >送</el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="备注" prop="remark">
          <el-col :span="11">
            <el-input v-model="ruleForm.remark"></el-input>
          </el-col>
        </el-form-item>

        <!--<el-form-item label="类别" prop="typeId">
          <el-col :span="11">
            <el-select v-model="ruleForm.typeId" placeholder="请选择">
              <el-option
                v-for="item in options"
                :key="item.typeId"
                :lable="item.typeName"
                :value="item.typeId">
              </el-option>
            </el-select>
          </el-col>
        </el-form-item>-->

        <el-form-item label="类别">
          <el-select v-model="ruleForm.typeId" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.typeId"
              :label="item.typeName"
              :value="item.typeId">
            </el-option>
          </el-select>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="resetForm()">取 消</el-button>
        <el-button type="primary" @click='dialogStatus==="create"?addForm():updateForm()'>确 定</el-button>
      </div>
    </el-dialog>


  </div>
</template>

<script>
  var that;
  import Qs from 'qs';
  import Pagination from '@/components/Pagination';
  export default {
    name: "Propertys",
    components:{Pagination},
    data() {
      return {
        tableData: [],
        listLoading: true,
        dialogFormVisible:false,
        multipleSelection:[],
        totalCount: 0, // 总条数
      /*  listQuery:{
          page: 1,   // 当前页
          limit: 3  // 每页条数
        },*/
        param:{
          data:"",
          start:0,
          pageSize:3,
          name: '',
          typeId: ''

        },
        options:[],
        dialogStatus: '',
        textMap: {
          update: '修改',
          create: '新增'
        },
        ruleForm: {
          id:undefined,
          name: '',
          count: '',
          conditions: '',
          site: '',
          price: '',
          buyTime: '',
          manner: '',
          remark: '',
          typeId: '',
        },
        //用于存储条件查询数据的对象
        queryForm:{
          name: '',
          typeId: ''
        }
      }
    },
    created(){
      that = this;
      that.getPropertyList();
      that.queryTypeList();
    },
    methods:{
      getPropertyList(){
        this.listLoading = true
        var propertyQuery = this.queryForm;
        //console.log(this.queryForm);
        //let p = JSON.parse(JSON.stringify(this.queryForm));
        //p.pageNum = this.listQuery.page
       // p.pageSize = this.listQuery.limit
        this.$axios({
          method:"post",
          url:"/zuulApi/property_management/property/queryProperty",
          transformRequest:[function(data){
            return Qs.stringify(that.param)
          }],
          data:propertyQuery
        }).then(function(res){
          that.listLoading = false
          //that.total = res.data.total // 将PageInfo中的总条数设置给Vue实例中的总条数
          //console.log(res.data.data);
          that.tableData = res.data.data.list;
          that.totalCount=res.data.data.totalCount;
        })
      },

      //===================================================================
      queryTypeList(){
        var self = this;
        this.$axios({
          method:'post',
          url:'/zuulApi/property_management/property/queryType',
        }).then(function (response) {
          //console.log(response.data.data);
          self.options=response.data.data
        })
      },
      resetForm(){
        this.dialogFormVisible = false;
        if(this.dialogStatus==="create"){
          this.$refs['ruleForm'].resetFields();
        }else {
          this.ruleForm={}
        }
      },
      handleAdd(){
        this.dialogStatus = 'create'
        this.dialogFormVisible=true;
      },
      //添加数据
      addForm(){
        this.dialogFormVisible = false;
        this.$axios({
          method:'post',
          url:'/zuulApi/property_management/property/addProperty',
          data:this.ruleForm,
          transformRequest:[function (data) {
            return Qs.stringify(data);
          }]
        }).then(function (response) {
          that.$message.success('新增成功');
          that.getPropertyList()
          that.resetForm();

        })
      },
      //打开修改页面
      handleUpdate(row){
        let obj = JSON.parse(JSON.stringify(row));
        this.dialogStatus = 'update'
        this.dialogFormVisible = true
        this.ruleForm = obj
      },
      updateForm(){
        this.dialogFormVisible=false
        this.$axios({
          method:'post',
          url:'/zuulApi/property_management/property/updateProperty',
          transformRequest:[function (data) {
            return Qs.stringify(data);
          }],
          data:this.ruleForm
        }).then(function (response) {
          that.$message.success('修改成功');
          that.getPropertyList();
        })
      },
      //删除
      del(id){
        this.$axios({
          method:'post',
          url:'/zuulApi/property_management/property/deleteProperty',
          transformRequest:[function (data) {
            return Qs.stringify(data)
          }],
          data:{
            'id':id
          },

        }).then(function (response) {
            that.$message.success("删除成功");
            that.getPropertyList();
        }).catch(function(response) {
          that.$message.error('删除失败');
        })
      },
      //批量删除
      deleteBatch(){
        let id = this.multipleSelection.join(",");
        this.$axios({
          method:'post',
          url:'/zuulApi/property_management/property/deleteBathProperty',
          transformRequest:[function (data) {
            return Qs.stringify(data)
          }],
          data:{
            'ids':id
          }
        }).then(function(response){
          that.$message.success("删除成功");
          that.getPropertyList();
        })
      },
      handleSelectionChange(val) {
        this.multipleSelection=[] //每次改动重置
        val.forEach((data)=>{
          this.multipleSelection.push(data.id)
        }).catch(function(response){
          that.$message.error('删除错误');
        })
      },
      //分页
      handleCurrentChange(val) {
        //  console.log(`当前页: ${val}`);
        this.param.start=(val-1)*this.param.pageSize
        this.getPropertyList();
      }
    }

    }
</script>

<style scoped>
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>
