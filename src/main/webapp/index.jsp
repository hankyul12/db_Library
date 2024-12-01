<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>도서관</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Agbalumo&family=Dongle:wght@300;700&family=Gaegu&family=Gamja+Flower&family=Gowun+Dodum&family=Orbit&family=Playpen+Sans:wght@200;400&family=Sunflower:wght@500&display=swap" rel="stylesheet">
    <style>
        body {
            height: 100vh;
            margin: 0;
            
        }

        header {
            width: 100%;
            height: 23vh;
        }

        #logo {
            width: 17%;
            height: 100%;
            float: left;            
        }

            #logo img {
                margin-left: 70px;
                width: 65%;
            }

        section {
            height: 77vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        #bookList {
            width: 99%;
            height: 99%;
            border : solid;
            border-color : grey;
        }

        #func {
            margin: 10px;
            padding: 1px;
            border: dashed;
            border-color: #008D62;
            border-radius: 10px;
            width: 80%;
            height: 210px;            
        }

        #mypage {
            width: 70%;
            height: 80%;
            margin-left : 10px;
            border-radius: 40px;
            border: 3px solid black;
            color: white;
            background: #008D62;
        }

        #searchInput {
            width: 95%;
            height: 80%;
            border-radius: 40px;
            border: 3px solid black;
        }
		#searchType{
			width: 85%;
		    height: 80%;
		    border-radius: 40px;
		    border: 3px solid black;
		    
		}
        #searchButton {
            width: 40%;
            height: 80%;
            border-radius: 40px;
            color: white;
            background: #008D62;
            border: 3px solid black;
        }

        #login {
            width: 95%;
            height: 80%;
            border-radius: 10px;
            border: 3px solid black;
            background: #008D62;
            color: white;
        }
        

        .funcText {
            font-size: 17px;
            font-family: 'Orbit', serif;
           
        }

        #mypage, #login, #loginButton, #searchInput, #searchButton, #searchType {
            box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); 
            font-size: 22px;            
            
        }

        #login:hover, #loginButton:hover, #searchButton:hover, #mypage:hover {
            background: grey;
            transition: background-color 0.3s;
        }

    </style>
</head>

<body onload="loginYN()">
    <header>
        <div id="logo">
           <img src="img/logo.png" alt="Logo Image" onclick="mainpage()">
        </div>
        <div>
            <table id="func">
                <tr>
                    <td>
                        <select class="funcText"  name="languages" id="searchType">
							<option value="title">제목</option>
							<option value="Genre">장르</option>
					</select>
					</td>
                    <td>
                        <input type="text" id="searchInput" class="funcText" placeholder="검색어를 입력하세요"> <!-- 검색 입력창 -->
                    </td>
                    <td>
                    	<button id="searchButton" class="funcText" onclick="search()" >🔍︎</button> <!-- 검색 버튼 -->
                    </td>
                    <td>
                        <button id="login" class="funcText">로그인</button> <!-- 로그인 버튼 -->
                    </td>
                    <td >
                        <button id="mypage" class="funcText" onclick="window.location.href='mypage.html'">마이 페이지</button> <!-- 마이 페이지  버튼 -->
                    </td>
                </tr>
            </table>
        </div>
    </header>
    <section>      
        <iframe id="bookList" src="bookList.jsp">
            <!-- DB로부터 책 목록을 불러옴 -->
        </iframe>
    </section>
    <script>
		function search(){
			var searchtext = document.getElementById('searchInput').value;
			if(searchtext==""){
				document.getElementById('bookList').src="bookList.jsp"
			}else{
				var searchType = document.getElementById('searchType').value;
				//document.getElementById('bookList').src="searchbookList.html?"+searchtext;

				document.getElementById('bookList').src="searchbookList.html?searchtext="+searchtext+"&searchType="+searchType; 
			}
		}
		function mainpage(){
			var ifr = document.getElementById('bookList');
			ifr.src="bookList.jsp";
		}
		function loginYN() {
         	var btn = document.getElementById("login");
         	var btn2 = document.getElementById("mypage");
         	var myid = localStorage.getItem('id');
         	if(myid == null) {
            	btn.innerText = "로그인";
            	btn.onclick = function() {
               		window.location.href = "login.html";
            	}
         	}
         	else if(myid == "해당하는 결과가 없습니다."){
         		localStorage.clear();
         		alert("로그인 실패!");
         		btn.onclick = function() {
               		window.location.href = "login.html";
            	}
         	}
         	else {
            	btn.innerText = "로그아웃";
           		btn.onclick = function() {
              		localStorage.clear();
               		btn.innerText = "로그인";
               		location.reload();
               		
            }
         }
         
      }
	</script>
</body>
</html>
