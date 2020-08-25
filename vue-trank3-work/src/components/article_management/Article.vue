<template>
    <div>
      <el-button type="primary" v-on:click="toAdd">物品入库</el-button>
      <!--查询-->
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
          label="物品名称"
          width="100">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.articleName }}</span>
          </template>
        </el-table-column>

        <el-table-column
          label="单价"
          width="80">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.articlePrice }}</span>
          </template>
        </el-table-column>

        <el-table-column
          label="数量"
          width="80">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.articleCount }}</span>
          </template>
        </el-table-column>

        <el-table-column
          label="入库人"
          width="80">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.storeMember }}</span>
          </template>
        </el-table-column>

        <el-table-column
          label="入库时间"
          width="120">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.storeDate }}</span>
          </template>
        </el-table-column>

        <el-table-column
          label="特殊说明"
          width="220">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.information }}</span>
          </template>
        </el-table-column>

        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">修改</el-button>
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

      <!--添加-->
      <el-dialog
        title="增加"
        :visible.sync="dialogAddVisible">
        <el-form :model="article">

          <el-form-item label="物品名称" label-width="120px">
            <el-input v-model="article.articleName" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item label="价格" label-width="120px">
            <el-input v-model="article.articlePrice" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item label="数量" label-width="120px">
            <el-input v-model="article.articleCount" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item label="入库人" label-width="120px">
            <el-input v-model="article.storeMember" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item label="入库时间" label-width="120px">
            <div class="block">
              <el-date-picker
                v-model="article.storeDate"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="选择日期">
              </el-date-picker>
            </div>
          </el-form-item>

          <el-form-item label="特殊说明" label-width="120px">
            <el-input v-model="article.information" autocomplete="off"></el-input>
          </el-form-item>

        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogAddVisible = false">取 消</el-button>
          <el-button type="primary" @click="addArticle">确 定</el-button>
        </span>
      </el-dialog>

      <!--修改-->
      <el-dialog
        title="修改"
        :visible.sync="dialogUpdateVisible">
        <el-form :model="article">

          <el-form-item label="物品名称" label-width="120px">
            <el-input v-model="article.articleName" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item label="价格" label-width="120px">
            <el-input v-model="article.articlePrice" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item label="数量" label-width="120px">
            <el-input v-model="article.articleCount" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item label="入库人" label-width="120px">
            <el-input v-model="article.storeMember" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item label="入库时间" label-width="120px">
            <div class="block">
              <el-date-picker
                v-model="article.storeDate"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="选择日期">
              </el-date-picker>
            </div>
          </el-form-item>

          <el-form-item label="特殊说明" label-width="120px">
            <el-input v-model="article.information" autocomplete="off"></el-input>
          </el-form-item>

        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="cancelUpdate">取 消</el-button>
          <el-button type="primary" @click="updateArticle">确 定</el-button>
        </span>
      </el-dialog>


    </div>
</template>

<script>
    export default {
      name: "Article",
      data(){
        return{
          tableData:[],
          multipleSelection:[],
          param:{
            start:0,
            pageSize:4,
          },
          totalCount:0,

          dialogAddVisible:false,
          article:{
            articleId:"",
            articleName:"",
            articlePrice:"",
            articleCount:"",
            storeMember:"",
            storeDate:"",
            information:"",
          },

          dialogUpdateVisible:false,


        }
      },
      created(){
        this.queryList();
      },
      methods:{
        //增加
        toAdd(){
          this.dialogAddVisible = true;
          this.article = {}
        },
        addArticle(){
          var self = this;
          this.$axios.post("/zuulApi/article_management/article/addArticle",this.$qs.stringify(this.article)).then(function(res){
            if(res.data.code==200){
              self.article = {};
              self.dialogAddVisible = false;
              self.queryList();
            }
          })
        },
        //查询
        queryList(){
          var self = this;
          this.$axios.post("/zuulApi/article_management/article/queryList",this.$qs.stringify(this.param)).then(function(res){
            if(res.data.code==200){
              console.log(res.data.data.totalCount);
              self.tableData = res.data.data.list;
              self.totalCount = res.data.data.totalCount;
            }
          })
        },
        handleCurrentChange(val){
          this.param.start=(val-1)*this.param.pageSize
          this.queryList();
        },
        //回显
        handleEdit(index, row){
          console.log(index, row);
          this.article = row;
          this.dialogUpdateVisible = true;
        },
        cancelUpdate(){
          this.article = {};
          this.dialogUpdateVisible = false;
        },
        //修改
        updateArticle(){
          var self = this;
          this.$axios.post("/zuulApi/article_management/article/updateArticle",this.$qs.stringify(this.article)).then(function(res){
            if(res.data.code==200){
              self.article = {};
              self.dialogUpdateVisible = false;
              self.queryList();
            }
          })
        },
        //删除
        handleDelete(index, row){
          //console.log(index, row);
          var self = this;
          this.$axios.post("/zuulApi/article_management/article/deleteArticle/" + row.articleId,this.$qs.stringify()).then(function(res){
            if(res.data.code==200){
              self.queryList();
            }
          })
        },
        //多选框
        handleSelectionChange(){

        },
      }
    }
</script>

<style scoped>

</style>
