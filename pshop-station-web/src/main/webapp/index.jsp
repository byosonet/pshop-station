<%@ include file="./WEB-INF/views/layout/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>eQuivira</title>
  <jsp:include page="./WEB-INF/views/layout/staticResources.jsp"></jsp:include>

  <style type="text/css">
	html * {font-family: Verdana;font-size: 12;}
  </style>

  
  <script type="text/javascript">
      $(function(){
          var status;
          $('input#login').focus();
          
          $("input#password").keypress(function(event) {
              if (event.which == 13) {
                  event.preventDefault();
                  login();
              }
          });

          $("input#login").keypress(function(event) {
              if (event.which == 13) {
                  event.preventDefault();
                  login();
              }
          });

          
          $('button#acceder').click(function(){
              login();
          });
          
          function login(){
        	  var email = $('input#login');
              var password = $('input#password');
              if(email.val() === ""){
                  muestraMsjSistemaError('El login es requerido.');
                  return false;
              }else if(password.val() === ""){
                  muestraMsjSistemaError('El password es requerido.');
                  return false;
              }
              
              $.blockUI();
              $.ajax({
	              type: 'POST',
	              url: '${contextpath}'+'/validar/usuario',
	              data: $('form#ingresar').serialize(),
	                  success: function (data) {
                             $.unblockUI();
                             //muestraMsjSistemaSuccess(data.mensaje);
                             var urlAction = '${contextpath}' + '/equivira';
                             document.getElementById('ingresar').action = urlAction;
                             document.getElementById('ingresar').method = 'POST';
                             document.getElementById('ingresar').submit();
	              			},
                         error: function(msj){
                             status = JSON.parse(msj.responseText);
                             $.unblockUI();
                             muestraMsjSistemaError(status.mensaje);
                          }
	        });
          }
          
          $('button#registrar').click(function(){
                $.blockUI();
                var urlAction = '${contextpath}' + '/registrar/usuario';
				document.getElementById('ingresar').action = urlAction;
                document.getElementById('ingresar').method = 'GET';
				document.getElementById('ingresar').submit();
          });

        function muestraMsjSistemaError(msjStatus){
           BootstrapDialog.show({
            size: BootstrapDialog.SIZE_SMALL,
            title: 'Mensaje del Sistema:',
            closable: false,
            message: msjStatus,
            type: BootstrapDialog.TYPE_DANGER,
            cssClass: 'login-dialog',
            buttons: [{
                icon: 'glyphicon glyphicon-check',
                label: 'OK',
                cssClass: 'btn-primary',
                action: function(dialog) {
                    dialog.close();
                }
            }]
        });
        }
        
        function muestraMsjSistemaSuccess(msjStatus){
           BootstrapDialog.show({
            size: BootstrapDialog.SIZE_SMALL,
            title: 'Mensaje del Sistema:',
            closable: false,
            message: msjStatus,
            type: BootstrapDialog.TYPE_SUCCESS,
            cssClass: 'login-dialog',
            buttons: [{
                icon: 'glyphicon glyphicon-ok',
                label: 'CONTINUAR',
                cssClass: 'btn-primary',
                action: function(dialog) {
                    dialog.close();
                    $.blockUI();
                    var urlAction = '${contextpath}' + '/equivira';
                    document.getElementById('ingresar').action = urlAction;
                    document.getElementById('ingresar').method = 'POST';
                    document.getElementById('ingresar').submit();
                }
            }]
        });
        }
      });
  </script>
  <style>
             body{
                font:  10.5px Verdana;
             }
  </style>
</head>
<body style="">
     <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/bstore" style="color:white;">eQuivira</a>
          </div>
          <div style="height: 1px;" aria-expanded="false" class="navbar-collapse collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                  <a style="color:black;" aria-expanded="true" aria-haspopup="true" role="button" data-toggle="dropdown" class="navbar-brand dropdown-toggle" href="#"></a>
                </li>
              </ul>
          </div>
        </div>
      </nav>

<div class="container-fluid" style="margin-top: 30px;">
    <div class="row">
        <div class="col-sm-12 col-sm-offset-0 col-md-3 col-md-offset-4 main">
        </br>
        </br>
        </br>
            <form id="ingresar" class="form-horizontal" method="POST" action="${contextpath}/equivira">
                <div class="form-group">
                    <label class="control-label col-sm-3" for="nombre"></label>
                    <div class="col-sm-9">
                        <div style="text-align:center;color:black"><h5><b>e Q u i v i r a</b></h5><br><img width="150px" height="150px" src="${contextpath}/static/resources/img/favicon.ico">
                      </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3" style="color:black;" for="nombre">Usuario</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="login" name="user" placeholder="Ingresa tu login">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-3" style="color:black;" for="email">Password</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Ingresa tu password">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-12" style="color:black;">¿Olvidé mi contraseña? <a href="${contextpath}/password/recuperar">Recuperar contraseña</a></label>
                </div>
            </form>
            <div class="row">
                <div class="col-sm-offset-2 col-sm-10" style="text-align: right;">
                <button id="registrar" class="btn btn-default"><span class="glyphicon glyphicon-user"></span> REGISTRAR</button>
                <button id="acceder" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span> ACCEDER</button>
                </div>
            </div>
        </div>
    </div>    
</div>
</body>
</html>
