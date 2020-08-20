<template>
  <div>
    <el-button type="primary" v-on:click="toAdd">增加</el-button>
    <el-button type="danger" size="small" v-on:click="deleteBatch">批量删除</el-button>
    <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
    <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>

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


    </el-table>


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
      queryRoomList(){
        var self = this;
        this.$axios.post("/meeting/room/queryRoomList",this.$qs.stringify()).then(function(res){
          console.log(res.data.data)
          self.tableData = res.data.data
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
        this.$axios.post("/meeting/room/addRoom",this.$qs.stringify(this.room)).then(function(res){
          if(res.data.code==200){
            self.dialogVisible = false;
            self.room = {};
            self.queryRoomList();
          }
        })
      },
      handleDelete(index, row) {
        var self = this;
        this.$axios.get("/meeting/room/deleteRoom/"+row.roomId,this.$qs.stringify(this.room)).then(function(res){
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

          this.$axios.post("/meeting/room/deleteBatch",this.$qs.stringify({"idList":delList},{ indices: false })).then(function(res){
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
        this.$axios.post("/meeting/room/updateRoom",this.$qs.stringify(this.room)).then(function(res){
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
