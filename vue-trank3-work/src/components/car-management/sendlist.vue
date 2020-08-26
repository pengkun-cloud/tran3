<template>
  <div>
    <div style="background-color: #72a4ff; height: 110px">
      <div style="margin-left: 5px">
        <el-form :inline="true" :model="param" class="demo-form-inline">
          <el-row>
            <el-col :span="3">
              <div class="grid-content bg-purple" style="margin-top: 15px; margin-left: 10px">
                <el-button  size="small" v-on:click="toAdd">增加</el-button>
              </div>
              <div class="grid-content bg-purple" style="margin-top: 20px; margin-left: 10px">
                <el-button  size="small" v-on:click="deleteBatch">批量删除</el-button>
              </div>
            </el-col>
            <!--条件查询-->
            <el-col :span="6">
              <div class="grid-content bg-purple">
                <el-form-item label="派车历史编号">
                  <el-input v-model="param.sHistory" style="width: 130px" placeholder="请输入车辆编号"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="3">
              <div class="grid-content bg-purple" style="float: left">
                <el-form-item>
                  <el-button type="" @click="" size="small" style="margin-left: 35px" round>重置</el-button>
                </el-form-item>
              </div>
            </el-col>

            <el-col :span="6">
              <div class="grid-content bg-purple" >
                <el-form-item label="车辆编号" :label-width="formLabelWidth">
                  <el-select v-model="param.sCarId" style="width: 100px" placeholder="请选择">
                    <el-option
                      v-for="item in typeList"
                      :key="item.id"
                      :label="item.carId"
                      :value="item.id">
                    </el-option>
                  </el-select>
                </el-form-item>
              </div>
            </el-col>

            <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label=" 出  发  地 ">
                <el-input v-model="param.sStart" style="width: 150px" placeholder="请输入出发地"></el-input>
              </el-form-item>
            </div>
          </el-col>

            <el-col :span="6">
              <div class="grid-content bg-purple">
                <el-form-item label="目的地">
                  <el-input v-model="param.sGoal" style="width: 170px" placeholder="请输入目的地"></el-input>
                </el-form-item>
              </div>
            </el-col>

            <el-col :span="3">
              <div class="grid-content bg-purple" style="float: left">
                <el-form-item>
                  <el-button type="" @click="queryList" size="small" style="margin-left: 35px" round>搜索</el-button>
                </el-form-item>
              </div>
            </el-col>

            <el-col :span="6">
            <el-form-item label="出发时间">
              <el-date-picker
                style="width: 150px"
                type="date"
                v-model="param.sStartDate"
                placeholder="请输入出发时间">
              </el-date-picker>
            </el-form-item>
            </el-col>

            <el-col :span="6">
            <el-form-item label="返回时间">
              <el-date-picker
                v-model="param.sBackDate"
                type="date"
                style="width: 150px"
                placeholder="请输入返回时间">
              </el-date-picker>
            </el-form-item>
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
          <span style="margin-left: 10px">{{ scope.row.sId }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="派车历史编号"
        width="80">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.sHistory }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="车辆编号"
        width="80">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.carId }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="出发地"
        width="80">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.sStart }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="目的地"
        width="80">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.sGoal }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="出发时间"
        width="110">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.sStartDate }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="返回时间"
        width="110">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.sBackDate }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="派车原因"
        width="80">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.sCause }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="乘客数量"
        width="60">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.sCarry }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="备注"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.sRemark }}</span>
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
      <el-form :model="send">
        <el-form-item label="派车历史编号" :label-width="formLabelWidth">
          <el-input v-model="send.sHistory" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="车辆编号" :label-width="formLabelWidth">
          <el-select v-model="send.sCarId" placeholder="请选择">
            <el-option
              v-for="item in typeList"
              :key="item.cId"
              :label="item.carId"
              :value="item.cId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="出发地" :label-width="formLabelWidth">
          <el-input v-model="send.sStart" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="目的地" :label-width="formLabelWidth">
          <el-input v-model="send.sGoal"  autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="出发时间" :label-width="formLabelWidth">
          <div class="block">
            <el-date-picker
              v-model="send.sStartDate"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择日期">
            </el-date-picker>
          </div>
        </el-form-item>
        <el-form-item label="返回时间" :label-width="formLabelWidth">
          <div class="block">
            <el-date-picker
              v-model="send.sBackDate"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择日期">
            </el-date-picker>
          </div>
        </el-form-item>
        <el-form-item label="派车原因" :label-width="formLabelWidth">
          <el-input v-model="send.sCause" size="small"
                    placeholder="请输入内容"autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="乘客数量" :label-width="formLabelWidth">
          <el-input v-model="send.sCarry" size="small"
                    placeholder="请输入内容"
                     autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="备注" :label-width="formLabelWidth">
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="send.sRemark ">
          </el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addSend">确 定</el-button>
      </div>
    </el-dialog>

    <!--修改-->
    <el-dialog title="修改" :visible.sync="dialogFormUpdate">
      <el-form :model="send">


        <el-form-item label="派车历史编号" :label-width="formLabelWidth">
          <el-input v-model="send.sHistory" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="车辆编号" :label-width="formLabelWidth">
          <el-select v-model="send.sCarId" placeholder="请选择">
            <el-option
              v-for="item in typeList"
              :key="item.cId"
              :label="item.carId"
              :value="item.cId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="出发地" :label-width="formLabelWidth">
          <el-input v-model="send.sStart" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="目的地" :label-width="formLabelWidth">
          <el-input v-model="send.sGoal"  autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="出发时间" :label-width="formLabelWidth">
          <div class="block">
            <el-date-picker
              v-model="send.sStartDate"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择日期">
            </el-date-picker>
          </div>
        </el-form-item>
        <el-form-item label="返回时间" :label-width="formLabelWidth">
          <div class="block">
            <el-date-picker
              v-model="send.sBackDate"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择日期">
            </el-date-picker>
          </div>
        </el-form-item>
        <el-form-item label="派车原因" :label-width="formLabelWidth">
          <el-input v-model="send.sCause" size="small"
                    placeholder="请输入内容"autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="乘客数量" :label-width="formLabelWidth">
          <el-input v-model="send.sCarry" size="small"
                    placeholder="请输入内容"
                    autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="备注" :label-width="formLabelWidth">
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="send.sRemark ">
          </el-input>
        </el-form-item>


      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormUpdate = false">取 消</el-button>
        <el-button type="primary" @click="updateSend">确 定</el-button>
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
            sHistory:"",
            sCarId:"",
            sStart:"",
            sGoal:"",
            sStartDate:"",
            sBackDate:""
          },
          send:{
            sHistory:"",
            sCarId:"",
            sStart:"",
            sGoal:"",
            sStartDate:"",
            sBackDate:"",
            sCause:"",
            sCarry:"",
            sRemark:"",
          }
        }
      },
      created(){
        this.queryList();
        this.queryTypeList();
      },
      methods: {
        addSend(){
          var self = this;
          this.$axios.post("/zuulApi/car_management/sends/addSendCar",this.$qs.stringify(this.send)).then(function(res){
            if(res.data.code==200){
              self.dialogFormVisible= false;
              self.queryList();
              self.send={};
            }
          })
        },
        queryTypeList(){
          var self = this;
          this.$axios.post("/zuulApi/car_management/sends/querySendCar",this.$qs.stringify(this.param)).then(function(res){
            if(res.data.code==200){
              self.typeList=res.data.data;
            }
          })
        },
        queryList(){
          var self = this;
          console.log(this.param)
          this.$axios.post("/zuulApi/car_management/sends/queryList",this.$qs.stringify(this.param)).then(function(res){
            if(res.data.code==200){
              self.tableData=res.data.data.list;
              self.totalCount=res.data.data.totalCount;
              alert(self.param.sStartDate)
            }
          })
        },
        carDelete(index, row) {
          console.log(index, row);
          var self = this;
          this.$axios.post("/zuulApi/car_management/sends/delSend/"+row.sId,this.$qs.stringify(this.send)).then(function(res){
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
              delList.push(this.multipleSelection[i].sId)
            }
            this.$axios.post("/zuulApi/car_management/sends/deleteBatch",this.$qs.stringify({"idList":delList},{ indices: false })).then(function(res){
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
          this.send =row;
          this.dialogFormUpdate= true;
        },
        updateSend(){
          console.log(this.car);
          var self = this;
          this.$axios.post("/zuulApi/car_management/sends/updateSend",this.$qs.stringify(this.send)).then(function(res){
            if(res.data.code==200){
              self.dialogFormUpdate= false;
              self.queryList();
              self.send={};
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
