<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>萝卜影视</title>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/main.css">

</head>
<body>
	<style type="text/css">
</style>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/handlebars-1.0.0.beta.6.js"></script>
	<div id="content" class="row-fluid">
		<div class="container">
			<div id="head"></div>
			<div class="col-md-9" style="padding: 5px;background: #F2F2F3;" id="midContent">
				<h2>Main Content Section</h2>
				adsf
			</div>
			<div class="col-md-3">
				<div class="row" id="left1"></div>
				<div class="row" id="left2"></div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
$(document).ready(function(){ 
  $('#head').load('head.html');
  //$('#midContent').load('films.html');
  $('#midContent').load('record.html');
  $('#left1').load('hot.html');
  $('#left2').load('hot.html');
}); 

    
</script>

</html>