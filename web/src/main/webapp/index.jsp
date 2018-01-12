<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>首页</title>
    </head>
    <body>
        <h2>Hello World!</h2>
        <input id="call" type="button" value="调用接口"/>
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript">
            $(function(){
                $('#call').on({
                    'click' : function(){
                        $.ajax({
                            type : 'POST',
                            url : 'index/getInfo.do',
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
