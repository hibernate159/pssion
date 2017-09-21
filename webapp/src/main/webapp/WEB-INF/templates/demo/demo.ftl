<@bp.default title="demo-mv" userStr="${userStr}" urlMap={"",""}>
<#escape x as x?html>
${returnPage.userId}
<#list CsrfToken as token>
${token}
</#list>

<form action="/demo/f_demo.do" method="post">
    <input type="hidden" name="_csrf_token" value="${CsrfToken[0]}" />
    <input type="submit" value="button" />
</form>
</#escape>
</@bp.default>