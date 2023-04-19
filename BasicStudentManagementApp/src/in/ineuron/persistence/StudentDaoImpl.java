package in.ineuron.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Student;
import in.ineuron.utilconnection.JdbcConnection;

//Persistence logic using JDBC api
public class StudentDaoImpl implements IStudentDao {

	// Resources used
	Connection connection = null;
	PreparedStatement pStatement = null;
	ResultSet resultSet = null;
	PreparedStatement pStatementSelect = null;

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {

		// Variables used
		String sqlInseryQuery = "insert into student(`sname`,`sage`,`saddress`)values(?,?,?)";

		try {
			connection = JdbcConnection.getJdbcConnection();

			if (connection != null) {
				pStatement = connection.prepareStatement(sqlInseryQuery);
			}

			if (pStatement != null) {
				pStatement.setString(1, sname);
				pStatement.setInt(2, sage);
				pStatement.setString(3, saddress);

				int rowAffected = pStatement.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return "failure";
	}

	@Override
	public Student searchStudent(Integer sid) {
		String sqlSelectQuery = "select sid,sname,sage,saddress from student where sid = ?";
		Student student = null;

		try {
			connection = JdbcConnection.getJdbcConnection();

			if (connection != null)
				pStatement = connection.prepareStatement(sqlSelectQuery);

			if (pStatement != null)
				pStatement.setInt(1, sid);

			if (pStatement != null) {
				resultSet = pStatement.executeQuery();
			}

			if (resultSet != null) {

				if (resultSet.next()) {
					student = new Student();

					// copy resultSet data to student object
					student.setSid(resultSet.getInt(1));
					student.setSname(resultSet.getString(2));
					student.setSage(resultSet.getInt(3));
					student.setSaddress(resultSet.getString(4));

					return student;

				}

			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return student;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {

		String rsName = null;
		Integer rsAge = null;
		String rsAddress = null;

		try {
			connection = JdbcConnection.getJdbcConnection();
			String sqlUpdateQuery = "update student set sname = ?,sage = ?, saddress = ? where sid = ?";
			String sqlSelectQuery = "select sid,sname,sage,saddress from student where sid = ?";

			if (connection != null) {
				pStatement = connection.prepareStatement(sqlUpdateQuery);
				pStatementSelect = connection.prepareStatement(sqlSelectQuery);
			}
			if (pStatement != null && pStatementSelect != null) {

				pStatementSelect.setInt(1, sid);
				resultSet = pStatementSelect.executeQuery();

				if (resultSet != null) {
					while (resultSet.next()) {
						rsName = resultSet.getString("sname");
						rsAge = resultSet.getInt("sage");
						rsAddress = resultSet.getString("saddress");
					}
				}

				if (sname == null) {
					sname = rsName;
				}
				if (sage == null) {
					sage = rsAge;
				}
				if (saddress == null) {
					saddress = rsAddress;
				}

				pStatement.setString(1, sname);
				pStatement.setInt(2, sage);
				pStatement.setString(3, saddress);
				pStatement.setInt(4, sid);

				int rowAffected = pStatement.executeUpdate();

				if (rowAffected > 0) {
					return "success";
				} else {
					return "failure";
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
			
		}
		return "failure";
	}

	@Override
	public String deleteStudent(Integer sid) {

String sqlInseryQuery = "delete from student where sid = ?";
		
		try {
			connection = JdbcConnection.getJdbcConnection();
			
				if(connection!=null) {
				 pStatement = connection.prepareStatement(sqlInseryQuery);
			}
			
			if(pStatement!=null) {
				pStatement.setInt(1, sid);
				
				
				 int rowAffected = pStatement.executeUpdate();
				 
				 if(rowAffected==1) {
					 return "success";
				 }else {
					 return "not found";
				 }
			}
			
		}catch (SQLException | IOException e) {
            e.printStackTrace();
            return "failure";
		}
		
		return "failure";
	}

}
