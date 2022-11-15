package web; /**
 * @Author XDW
 * @Version 1.0
 * @date 2022/10/28 16:31
 */

import MD5_Base64.en_decoding;
import Mapper.UserMapper;
import Utils.SqlSessionFactaryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/logup")
public class logup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String username = en_decoding.encoderBASE64(request.getParameter("username"));
        String password = en_decoding.encoderBASE64(request.getParameter("password"));

        SqlSessionFactory sqlSessionFactory = SqlSessionFactaryUtil.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User check = mapper.Check(username, password);
        PrintWriter writer = response.getWriter();
        if (check!=null) {
            writer.write("<h2>注册失败</h2>");
        }else {
            writer.write("<h2>注册成功</h2>");
            mapper.ins(username,password);
            sqlSession.commit();
        }
        sqlSession.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
