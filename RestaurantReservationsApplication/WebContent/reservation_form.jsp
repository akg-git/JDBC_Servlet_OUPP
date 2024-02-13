<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Form</title>
</head>
<body>
	<form action="ReservationServlet" style="align: '' center';">
		<pre>
	
			<label for="name"> Name </label>		
			<input type="text" name="name"
				placeholder="enter your name"></br>
			
			<label for="phone_number"> Phone Number</label>	
			<input type="number"
				name="phone" placeholder="enter your phone number"></br>
			
			<label for="party_size">Party Size</label>	 
			<input type="number"
				name="party_size" placeholder="enter your party size"></br>
			
			<label for="tableId"> Table Number </label>	 
			<input type="number"
				name="tableId"></br>
			
			<!-- <label for="date"> Date </label>		<input type="date" name = "date"></br>
			<input type="date" class="form-control form-control-lg" id="fromBookingDate" placeholder="dd/MM/yyyy"/> -->
			
			<label for="date">Date: </label>
			<input type="date" id="date" name="date" value="dd-MM-yyyy"
				min="2023-12-11" max="2023-12-31" date-toggle="datetimepicker" />
			
		<!-- 	<label>Date:	<input type="date" name="bday" /> </label> -->
			
		
			<label for="timeslot"> Time Slot: </label>
			<select name="time_slot">
				<option value="choose">Choose</option>
				<option value="6.30PM">6.30PM</option>
				<option value="8.15PM">8.15PM</option>
				<option value="10.00PM">10.00PM</option>
			</select></br>
			
			<input type="submit" name="cancel" value="cancel">		
			<input type="submit" name="book" value="book">
	</pre>
	</form>

</body>
</html>