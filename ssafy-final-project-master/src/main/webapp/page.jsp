<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>${pageName}</title>
    <link type="text/css" href="css/css.css" rel="stylesheet" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    />
    <!-- 부가적인 테마 -->
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
    />
    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
  </head>
  <body>
    <jsp:include page="header.jsp"></jsp:include>
    <div id="root"></div>
    <jsp:include page="footer.jsp"></jsp:include>
  </body>
  <script src="react/${pageName}.bundle.js"></script>
</html>
