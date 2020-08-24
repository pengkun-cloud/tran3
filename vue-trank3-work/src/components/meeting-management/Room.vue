<template>
  <div>
    <el-row>
      <div >
        <div style="float: left">
            <el-button type="primary" v-on:click="toAdd">增加</el-button>
            <el-button type="danger" size="small" v-on:click="deleteBatch">批量删除</el-button>
        </div>
        <div style="float: left;margin-left: 30px">
    <el-form :inline="true" :model="param" class="demo-form-inline">

      <el-form-item label="会议室名称">
        <el-input v-model="param.roomName" placeholder="会议室名称"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="queryRoomList" size="small" style="margin-left: 35px" round>查询</el-button>
      </el-form-item>
    </el-form>
        </div>
      </div>
    </el-row>
    <!--回显 以及 到新增页面-->
    <el-table
      ref="tb"
      :data="tableData"
      style="width: 100%"
      @selection-change="handleSelectionChange">
      <el-table-column
        type="selection"
        width="55">
      </el-table-column>

      <el-table-column
        label="会议室名称"
        width="100">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.roomName }}</span>
        </template>
      </el-table-column>

      <el-table-column
        label="会议室地址"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.roomSite }}</span>
        </template>
      </el-table-column>

      <el-table-column
        label="容纳人数"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.roomSize }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="设备情况"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.roomFacility }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="备注"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.roomNotes }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作"  >
        <template slot-scope="scope" width="100" >
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">操作</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>

    </el-table>
    <!--分页-->
    <el-pagination
      background
      :pager-count="9"
      layout="prev, pager, next"
      @current-change="handleCurrentChange"
      :page-size=param.pageSize
      :total=totalCount>
    </el-pagination>

    <!--增加 是否新增成功方法-->
    <el-dialog
      title="增加"
      :visible.sync="dialogVisible">

      <el-form :model="room">
        <el-row :gutter="30">
          <el-col :lg="12" >
        <el-form-item label="会议室名称" :label-width="formLabelWidth">
          <el-input v-model="room.roomName" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
            <el-col :lg="12" >
        <el-form-item label="会议室地址" :label-width="formLabelWidth">
          <el-input v-model="room.roomSite" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="30">
          <el-col :lg="12" >
        <el-form-item label="容纳人数" :label-width="formLabelWidth">
          <el-input v-model="room.roomSize" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
            <el-col :lg="12" >
        <el-form-item label="设备情况" :label-width="formLabelWidth">
          <el-input v-model="room.roomFacility" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="备注" :label-width="formLabelWidth">
          <el-input type="textarea" v-model="room.roomNotes"></el-input>
        </el-form-item>


      </el-form>
      <span slot="footer" class="dialog-footer">
          <el-button @click="cancelAdd">取 消</el-button>
          <el-button type="primary" @click="addroom">确 定</el-button>
        </span>
    </el-dialog>

    <!--修改 是否新增成功方法-->
    <el-dialog
      title="修改"
      :visible.sync="dialogUpdateVisible">
      <el-form :model="room">
        <el-row :gutter="30">
          <el-col :lg="12" >
        <el-form-item label="会议室名称" :label-width="formLabelWidth">
          <el-input v-model="room.roomName" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
            <el-col :lg="12" >
        <el-form-item label="会议室地址" :label-width="formLabelWidth">
          <el-input v-model="room.roomSite" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="30">
          <el-col :lg="12" >
        <el-form-item label="容纳人数" :label-width="formLabelWidth">
          <el-input v-model="room.roomSize" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
            <el-col :lg="12" >
        <el-form-item label="设备情况" :label-width="formLabelWidth">
          <el-input v-model="room.roomFacility" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="备注" :label-width="formLabelWidth">
          <el-input type="textarea" v-model="room.roomNotes"></el-input>
        </el-form-item>


      </el-form>
      <span slot="footer" class="dialog-footer">
          <el-button @click="cancelUpdate">取 消</el-button>
          <el-button type="primary" @click="updateRoom">确 定</el-button>
        </span>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: "room",
    data(){
      return{
        //表格展示
        tableData:[],
        totalCount:0,
        param:{
          data:"",
          start:0,
          pageSize:3,
          roomName:"",
        },
        //自定义的model对象《用户新增 修改调用》
        room:{
          //会议Id
          roomName:"",
          roomSite:"",
          roomSize:"",
          roomFacility:"",
          roomNotes:"",
        },
        dialogVisible :false,
        dialogUpdateVisible :false,
        formLabelWidth:"120px",
        multipleSelection:[],
      }
    },
    created(){
      this.queryRoomList();
    },
    methods:{
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      handleCurrentChange(val) {
        //  console.log(`当前页: ${val}`);
        this.param.start=(val-1)*this.param.pageSize
        this.queryRoomList();
      },
      queryRoomList(){
        var self = this;
        this.$axios.post("http://localhost:8111/room/queryRoomList",this.$qs.stringify(this.param)).then(function(res){
          console.log(res.data.data)
          self.tableData = res.data.data.roomList;
          self.totalCount=res.data.data.totalCount;
        })
      },
      toAdd(){
        //点击新增按钮 页面改为true
        this.dialogVisible = true;
        this.room = {};
      },
      cancelAdd(){
        this.dialogVisible = false;
        this.room = {};
      },
      addroom(){
        var self = this;
        this.$axios.post("http://localhost:8111/room/addRoom",this.$qs.stringify(this.room)).then(function(res){
          if(res.data.code==200){
            self.dialogVisible = false;
            self.room = {};
            self.queryRoomList();
          }
        })
      },
      handleDelete(index, row) {
        var self = this;
        this.$axios.get("http://localhost:8111/room/deleteRoom/"+row.roomId,this.$qs.stringify(this.room)).then(function(res){
          if(res.data.code==200){
            self.queryRoomList();
          }
        })

      },
      deleteBatch(){
        var delList = [];
        var self = this;
        if(this.multipleSelection !=null && this.multipleSelection.length>0){
          for (let i = 0; i < this.multipleSelection.length; i++) {
            delList.push(this.multipleSelection[i].roomId)
          }

          this.$axios.post("http://localhost:8111/room/deleteBatch",this.$qs.stringify({"idList":delList},{ indices: false })).then(function(res){
            if(res.data.code==200){
              self.queryRoomList();

            }
          })
        }else{
          alert("请选择要删除的项！");
        }

      },
      handleEdit(index, row) {
        console.log(index, row);
        this.dialogUpdateVisible= true;
        this.room = row;
      },
      cancelUpdate(){
        this.dialogUpdateVisible = false;
      },
      updateRoom(){
        var self = this;
        this.$axios.post("http://localhost:8111/room/updateRoom",this.$qs.stringify(this.room)).then(function(res){
          if(res.data.code==200){
            self.dialogUpdateVisible = false;
            self.room = {};
            self.queryRoomList();
          }
        })
      },

    }
  }
</script>

<style scoped>



</style>
