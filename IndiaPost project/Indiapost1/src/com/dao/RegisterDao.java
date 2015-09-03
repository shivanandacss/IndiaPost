package com.dao;

import java.sql.SQLException;

import com.dto.PickUpDto;
import com.dto.RegisterDto;
import com.mysql.jdbc.PreparedStatement;
import com.util.DbConnection;

public class RegisterDao {
	
	DbConnection dbCon = new DbConnection();

	public boolean registerMyDetails(RegisterDto registerDto) {
		System.out.println("Inside Dao Class");

		boolean flag = false;
		String query = "insert into Indiapost(FirstName,LastName,gender,phoneNumber,Address,Email,Username,password) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = (PreparedStatement) dbCon.getPrepareStatement(query);
		try {
			pstmt.setString(1, registerDto.getFirstName());
			pstmt.setString(2, registerDto.getLastName());
			pstmt.setString(3, registerDto.getGender());
			pstmt.setInt(4, registerDto.getPhoneNumber());
			pstmt.setString(5, registerDto.getAddress());
			pstmt.setString(6, registerDto.getEmail());
			pstmt.setString(7, registerDto.getUserName());
			pstmt.setString(8, registerDto.getPassWord());

			int i = pstmt.executeUpdate();
			if (i > 0)
				System.out.println("Status True");
			flag = true;
		} catch (SQLException e) {
			System.out.println("Status Fail");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean loginMyPage(RegisterDto registerDto) {
		boolean flag = false;
		String query = "select * from Indiapost where Username=? and password=? ";
		PreparedStatement pstmt = (PreparedStatement) dbCon.getPrepareStatement(query);
		try {
			pstmt.setString(1, registerDto.getUserName());
			pstmt.setString(2, registerDto.getPassWord());

			java.sql.ResultSet rs = pstmt.executeQuery();
			if (rs.next())

				System.out.println("Status true");
			flag = true;
		} catch (SQLException e) {
			System.out.println("Status Fail");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean pickUpMyDetails(PickUpDto pickUpDto) {
		System.out.println("Inside Dao Class");

		boolean flag = false;
		String query = "insert into Schedulepickup1(scheduledDateTime,address,Weight) values(?,?,?)";
		PreparedStatement pstmt = (PreparedStatement) dbCon.getPrepareStatement(query);
		try {

			pstmt.setString(1, pickUpDto.getYear() + "-" + pickUpDto.getMonth() + "-" + pickUpDto.getDate() + " "
					+ pickUpDto.getHour() + ":" + pickUpDto.getMin());
			pstmt.setString(2, pickUpDto.getAddress());
			pstmt.setString(3, pickUpDto.getWeight() + " " + pickUpDto.getUnit());

			int i = pstmt.executeUpdate();
			if (i > 0)
				System.out.println("Status True");
			flag = true;
		} catch (SQLException e) {
			System.out.println("Status Fail");
			e.printStackTrace();
		}
		return flag;
	}

}
