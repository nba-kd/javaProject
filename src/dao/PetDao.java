package dao;

import java.util.List;

import entiy.Pet;

public interface PetDao {
	//��ѯ���ж���
	public List<Pet> findAll();
	//���ݱ�Ų�ѯ����
	public Pet findByAll(int id);
	//��������
	public int addPet(Pet pet);

}
