<template>
  <div>
    <div style="background-color: red; height: 40px">
      <div style="margin-left: 5px">
        <el-form :inline="true" :model="param" class="demo-form-inline">
          <el-row>
            <el-col :span="4">
              <div class="grid-content bg-purple">
                <el-button  size="small" v-on:click="toAdd">增加</el-button>
                <el-button  size="small" v-on:click="deleteBatch">批量删除</el-button>
              </div>
            </el-col>
            <!--条件查询-->
            <el-col :span="5">
              <div class="grid-content bg-purple">
                <el-form-item label="车辆编号">
                  <el-input v-model="param.carId" style="width: 150px" placeholder="请输入车辆编号"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="4">
              <div class="grid-content bg-purple">
                <el-form-item label="车牌号">
                  <el-input v-model="param.carPlate" style="width: 100px" placeholder="请输入车牌号"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="5">
              <div class="grid-content bg-purple" >
                <el-form-item label="类型" :label-width="formLabelWidth">
                  <el-select v-model="param.carType" style="width: 100px" placeholder="请选择">
                    <el-option
                      v-for="item in typeList"
                      :key="item.id"
                      :label="item.typeName"
                      :value="item.id">
                    </el-option>
                  </el-select>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="4">
            <div class="grid-content bg-purple">
              <el-form-item label="结构特点">
                <el-input v-model="param.carStructure" style="width: 100px" placeholder="请输入结构特点"></el-input>
              </el-form-item>
            </div>
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
          <span style="margin-left: 10px">{{ scope.row.cId }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="车辆编号"
        width="100">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.carId }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="车牌号"
        width="100">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.carPlate }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="品牌类型"
        width="80">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.typeName }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="结构特点"
        width="100">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.carStructure }}</span>
          <!--<span style="margin-left: 10px">{{ scope.row.status==1?'已上架':'未上架' }}</span>-->
        </template>
      </el-table-column>
      <el-table-column
        label="载客数量"
        width="50">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.carCarry }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="燃料"
        width="80">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.carFuel }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="排量等级"
        width="80">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.carEmissions }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="车身颜色"
        width="100">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.carColor }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="备注"
        width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.carRemark }}</span>
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
      <el-form :model="car">
        <el-form-item label="车辆编号" :label-width="formLabelWidth">
          <el-input v-model="car.carId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="车牌号" :label-width="formLabelWidth">
          <el-input v-model="car.carPlate" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="品牌类型" :label-width="formLabelWidth">
         <el-select v-model="car.carType" placeholder="请选择">
           <el-option
             v-for="item in typeList"
             :key="item.id"
             :label="item.typeName"
             :value="item.id">
           </el-option>
         </el-select>
       </el-form-item>
        <el-form-item label="结构特点" :label-width="formLabelWidth">
          <el-input v-model="car.carStructure" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="载客数量" :label-width="formLabelWidth">
          <el-input v-model="car.carCarry"  autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="燃料" :label-width="formLabelWidth">
          <el-input v-model="car.carFuel" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="排量等级" :label-width="formLabelWidth">
          <el-input v-model="car.carEmissions" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="车身颜色" :label-width="formLabelWidth">
          <el-input v-model="car.carColor" size="small"
                    placeholder="请输入内容"
                     autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="备注" :label-width="formLabelWidth">
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="car.carRemark">
          </el-input>
          <!--<el-input v-model="car.carRemark" autocomplete="off"></el-input>-->
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addcar">确 定</el-button>
      </div>
    </el-dialog>

    <!--修改-->
    <el-dialog title="修改" :visible.sync="dialogFormUpdate">
      <el-form :model="car">
        <el-form-item label="车辆编号" :label-width="formLabelWidth">
          <el-input v-model="car.carId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="车牌号" :label-width="formLabelWidth">
          <el-input v-model="car.carPlate" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="品牌类型" :label-width="formLabelWidth">
          <el-select v-model="car.carType" placeholder="请选择">
            <el-option
              v-for="item in typeList"
              :key="item.id"
              :label="item.typeName"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="结构特点" :label-width="formLabelWidth">
          <el-input v-model="car.carStructure" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="载客数量" :label-width="formLabelWidth">
          <el-input v-model="car.carCarry"  autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="燃料" :label-width="formLabelWidth">
          <el-input v-model="car.carFuel" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="排量等级" :label-width="formLabelWidth">
          <el-input v-model="car.carEmissions" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="车身颜色" :label-width="formLabelWidth">
          <el-input v-model="car.carColor" size="small"
                    placeholder="请输入内容"
                    autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="备注" :label-width="formLabelWidth">
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="car.carRemark">
          </el-input>
          <!--<el-input v-model="car.carRemark" autocomplete="off"></el-input>-->
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
            carId:"",
            carPlate:"",
            carType:"",
            carStructure:"",
          },
          car:{
            carId:"",
            carPlate:"",
            carType:"",
            carStructure:"",
            carCarry:"",
            carFuel:"",
            carEmissions:"",
            carColor:"",
            carRemark:"",
          }
        }
      },
      created(){
        this.queryList();
        this.queryTypeList();
      },
      methods: {
        addcar(){
          var self = this;
          this.$axios.post("http://localhost:1111/cars/addCar",this.$qs.stringify(this.car)).then(function(res){
            if(res.data.code==200){
              self.dialogFormVisible= false;
              self.queryList();
              self.car={};
            }
          })
        },
        queryTypeList(){
          var self = this;
          this.$axios.post("http://localhost:1111/cars/typeList",this.$qs.stringify(this.param)).then(function(res){
            if(res.data.code==200){
              self.typeList=res.data.data;
            }
          })
        },
        queryList(){
          var self = this;
          console.log(this.param)
          this.$axios.post("http://localhost:1111/cars/queryList",this.$qs.stringify(this.param)).then(function(res){
            if(res.data.code==200){
              self.tableData=res.data.data.list;
              self.totalCount=res.data.data.totalCount;
            }
          })
        },
        carDelete(index, row) {
          console.log(index, row);
          var self = this;
          this.$axios.post("http://localhost:1111/cars/deleteCar/"+row.cId,this.$qs.stringify(this.car)).then(function(res){
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
              delList.push(this.multipleSelection[i].cId)
            }
            this.$axios.post("http://localhost:1111/cars/deleteBatch",this.$qs.stringify({"idList":delList},{ indices: false })).then(function(res){
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
          this.car =row;
          //this.product.status="1";
          this.dialogFormUpdate= true;
        },
        updateCar(){
          console.log(this.car);
          var self = this;
          this.$axios.post("http://localhost:1111/cars/updateCar",this.$qs.stringify(this.car)).then(function(res){
            if(res.data.code==200){
              self.dialogFormUpdate= false;
              self.queryList();
              self.car={};
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
