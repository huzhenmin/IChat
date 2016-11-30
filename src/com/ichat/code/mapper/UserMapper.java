package com.ichat.code.mapper;

import java.util.List;
import java.util.Map;



import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ichat.code.beans.User;



public interface UserMapper {
	
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@Select("select * from user where username=#{un} and password=#{pw}")
    @Results({
		
		@Result(id=true,property="id",column="id",javaType=Integer.class),
		@Result(property="username",column="username",javaType=String.class),
		@Result(property="password",column="password",javaType=String.class),
		@Result(property="account",column="account",javaType=Double.class)
	})
	public User login(@Param("un")String username,@Param("pw")String password);
	/**
	 *
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Insert("insert into user value (null,user.username,user.password,user.account)")
	@Options(useGeneratedKeys=true,keyProperty="user.id")
	public int insertUser(@Param("user")User user) throws Exception;
	
	
	/**
	 * 
	 * @param user
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Update(" update user set username=#{u.username},password=#{u.password},account=#{u.account} where id=#{id}")
    public int updateUser (@Param("u")User user,@Param("id")int id) throws Exception;
	
     /**
      * @param id
      * @return
      * @throws Exception
      */
	@Delete(" delete from user where id=#{id}  ")
    public int deleteUser(int id) throws Exception;
	
	
    /**
     * @param id
     * @return
     * @throws Exception
     */
	
	@Select(" select * from t_user where id=#{id}")
	@Results({
		
		@Result(id=true,property="id",column="id",javaType=Integer.class),
		@Result(property="username",column="username",javaType=String.class),
		@Result(property="password",column="password",javaType=String.class),
		@Result(property="account",column="account",javaType=Double.class)
	})
    public User selectUserById(int id) throws Exception;
     /**
      * @return
      * @throws Exception
      */
	
	@Select(" select * from t_user")
	@ResultMap("userMap")
    public List<User> selectAllUser() throws Exception;
    
    
    /**
     * @param user
     * @return
     * @throws Exception
     */
   public int batchInsertUser(@Param("users")List<User> user) throws Exception;
   
   /**
    * @param list
    * @return
    * @throws Exception
    */
   public int batchDeleteUser(@Param("list")List<Integer> list) throws Exception;
   
   
   /**
    * @param parma
    * @return
    * @throws Exception
    */
   public List<User> pagerUser(Map<String, Object> parmas) throws Exception;
   
   /**
    * 
    * @param parma
    * @return
    * @throws Exception
    */
    public int countUser(Map<String, Object> parmas) throws Exception;
    
  
    
    
}
