<template>
  <div>
    <div style="background-color: red; height: 40px">
      <div style="margin-left: 5px">
        <el-form :inline="true" :model="param" class="demo-form-inline">
          <el-row>
            <el-col :span="2">
              <div class="grid-content bg-purple" style="margin-top: 4px; margin-left: 10px">
                <el-button  size="small" v-on:click="toAdd">增加</el-button>
              </div>
              <div class="grid-content bg-purple" style="margin-top: 10px; margin-left: 10px">
                <el-button  size="small" v-on:click="deleteBatch">批量删除</el-button>
              </div>
            </el-col>
            <!--条件查询-->
            <el-col :span="5">
              <div class="grid-content bg-purple">
                <el-form-item label="车辆编号">
                  <el-input v-model="param.xCarId" style="width: 150px" placeholder="请输入车辆编号"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="4">
              <div class="grid-content bg-purple">
                <el-form-item label="送修人">
                  <el-input v-model="param.xPeo" style="width: 100px" placeholder="请输入车牌号"></el-input>
                </el-form-item>
              </div>
            </el-col>

            <el-col :span="5">
              <el-form-item label="送修时间">
                <el-date-picker
                  style="width: 150px"
                  type="date"
                  v-model="param.xTime"
                  placeholder="请输入送修时间">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="返回时间">
                <el-date-picker
                  v-model="param.jTime"
                  type="date"
                  style="width: 150px"
                  placeholder="请输入返回时间">
                </el-date-picker>
              </el-form-item>
            </el-col>

            <el-col :span="1">
              <div class="grid-content bg-purple" style="float: left">
                <el-form-item>
                  <el-button type="primary" @click="queryList" size="small" style="margin-left: 35px" round>查询</el-button>
                </el-form-item>
              </div>
            </el-col>

          </el-row>
        </el-form>
      </div>
    </div>

    <el-table
      ref="tb"
      :data="tableData"
      @row-click="rowClick"
      style="width: 100%"
      @selection-change="handleSelectionChange">
      <el-table-column
        type="selection"
        width="55">
      </el-table-column>
      <el-table-column
        label="ID"
        width="50">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.xId }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="车辆编号">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.xCarId }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="送修人">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.xPeo }}</span>
        </template>
      </el-table-column>

      <el-table-column
        label="送修时间">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.xTime }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="交车时间">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.jTime }}</span>
        </template>
      </el-table-column>

      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="carDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
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
    <!--增加-->
    <el-dialog title="增加" :visible.sync="dialogFormVisible">
      <el-form :model="garage">
        <el-form-item label="车辆编号" :label-width="formLabelWidth">
          <el-input v-model="garage.xCarId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="送修人" :label-width="formLabelWidth">
          <el-input v-model="garage.xPeo" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="送修时间" :label-width="formLabelWidth">
          <div class="block">
            <el-date-picker
              v-model="garage.xTime"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择日期">
            </el-date-picker>
          </div>
        </el-form-item>

        <el-form-item label="交车时间" :label-width="formLabelWidth">
          <div class="block">
            <el-date-picker
              v-model="garage.jTime"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择日期">
            </el-date-picker>
          </div>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addcar">确 定</el-button>
      </div>
    </el-dialog>

    <!--修改-->
    <el-dialog title="修改" :visible.sync="dialogFormUpdate">
      <el-form :model="garage">
        <el-form-item label="车辆编号" :label-width="formLabelWidth">
          <el-input v-model="garage.xCarId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="送修人" :label-width="formLabelWidth">
          <el-input v-model="garage.xPeo" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="送修时间" :label-width="formLabelWidth">
          <div class="block">
            <el-date-picker
              v-model="garage.xTime"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择日期">
            </el-date-picker>
          </div>
        </el-form-item>
        <el-form-item label="交车时间" :label-width="formLabelWidth">
          <div class="block">
            <el-date-picker
              v-model="garage.jTime"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择日期">
            </el-date-picker>
          </div>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormUpdate = false">取 消</el-button>
        <el-button type="primary" @click="updateCar">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
    export default {
        name: "carlist",
      data() {
        return {
          multipleSelection:[],
          dialogFormUpdate:false,
          dialogFormVisible:false,
          formLabelWidth:"120px",
          totalCount:0,
          typeList: [],
          tableData: [],
          param:{
            data:"",
            start:0,
            pageSize:10,
            xId:"",
            xCarId:"",
            xPeo:"",
            xTime:"",
            jTime:"",
          },
          garage:{
            xId:"",
            xCarId:"",
            xPeo:"",
            xTime:"",
            jTime:"",
          }
        }
      },
      created(){
        this.queryList();
      },
      methods: {
        addcar(){
          var self = this;
          this.$axios.post("http://localhost:1111/garages/addGarage",this.$qs.stringify(this.garage)).then(function(res){
            if(res.data.code==200){
              self.dialogFormVisible= false;
              self.queryList();
              self.car={};
            }
          })
        },
        queryList(){
          var self = this;
          console.log(this.param)
          this.$axios.post("http://localhost:1111/garages/queryList",this.$qs.stringify(this.param)).then(function(res){
            if(res.data.code==200){
              self.tableData=res.data.data.list;
              self.totalCount=res.data.data.totalCount;
            }
          })
        },
        carDelete(index, row) {
          console.log(index, row);
          var self = this;
          this.$axios.post("http://localhost:1111/garages/del/"+row.xId,this.$qs.stringify(this.garage)).then(function(res){
            if(res.data.code==200){
              self.queryList();
            }
          })
        },
        deleteBatch(){
          var delList = [];
          var self = this;
          if(this.multipleSelection !=null && this.multipleSelection.length>0){
            for (let i = 0; i < this.multipleSelection.length; i++) {
              delList.push(this.multipleSelection[i].xId)
            }
            this.$axios.post("http://localhost:1111/garages/deleteBatch",this.$qs.stringify({"idList":delList},{ indices: false })).then(function(res){
              if(res.data.code==200){
                self.queryList();
                self.isShow =false;
              }
            })
          }else{
            alert("请选择要删除的项！!!");
          }
        },
        handleEdit(index, row) {
          console.log(index, row);
          this.garage =row;
          this.dialogFormUpdate= true;
        },
        updateCar(){
          console.log(this.garage);
          var self = this;
          this.$axios.post("http://localhost:1111/garages/updateGarage",this.$qs.stringify(this.garage)).then(function(res){
            if(res.data.code==200){
              self.dialogFormUpdate= false;
              self.queryList();
              self.garage={};
            }
          })
        },
        toAdd(){
          this.dialogFormVisible = true;
        },

        handleSelectionChange(val) {
          this.multipleSelection = val;
        },
        rowClick(row, column, event){
          //console.log(row)
          this.$refs.tb.toggleRowSelection(row);
        },
        handleCurrentChange(val) {
          //  console.log(`当前页: ${val}`);
          this.param.start=(val-1)*this.param.pageSize
          this.queryList();
        }

      }
    }
</script>

<style scoped>
</style>
