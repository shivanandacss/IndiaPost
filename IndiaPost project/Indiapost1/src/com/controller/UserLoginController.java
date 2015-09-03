package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.dto.PickUpDto;
import com.dto.RegisterDto;
import com.util.DateValidation;

@WebServlet("/UserLoginController1")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserLoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String link = request.getParameter("indiaPost");
		if (link.equalsIgnoreCase("register")) {
			System.out.println("Inside Registration page");

			String FirstName = request.getParameter("firstName");
			String LastName = request.getParameter("lastName");
			String gender = request.getParameter("gender");
			String phoneNumber = request.getParameter("number");
			int phonenumber = Integer.parseInt(phoneNumber);
			String email = request.getParameter("email");
			String address = request.getParameter("addressType");
			String userName = request.getParameter("username");
			String passWord = request.getParameter("password");
			System.out.println("FirstName:" + FirstName + "LastName:"
					+ LastName + "gender:" + gender + "phonenumber:"
					+ phonenumber + "email:" + email + "userName" + userName
					+ "passWord:" + passWord + "address:" + address);

			/*
			 * DTO Setting the values of the user details
			 */

			RegisterDto registerDto = new RegisterDto();
			registerDto.setFirstName(FirstName);
			registerDto.setLastName(LastName);
			registerDto.setGender(gender);
			registerDto.setPhoneNumber(phonenumber);
			registerDto.setEmail(email);
			registerDto.setAddress(address);
			registerDto.setUserName(userName);
			registerDto.setPassWord(passWord);

			RegisterDao registerDao = new RegisterDao();
			boolean status = registerDao.registerMyDetails(registerDto);

			if (status) {
				System.out.println("Sucess");
				out.println("Sucess...");
				RequestDispatcher rd = request
						.getRequestDispatcher("login.jsp");
				rd.forward(request, response);

			} else {
				System.out.println("Failed");
				out.println("failed....");
				RequestDispatcher rd = request
						.getRequestDispatcher("register.jsp");
				rd.include(request, response);
			}
		}
		if (link.equalsIgnoreCase("login")) {

			String userName = request.getParameter("UserName");
			String passWord = request.getParameter("Password");

			RegisterDto registerDto = new RegisterDto();
			registerDto.setUserName(userName);
			registerDto.setPassWord(passWord);

			RegisterDao registerDao = new RegisterDao();
			boolean status = registerDao.loginMyPage(registerDto);
			if (status) {
				System.out.println("Login Sucess");
				out.println(" Login Sucess...");
				RequestDispatcher rd = request
						.getRequestDispatcher("SchedulePickup.jsp");
				rd.forward(request, response);

			} else {
				System.out.println(" Login Failed");
				out.println(" Login failed....");
				RequestDispatcher rd = request
						.getRequestDispatcher("Error.jsp");
				rd.include(request, response);
			}
		}
		if (link.equalsIgnoreCase("schedule")) {

			String date = request.getParameter("date");
			String month = request.getParameter("month");
			String year = request.getParameter("year");

			String hour = request.getParameter("hour");
			String min = request.getParameter("min");

			String unit = request.getParameter("unit");

			String address = request.getParameter("Address");
			String weight = request.getParameter("weight");

			PickUpDto pickUpDto = new PickUpDto();

			pickUpDto.setDate(date);
			pickUpDto.setMonth(month);
			pickUpDto.setYear(year);

			pickUpDto.setHour(hour);
			pickUpDto.setMin(min);
			pickUpDto.setUnit(unit);

			pickUpDto.setAddress(address);
			pickUpDto.setWeight(weight);

			String pickDateTime = pickUpDto.getYear() + "-"
					+ pickUpDto.getMonth() + "-" + pickUpDto.getDate() + " "
					+ pickUpDto.getHour() + ":" + pickUpDto.getMin();

			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");

			String currentDateTime = dateFormat.format(new Date());

			int dateStatus = DateValidation.compareDates(pickDateTime,
					currentDateTime);

			if (dateStatus == 0) {
				RequestDispatcher rd = request
						.getRequestDispatcher("DateError.jsp");
				rd.forward(request, response);
			} else if (dateStatus == 1) {
				System.out.println("PickUp Sucess");
				out.println(" Pickup Sucess...");
				RequestDispatcher rd = request
						.getRequestDispatcher("confirm.jsp");
				rd.forward(request, response);

			} else if (dateStatus == -1) {
				RequestDispatcher rd = request
						.getRequestDispatcher("DateError.jsp");
				rd.forward(request, response);
			}

		}

	}
}
