package membershippack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/membership/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Register() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post 전송시 한글이 깨지기 때문에 아래 코드를 추가 
		request.setCharacterEncoding("utf-8");
		
		//파라미터를 읽어서 출력
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
		System.out.println("email : "+email);
		System.out.println("pw : "+pw);
		System.out.println("name : "+name);
		System.out.println("gender : "+gender);
		
		
		//결과 페이지에 전송할 데이터를 저장
		request.setAttribute("msg", "회원가입에 성공하였습니다.");
		
		//결과 페이지로 포워딩 - 새로고침 하면 작업을 다시 수행하게 되서 즉 회원가입이 다시 또 되서, 이렇게 쓰면 안된다.
		/*
		RequestDispatcher dispatcher = request.getRequestDispatcher("output.jsp");
		dispatcher.forward(request, response);
		*/
		
		request.getSession().setAttribute("msg", "회원가입 성공");
		response.sendRedirect("output.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
