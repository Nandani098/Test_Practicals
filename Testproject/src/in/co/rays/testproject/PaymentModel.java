package in.co.rays.testproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PaymentModel {

	public void add(PaymentBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nandani", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into Payment values(?,?,?,?,?,?)");

		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getAmount());
		ps.setString(4, bean.getPaymentmethod());
		ps.setString(5, bean.getStatus());
		ps.setString(6, bean.getPayer());

		int i = ps.executeUpdate();
		System.out.println("data added=" + i);

	}

	public void update(PaymentBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nandani", "root", "root");
		PreparedStatement ps = conn
				.prepareStatement("update payment set name=?,amount=?, paymentmethod=?, status=? ,payer=? ,where id=?");

		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getAmount());
		ps.setString(3, bean.getPaymentmethod());
		ps.setString(4, bean.getStatus());
		ps.setString(5, bean.getPayer());
		ps.setInt(6, bean.getId());

		int i = ps.executeUpdate();
		System.out.println("data updated=" + i);

	}

	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nandani", "root", "root");
		PreparedStatement ps = conn.prepareStatement("delete from payment where id=?");

		ps.setInt(1, id);

		int i = ps.executeUpdate();
		System.out.println("data deleted=" + i);

	}

	public PaymentBean findbyPk() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nandani", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select from payment where id=?");

		ResultSet rs = ps.executeQuery();

		PaymentBean bean = new PaymentBean();

		while (rs.next()) {

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setAmount(rs.getInt(3));
			bean.setPaymentmethod(rs.getString(4));
			bean.setStatus(rs.getString(5));
			bean.setPayer(rs.getString(6));

		}
		return bean;

	}
}
