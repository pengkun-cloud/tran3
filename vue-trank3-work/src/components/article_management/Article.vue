<template>
    <div>
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
            pageSize:2,
          },
          totalCount:0
        }
      },
      created(){
        this.queryList();
      },
      methods:{
        //查询
        queryList(){
          var self = this;
          this.$axios.post("http://localhost:8100/article/queryList",this.$qs.stringify(this.param)).then(function(res){
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
        },
        //删除
        handleDelete(index, row){
          console.log(index, row);
        },
        //多选框
        handleSelectionChange(){

        },
      }
    }
</script>

<style scoped>

</style>
