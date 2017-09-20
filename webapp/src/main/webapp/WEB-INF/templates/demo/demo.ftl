<#import "spring.ftl" as spring>
<@bp.default title="demo-mv" userStr="${userStr}" urlMap={"",""}>
<#escape x as x?html>
${returnPage.userId}
<@spring.message "remove"/> 
<form action="/demo/f_demo.do" method="post">

</form>
</#escape>
</@bp.default>