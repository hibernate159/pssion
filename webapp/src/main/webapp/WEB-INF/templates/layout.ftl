<#assign staticHttpUrl=".." uploadHttpUrl="b" />
<#assign menuMap={"订单管理":"orders","外协管理":"wx","往来管理":"wl","订单管理":"orders","外协管理":"wx","往来管理":"wl"} />

<#macro default title userStr urlMap>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>供应商-${title?html}</title>

    <!-- Bootstrap core CSS -->
    <link href="${staticHttpUrl}/globle/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${staticHttpUrl}/globle/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${staticHttpUrl}/globle/css/mp/navbar-fixed-top.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]></script><![endif]-->
    <script src="${staticHttpUrl}/globle/assets/js/ie8-responsive-file-warning.js">
    <script src="${staticHttpUrl}/globle/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <![endif]-->
    <script src="${staticHttpUrl}/globle/assets/js/html5shiv.min.js"></script>
    <script src="${staticHttpUrl}/globle/assets/js/respond.min.js"></script>
  </head>

  <body>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="javascript:;">供应商平台</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <#assign mks = menuMap?keys />
            <#list mks as mk>
            <li class="dropdown">
            <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${mk} <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">${menuMap["${mk}"]}_${mk_index}</a></li>
            </ul>
            </li>
            </#list>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
            <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">欢迎:${userStr} <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="javascript:;">退出</a></li>
            </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <#nested>
    
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${staticHttpUrl}/globle/js/jquery.min.js"></script>
    <script src="${staticHttpUrl}/globle/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${staticHttpUrl}/globle/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
</#macro>