package service;

import java.util.List;

import dao.imple.PetImpDao;
import entiy.Pet;
//��ѯ���з���
public class ServiceImp {
	PetImpDao pi=new PetImpDao();
	public List<Pet> getList() {
		
		List<Pet> findAll = pi.findAll();
		return findAll;
	}
	//����id����
	public Pet findById(int id) {
		Pet findByAll = pi.findByAll(id);
		return findByAll;
	}
	//��ӳ���
	public int add(Pet pet) {
		int addPet = pi.addPet(pet);
		return addPet;
	}
	
}
