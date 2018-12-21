package dao.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.PetDao;
import entiy.Pet;

public class PetImpDao extends BaseDao implements PetDao {
	List<Pet> list=null;
	Pet pet=null;
	BaseDao bs = new BaseDao();
	@Override
	//查询所有信息
	public List<Pet> findAll() {
		pet=new Pet();
		try {
			
			String sql = "SELECT id,`NAME`,health,love,strain FROM `pet`";
			Object[]parms1=null;
			ResultSet excuteQuery = bs.excuteQuery(sql, parms1);
			if (null != excuteQuery) {
				list=new ArrayList<Pet>();
				while (excuteQuery.next()) {
					pet.setId(excuteQuery.getInt("id"));
					pet.setName(excuteQuery.getString("name"));
					pet.setHealth(excuteQuery.getInt("health"));
					pet.setLove(excuteQuery.getInt("love"));
					pet.setStrain(excuteQuery.getString("strain"));
					list.add(pet);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			bs.closeAll(connection, preparedStatement, rs);
		}

		return list;
	}

	@Override
	//根据编号查找
	public Pet findByAll(int id) {
		pet=new Pet();
			try {
				String sql="SELECT id,NAME,health,love,strain FROM `pet`AS WHERE id=?";
				Object[] parms1= {id};
				ResultSet excuteQuery = bs.excuteQuery(sql, parms1);
				if(null!=excuteQuery) {
				while(excuteQuery.next()){
					pet.setId(excuteQuery.getInt("id"));
					pet.setName(excuteQuery.getString("name"));
					pet.setHealth(excuteQuery.getInt("health"));
					pet.setLove(excuteQuery.getInt("love"));
					pet.setStrain(excuteQuery.getString("strain"));
					
				}
			}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		return pet;
	}
	//
	@Override
	public int addPet(Pet pet) {
		String sql="INSERT INTO `pet`() VALUES (DEFAULT,?,?,?,?)";
		Object[]parms= {pet.getId(),pet.getName(),pet.getHealth(),pet.getLove(),pet.getStrain()};
		int result=-1;
		try {
			int excuteUpdtate = bs.excuteUpdtate(sql, parms);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return result;
	}

}
