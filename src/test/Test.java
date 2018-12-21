package test;

import java.util.List;

import entiy.Pet;
import service.ServiceImp;

public class Test {
	public static void main(String[] args) {
		ServiceImp si=new ServiceImp();
//		Pet findById = si.findById(1);
//		System.out.println(findById.getName());
		List<Pet> list = si.getList();
		if(null!=list) {
			for (Pet pet : list) {
				System.out.println(pet.getName());
			}
		}
		
		
	}

}
