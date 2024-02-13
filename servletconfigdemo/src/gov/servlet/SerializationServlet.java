package gov.servlet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//it replaces web.xml file
@WebServlet("/SerializationServlet")
public class SerializationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SerializationServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		// create user object
		User user = new User("john_doe", "secretpassword");

		// serialize the user object to a byte array
		byte[] serializedUser = serializeUser(user);

		// display the serialized user as a string
		response.getWriter().print("Serialized User: " + new String(serializedUser));

		// Deserialize the user object from the byte array
		User deserializedUser;
		try {
			deserializedUser = deserializeUser(serializedUser);

			// Display the deserialized user's username
			response.getWriter().print("Deserialized Username: " + deserializedUser.getUsername()
									+ "Deserialized Password: " + deserializedUser.getPassword());
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

	}

	private byte[] serializeUser(User user) throws IOException {

		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos)) {
			oos.writeObject(user);

			return baos.toByteArray();
		}

	}

	private User deserializeUser(byte[] serializedUser) throws IOException, ClassNotFoundException {

		try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedUser);
				ObjectInputStream ois = new ObjectInputStream(bais)) {

			return (User) ois.readObject();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
