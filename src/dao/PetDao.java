package dao;

import java.util.List;

import entiy.Pet;

public interface PetDao {
	//查询所有动物
	public List<Pet> findAll();
	//根据编号查询动物
	public Pet findByAll(int id);
	//新增动物
	public int addPet(Pet pet);

}
