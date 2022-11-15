package Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.User;

/**
 * @Author XDW
 * @Version 1.0
 * @date 2022/10/28 16:37
 */
public interface UserMapper {
    @Select("select * from user where username = #{username} and password =#{password}")
    User Check(@Param("username") String username,@Param("password") String password);

    @Insert("insert into user(username,password) values (#{username},#{password})")
    void ins(@Param("username") String username,@Param("password") String password);

}
