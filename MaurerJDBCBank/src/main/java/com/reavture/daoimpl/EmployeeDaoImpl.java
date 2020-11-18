package com.reavture.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bean.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.util.ConnFactory;

public class EmployeeDaoImpl implements EmployeeDao
{
	public static ConnFactory cf = ConnFactory.getInstance();
	public static Connection conn = cf.getConnection();	

	@Override
	public Employee getEmployeeByUserName(String email)
	{
		
		try {
			
			String sql = "select * from employee where emp_email=?;";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			Employee c = null;
			
			while(rs.next())
			{
				c = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));
			}
			
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

}
