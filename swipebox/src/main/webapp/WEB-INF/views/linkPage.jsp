<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <title>Swipebox main page</title>

  <!-- CSS  -->
  <link href="${pageContext.request.contextPath}/resources/css/prism.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/css/ghpages-materialize.css" type="text/css" rel="stylesheet" media="screen,projection">
  <link href="https://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>

  <header>

    <div class="container"><a href="#" data-activates="nav-mobile" class="button-collapse top-nav waves-effect waves-light circle hide-on-large-only"><i class="material-icons">menu</i></a></div>
    <ul id="nav-mobile" class="side-nav fixed">
      <li class="bold"><a href="/project/list" class="waves-effect waves-teal">My Files</a></li>
      <li class="no-padding">
        <ul class="collapsible collapsible-accordion">
          <li class="bold"><a class="collapsible-header  waves-effect waves-teal">Additional features</a>
            <div class="collapsible-body">
              <ul>
                <li><a href="#">Archive Page</a></li>
                <li><a href="#">Trash</a></li>
              </ul>
            </div>
          </li>
          <li class="bold"><a class="collapsible-header  waves-effect waves-teal">QnA</a>
            <div class="collapsible-body">
              <ul>
                <li><a href="#">Frequently Asked Questions</a></li>
                <li><a href="#">My QnA</a></li>
              </ul>
            </div>
          </li>
        </ul>
      </li>
    </ul>
  </header>

  <main>      <div class="section no-pad-bot" id="index-banner">
      <div class="container">
        <h4 class="header center-on-small-only">Home</h4>
        <div class='row center'>
          <h4 class ="header col s12 light center">Now Upload Files</h4>
        </div>
        <div class="row center">
          <a href="/project/fileUpload" id="download-button" class="btn-large waves-effect waves-light">UPLOAD FILES</a>
        </div>
        <div class="buysellads-header buysellads-homepage row center">
        </div>
        <br>
      </div>

    <div class="container">

      <div class="divider"></div>
      <div class="section">
        <div class="row center">
          <h3 class="light header">Archive Page</h3>
          <p class="col s12 m8 offset-m2 caption">This is the page where all your activity history is stored.</p>
          <a href="http://materializecss.com/showcase.html" class="btn-large waves-effect waves-light">Explore Archive Page</a>
        </div>
      </div>
      <div class="divider"></div>
      <div class="section">
        <div class="row center">
          <h3 class="light header">Trash</h3>
          <div class="col s12 m6 offset-m3">
            <p class="caption">
            Go to see the poor file in the trash.</p>
            <img width="100%" src="https://s23.postimg.org/9g7ajckrf/thunder.png" alt="">
            <br><br>
            <a href="http://materializecss.com/themes.html" class="btn-large waves-effect waves-light">Explore your Trash</a>
          </div>
        </div>
      </div>
    </div>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/materialize.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/init.js"></script>

  </body>
</html>
