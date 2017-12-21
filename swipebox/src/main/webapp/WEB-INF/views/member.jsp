<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8" />
  <meta http-equiv="Content-Type" content="text/html" />
  <meta http-equiv="Content-Script-Type" content="text/javascript">
  <meta http-equiv="Content-Style-Type" content="text/css">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <title>Swipebox join page</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/semantic.min.css">
  <style type="text/css">
    header {
      padding-bottom: 100px;
    }
  </style>
  <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/form.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/transition.js"></script>
  <script>
    $(document)
      .ready(function() {
        $('.ui.form')
          .form({
            fields: {
              email: {
                identifier: 'email',
                rules: [{
                    type: 'empty',
                    prompt: 'Please enter your e-mail'
                  },
                  {
                    type: 'email',
                    prompt: 'Please enter a valid e-mail'
                  }
                ]
              },
              password: {
                identifier: 'passwd',
                rules: [{
                    type: 'empty',
                    prompt: 'Please enter your password'
                  },
                  {
                    type: 'length[6]',
                    prompt: 'Your password must be at least 6 characters'
                  }
                ]
              },
              reconfirm: {
                identifier: 'reconfirm[password]',
                rules: [{
                    type: 'empty',
                    prompt: 'Please enter your reconfirm_password'
                  },
                  {
                    type: 'match[passwd]',
                    prompt: 'Your reconfirm_password does not match the password'
                  }
                ]
              },
              userName: {
                identifier: 'name',
                rules: [{
                    type: 'empty',
                    prompt: 'Please enter your name'
                  },
                  {
                    type: 'minLength[2]',
                    prompt: 'Your name must be at least 2 characters'
                  }
                ]
              }
            }
          });
      });
  </script>
</head>

<body>
  <header>
    <div class="ui secondary pointing menu">
      <a class="item">Swipebox</a>
      <div class="right menu">
        <a class="item" href="./login">Login</a>
        <a class="item">Help<i class="help icon"></i></a>
      </div>
    </div>
  </header>
  <content>
    <h2 class="ui center aligned icon header">
    <i class="circular users icon"></i>
      Join
    </h2>
    <form class="ui large form" name="regForm" action="./member" method="POST">
      <div class="ui middle aligned center aligned grid">
        <div class="ui form">
          <div class="field">
            <label>User ID</label>
            <input type="text" name="id" placeholder="example" required>
          </div>
          <div class="two fields">
            <div class="field">
              <label for="input[password]">Password</label>
              <input type="password" name="passwd" required>
            </div>
            <div class="field">
              <label for="reconfirm[password]">Reconfirm password</label>
              <input type="password" name="reconfirm[password]" required>
            </div>
          </div>
          <div class="field">
            <label>User name</label>
            <input type="text" name="name" placeholder="User Name" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" required>
          </div>
          <div class="field">
            <label>User cellphone</label>
            <input type="number" name="tel" placeholder="01012341234" pattern="^\d{3}\d{4}\d{4}$">
          </div>
          <div class="field">
            <label>User E-mail</label>
            <input type="email" name="email" placeholder="example@example.com">
          </div>
          
          <div class="ui error message"></div>
          <button class="ui button" type="submit">Submit</button>
          <!-- <div class="ui fluid large black submit button">Sign up</div> -->
        </div>
      </div>
    </form>
  </content>

</body>

</html>
