package service;

import java.util.List;

import dao.imple.PetImpDao;
import entiy.Pet;
//查询所有方法
public class ServiceImp {
	PetImpDao pi=new PetImpDao();
	public List<Pet> getList() {
		
		List<Pet> findAll = pi.findAll();
		return findAll;
	}
	//根据id查找
	public Pet findById(int id) {
		Pet findByAll = pi.findByAll(id);
		return findByAll;
	}
	//添加宠物
	public int add(Pet pet) {
		int addPet = pi.addPet(pet);
		return addPet;
	}
	
}
