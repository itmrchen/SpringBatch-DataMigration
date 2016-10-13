<%@ page contentType="text/html;charset=gb2312" pageEncoding="utf-8"%>
<html>
<body>

<center>
    <h2>数据迁移管理平台(线下)</h2>

    <table border="1">
        <tr>
            <th>任务编号</th>
            <th>任务名称</th>
            <th>条件字段</th>
            <th>开始id（含）</th>
            <th>结束id（不含）</th>
            <th>开始时间（含）</th>
            <th>结束时间（不含）</th>
            <th>操作</th>
        </tr>
        <form action="/executeJob" method="get">
            <tr>
                <input type="hidden" name="jobName" value="userBatchJobName">
                <td>1</td>
                <td>userBatchJobName</td>
                <td>id,create_time</td>
                <td><input type="text" name="idStart"> </td>
                <td><input type="text" name="idEnd"></td>
                <td><input type="text" name="startCreateTime"> </td>
                <td><input type="text" name="endCreateTime"></td>
                <td><input type="submit" value="启动"></td>
            </tr>
        </form>
    </table>



</center>
</body>
</html>
