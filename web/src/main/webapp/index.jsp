<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>首页</title>
        <style type="text/css">
            .table_labels{
                font-size: 20px;
            }
        </style>
    </head>
    <body>
        <div style="margin-top: 5%">
            <h1 style="text-align: center">提交数据</h1>
            <table style="">
                <tr>
                    <td class="table_labels">客户姓名:</td>
                    <td>
                        <input type="text" id="name" value=""/>
                    </td>
                </tr>
                <tr>
                    <td class="table_labels">客户手机号:</td>
                    <td>
                        <input type="text" id="mobile" value=""/>
                    </td>
                </tr>
                <tr>
                    <td class="table_labels">检测地址:</td>
                    <td>
                        <input type="text" id="address" value=""/>
                    </td>
                </tr>
                <tr>
                    <td class="table_labels">竞拍场次:</td>
                    <td>
                        <input type="text" id="screenName" value=""/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center">
                        <input style="font-size: 20px" type="button" id="submit" value="提交"/>
                    </td>
                </tr>
            </table>
        </div>
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript">
            $(function(){
                $('#submit').on({
                    'click' : function(){
                        $.ajax({
                            type : 'POST',
                            url : 'index/getInfo.do',
                            data : {
                                name : $('#name').val(),
                                mobile : $('#mobile').val(),
                                address : $('#address').val(),
                                screenName : $('#screenName').val()
                            },
                            dataType : 'json',
                            success : function(data){
                                alert(data.flag);
                            }
                        });
                    }
                });
            });
        </script>
    </body>
</html>
