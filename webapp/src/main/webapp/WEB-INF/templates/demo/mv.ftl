<#import "spring.ftl" as spring>
<@bp.default title="demo-mv" userStr="${userStr}" urlMap={"",""}>
<#escape x as x?html>
${sc}
<@spring.message "remove"/> 
</#escape>
</@bp.default>