package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class BaseDao {
	private String url = "jdbc:mysql://localhost/epet?useUnicode=true&characterEncoding=UTF-8";
	private String driver = "com.mysql.jdbc.Driver";
	private String user = "root";
	private String password = "123456";
	
	protected Connection connection = null;
	protected PreparedStatement preparedStatement = null;
	protected ResultSet rs = null;
	
	// ��ȡ���Ӷ���
	public Connection getConnection() {
		// ��������
		try {
			Class.forName(driver);
			// ��ȡ���Ӷ���
			connection =  DriverManager.getConnection(url, user, password);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return connection;
	}
	
	//�ر���Դ
	
	public void closeAll(Connection connection,PreparedStatement preparedStatement,ResultSet rs) {
		try {
			if(null!=rs) {
				rs.close();
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		try {
			if(null!=preparedStatement) {
				preparedStatement.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			if(null!=connection) {
				connection.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	//��ɾ�Ĳ���
	public int excuteUpdtate(String sql,Object[]parms) {
		getConnection();
		int result=-1;
		try {
			preparedStatement =  connection.prepareStatement(sql);
			//Ϊռλ����ֵ
			if(null!=preparedStatement) {
				for(int i=0;i<parms.length;i++) {
					preparedStatement.setObject(i+1, parms[i]);
				}
			}
			//����
			int executeUpdate = preparedStatement.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			this.closeAll(connection, preparedStatement, rs);
		}
		
		return  result;
		
	}
	// ��ѯ�ķ���
	public ResultSet excuteQuery(String sql,Object[]parms1) {
		getConnection();
		
		try {
			//����PreparedStaement����
			preparedStatement = connection.prepareStatement(sql);
			if(null!=preparedStatement) {
				for(int i=0;i<parms1.length;i++) {
					preparedStatement.setObject(i+1,parms1[i] );
				}
			}
			rs=preparedStatement.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	