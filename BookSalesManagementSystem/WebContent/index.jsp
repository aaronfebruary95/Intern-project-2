<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Sales Management System</title>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/resources/css/index.css" />
</head>
<body>
	<form class="login">
        <div class="container">
            <ul>
                <li>
                    <label for="uname"><b>User Name</b></label>
                    <input type="text" id="uname" name="uname" placeholder="Enter UserName" required>
                </li>
                <li>
                    <label for="psw"><b>Password</b></label>
                    <input type="password" id="psw" name="psw" placeholder="Enter Password" required>            
                </li>
                <li>
                    <button type="submit">LOGIN</button>
                </li>
                <li>
                    <label>
                        <input type="checkbox" checked="checked" name="remember">Remember me
                    </label>
                </li>
                <li>
                <li>
                        <span class="psw"><a href="#">Forgot Password</a></span>
                </li>
            </ul>
        </div>
    </form>

    <div style="display: flex;">
        <button style="margin: 0 auto;" onclick="document.getElementById('id01').style.display='block'">
                Sign Up
        </button>
        <div id="id01" class="sign-up">
            <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">
                &times;
            </span>
            <form class="sign-up-main">
                <div class="text">
                    <h1>Sign Up</h1>
                    <p>Please fill in this form to create an account.</p>
                </div>
                <ul>
                    <li>
                            <label for="user"><b>User Name</b></label>
                            <input type="text" placeholder="Enter User Name" name="user" required>
                    </li>
                    <li>

                    </li>
                    <li>
                            <label for="psw"><b>Password</b></label>
                            <input type="password" placeholder="Enter Password" name="psw" required>
                    </li>
                    <li>
                            <label for="psw-repeat"><b>Repeat Password</b></label>
                            <input type="password" placeholder="Repeat Password" name="psw-repeat" required>
                    </li>
                    <li>
                            <label>
                                <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
                            </label>
                    </li>
                    <li>
                        <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
                    </li>
                    <li>
                        <div class="clearfix">
                            <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
                            <button type="submit" class="signupbtn">Sign Up</button>
                        </div>
                    </li>
                </ul>
            </form>
        </div>
        <script>
            var modal = document.getElementById('id01');
            window.onclick = function(event){
                if(event.target == modal){
                    modal.style.display = "none";
                }
            }
        </script>
    </div>
</body>
</html>