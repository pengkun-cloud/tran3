<template>
  <div>
    <el-button type="primary" v-on:click="toAdd">增加</el-button>
    <el-button type="danger" size="small" v-on:click="deleteBatch">批量删除</el-button>
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
        label="会议主题"
        width="100">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.meetingTheme }}</span>
        </template>
      </el-table-column>

      <el-table-column
        label="参会人员"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.conferee }}</span>
        </template>
      </el-table-column>

      <el-table-column
        label="开始时间"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.meetingMinDate }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="结束时间"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.meetingMaxDate }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="会议室"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.roomName }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="会议类型"
        width="100">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.meetingType==1?'简洁':'高级'==2?'高级':'格调' }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="主持人"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.compere }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="记录人"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.recorder }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="登记人"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.registrant }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="登记时间"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.registerTime }}</span>
        </template>
      </el-table-column>

      <el-table-column
        label="附件"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px"><img :src="scope.row.photo" width="50px" height="50px"/></span>
        </template>
      </el-table-column>
      <el-table-column
        label="会议保障内容"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.meetingSafeWhad }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="会议内容"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.meetingWhad }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="会议说明"
        width="120">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.meetingState }}</span>
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


    <!--增加 是否新增成功方法-->
    <el-dialog
      title="增加"
      :visible.sync="dialogVisible">
      <el-form :model="meeting">
        <el-form-item label="会议主题" :label-width="formLabelWidth">
          <el-input v-model="meeting.meetingTheme" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="参会人员" :label-width="formLabelWidth">
          <el-input v-model="meeting.conferee" autocomplete="off"></el-input>
        </el-form-item>
        <el-row :gutter="30">
          <el-col :lg="12" >
        <el-form-item label="开会时间" :label-width="formLabelWidth">
          <el-input v-model="meeting.meetingMinDate" type="date" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
              <el-col :lg="12" >
        <el-form-item label="结束时间" :label-width="formLabelWidth">
          <el-input v-model="meeting.meetingMaxDate" type="date" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="30">
          <el-col :lg="12" >
        <el-form-item label="会议室" :label-width="formLabelWidth">
          <div class="block">
            <el-cascader
              v-model="meeting.meetingRoomList"
              :options="roomList"
              :props="aprops"></el-cascader>
          </div>
        </el-form-item>
          </el-col>
              <el-col :lg="12" >
        <el-form-item label="会议类型" :label-width="formLabelWidth">
          <el-radio v-model="meeting.meetingType" :label=1 >简洁</el-radio>
          <el-radio v-model="meeting.meetingType" :label=2 >高级</el-radio>
          <el-radio v-model="meeting.meetingType" :label=3 >格调</el-radio>
        </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="30">
          <el-col :lg="12" >
        <el-form-item label="主持人" :label-width="formLabelWidth">
          <el-input v-model="meeting.compere" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
              <el-col :lg="12" >
        <el-form-item label="记录人" :label-width="formLabelWidth">
          <el-input v-model="meeting.recorder" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="30">
          <el-col :lg="12" >
        <el-form-item label="登记人" :label-width="formLabelWidth">
          <el-input v-model="meeting.registrant" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
              <el-col :lg="12" >
        <el-form-item label="登记时间" :label-width="formLabelWidth">
          <el-input v-model="meeting.registerTime" type="date" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="附件" :label-width="formLabelWidth">
          <el-upload
            class="upload-demo"
            action="/meeting/file/uploadToOSS"
            :on-preview="handlePreview"
            :on-remove="handleRemove"
            :on-success="uploadSuccess"
            :file-list="photo"
            list-type="picture">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>

        </el-form-item>

        <el-form-item label="会议保障内容" :label-width="formLabelWidth">
          <el-input type="textarea" v-model="meeting.meetingSafeWhad"></el-input>
        </el-form-item>
        <el-form-item label="会议内容" :label-width="formLabelWidth">
          <el-input type="textarea" v-model="meeting.meetingWhad"></el-input>
        </el-form-item>
        <el-form-item label="会议说明" :label-width="formLabelWidth">
          <el-input v-model="meeting.meetingState" autocomplete="off"></el-input>
        </el-form-item>


      </el-form>
      <span slot="footer" class="dialog-footer">
          <el-button @click="cancelAdd">取 消</el-button>
          <el-button type="primary" @click="addMeeting">确 定</el-button>
        </span>
    </el-dialog>
    <el-dialog
      title="修改"
      :visible.sync="dialogUpdateVisible">
      <el-form :model="meeting">
        <el-form-item label="会议主题" :label-width="formLabelWidth">
          <el-input v-model="meeting.meetingTheme" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="参会人员" :label-width="formLabelWidth">
          <el-input v-model="meeting.conferee" autocomplete="off"></el-input>
        </el-form-item>
        <el-row :gutter="30">
          <el-col :lg="12" >
        <el-form-item label="开会时间" :label-width="formLabelWidth">
          <el-input v-model="meeting.meetingMinDate" type="date" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
              <el-col :lg="12" >
        <el-form-item label="结束时间" :label-width="formLabelWidth">
          <el-input v-model="meeting.meetingMaxDate" type="date" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="30">
          <el-col :lg="12" >
        <el-form-item label="会议室" :label-width="formLabelWidth">
          <div class="block">
            <el-cascader
              v-model="meeting.meetingRoomList"
              :options="roomList"
              :props="aprops"></el-cascader>
          </div>
        </el-form-item>
          </el-col>
              <el-col :lg="12" >
        <el-form-item label="会议类型" :label-width="formLabelWidth">
          <el-radio v-model="meeting.meetingType" :label=1 >简洁</el-radio>
          <el-radio v-model="meeting.meetingType" :label=2 >高级</el-radio>
          <el-radio v-model="meeting.meetingType" :label=3 >格调</el-radio>
        </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="30">
          <el-col :lg="12" >
        <el-form-item label="主持人" :label-width="formLabelWidth">
          <el-input v-model="meeting.compere" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
              <el-col :lg="12" >
        <el-form-item label="记录人" :label-width="formLabelWidth">
          <el-input v-model="meeting.recorder" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="30">
          <el-col :lg="12" >
        <el-form-item label="登记人" :label-width="formLabelWidth">
          <el-input v-model="meeting.registrant" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
              <el-col :lg="12" >
        <el-form-item label="登记时间" :label-width="formLabelWidth">
          <el-input v-model="meeting.registerTime" type="date" autocomplete="off"></el-input>
        </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="附件" :label-width="formLabelWidth">
          <el-upload
            class="upload-demo"
            action="/meeting/file/uploadToOSS"
            :on-preview="handlePreview"
            :on-remove="handleRemove"
            :on-success="uploadSuccess"
            :file-list="photo"
            list-type="picture">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>

        </el-form-item>

        <el-form-item label="会议保障内容" :label-width="formLabelWidth">
          <el-input type="textarea" v-model="meeting.meetingSafeWhad"></el-input>
        </el-form-item>
        <el-form-item label="会议内容" :label-width="formLabelWidth">
          <el-input type="textarea" v-model="meeting.meetingWhad"></el-input>
        </el-form-item>
        <el-form-item label="会议说明" :label-width="formLabelWidth">
          <el-input v-model="meeting.meetingState" autocomplete="off"></el-input>
        </el-form-item>


      </el-form>
      <span slot="footer" class="dialog-footer">
      <el-button @click="cancelUpdate">取 消</el-button>
      <el-button type="primary" @click="updateMeeting">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: "Meeting",
    data(){
      return{
        photo:[],
        //表格展示
        tableData:[],

        //自定义的model对象《用户新增 修改调用》
        meeting:{
          meetingRoomList:[],
          //会议Id
          //会议主题
          meetingTheme:"",
          //参会人员
          conferee:"",
          meetingMinDate:"",
          meetingMaxDate:"",
          roomId:"",
          meetingType:"",
          compere:"",
          recorder:"",
          registrant:"",
          registerTime:"",
          photo:"",
          meetingSafeWhad:"",
          meetingWhad:"",
          meetingState:"",
          queryRoomList:[]
        },
        dialogVisible :false,
        dialogUpdateVisible :false,
        formLabelWidth:"120px",
        roomList:[],
        meetingRoomList:[],
        aprops:{
          //会议室中字段
          label:"roomName",
          value:"roomId"
        },
        multipleSelection:[],
      }
    },
    created(){
      this.queryMeetingList();
      this.queryRoomList();
    },
    methods:{
      //附件
      handleRemove(file, photo) {
        console.log(file, photo);
        photo=[];
        this.meeting.photo="";
      },
      handlePreview(file) {
        console.log(file);
      },
      uploadSuccess(response, file, photo){
        console.log(response.data)
        this.meeting.photo=response.data;
        this.photo = [{url:response.data}]

      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },

      queryMeetingList(){
        var self = this;
        this.$axios.post("/meeting/meeting/queryMeetingList",this.$qs.stringify()).then(function(res){
          if(res.data.code==200){
            console.log(res.data.data)
            self.tableData = res.data.data;
          }
        })
      },
      queryRoomList(){
        var self = this;
        this.$axios.post("/meeting/room/queryRoomList",this.$qs.stringify()).then(function(res){
          if(res.data.code==200){
            console.log(res.data.data)
            self.roomList = res.data.data;
          }
        })
      },
      toAdd(){
        //点击新增按钮 页面改为true
        this.dialogVisible = true;
        this.queryRoomList();
        //新增的汽车对象
        this.meeting = {};
      },
      cancelAdd(){
        this.dialogVisible = false;
        this.meeting = {};
      },
      addMeeting(){
        var self = this;
        this.$axios.post("/meeting/meeting/addMeeting",this.$qs.stringify(this.meeting)).then(function(res){
          if(res.data.code==200){
            self.dialogVisible = false;
            self.queryMeetingList();
            self.meeting = {};
          }
        })
      },
      handleDelete(index, row) {
        //console.log(index, row);
        var self = this;
        this.$axios.get("/meeting/meeting/deleteMeeting/"+row.meetingId,this.$qs.stringify(this.meeting)).then(function(res){
          if(res.data.code==200){
            self.queryMeetingList();
          }
        })

      },
      deleteBatch(){
        var delList = [];
        var self = this;
        if(this.multipleSelection !=null && this.multipleSelection.length>0){
          for (let i = 0; i < this.multipleSelection.length; i++) {
            delList.push(this.multipleSelection[i].meetingId)
          }

          this.$axios.post("/meeting/meeting/deleteBatch",this.$qs.stringify({"idList":delList},{ indices: false })).then(function(res){
            if(res.data.code==200){
              self.queryMeetingList();
            }
          })
        }else{
          alert("请选择要删除的项！");
        }

      },
      handleEdit(index, row) {
        console.log(index, row);
        //this.product.status="1";
        this.dialogUpdateVisible= true;
        this.meeting = row;
        this.photo=[{url:row.photo}]

      },
      cancelUpdate(){
        this.dialogUpdateVisible = false;
      },
      updateMeeting(){
        var self = this;
        this.$axios.post("/meeting/meeting/updateMeeting",this.$qs.stringify(this.meeting)).then(function(res){
          if(res.data.code==200){
            self.dialogUpdateVisible = false;
            self.meeting = {};
            self.roomList = res.data.data;
          }
        })
      },

    }
  }
</script>
<style scoped>

</style>
