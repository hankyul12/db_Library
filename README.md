톰캣 10.1

https://tomcat.apache.org/download-10.cgi

https://dev-handbook.tistory.com/32

==============================================

mysql connector 8.0.22.jar사용

src/main/webapp/WEB-INF/lib에 존재

==============================================

mysql 

ID : root 

PWD : 0000

(DBConnection.java에서 자기자신의 mysql정보 입력)

Library_sql.txt   위에서 순서대로 실행 (맨처음 mydbs삭제 sql문이 있으니 조심)

==============================================

Eclipse를 열고 File > Import

General > Existing Projects into Workspace를 선택하고 Next

Select root directory에서 Git에서 다운로드한 프로젝트 폴더를 선택한 후 Finish

index.jsp을 톰캣서버에서 실행


이미 톰캣버전 다른버전이나 이클립스의 자신만의 다른 설정등을 사용하고 있으면

이클립스에 톰캣 서버 세팅한 다음

src/main안에 있는 .java , .html , img파일 등등 같은 자리에 파일생성 + 복붙
